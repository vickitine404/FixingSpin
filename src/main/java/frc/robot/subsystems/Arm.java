package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Arm extends SubsystemBase {
    private final WPI_TalonFX armMotor;

    public Arm(WPI_TalonFX armMotor) {
        this.armMotor = armMotor;
        armMotor.setNeutralMode(NeutralMode.Brake);;
    }


    public void setMotors(double speed) {
        armMotor.set(TalonFXControlMode.PercentOutput, speed);

    }
}
