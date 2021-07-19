package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Sensors;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.OrbitLibrary.Util.Clock;

public class OrbitEncoder extends BaseSensor<DcMotor> {

    private DcMotorEx motor;
    private final double ticksPerRev;

    private int lastTime = 0;
    private int lastPosition = 0;
    private double lastVelocity = 0;

    protected int position;
    protected double velocity; //ticks/s
    protected double acceleration; //ticks/s^2


    public OrbitEncoder(String name, double ticksPerRev, DcMotorEx motor) {
        super(name);
        this.motor = motor;
        this.ticksPerRev = ticksPerRev;
    }


    @Override
    public void update() {
        int time = Clock.getCurrentTime();

        position = motor.getCurrentPosition();
        velocity =  (position - lastPosition) / (time - lastTime);
        acceleration = (velocity - lastVelocity) / (time - lastTime);

        lastTime = time;
        lastPosition = position;
        lastVelocity = velocity;
    }

    @Override
    public void init(HardwareMap hwMap) {

    }
}
