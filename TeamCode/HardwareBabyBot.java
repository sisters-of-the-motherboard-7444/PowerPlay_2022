package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Original created by KPSorrells (for teaching RoboLearners) 11/26/2022
 */

@Disabled

public class HardwareBabyBot {

    //Wheels
    public DcMotor leftDrive;
    public DcMotor rightDrive;
    //private DcMotor leftDrive = null;
    //private DcMotor rightDrive = null;


//----------------------------Initialize Robot ---------------------------------
   /*  This method allows us to initialize the motors and sensors only once.
       It is called and used in every other program after "Init" is pressed.
    */

    public void InitializeRobot(HardwareMap hwMap) {

        HardwareMap HWMap = hwMap;

        //initialize Wheels
        leftDrive= HWMap.dcMotor.get("leftDrive");
        rightDrive= HWMap.dcMotor.get("rightDrive");

        // Reverse the right side motors
        // Reverse left motors if you are using NeveRest
        leftDrive.setDirection(DcMotor.Direction.REVERSE);

        //Initialize Servos
        //sweeperLeft = HWMap.crservo.get("sweeperLeft");
        //sweeperRight = HWMap.crservo.get("sweeperRight");
        //boxLid = HWMap.servo.get("boxLid");
        //duckSpin = HWMap.crservo.get("duckSpin");

    }  //end of method InitializeRobot


//--------------------------Driving Pathways------------------------------------

   /*  This method allows the robot to drive forward based on encoder values.
       A distance is given that is converted to an encoder position in the code.
       leftDirection and rightDirection set the direction of the motors to allow
       the robot to either move straight ot turn.
    */

    public void DriveStraight(double power, double totalSeconds, int Direction) throws InterruptedException {

        //For driving
        // declare variables for this method (power, totalSeconds (milliseconds) & Direction)
        //For forwards set direction = 1 (In method call)
        // For backwards set direction = -1 (In method call)
        //example: driveStraight(1, 5, 1) means drive straight at 100% power, for 5 seconds, in forward direction
        //example: driveStraight(1, 5, -1) means drive straight at 100% power, for 5 seconds, in backwards direction

        leftDrive.setPower(power * Direction);
        rightDrive.setPower(power * Direction);

        Thread.sleep((long) totalSeconds);
        //look up what the "long" means

        //Stop Robot

        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);

    }

    public void PivotSpin(double power, long totalSeconds, int Direction) throws InterruptedException {

        //For pivot Turning robot
        // declare variables for this method (power, totalSeconds (milliseconds) & Direction)
        //For right motion set direction = 1 (In method call)
        //For left motion set direction = -1 (In method call)
        //180 degree spin at 100% power takes -----; at 75% takes ----; at 50% takes
        //90 degree spring at 100% power takes----; at 75% takes ----; at 50% takes

        //example: CenterSpin(1, 3, 1) means spin at 100% power, for 3 seconds, to the right

        if (Direction == 1) {

            leftDrive.setPower(power * Direction);
            rightDrive.setPower(0);
        }

        if (Direction==-1) {

            leftDrive.setPower(0);
            rightDrive.setPower(power * Direction);
        }

        Thread.sleep(totalSeconds);

        // stops all motion

        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
    }

    public void CenterSpin(double power, long totalSeconds, int Direction) throws InterruptedException {

        //For Center Turning robot
        // declare variables for this method (power, totalSeconds (milliseconds) & Direction)
        //For right motion set direction = 1 (In method call)
        //For left motion set direction = -1 (In method call)
        //180 degree spin at 100% power takes -----; at 75% takes ----; at 50% takes
        //90 degree spring at 100% power takes----; at 75% takes ----; at 50% takes

        //example: CenterSpin(1, 3, 1) means spin at 100% power, for 3 seconds, to the right

        if (Direction == 1) {

            leftDrive.setPower(power * Direction);
            rightDrive.setPower(-power * Direction);
        }

        if (Direction==-1) {

            leftDrive.setPower(power * Direction);
            rightDrive.setPower(-power * Direction);
        }

        Thread.sleep(totalSeconds);

        // stops all motion

        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
    }
}

