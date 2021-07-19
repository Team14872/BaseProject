package org.firstinspires.ftc.teamcode.OrbitLibrary;
public class PIDController {

    public double kP = 0;
    public double kI = 0;
    public double kD = 0;
    public double kF = 0;
    public double iZone = 0;

    public double target = 0;

    private double integral = 0;

    private double prevError = 0;
    private double prevTime = 0;
    private double prevDerivative = 0;

    public PIDController(final double kP, final double kI, final double kD, final double kF, final double iZone) {
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
        this.kF = kF;
        this.iZone = iZone;
    }

    public double update(final double current) {
        final double currentError = target - current;
        final double currentTime = System.currentTimeMillis();
        final double deltaTime = currentTime - prevTime;

        if (Math.abs(currentError) < iZone) {
            if (Math.signum(currentError) != Math.signum(prevError)) {
                integral = 0;
            } else {
                integral += currentError * deltaTime;
            }
        }

        final double derivative = deltaTime == 0 ? prevDerivative : (currentError - prevError) / deltaTime;

        prevDerivative = derivative;
        prevError = currentError;
        prevTime = currentTime;

        return kP * currentError + kI * integral + kD * derivative + kF * target;
    }
}