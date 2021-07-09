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

    private final int minPos = Integer.MIN_VALUE; //ticks
    private final int maxPos = Integer.MAX_VALUE; //ticks
    private final double minRPM = Double.MIN_NORMAL; //ticks/s
    private final double maxRPM = Double.MIN_NORMAL; //ticks/s

    public final PIDController controller = new PIDController(0, 0, 0, 0, 0);

    public OrbitMotor(String name, ZeroPowerBehavior zeroPowerBehavior) {
        super(name);
        this.zeroPowerBehavior = zeroPowerBehavior;
    }

    @Override
    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotorEx.class, name);
        motor.setZeroPowerBehavior(zeroPowerBehavior);
    }

    public void setOutput(ControlMode mode, double value, double current){
        switch (mode){
            case percentage:
                motor.setPower(value);
                break;
            case position:
                controller.target = OrbitMath.limit(value, minPos, maxPos);
                motor.setPower(controller.update(current));
                break;
            case velocity:
                controller.target = OrbitMath.limit(value, minRPM, maxRPM);
                motor.setPower(controller.update(current));
                break;
        }
    }
}
