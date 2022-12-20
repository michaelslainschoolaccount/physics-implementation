public class Matter {
    private boolean IamFine = true;
    private double position = 0;
    private double velocity = 0;
    private double acceleration = 1;
    private double force = 1;
    private double mass = 2;
    private String name = "Johnny"; // default name

    public Matter() {

    }

    public Matter(double position) {
        this.position = position;
    }

    public boolean getEmotionalStatus() {
        return IamFine;
    }

    public double getPosition() {
        return position;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double getForce() {
        return force;
    }

    public double getMass() {
        return mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setForce(double force) {
        this.force = force;
    }

    public void updatePosition(double deltaTime) {
        position += velocity * deltaTime;
    }

    public void updateVelocity(double deltaTime) {
        velocity += acceleration * deltaTime;
    }

    public void updateVelocityHalfWay() {
        velocity += acceleration / 2;
    }

    public void updateAcceleration() {
        acceleration = force / mass;
    }

    public void updateEmotionalStatus() {
        if (position > 1000)
            IamFine = false;
    }

    public void newUpdate(double deltaTime) {
        updateAcceleration();
        updateVelocityHalfWay();
        updatePosition(deltaTime);
        updateAcceleration();
        updateVelocityHalfWay();
        System.out.println(this);
        updateEmotionalStatus();
    }

    public void update(double deltaTime) {
        updateAcceleration();
        updateVelocity(deltaTime);
        updatePosition(deltaTime);
        System.out.println(this);
        updateEmotionalStatus();
    }

    public String toString() {
        String out = "_________________________________________\n";

        out += "| I am " + name + ", and here is my data:\n";

        out += "| ";
        if (IamFine)
            out += "I am fine\n";
        else
            out += "I am not fine\n";

        out += "| my position is: " + position;
        out += "\n| my velocity is: " + velocity;
        out += "\n| my acceleration is: " + acceleration;
        out += "\n| my force is: " + force;
        out += "\n| my mass is:" + mass;

        out += "\n_________________________________________\n";

        return out;
    }

    public static double computeForce(Matter a, Matter b) {
        return a.position - b.position;
    }
}
