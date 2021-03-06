package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

@TeleOp public class NJHSRobotA extends OpMode {

    public DcMotor rightBack;   // its for wiring, like so u know how many motors are being used
    public DcMotor leftBack;   // and like how many servos
    public DcMotor collection;      // just a routine, no code to learn here :)
    public Servo servo;

    @Override
    public void init() {
        rightBack = hardwareMap.dcMotor.get("rightBack");   // 
        leftBack = hardwareMap.dcMotor.get("leftBack");
       
        collection = hardwareMap.dcMotor.get("collection");
        servo = hardwareMap.servo.get("servo");
    
    @Override
    public void start(){}

    @Override
    public void loop() {
    // right stick y : forward and back
    // right stick x : turning left and right
    // triggers : strafing left and right
    // left stick x and y: diagonals
    
    leftBack.setPower(.4*(-gamepad1.right_stick_y)+ .6*gamepad1.right_stick_x);
    rightBack.setPower(.4*(gamepad1.right_stick_y)+ .6*gamepad1.right_stick_x);

    //Collection  
        collection.setPower(gamepad2.right_stick_y*-.9);
    
    if(gamepad2.a){
        servo.setPosition(1);
    }
    if(gamepad2.x){
        servo.setPosition(0);
    }
    }


    @Override
    public void stop () {
    }
}
