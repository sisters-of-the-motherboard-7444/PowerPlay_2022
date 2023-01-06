package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.hardware.bosch.BNO055IMU;

/**
 * Original created by ashley.peake on 8/30/2018.
 * modified by KPSorrells (for teaching RoboLearners) 11/26/2022
 */

@Disabled
public class HardwarePowerPlay {

    //Wheels
    public DcMotor motorFrontLeft;
    public DcMotor motorBackLeft;
    public DcMotor motorFrontRight;
    public DcMotor motorBackRight;


    //DoubleReverse 4-Bar Lift
    //public DcMotor leftLift;
    //public DcMotor rightLift;
    //public DcMotor leftSlide;
    //public DcMotor rightSlide;

    //Servos or Claw - CR = continuos Servo
    //public CRServo sweeperLeft;
    //public CRServo sweeperRight;
    //public Servo boxLid;
    //public CRServo duckSpin;

    //Sets variable driveTime as an integer
    int driveTime;


//----------------------------Initialize Robot ---------------------------------
   /*  This method allows us to initialize the motors and sensors only once.
       It is called and used in every other program after "Init" is pressed.
    */

    public void InitializeRobot(HardwareMap hwMap) {

        HardwareMap HWMap = hwMap;

        //initialize Wheels
        motorFrontLeft= HWMap.dcMotor.get("motorFrontLeft");
        motorBackLeft= HWMap.dcMotor.get("motorBackLeft");
        motorFrontRight= HWMap.dcMotor.get("motorFrontRight");
        motorBackRight= HWMap.dcMotor.get("motorBackRight");

        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests
        //motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);//set for PracticeBot
        //motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE); //Set for PracticeBot
        //motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);//Competition Bot PowerPlay
        motorFrontRight.setDirection(DcMotorSimple.Direction.FORWARD); //Practice Bot
        motorBackRight.setDirection(DcMotorSimple.Direction.FORWARD); //Competition Bot PowerPlay
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE); //Competition Bot & PracticeBot PowerPlay
        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE); //Competition Bot & PracticeBot PowerPlay

        
        //Initialize DoubleReverse 4-Bar Lift
        //leftLift= HWMap.dcMotor.get("leftLift");
        //rightLift= HWMap.dcMotor.get("rightLift");
       // leftLift.setDirection(DcMotorSimple.Direction.REVERSE); //Set for Competition
        // leftSlide = HWMap.dcMotor.get("leftSlide");
        //rightSlide = HWMap.dcMotor.get("rightSlide");

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

        //For driving forward or backward
        // declare variables for this method (power, totalSeconds (milliseconds) & Direction)
        //For forwards set direction = 1 (In method call)
        // For backwards set direction = -1 (In method call)
        //example: driveStraight(1, 5, 1) means drive straight at 100% power, for 5 seconds, in forward direction
        //example: driveStraight(1, 5, -1) means drive straight at 100% power, for 5 seconds, in backwards direction

        motorFrontLeft.setPower(power * Direction);
        motorBackLeft.setPower(power * Direction);
        motorFrontRight.setPower(power * Direction);
        motorBackRight.setPower(power * Direction);

        Thread.sleep((long) totalSeconds);

        //Stop Robot
        motorFrontLeft.setPower(0.0);
        motorBackLeft.setPower(0.0);
        motorFrontRight.setPower(0.0);
        motorBackRight.setPower(0.0);

    } //End DriveStraight Method

    public void DriveSideways(double power, long totalSeconds, int Direction) throws InterruptedException {

        //For strafing to the left or the right
        // declare variables for this method (power, totalSeconds (milliseconds) & Direction)
        //For right motion set direction = 1 (In method call)
        //For left motion set direction = -1 (In method call)
        //example: driveSideways(.5, 3, 1) means drive straight at 50% power, for 3 seconds, in right direction
        //example: driveSideways(.75, 5, -1) means drive straight at 75% power, for 5 seconds, in left direction

        motorFrontLeft.setPower(power * Direction);
        motorBackLeft.setPower(power * -Direction);
        motorFrontRight.setPower(power * -Direction);
        motorBackRight.setPower(power * Direction);

        Thread.sleep(totalSeconds);

        // stops all motion
        motorFrontLeft.setPower(0.0);
        motorBackLeft.setPower(0.0);
        motorFrontRight.setPower(0.0);
        motorBackRight.setPower(0.0);

    } //Ends DriveSideways Method

    public void DiagonolForward(double power, long totalSeconds, int Direction) throws InterruptedException {

        //For driving forward in a diagonal direction
        // declare variables for this method (power, totalSeconds (milliseconds) & Direction)
        //For right motion set direction = 1 (In method call)
        //For left motion set direction = -1 (In method call)
        //example: DiagonolForward(.8, 3, 1) means drive straight at 80% power, for 3 seconds, in forward right direction
        //example: DiagonalForward(.75, 5, -1) means drive straight at 75% power, for 5 seconds, in forward left direction

        if (Direction == 1) {

            motorFrontLeft.setPower(power * Direction);
            motorBackLeft.setPower(0);
            motorFrontRight.setPower(0);
            motorBackRight.setPower(power * Direction);

            Thread.sleep(totalSeconds);
        }

        if (Direction == -1) {

            motorFrontLeft.setPower(0);
            motorBackLeft.setPower(power * -Direction);
            motorFrontRight.setPower(power * -Direction);
            motorBackRight.setPower(0);

            Thread.sleep(totalSeconds);
        }

        // stops all motion

        motorFrontLeft.setPower(0.0);
        motorBackLeft.setPower(0.0);
        motorFrontRight.setPower(0.0);
        motorBackRight.setPower(0.0);

    } //End Diagonal Forward Method


    public void DiagonolBackward(double power, long totalSeconds, int Direction) throws InterruptedException {

        //For driving forward in a diagonal direction
        // declare variables for this method (power, totalSeconds (milliseconds) & Direction)
        //For right motion set direction = 1 (In method call)
        //For left motion set direction = -1 (In method call)
        //example: DiagonolBackward(.8, 3, 1) means drive straight at 80% power, for 3 seconds, in back Right direction
        //example: DiagonalForward(.75, 5, -1) means drive straight at 75% power, for 5 seconds, in left direction

        if (Direction == 1) {

            motorFrontLeft.setPower(0);
            motorBackLeft.setPower(power * -Direction);
            motorFrontRight.setPower(power * -Direction);
            motorBackRight.setPower(0);

            Thread.sleep(totalSeconds);
        }

        if (Direction == -1) {

            motorFrontLeft.setPower(power * Direction);
            motorBackLeft.setPower(0);
            motorFrontRight.setPower(0);
            motorBackRight.setPower(power * Direction);

            Thread.sleep(totalSeconds);
        }

        // stops all motion

        motorFrontLeft.setPower(0.0);
        motorBackLeft.setPower(0.0);
        motorFrontRight.setPower(0.0);
        motorBackRight.setPower(0.0);

    } //End Diagonal Backward Method


    public void CenterSpin(double power, long totalSeconds, int Direction) throws InterruptedException {

        //For turning robot on center
        // declare variables for this method (power, totalSeconds (milliseconds) & Direction)
        //For right motion set direction = 1 (In method call)
        //For left motion set direction = -1 (In method call)
        //180 degree spin at 100% power takes -----; at 75% takes ----; at 50% takes
        //90 degree spring at 100% power takes----; at 75% takes ----; at 50% takes
        //Check BATTERY Power

        //example: CenterSpin(1, 3, 1) means spin at 100% power, for 3 seconds, to the right

        if (Direction == 1) {

            motorFrontLeft.setPower(power * Direction);
            motorBackLeft.setPower(power * Direction);
            motorFrontRight.setPower(power * -Direction);
            motorBackRight.setPower(power * -Direction);

            Thread.sleep(totalSeconds);
        }

        if (Direction == -1) {

            motorFrontLeft.setPower(power * Direction);
            motorBackLeft.setPower(power * Direction);
            motorFrontRight.setPower(power * -Direction);
            motorBackRight.setPower(power * -Direction);

            Thread.sleep(totalSeconds);
        }

        // stops all motion

        motorFrontLeft.setPower(0.0);
        motorBackLeft.setPower(0.0);
        motorFrontRight.setPower(0.0);
        motorBackRight.setPower(0.0);

    } //End CenterSpin Method

    public void StopMotion(double seconds) throws InterruptedException {
        // stops all motion

        motorFrontLeft.setPower(0.0);
        motorBackLeft.setPower(0.0);
        motorFrontRight.setPower(0.0);
        motorBackRight.setPower(0.0);
    }
}
