package frc.robot.autos;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pneumatics;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Tank;

public class realAuto extends CommandBase {

    private Elevator elevator;
    private Arm arm;
    private Tank tank;
    private Pneumatics pneumatics;

    public realAuto(Elevator s_Elevator, Arm s_Arm, Tank s_Tank, Pneumatics s_Pneumatics) {
        this.elevator = s_Elevator;
        this.arm = s_Arm;
        this.tank = s_Tank;
        this.pneumatics = s_Pneumatics;
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
            Thread.sleep(1650L);
            elevator.setMotors(0);
            //lower later
            // Thread.sleep(1000L);
            // arm.setMotors(0.5);
            // Thread.sleep(500L);
            // arm.setMotors(0);
            // Thread.sleep(100);
            Constants.Pneumatics.clawTilt.set(DoubleSolenoid.Value.kReverse);
            Constants.Pneumatics.clawTilt.toggle();
            // Thread.sleep(500L);
        } catch (Exception e){

        }
        
    }

    @Override
    public void end(boolean interrupted) {
    }
}
