package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public abstract class BaseHardware<T> {

    protected String name;
    protected Class<? extends T> type;

    public BaseHardware(String name, Class<? extends T> type){
        this.name = name;
        this.type = type;
    }

    abstract public void init(HardwareMap hwMap);
}
