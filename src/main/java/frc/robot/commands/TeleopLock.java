package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lock;
import frc.robot.Constants;

public class TeleopLock extends CommandBase {
    //set the left and right joysticks for the tank drive
    private final Lock lock;
    private final Joystick joystick = new Joystick(1);
    private final WPI_TalonFX frontLeft = new WPI_TalonFX(5);
    private final WPI_TalonFX frontRight = new WPI_TalonFX(2);
    private final WPI_TalonFX backLeft = new WPI_TalonFX(6);
    private final WPI_TalonFX backRight = new WPI_TalonFX(10);
    public boolean toggle = false;


  
    public TeleopLock(Lock lock, Joystick rightStick) {
        this.lock = lock;
        addRequirements(lock);
    }
  
    //get the speed from the y position on the joysticks.
    @Override
    public void execute() {

        if (joystick.getRawButtonPressed(1)) {
            if (!toggle) {
                backLeft.setNeutralMode(NeutralMode.Brake);
                backRight.setNeutralMode(NeutralMode.Brake);
                frontLeft.setNeutralMode(NeutralMode.Brake);
                frontRight.setNeutralMode(NeutralMode.Brake);
                toggle = true;
            } else {
                backLeft.setNeutralMode(NeutralMode.Coast);
                backRight.setNeutralMode(NeutralMode.Coast);
                frontLeft.setNeutralMode(NeutralMode.Coast);
                frontRight.setNeutralMode(NeutralMode.Coast);
                toggle = false;
            }
        }
        
    }

    @Override
    public void end(boolean interrupted) {
    }
}
