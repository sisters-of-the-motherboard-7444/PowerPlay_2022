package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//REMINDER -- Battery Level effects Motor Power which effects timing

@Autonomous (name = "AutoBabyBotPlay")

@Disabled

public class AutoBabyBotOne extends LinearOpMode {

    HardwareBabyBot Jude = new HardwareBabyBot();

    @Override

    public void runOpMode() throws InterruptedException {

        System.out.println("Starting up");
        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();

        System.out.println("Initialize Robot");
        Jude.InitializeRobot(hardwareMap);
        System.out.println("Robot Initialized");

        telemetry.addData("Status", "Ready!");

        telemetry.update();

        waitForStart();

        Jude.DriveStraight(1, 2000, 1); //Forward
        Thread.sleep(250);
        Jude.PivotSpin(1,1300,1); //Turn Right
        Thread.sleep(250);
        Jude.DriveStraight(1, 1000, 1); //Forward
        Thread.sleep(250);
        Jude.DriveStraight(1, 1000, -1); //Backward
        Thread.sleep(250);
        Jude.CenterSpin(1,800,-1); //Turn Left
        Thread.sleep(250);
       Jude.DriveStraight(1, 1800, 1); //Forward
       Thread.sleep(250);

    }
}
