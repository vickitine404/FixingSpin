package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Grippers;
import edu.wpi.first.wpilibj.Joystick;

public class TeleopGrippers extends CommandBase {

    private final Grippers subsystem;
    private final Joystick joystick;

    public TeleopGrippers(Grippers subsystem, Joystick joystick) {
        this.subsystem = subsystem;
        this.joystick = joystick;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
    }
    //7 down
    @Override
    public void execute() {
        if (joystick.getRawButton(7)) {
            subsystem.setMotors(.3);
        } else if (joystick.getRawButton(9)) {
            subsystem.setMotors(-.3); 
        } else {
            subsystem.setMotors(0);
        }
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.setMotors(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
