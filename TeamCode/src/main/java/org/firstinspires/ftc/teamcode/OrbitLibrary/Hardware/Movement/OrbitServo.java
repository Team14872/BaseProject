package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Movement;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.BaseHardware;

public class OrbitServo extends BaseHardware<Servo> {

    private Servo servo;
    private final Servo.Direction direction;

    public OrbitServo(String name, Servo.Direction direction) {
        super(name);
        this.direction = direction;
    }

    @Override
    public void init(HardwareMap hwMap) {
        servo = hwMap.get(Servo.class, name);
        servo.setDirection(direction);
    }

    public void setPos(double val) {
        servo.setPosition(val);
    }
}
