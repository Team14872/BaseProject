package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Sensors;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.OrbitLibrary.Util.Clock;

public class OrbitEncoder extends BaseSensor<DcMotor> {

    private DcMotor motor;
    private final double ticksPerRev;

    private int lastTime = 0;
    private int lastTicks = 0;
    private double lastVelocity = 0;

    protected int ticks;
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

        ticks = motor.getCurrentPosition();
        velocity =  (ticks - lastTicks) / (time - lastTime);
        acceleration = (velocity - lastVelocity) / (time - lastTime);

        lastTime = time;
        lastTicks = ticks;
        lastVelocity = velocity;
    }
}
