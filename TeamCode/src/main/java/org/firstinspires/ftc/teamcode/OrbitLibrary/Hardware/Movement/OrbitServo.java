package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Movement;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.BaseHardware;

public class OrbitServo extends BaseHardware<Servo> {

    private Servo servo;

    public OrbitServo(String name) {
        super(name, Servo.class);
    }

    @Override
    public void init(HardwareMap hwMap) {
        servo = hwMap.get(type, name);
    }

    public void setPos(double val) {
        servo.setPosition(val);
    }
}
