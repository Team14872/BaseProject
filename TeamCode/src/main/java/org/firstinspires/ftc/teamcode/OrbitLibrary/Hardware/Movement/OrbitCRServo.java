package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Movement;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.BaseHardware;

public class OrbitCRServo extends BaseHardware{
    public CRServo crServo;
    private final DcMotorSimple.Direction direction;

    public OrbitCRServo(String name, DcMotorSimple.Direction direction) {
        super(name);
        this.direction = direction;
    }

    @Override
    public void init(HardwareMap hwMap) {
        crServo = hwMap.get(CRServo.class,name);
        crServo.setDirection(direction);
    }

    public void setPower(double val){
        crServo.setPower(val);
    }
}
