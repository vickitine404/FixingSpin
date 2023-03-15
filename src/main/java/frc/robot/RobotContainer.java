package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    
    private final Joystick leftStick = new Joystick(0);
    private final Joystick rightStick = new Joystick(1);
    private final Joystick soloStick = new Joystick(3);
    
    /* Drive Controls */
    private final int translationAxis = Joystick.AxisType.kY.value;
    private final int strafeAxis = Joystick.AxisType.kX.value;
    private final int rotationAxis = Joystick.AxisType.kX.value; //right
    
    //private final int leftTankAxis = Joystick.AxisType.kY.value;
    //private final int rightTankAxis = Joystick.AxisType.kThrottle.value;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(leftStick, 1);
    private final JoystickButton robotCentric  = new JoystickButton(leftStick, 12);
    //private final JoystickButton toggleDriveMode = new JoystickButton(rightStick, 2);

    /* Subsystems */
    private final Swerve s_Swerve = new Swerve();
    private final Elevator s_Elevator = new Elevator(new WPI_TalonFX(Constants.Elevator.leftElevator), new WPI_TalonFX(Constants.Elevator.rightElevator), 8, 9, 7);
    private final Arm s_Arm = new Arm(new WPI_TalonFX(Constants.Arm.armMotor), 6, 5, 4); 
    private final Grippers s_Grippers = new Grippers(new WPI_TalonFX(Constants.Grippers.leftGripper), new WPI_TalonFX(Constants.Grippers.rightGripper));
    private final Pneumatics s_Pneumatics = new Pneumatics();
    private final Tank s_Tank = new Tank(new WPI_TalonFX(Constants.Tank.frontLeft), new WPI_TalonFX(Constants.Tank.frontRight), new WPI_TalonFX(Constants.Tank.backLeft), new WPI_TalonFX(Constants.Tank.backRight));

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> -leftStick.getRawAxis(translationAxis), 
                () -> -leftStick.getRawAxis(strafeAxis), 
                () -> -rightStick.getRawAxis(rotationAxis), 
                () -> robotCentric.getAsBoolean()
            )
        );

        s_Elevator.setDefaultCommand(
            new TeleopElevator(s_Elevator, soloStick)
        );

        s_Arm.setDefaultCommand(
            new TeleopArm(s_Arm, soloStick)
        );

        s_Grippers.setDefaultCommand(
            new TeleopGrippers(s_Grippers, soloStick)
        );
        
        s_Pneumatics.setDefaultCommand(
            new TeleopPneumatics(s_Pneumatics, leftStick)
        );
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public boolean run = true;
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        if (run) {
            this.run = false;
            return new realAuto(s_Elevator, s_Arm, s_Tank, s_Pneumatics);
        }

        return null;

    }
}
