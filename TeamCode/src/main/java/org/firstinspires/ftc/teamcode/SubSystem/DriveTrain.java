package org.firstinspires.ftc.teamcode.SubSystem;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Util.Constants;
import org.firstinspires.ftc.teamcode.Util.Logger;

import java.util.Locale;

@Config
public class DriveTrain {
    // Drive Base
    MecanumDrive driveBase;
    // PID Controllers
    //private final PIDController headingControl;
   // public static PIDCoefficients headingPID = new PIDCoefficients(Constants.DriveBase.HEADING_Kp,Constants.DriveBase.HEADING_Ki,Constants.DriveBase.HEADING_Kd);

    // Hardware Mapping
    private final HardwareMap hwMap;
    // Motor definition
    private Motor leftFrontDrive;
    private Motor leftBackDrive;
    private Motor rightFrontDrive;
    private Motor rightBackDrive;

    public DriveTrain(HardwareMap hwMap) {
        this.hwMap = hwMap;
        this.assignMotors();
        this.initializeMotors();
    }

    private void assignMotors(){
        // Assign the motors
        this.leftFrontDrive = new Motor(hwMap, "left_front_drive"); // 0
        this.rightFrontDrive = new Motor(hwMap, "right_front_drive"); // 1
        this.leftBackDrive = new Motor(hwMap, "left_back_drive"); // 2
        this.rightBackDrive = new Motor(hwMap, "right_back_drive"); // 3
    }

    private void initializeMotors(){
        // Initialize Motors
        this.leftFrontDrive.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        this.leftBackDrive.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        this.rightFrontDrive.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        this.rightBackDrive.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        // Inverting, since it isn't direct drive
        this.leftFrontDrive.setInverted(true);
        this.leftBackDrive.setInverted(true);
        this.rightFrontDrive.setInverted(true);
        this.rightBackDrive.setInverted(true);
    }
}
