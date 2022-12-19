public class Matter {
    private boolean IamFine = true;
    private double position = 0;
    private double velocity = 0;
    private double acceleration = 1;
    private double force = 1;
    private double mass = 2;

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

    public void setForce(double force) {
        this.force = force;
    }

    public void updatePosition() {
        position += velocity;
    }

    public void updateVelocity() {
        velocity += acceleration;
    }

    public void updateAcceleration() {
        acceleration = force / mass;
    }

    public void updateEmotionalStatus() {
        if (position > 10)
            IamFine = false;
    }

    public String toString() {
        if (IamFine)
            return "I am fine, my position is: " + position;

        return "I am not fine";
    }

    public static double computeForce(Matter a, Matter b) {
        return a.position - b.position;
    }
}
