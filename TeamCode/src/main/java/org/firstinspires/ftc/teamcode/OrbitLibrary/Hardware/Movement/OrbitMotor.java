package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Movement;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.BaseHardware;
import org.firstinspires.ftc.teamcode.OrbitLibrary.OrbitMath;
import org.firstinspires.ftc.teamcode.OrbitLibrary.PIDController;
public class OrbitMotor extends BaseHardware<DcMotorEx> {

    private DcMotorEx motor;
    private int minPos = Integer.MIN_VALUE;
    private int maxPos = Integer.MAX_VALUE;
    private double minRPM = Double.MIN_NORMAL;
    private double maxRPM = Double.MIN_NORMAL;

    private PIDController pid = new PIDController(0, 0, 0, 0, 0);

    public OrbitMotor(String name) {
        super(name, DcMotorEx.class);
    }

    public OrbitMotor(String name, int minPos, int maxPos) {
        super(name, DcMotorEx.class);
        this.minPos = minPos;
        this.maxPos = maxPos;
    }

    public OrbitMotor(String name, double minRPM, double maxRPM) {
        super(name, DcMotorEx.class);
        this.minRPM = minRPM;
        this.maxRPM = maxRPM;
    }

    public OrbitMotor(String name, int minPos, int maxPos, int maxRPM) {
        super(name, DcMotorEx.class);
        this.minPos = minPos;
        this.maxPos = maxPos;
        this.maxRPM = maxRPM;
    }

    @Override
    public void init(HardwareMap hwMap) {
        motor = hwMap.get(type, name);
    }

    public void setOutput(ControlMode mode, double value){
        switch (mode){
            case percentage:
                final double targetPre = OrbitMath.limit(value, -1, 1);
                motor.setPower(targetPre);
                break;
            case position:
                final double targetPos = OrbitMath.limit(value, minPos, maxPos);
                motor.setPower(pid.update());
                break;
            case velocity:
                final double targetRPM = OrbitMath.limit(value, minRPM, maxRPM);
                motor.setPower(pid.update());
                break;
        }
    }

    public int getCurrentPos(){return 0;}

    public double getCurrentRPM(){return 0;}
}
