package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Pneumatics;
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

        

    }
    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
