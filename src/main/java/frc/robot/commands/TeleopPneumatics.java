package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;

public class TeleopPneumatics extends CommandBase {

    private final Pneumatics subsystem;
    private final Joystick joystick;

    public TeleopPneumatics(Pneumatics subsystem, Joystick joystick) {
        this.subsystem = subsystem;
        this.joystick = joystick;
        addRequirements(subsystem);
        Constants.Pneumatics.air.enableDigital();
    }

    @Override
    public void initialize() {
        Constants.Pneumatics.clawClamp.set(DoubleSolenoid.Value.kForward);
        Constants.Pneumatics.clawTilt.set(DoubleSolenoid.Value.kReverse);
        

    }
    private boolean toggle = false;
    @Override
    public void execute() {
        if (joystick.getRawButtonPressed(5) ) {
            Constants.Pneumatics.clawClamp.toggle();
        } else if (joystick.getRawButtonPressed(3)) {
            //Constants.Pneumatics.clawTilt.toggle();
            if (toggle) Constants.Pneumatics.clawTilt.set(DoubleSolenoid.Value.kOff);
            else Constants.Pneumatics.clawTilt.set(DoubleSolenoid.Value.kReverse);
        } 
    }

    @Override
    public void end(boolean interrupted) {
        Constants.Pneumatics.clawClamp.set(DoubleSolenoid.Value.kForward);
        Constants.Pneumatics.clawTilt.set(DoubleSolenoid.Value.kForward);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}