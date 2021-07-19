package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Movement.OrbitCRServo;
import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Movement.OrbitMotor;
import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Movement.OrbitServo;
import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Sensors.BaseSensor;
import org.firstinspires.ftc.teamcode.OrbitLibrary.HardwareNames.CRServoNames;
import org.firstinspires.ftc.teamcode.OrbitLibrary.HardwareNames.MotorNames;
import org.firstinspires.ftc.teamcode.OrbitLibrary.HardwareNames.SensorNames;
import org.firstinspires.ftc.teamcode.OrbitLibrary.HardwareNames.ServoNames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class OrbitSubsystem {
    protected HashMap<MotorNames,OrbitMotor> motors = new HashMap<>();
    protected HashMap<ServoNames,OrbitServo> servos = new HashMap();
    protected HashMap<SensorNames,BaseSensor> sensors = new HashMap();
    protected HashMap<CRServoNames, OrbitCRServo> crServos = new HashMap<>();

    protected abstract void setHardware();

    public void init(HardwareMap hwMap){
        setHardware();
        for(OrbitMotor motor: motors.values()){
            motor.init(hwMap);
        }
        for (OrbitServo servo : servos.values()){
            servo.init(hwMap);
        }
        for (OrbitCRServo CRServo : crServos.values()){
            CRServo.init(hwMap);
        }
        for (BaseSensor sensor : sensors.values()){
            sensor.init(hwMap);
        }
    }

    public void update(){
        for (BaseSensor sensor : sensors.values()){
            sensor.update();
        }
    }

    abstract public void sendDate(Telemetry telemetry, TelemetryPacket packet);
}
