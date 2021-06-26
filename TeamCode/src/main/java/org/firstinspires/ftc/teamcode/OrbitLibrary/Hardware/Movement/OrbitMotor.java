package org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.Movement;


import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.OrbitLibrary.Hardware.BaseHardware;
import org.firstinspires.ftc.teamcode.OrbitLibrary.OrbitMath;
import org.firstinspires.ftc.teamcode.OrbitLibrary.PIDController;

public class OrbitMotor extends BaseHardware<DcMotorEx> {

    private DcMotorEx motor;

    private final ZeroPowerBehavior zeroPowerBehavior;

    private final int minPos = Integer.MIN_VALUE;
    private final int maxPos = Integer.MAX_VALUE;
    private final double minRPM = Double.MIN_NORMAL;
    private final double maxRPM = Double.MIN_NORMAL;

    private PIDController controller = new PIDController(0, 0, 0, 0, 0);

    public OrbitMotor(String name, ZeroPowerBehavior zeroPowerBehavior) {
        super(name, DcMotorEx.class);
        this.zeroPowerBehavior = zeroPowerBehavior;
    }

    @Override
    public void init(HardwareMap hwMap) {
        motor = hwMap.get(type, name);
        motor.setZeroPowerBehavior(zeroPowerBehavior);
    }

    public void setOutput(ControlMode mode, double value){
        switch (mode){
            case percentage:
                final double targetPre = OrbitMath.limit(value, -1, 1);
                motor.setPower(targetPre);
                break;
            case position:
                final double targetPos = OrbitMath.limit(value, minPos, maxPos);
                motor.setPower(controller.update(targetPos));
                break;
            case velocity:
                final double targetRPM = OrbitMath.limit(value, minRPM, maxRPM);
                motor.setPower(controller.update(targetRPM));
                break;
        }
    }

    public int getCurrentPos(){return 0;}

    public double getCurrentRPM(){return 0;}
}
