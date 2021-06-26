package org.firstinspires.ftc.teamcode.OrbitLibrary;

public class PIDController {
    public double Kp = 0;
    public double Ki = 0;
    public double Kd = 0;
    public double Kf = 0;
    public double IZone = 0;

    public PIDController(final double Kp, final double Ki, final double Kd, final double Kf, final double IZone){
        this.Kp = Kp;
        this.Ki = Ki;
        this.Kd = Kd;
        this.IZone = IZone;
    }

    //TODO: write the function
    public double update(){
        return 0;
    }
}
