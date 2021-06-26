package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Sensors;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.BaseHardware;

public abstract class BaseSensor<T> extends BaseHardware<T> {

    public BaseSensor(String name) {
        super(name);
    }

    public abstract void update();
}
