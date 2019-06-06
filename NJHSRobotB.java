package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

@TeleOp public class NJHSRobotB extends OpMode {

    public DcMotor rightFront;  // this is a standard thing that is needed
    public DcMotor leftFront;   // it basically sets up the program
    public DcMotor rightBack;   // its for wiring, like so u know how many motors are being used
    public DcMotor leftBack;   // and like how many servos
    public DcMotor collection;      // just a routine, no code to learn here :)

    @Override
    public void init() {
        rightFront = hardwareMap.dcMotor.get("rightFront");  // now we are assigning a name to each motor/servo
        leftFront = hardwareMap.dcMotor.get("leftFront");   // also nothing special here
        rightBack = hardwareMap.dcMotor.get("rightBack");   // 
        leftBack = hardwareMap.dcMotor.get("leftBack");
       
        collection = hardwareMap.dcMotor.get("collection");
    
    @Override
    public void start(){}

    @Override
    public void loop() {
    // right stick y : forward and back
    // right stick x : turning left and right
    // triggers : strafing left and right
    // left stick x and y: diagonals
    
    leftBack.setPower(.4*(-gamepad1.right_stick_y)+ .6*gamepad1.right_stick_x + .7*(-gamepad1.left_stick_x));
    leftFront.setPower(.4*(-gamepad1.right_stick_y)+ .6*gamepad1.right_stick_x + .7*(gamepad1.left_stick_x));
    rightBack.setPower(.4*(gamepad1.right_stick_y)+ .6*gamepad1.right_stick_x + .7*(-gamepad1.left_stick_x));
    rightFront.setPower(.4*(gamepad1.right_stick_y)+ .6*gamepad1.right_stick_x + .7*(gamepad1.left_stick_x));

    //Collection  
        collection.setPower(gamepad2.right_stick_y*-.9);
    }


    @Override
    public void stop () {
    }
}
