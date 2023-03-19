package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
        
        //out                 
        if (joystick.getRawButton(6) && subsystem.armEncoder.get() <= 14000) {
            subsystem.setMotors(.5);
            //in   && Arm.isArmTriggered == false
        } else if (joystick.getRawButton(4) && subsystem.isArmTriggered == true) {
            subsystem.setMotors(-.6); 

        } else {
            subsystem.setMotors(0);
        }
        if(joystick.getRawButton(9)){
            Arm.armMotor.set(ControlMode.Position, 187057);
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
