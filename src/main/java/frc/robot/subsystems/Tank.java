package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Tank extends SubsystemBase {
    // change ids 
    private final WPI_TalonFX frontLeft = new WPI_TalonFX(5);
    private final WPI_TalonFX frontRight = new WPI_TalonFX(2);
    private final WPI_TalonFX backLeft = new WPI_TalonFX(6);
    private final WPI_TalonFX backRight = new WPI_TalonFX(10);

    //Set the back motors to follow the Fronts motors
    public Tank(WPI_TalonFX wpi_TalonFX, WPI_TalonFX wpi_TalonFX2, WPI_TalonFX wpi_TalonFX3, WPI_TalonFX wpi_TalonFX4) {
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);
    }

    //set the left and right motor speeds from the TeleopTank commands
    public void setLeftMotors(double speed) {
        frontLeft.set(speed);
    }
    
    public void setRightMotors(double speed) {
        frontRight.set(speed);
    }
    
    public void stop() {
        frontLeft.stopMotor();
        frontRight.stopMotor();
    }   

}