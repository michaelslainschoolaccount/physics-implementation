public class Test {
    private static int testAmount = 0;
    private static int passedAmount = 0;

    public static void runTests() {
        Matter object = new Matter();
        double deltaTime = 1;
        boolean criteria;

        criteria = object.getEmotionalStatus();
        create(criteria, "get emotional status");

        criteria = object.getPosition() == 0;
        create(criteria, "get position");

        criteria = object.getVelocity() == 0;
        create(criteria, "get velocity");

        criteria = object.getAcceleration() == 1;
        create(criteria, "get acceleration");

        criteria = object.getForce() == 1;
        create(criteria, "get force");

        criteria = object.getMass() == 2;
        create(criteria, "get mass");

        object.setForce(-10);
        criteria = object.getForce() == -10;
        create(criteria, "set force");

        object = new Matter();
        object.updatePosition(deltaTime);
        criteria = object.getPosition() == 0;
        create(criteria, "update position when velocity is 0");

        object = new Matter();
        object.updateVelocity(deltaTime);
        criteria = object.getVelocity() == 1;
        create(criteria, "update velocity without an acceleration");

        object.updatePosition(deltaTime);
        criteria = object.getPosition() == 1;
        create(criteria, "update position when velocity > 0");

        object = new Matter();
        object.updateAcceleration();
        criteria = object.getAcceleration() == 0.5;
        create(criteria, "update acceleration");

        object.updateVelocity(deltaTime);
        criteria = object.getVelocity() == 0.5;
        create(criteria, "update velocity with an acceleration");

        object = new Matter();
        object.setForce(100);
        object.updateAcceleration();
        criteria = object.getAcceleration() == 50;
        create(criteria, "update acceleration with a large force");

        object = new Matter();
        for (int i = 0; i < 1000; i++) {
            object.updatePosition(deltaTime);
            object.updateVelocity(deltaTime);
            object.updateEmotionalStatus();
        }
        criteria = !object.getEmotionalStatus();
        create(criteria, "update emotional status when position passes threshold of 10");

        object = new Matter();
        object.update(deltaTime);
        criteria = object.getEmotionalStatus() && object.getPosition() == 0.5 && object.getVelocity() == 0.5
                && object.getAcceleration() == 0.5 && object.getForce() == 1 && object.getMass() == 2;
        create(criteria, "update all");

        object.update(deltaTime);
        criteria = object.getEmotionalStatus() && object.getPosition() == 1.5 && object.getVelocity() == 1
                && object.getAcceleration() == 0.5 && object.getForce() == 1 && object.getMass() == 2;
        create(criteria, "update all 2");

        object = new Matter();
        object.updateVelocityHalfWay();
        criteria = object.getVelocity() == 0.5;
        create(criteria, "update veloctiy halfway");

        object.updateVelocityHalfWay();
        criteria = object.getVelocity() == 1;
        create(criteria, "update veloctiy halfway 2");

        object = new Matter();
        object.newUpdate(deltaTime);
        criteria = object.getEmotionalStatus() && object.getPosition() == 0.25 && object.getVelocity() == 0.5
                && object.getAcceleration() == 0.5 && object.getForce() == 1 && object.getMass() == 2;
        create(criteria, "new update all");

        object.newUpdate(deltaTime);
        criteria = object.getEmotionalStatus() && object.getPosition() == 1 && object.getVelocity() == 1
                && object.getAcceleration() == 0.5 && object.getForce() == 1 && object.getMass() == 2;
        create(criteria, "new update all 2");

        stop();
    }

    public static void runSampleEventLoops() {
        sampleEventLoopBetween2Particles();
        sampleEventLoopBetween3Particles();
    }

    private static void create(boolean criteria, String name) {
        System.out.println("-- Test " + ++testAmount + ": " + name);

        if (criteria) {
            System.out.println("---- passed (>^-^)>");
            passedAmount++;
            return;
        }

        System.out.println("---- failed");
    }

    private static void stop() {
        System.out.println(passedAmount + " out of " + testAmount + " passed");

        if (passedAmount < testAmount)
            System.out.println("Damn you suck get better (:");
    }

    private static void sampleEventLoopBetween2Particles() {
        // the objects
        Matter me = new Matter(10);
        Matter you = new Matter();

        // set names of the objects
        me.setName("Joe");
        you.setName("Bob");

        double deltaTime = 0.1;

        while (me.getEmotionalStatus()) {
            // update forces
            me.setForce(Matter.computeForce(me, you));
            you.setForce(Matter.computeForce(you, me));

            // update other stuff
            me.update(deltaTime);
            you.update(deltaTime);
        }
    }

    private static void sampleEventLoopBetween3Particles() {
        // the objects
        Matter me = new Matter(10);
        Matter you = new Matter();
        Matter him = new Matter(20);

        // set names of the objects
        me.setName("Joe");
        you.setName("Bob");
        him.setName("George");

        double deltaTime = 0.1;

        while (me.getEmotionalStatus()) {
            // update forces
            me.setForce(Matter.computeForce(me, you));
            you.setForce(Matter.computeForce(you, me));
            him.setForce(Matter.computeForce(him, me));
            him.setForce(him.getForce() + Matter.computeForce(him, you));
            me.setForce(me.getForce() + Matter.computeForce(me, him));
            you.setForce(you.getForce() + Matter.computeForce(you, him));

            // update other stuff
            me.newUpdate(deltaTime);
            you.newUpdate(deltaTime);
            him.newUpdate(deltaTime);
        }
    }
}
