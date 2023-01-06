package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//REMINDER -- Battery Level effects Motor Power which effects timing

@Autonomous (name = "MecPlayAuto")

@Disabled

public class MecAutoKPSNov28 extends LinearOpMode {

    HardwarePowerPlay Wall_E = new HardwarePowerPlay();

    @Override

    public void runOpMode() throws InterruptedException {

        System.out.println("Starting up");
        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();

        System.out.println("Initialize Robot");
        Wall_E.InitializeRobot(hardwareMap);
        System.out.println("Robot Initialized");

        telemetry.addData("Status", "Ready!");

        telemetry.update();

        waitForStart();

        Wall_E.DriveStraight(.5, 500, 1); //Forward
        Thread.sleep(1000);
        Wall_E.DriveSideways(1,1000,1); //Drive Right
        Thread.sleep(500);
        Wall_E.DriveSideways(1,1500,-1); //Drive Right
        Thread.sleep(500);
        Wall_E.DiagonolForward(.5, 1000, -1); //Backward
        Thread.sleep(250);
        //BumbleBee.CenterSpin(1,800,-1); //Turn Left
        //Thread.sleep(250);
        //BumbleBee.DriveStraight(1, 1800, 1); //Forward
       //Thread.sleep(250);

    }
}
