package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp

public class GameManualZeroTeleop extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure your ID's match your configuration
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");
        //DcMotor leftLift = hardwareMap.dcMotor.get("leftLift");
       // DcMotor rightLift = hardwareMap.dcMotor.get("rightLift");

        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests

        //Chassis Motors

        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE); //Competition Bot
        motorBackRight.setDirection(DcMotorSimple.Direction.FORWARD);//Competition Bot
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);//Competition Bot
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);//Competition Bot
/*
        //Lift Motor
        leftLift.setDirection(DcMotorSimple.Direction.REVERSE);
        rightLift.setDirection(DcMotorSimple.Direction.FORWARD);

        // reset the motor encoder so that it reads zero ticks
        rightLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Added to tell motor to use encoder position when buttons pressed
        leftLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // position of the dr4b when it is on the **ground
        int liftGroundPosition = 50;

        // position of dr4b when it is **low
        int liftLowPosition = 450;

        // position of dr4b when it is **mid
        int liftMidPosition = 650;

        // position of dr4b when it is **high
        int liftHighPosition = 1550;

        // sets the starting position of the arm to the down position
        rightLift.setTargetPosition(liftGroundPosition);
        rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftLift.setTargetPosition(liftGroundPosition);
        leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
*/
        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);
/*
            // if the x button is pressed, move to **ground
            if (gamepad2.x) {
                rightLift.setPower(1);
                leftLift.setPower(1);
                rightLift.setTargetPosition(liftGroundPosition);
                rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                leftLift.setTargetPosition(liftGroundPosition);
                leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }

            // if the y button is pressed, move to **high
            if (gamepad2.y) {
                rightLift.setPower(1);
                leftLift.setPower(1);
                rightLift.setTargetPosition(liftHighPosition);
                rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                leftLift.setTargetPosition(liftHighPosition);
                leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            //else {
             //   rightLift.setPower(0);
             //   leftLift.setPower(0);
           // }

            // if the b button is pressed, move to **mid
            if (gamepad2.b) {
                rightLift.setPower(1);
                leftLift.setPower(1);
                rightLift.setTargetPosition(liftMidPosition);
                rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                leftLift.setTargetPosition(liftMidPosition);
                leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }

            // if the a button is pressed, move to **low
            if (gamepad2.a) {
                rightLift.setPower(1);
                leftLift.setPower(1);
                rightLift.setTargetPosition(liftLowPosition);
                rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                leftLift.setTargetPosition(liftLowPosition);
                leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }


            // get the current position of the motor
            double position = rightLift.getCurrentPosition();
            position = leftLift.getCurrentPosition();

            // get the target position of the motor
            double desiredPosition = rightLift.getTargetPosition();
            desiredPosition = leftLift.getTargetPosition();

            // show the position of the motor on telemetry
            telemetry.addData("Encoder Position", position);

            // show the target position of the motor on telemetry
            telemetry.addData("Desired Position", desiredPosition);

            telemetry.update();

 */
        }

    }
    }