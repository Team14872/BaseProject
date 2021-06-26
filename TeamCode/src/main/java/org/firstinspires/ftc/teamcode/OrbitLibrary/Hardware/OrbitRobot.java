package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.OrbitLibrary.OpModes.BaseOpMode;

public abstract class OrbitRobot extends OrbitSubsystem {

    private final FtcDashboard dash = FtcDashboard.getInstance();

    private final Telemetry telemetry;
    private final TelemetryPacket packet = new TelemetryPacket();

    private final OrbitSubsystem[] subsystems;

    public OrbitRobot(BaseOpMode opMode, OrbitSubsystem[] subsystems){
        this.telemetry = opMode.telemetry;
        this.subsystems = subsystems;
    }

    @Override
    public void init(HardwareMap hwMap) {
        for (OrbitSubsystem system : subsystems) {
            system.init(hwMap);
        }
    }

    @Override
    public void update() {
        for (OrbitSubsystem system : subsystems) {
            system.update();
            system.sendDate(telemetry, packet);
        }
        dash.sendTelemetryPacket(packet);
    }
}
