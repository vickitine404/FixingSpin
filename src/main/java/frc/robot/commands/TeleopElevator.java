package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Joystick;

public class TeleopElevator extends CommandBase {

    private final Elevator subsystem;
    private final Joystick joystick;

    public TeleopElevator(Elevator subsystem, Joystick joystick) {
        this.subsystem = subsystem;
        this.joystick = joystick;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
    }
    //-5000
    //1091
    @Override
    public void execute() {
        // && subsystem.isTopLimitSwitchTriggered == false
        if (joystick.getRawButton(3) && subsystem.bottomLimit > -3000) {
            subsystem.setMotors(.3);
        } else if (joystick.getRawButton(5) && subsystem.isTopLimitSwitchTriggered == true) {
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
