public class Test {
    private static int testAmount = 0;
    private static int passedAmount = 0;

    public static void run() {
        Matter me = new Matter();
        boolean criteria;

        criteria = me.getEmotionalStatus();
        create(criteria, "get emotional status");

        criteria = me.getPosition() == 0;
        create(criteria, "get position");

        criteria = me.getVelocity() == 0;
        create(criteria, "get velocity");

        criteria = me.getAcceleration() == 1;
        create(criteria, "get acceleration");

        criteria = me.getForce() == 1;
        create(criteria, "get force");

        criteria = me.getMass() == 2;
        create(criteria, "get mass");

        me.setForce(-10);
        criteria = me.getForce() == -10;
        create(criteria, "set force");

        me = new Matter();
        me.updatePosition();
        criteria = me.getPosition() == 0;
        create(criteria, "update position when velocity is 0");

        me = new Matter();
        me.updateVelocity();
        criteria = me.getVelocity() == 1;
        create(criteria, "update velocity");

        me.updatePosition();
        criteria = me.getPosition() == 1;
        create(criteria, "update position when velocity > 0");

        me = new Matter();
        me.updateAcceleration();
        criteria = me.getAcceleration() == 0.5;
        create(criteria, "update acceleration");

        me = new Matter();
        for (int i = 0; i < 20; i++) {
            me.updatePosition();
            me.updateVelocity();
            me.updateEmotionalStatus();
        }
        criteria = !me.getEmotionalStatus();
        create(criteria, "update emotional status when position passes threshold of 10");

        stop();
    }

    private static void create(boolean criteria, String name) {
        System.out.println("-- Test " + ++testAmount + ": " + name);

        if (criteria) {
            System.out.println("-- passed (>^-^)>");
            passedAmount++;
            return;
        }

        System.out.println("-- failed");
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

        while (me.getEmotionalStatus()) {
            // update forces
            me.setForce(Matter.computeForce(me, you));
            you.setForce(Matter.computeForce(you, me));

            // update stuff for "me"
            me.updateAcceleration();
            me.updatePosition();
            me.updateVelocity();
            me.updateEmotionalStatus();
            System.out.println(me);

            // update stuff for "you"
            you.updateAcceleration();
            you.updatePosition();
            you.updateVelocity();
            you.updateEmotionalStatus();
            System.out.println(you);
        }
    }

    // private static void sampleEventLoopBetween3Particles() {

    // }
}
