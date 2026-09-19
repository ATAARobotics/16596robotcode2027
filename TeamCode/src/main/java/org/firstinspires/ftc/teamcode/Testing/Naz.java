package org.firstinspires.ftc.teamcode.Testing;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
@TeleOp(name = "Naz", group = "Testing")
public class Naz extends OpMode {
    public HardwareMap hwMap;
    private VoltageSensor voltageSensor;
    private double currentVoltage;
    private Telemetry telemetry;

    public void init() {
        voltageSensor = hwMap.voltageSensor.iterator().next();
        // Telemetry
        this.telemetry = FtcDashboard.getInstance().getTelemetry();
    }
    @Override
    public void loop(){
        currentVoltage = voltageSensor.getVoltage();
        this.telemetry.addData("Voltage: ","%.4f",this.currentVoltage);
        this.telemetry.update();
    }
}