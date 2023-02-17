package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DigitalSource;
//import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class Elevator extends SubsystemBase {
    private final WPI_TalonFX  masterMotor;
    private final WPI_TalonFX  followerMotor;
    private final Encoder encoder;
    private final DigitalInput limitSensor;

    public int upperLimit;
    public int bottomLimit;

    
    public Elevator(WPI_TalonFX masterMotor, WPI_TalonFX followerMotor, int channelA, int channelB, int limitChannel) {
        this.masterMotor = masterMotor;
        this.followerMotor = followerMotor;
        this.encoder = new Encoder(channelA, channelB);
        this.limitSensor = new DigitalInput(limitChannel);
    }

    public void defineLimits(){
        
    }

    public void setMotors(double speed) {
        masterMotor.set(TalonFXControlMode.PercentOutput, speed);
        followerMotor.follow(masterMotor);
        followerMotor.setInverted(InvertType.FollowMaster);
        SmartDashboard.putNumber("encoder", encoder.get());
    }

}
