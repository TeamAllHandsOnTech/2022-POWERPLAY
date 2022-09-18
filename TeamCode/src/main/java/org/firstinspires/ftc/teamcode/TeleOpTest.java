
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleopTest", group="TeleOp Test")
public class TeleOpTest extends LinearOpMode{

    // Declare OpMode members for each of the 4 motors. Yay
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;
    double leftFrontPower;
    double rightFrontPower;
    double leftBackPower;
    double rightBackPower;
    double motorSpeed = 0.85f;

    @Override
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        leftFrontDrive  = hardwareMap.get(DcMotor.class, "frontLeft");
        leftBackDrive  = hardwareMap.get(DcMotor.class, "backLeft");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "frontRight");
        rightBackDrive = hardwareMap.get(DcMotor.class, "backRight");



        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            if (gamepad1.left_stick_y > 0.1){
                leftFrontPower = gamepad1.left_stick_y*motorSpeed;
                rightFrontPower = gamepad1.left_stick_y*motorSpeed;
                leftBackPower = gamepad1.left_stick_y*motorSpeed;
                rightBackPower = gamepad1.left_stick_y*motorSpeed;
            }else if(gamepad1.left_stick_y < -0.1){
                leftFrontPower = gamepad1.left_stick_y*motorSpeed;
                rightFrontPower = gamepad1.left_stick_y*motorSpeed;
                leftBackPower = gamepad1.left_stick_y*motorSpeed;
                rightBackPower = gamepad1.left_stick_y*motorSpeed;
            }else{
                leftFrontPower = 0;
                rightFrontPower = 0;
                leftBackPower = 0;
                rightBackPower = 0;
            }
            leftFrontDrive.setPower(leftFrontPower);
            rightFrontDrive.setPower(rightFrontPower);
            leftBackDrive.setPower(leftBackPower);
            rightBackDrive.setPower(rightBackPower);

            if (gamepad1.left_stick_x > 0.1){
                leftFrontPower = -gamepad1.left_stick_y*motorSpeed;
                rightFrontPower = gamepad1.left_stick_y*motorSpeed;
                leftBackPower = gamepad1.left_stick_y*motorSpeed;
                rightBackPower = -gamepad1.left_stick_y*motorSpeed;
            }else if(gamepad1.left_stick_x < -0.1){
                leftFrontPower = -gamepad1.left_stick_y*motorSpeed;
                rightFrontPower = gamepad1.left_stick_y*motorSpeed;
                leftBackPower = -gamepad1.left_stick_y*motorSpeed;
                rightBackPower = gamepad1.left_stick_y*motorSpeed;
            }else{
                leftFrontPower = 0;
                rightFrontPower = 0;
                leftBackPower = 0;
                rightBackPower = 0;
            }

            leftFrontDrive.setPower(leftFrontPower);
            rightFrontDrive.setPower(rightFrontPower);
            leftBackDrive.setPower(leftBackPower);
            rightBackDrive.setPower(rightBackPower);

            if (gamepad1.right_stick_x > 0.1){
                leftFrontPower = -gamepad1.right_stick_x*motorSpeed;
                rightFrontPower = gamepad1.right_stick_x*motorSpeed;
                leftBackPower = -gamepad1.right_stick_x*motorSpeed;
                rightBackPower = gamepad1.right_stick_x*motorSpeed;
            }else if(gamepad1.right_stick_x < -0.1){
                leftFrontPower = -gamepad1.right_stick_x*motorSpeed;
                rightFrontPower = gamepad1.right_stick_x*motorSpeed;
                leftBackPower = -gamepad1.right_stick_x*motorSpeed;
                rightBackPower = gamepad1.right_stick_x*motorSpeed;
            }else{
                leftFrontPower = 0;
                rightFrontPower = 0;
                leftBackPower = 0;
                rightBackPower = 0;
            }
            leftFrontDrive.setPower(leftFrontPower);
            rightFrontDrive.setPower(rightFrontPower);
            leftBackDrive.setPower(leftBackPower);
            rightBackDrive.setPower(rightBackPower);
        }
    }}
