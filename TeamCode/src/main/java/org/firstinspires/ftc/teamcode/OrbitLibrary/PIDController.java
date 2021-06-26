package org.firstinspires.ftc.teamcode.OrbitLibrary;

public class PIDController {
    public double Kp;
    public double Ki;
    public double Kd;
    public double Kf;
    public double IZone;

    public PIDController(final double Kp, final double Ki, final double Kd, final double Kf, final double IZone){
        this.Kp = Kp;
        this.Ki = Ki;
        this.Kd = Kd;
        this.Kf = Kf;
        this.IZone = IZone;
    }

    //TODO: write the function
    public double update(double target){
        return 0;
    }
}
