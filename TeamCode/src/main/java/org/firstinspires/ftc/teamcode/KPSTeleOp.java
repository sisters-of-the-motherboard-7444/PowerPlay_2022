package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Sample code for teaching lesson
 * Considered ROBOT CENTRIC Mecanum Code
 */

@TeleOp

@Disabled

public class KPSTeleOp extends LinearOpMode {
    @Override

    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure your ID's match your configuration file on the Driver's Hub

        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");

        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);//set for PracticeBot
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE); //Set for PracticeBot
        //motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);//set for Competition
        //motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE); //Set for Competition


        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double fwdBack = -gamepad1.left_stick_y; // Remember, this is reversed!
            double strafe = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double turn = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(fwdBack) + Math.abs(strafe) + Math.abs(turn), 1);
            double frontLeftPower = (fwdBack + strafe + turn) / denominator;
            double backLeftPower = (fwdBack - strafe + turn) / denominator;
            double frontRightPower = (fwdBack - strafe - turn) / denominator;
            double backRightPower = (fwdBack + strafe - turn) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);
        }
    }


}