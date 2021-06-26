package org.firstinspires.ftc.teamcode.OrbitLibrary.OpModes;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.OrbitRobot;

public abstract class BaseOpMode extends OpMode {
    protected final OrbitRobot robot;

    public BaseOpMode(OrbitRobot robot){
        this.robot = robot;
    }


    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        robot.update();
    }
}
