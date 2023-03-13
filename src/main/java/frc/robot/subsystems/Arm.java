package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Arm extends SubsystemBase {
    private final WPI_TalonFX armMotor;
    public final DutyCycleEncoder armEncoder;

    public Arm(WPI_TalonFX armMotor, int channelA) {
        this.armMotor = armMotor;
        this.armEncoder = new DutyCycleEncoder(channelA);
        armMotor.setNeutralMode(NeutralMode.Brake);
    }


    public void setMotors(double speed) {
        armMotor.set(TalonFXControlMode.PercentOutput, speed);
        SmartDashboard.putNumber("ArmEncoder", armEncoder.get());

    }
}
