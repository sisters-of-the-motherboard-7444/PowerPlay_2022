package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//REMINDER -- Battery Level effects Motor Power which effects timing

@Autonomous (name = "Right Park Terminal")

//@Disabled

public class RightParkTerminal extends LinearOpMode {

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

        Wall_E.DriveSideways(.6, 900, 1); //Forward Motion
        Thread.sleep(1500);
       // Wall_E.StopMotion(1500);
        //drop cone
        //Wall_E.CenterSpin(.5,500,1); //Center Spin to the Right
        Thread.sleep(500);
        //Grab and Lift Cone
        //Wall_E.DriveStraight(.75,375,1); //Backwards Motion
        Thread.sleep(500);
       // Wall_E.CenterSpin(1,500,1); //Center Spin to the Right
        Thread.sleep(500);
       // Wall_E.DriveStraight(.5, 1000, -1); //Forward Motion
        Thread.sleep(250);
        //Place and Cone


    }
}
