package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Sensors;

import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.BaseHardware;

public abstract class BaseSensor<T> extends BaseHardware<T> {

    public BaseSensor(String name, Class<? extends T> type) {
        super(name, type);
    }
}
