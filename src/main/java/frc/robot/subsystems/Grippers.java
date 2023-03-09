package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Grippers extends SubsystemBase {
    private final WPI_TalonFX  masterMotor;
    private final WPI_TalonFX  followerMotor;

    public Grippers(WPI_TalonFX masterMotor, WPI_TalonFX followerMotor) {
        this.masterMotor = masterMotor;
        this.followerMotor = followerMotor;
    }

    public void setMotors(double speed) {
        masterMotor.set(TalonFXControlMode.PercentOutput, speed);
        followerMotor.follow(masterMotor);
        followerMotor.setInverted(InvertType.FollowMaster);
    }

}
