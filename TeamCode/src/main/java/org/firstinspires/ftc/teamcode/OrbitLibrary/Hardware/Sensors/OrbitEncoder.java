package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Sensors;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.OrbitLibrary.Util.Clock;

public class OrbitEncoder extends BaseSensor<DcMotor> {

    private DcMotor motor;
    private final double ticksPerRev;

    private int lastTime = 0;
    private int lastPosition = 0;
    private double lastVelocity = 0;

    protected int position;
    protected double velocity; //ticks/s
    protected double acceleration; //ticks/s^2


    public OrbitEncoder(String name, double ticksPerRev) {
        super(name);
        this.ticksPerRev = ticksPerRev;
    }

    @Override
    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, name);
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
}
