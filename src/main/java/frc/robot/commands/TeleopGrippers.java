package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Grippers;

import com.ctre.phoenix.motorcontrol.NeutralMode;

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
        if (joystick.getRawButton(2)) {
            subsystem.setMotors(0.4);
        } else if (joystick.getRawButton(1)) {
            subsystem.setMotors(-0.4); 
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
