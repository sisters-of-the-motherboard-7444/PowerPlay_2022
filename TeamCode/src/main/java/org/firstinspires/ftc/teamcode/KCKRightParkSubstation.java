package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//REMINDER -- Battery Level effects Motor Power which effects timing

@Autonomous (name = "KCK Right Park Substation")

//@Disabled

public class KCKRightParkSubstation extends LinearOpMode {

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

        Wall_E.DriveSideways(0.5, 650, 1); //DriveSideways

        Thread.sleep(250);
        //Place and Cone


    }
}
