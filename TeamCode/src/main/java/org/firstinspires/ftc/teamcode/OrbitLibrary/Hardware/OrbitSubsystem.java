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
    BaseState currentState = null;
    List<OrbitMotor> motors = new ArrayList<OrbitMotor>();
    List<OrbitServo> servos = new ArrayList<OrbitServo>();
    List<BaseSensor> sensors = new ArrayList<BaseSensor>();

    public void init(HardwareMap hwMap){
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

    abstract public void update();

    abstract public void sendDate(Telemetry telemetry, TelemetryPacket packet);
}
