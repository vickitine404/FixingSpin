package frc.robot.autos;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pneumatics;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Grippers;
import frc.robot.subsystems.Swerve;

public class realAuto extends CommandBase {

    private Elevator elevator;
    private Arm arm;
    private Swerve swerve;
    private Pneumatics pneumatics;
    private Grippers grippers;

    public realAuto(Elevator s_Elevator, Arm s_Arm, Swerve s_Swerve, Pneumatics s_Pneumatics, Grippers s_Grippers) {
        this.elevator = s_Elevator;
        this.arm = s_Arm;
        this.swerve = s_Swerve;
        this.pneumatics = s_Pneumatics;
        this.grippers = s_Grippers;
        addRequirements();
    }

    private boolean run = true;
    @Override
    public void execute() {
        if (!run) return;
        run = false;
        try {
            Constants.Pneumatics.air.enableDigital();
            elevator.setMotors(-0.75);
            arm.setMotors(0.41);
            Thread.sleep(1000L);
            elevator.setMotors(0);
            arm.setMotors(0);
            Thread.sleep(100L);

            Constants.Pneumatics.clawTilt.set(DoubleSolenoid.Value.kForward);
            Thread.sleep(100L);

            arm.setMotors(0.8);
            Thread.sleep(1750L);
            arm.setMotors(0);
            Thread.sleep(100L);

            grippers.setMotors(0.4);
            Thread.sleep(1000L);
            Constants.Pneumatics.clawClamp.set(DoubleSolenoid.Value.kReverse);
            grippers.setMotors(0);
            Thread.sleep(100L);

            elevator.setMotors(0.20);
            arm.setMotors(-0.75);
            Thread.sleep(2000L);
            arm.setMotors(0);
            elevator.setMotors(0);
            Thread.sleep(100L);

            
            Thread.sleep(4000L);


            //Constants.Pneumatics.clawTilt.toggle();
            // Thread.sleep(500L);
        } catch (Exception e){

        }
        
    }

    @Override
    public void end(boolean interrupted) {
    }
}
