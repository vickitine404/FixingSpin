package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tank;

public class TeleopTank extends CommandBase {
    //set the left and right joysticks for the tank drive
    private final Tank tank;
    private final Joystick leftJoystick = new Joystick(0);
    private final Joystick rightJoystick = new Joystick(1);


  
    public TeleopTank(Tank tank, Joystick leftStick, Joystick rightStick) {
        this.tank = tank;
        addRequirements(tank);
    }
  
    //get the speed from the y position on the joysticks.
    @Override
    public void execute() {
        double leftSpeed = -leftJoystick.getY();
        double rightSpeed = -rightJoystick.getY();
        tank.setLeftMotors(leftSpeed);
        tank.setRightMotors(rightSpeed);
    }

    @Override
    public void end(boolean interrupted) {
        tank.stop();
    }
}

