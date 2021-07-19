package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class BaseHardware {

    protected String name;

    public BaseHardware(String name){
        this.name = name;
    }

    abstract public void init(HardwareMap hwMap);
}
