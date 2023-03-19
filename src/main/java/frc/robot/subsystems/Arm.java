package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.time.Period;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;



public class Arm extends SubsystemBase {
    public static WPI_TalonFX armMotor;
    public final Encoder armEncoder;
    public final DigitalInput armLimit;

    public double tempLimit;
    public double backLimit;
    public double trueLimit;
    public boolean isArmTriggered = false;
    
    public Arm(WPI_TalonFX armMotor, int channelA, int channelB, int limitChannel) {
        this.armMotor = armMotor;
        this.armEncoder = new Encoder(channelA, channelB);
        this.armLimit = new DigitalInput(limitChannel);
        armMotor.config_kP(0,0.23);
        armMotor.setNeutralMode(NeutralMode.Brake);
        //backLimit = armEncoder.get();
    }

    public void zeroOutArm() {
        
    }

    
    public void setMotors(double speed) {
        armMotor.set(TalonFXControlMode.PercentOutput, speed);
        SmartDashboard.putNumber("ArmEncoder", armEncoder.get());

        if (armLimit.get()) {
            backLimit = armEncoder.get();      
            isArmTriggered = true;
        } else {
            isArmTriggered = false;
        }
        
        trueLimit = armEncoder.get() - backLimit;

    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("armMotorTicks", armMotor.getSensorCollection().getIntegratedSensorPosition());
    }
    
}
