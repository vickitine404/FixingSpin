package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.Joystick;

public class TeleopArm extends CommandBase {

    private final Arm subsystem;
    private final Joystick joystick;

    public TeleopArm(Arm subsystem, Joystick joystick) {
        this.subsystem = subsystem;
        this.joystick = joystick;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
    }
    @Override
    public void execute() {
        //out              && subsystem.armEncoder.get() <= 11000
        if (joystick.getRawButton(6)) {
            subsystem.setMotors(.5);
            //in
        } else if (joystick.getRawButton(4) ) {
            subsystem.setMotors(-.15); 
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
