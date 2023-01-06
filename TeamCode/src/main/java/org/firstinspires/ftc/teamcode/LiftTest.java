package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
@Disabled

// will spit out positions in telemetry (on driver hub)
// record those numbers

public class LiftTest extends LinearOpMode
// linear opmode means it runs once
// regular opmode loops back through the code multiple times per second until you turn it off
{
    private DcMotorEx rightLift, leftLift;
    // it's a fancier way of running motors
    // basically it allows you to do stuff like setVelocity

    private double liftPower = 0;

    @Override
    public void runOpMode() {

        rightLift = hardwareMap.get(DcMotorEx.class, "rightLift");
        leftLift = hardwareMap.get(DcMotorEx.class, "leftLift");
        // right and left sides determined from front opening of bot
        // note: control hubs are in the back

        // reset the motor encoder so that it reads zero ticks
        rightLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // will use the encoder to take an active role in managing the motor’s speed
        rightLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftLift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("Mode", "waiting for start");
        telemetry.update();

        // reverse one motor until lift moves correctly
        rightLift.setDirection(DcMotorEx.Direction.REVERSE);

        // wait for the start button to be pressed
        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        while (opModeIsActive()) {
            // triggers power the left here, not joystick
            liftPower = gamepad2.right_trigger - gamepad2.left_trigger;
            rightLift.setPower(liftPower);
            leftLift.setPower(liftPower);

            telemetry.addData("rightLift position", rightLift.getCurrentPosition());
            telemetry.addData("leftLift position", leftLift.getCurrentPosition());
            telemetry.update();
        }
    }
}