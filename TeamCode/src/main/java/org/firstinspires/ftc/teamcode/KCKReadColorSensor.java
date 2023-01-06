package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//REMINDER -- Battery Level effects Motor Power which effects timing

@Autonomous (name = "KCK Color Sensor")

//@Disabled

public class KCKReadColorSensor extends LinearOpMode {

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

        Wall_E.DriveStraight(0.5,400,1);//DriveStraight
        Thread.sleep(1200);
        //Read Sensor, if sensor = 1
        Wall_E.DriveSideways(0.5,700,-1);//DriveSideways
//Read sensor, if sensor = 2
        Thread.sleep(1200);
        //Read sensor, if sensor = 3
        Wall_E.DriveSideways(0.5,700,1);//DriveSideways

        //Place and Cone

       //





    }
}
