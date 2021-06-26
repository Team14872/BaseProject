package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Movement.OrbitMotor;
import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Movement.OrbitServo;
import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Sensors.BaseSensor;

import java.util.ArrayList;
import java.util.List;

public abstract class OrbitSubsystem {
    protected List<OrbitMotor> motors = new ArrayList<OrbitMotor>();
    protected List<OrbitServo> servos = new ArrayList<OrbitServo>();
    protected List<BaseSensor> sensors = new ArrayList<BaseSensor>();

    protected abstract void setHardware();

    public void init(HardwareMap hwMap){
        setHardware();
        for(OrbitMotor motor: motors){
            motor.init(hwMap);
        }
        for (OrbitServo servo : servos){
            servo.init(hwMap);
        }
        for (BaseSensor sensor : sensors){
            sensor.init(hwMap);
        }
    }

    public void update(){
        for (BaseSensor sensor : sensors){
            sensor.update();
        }
    }

    abstract public void sendDate(Telemetry telemetry, TelemetryPacket packet);
}
