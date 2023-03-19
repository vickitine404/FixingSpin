package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.sensors.Pigeon2;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.lib.util.COTSFalconSwerveConstants;
import frc.lib.util.SwerveModuleConstants;

public final class Constants {
    public static final double stickDeadband = 0.08;
    
    public static final class Pneumatics{
        public static Compressor air;
        public static DoubleSolenoid clawTilt;
        public static DoubleSolenoid clawClamp; 
    
        public static void init() {
            air = new Compressor(1, PneumaticsModuleType.REVPH);
            clawTilt = new DoubleSolenoid(1,PneumaticsModuleType.REVPH, 4, 5);
            clawClamp = new DoubleSolenoid(1,PneumaticsModuleType.REVPH, 6, 7);
        }

    }

    // public static final class Lock{
        
    // }

    public static final class Arm{
        public static final int armMotor = 22;
        
    }

    public static final class Elevator{
        public static final int leftElevator = 18;
        public static final int rightElevator = 19;
    }
    public static final class Grippers{
        public static final int leftGripper = 24;
        public static final int rightGripper = 23;
    }

    public static final class Tank{
        public static final int frontRight = 2;
        public static final int frontLeft = 5;
        public static final int backRight = 10;
        public static final int backLeft = 6;
    }

    public static final class Swerve {
        public static final int pigeonID = 17;
        public static final boolean invertGyro = false; // Always ensure Gyro is CCW+ CW-
        
        public static final COTSFalconSwerveConstants chosenModule =  //done
            COTSFalconSwerveConstants.SDSMK4(COTSFalconSwerveConstants.driveGearRatios.SDSMK4_L2);

        /* Drivetrain Constants */
        public static final double trackWidth = Units.inchesToMeters(21.73); //later
        public static final double wheelBase = Units.inchesToMeters(21.73); //later
        public static final double wheelCircumference = chosenModule.wheelCircumference;

        /* Swerve Kinematics 
         * No need to ever change this unless you are not doing a traditional rectangular/square 4 module swerve */
         public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
            new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));

        /* Module Gear Ratios */
        public static final double driveGearRatio = chosenModule.driveGearRatio;
        public static final double angleGearRatio = chosenModule.angleGearRatio;

        /* Motor Inverts */
        public static final boolean angleMotorInvert = chosenModule.angleMotorInvert;
        public static final boolean driveMotorInvert = chosenModule.driveMotorInvert;

        /* Angle Encoder Invert */
        public static final boolean canCoderInvert = chosenModule.canCoderInvert;

        /* Swerve Current Limiting */
        public static final int angleContinuousCurrentLimit = 25;
        public static final int anglePeakCurrentLimit = 40;
        public static final double anglePeakCurrentDuration = 0.1;
        public static final boolean angleEnableCurrentLimit = true;

        public static final int driveContinuousCurrentLimit = 35;
        public static final int drivePeakCurrentLimit = 60;
        public static final double drivePeakCurrentDuration = 0.1;
        public static final boolean driveEnableCurrentLimit = true;

        /* These values are used by the drive falcon to ramp in open loop and closed loop driving.
         * We found a small open loop ramp (0.25) helps with tread wear, tipping, etc */
        public static final double openLoopRamp = 0.25;
        public static final double closedLoopRamp = 0.0;

        /* Angle Motor PID Values */
        public static final double angleKP = chosenModule.angleKP;
        public static final double angleKI = chosenModule.angleKI;
        public static final double angleKD = chosenModule.angleKD;
        public static final double angleKF = chosenModule.angleKF;

        /* Drive Motor PID Values */
        public static final double driveKP = 0.05; //done
        public static final double driveKI = 0.0;
        public static final double driveKD = 0.0;
        public static final double driveKF = 0.0;

        /* Drive Motor Characterization Values 
         * Divide SYSID values by 12 to convert from volts to percent output for CTRE */
        public static final double driveKS = (0.32 / 12); //done
        public static final double driveKV = (1.51 / 12);
        public static final double driveKA = (0.27 / 12);

        /* Swerve Profiling Values */
        /** Meters per Second */
        public static final double maxSpeed = 4.5; //change later
        /** Radians per Second */
        public static final double maxAngularVelocity = 10.0; //change later

        /* Neutral Modes */
        public static final NeutralMode angleNeutralMode = NeutralMode.Coast;
        public static final NeutralMode driveNeutralMode = NeutralMode.Brake;

        /* Module Specific Constants */
        /* Front Left Module - Module 0 */
        public static final class Mod0 { //done
            public static final int driveMotorID = 5;
            public static final int angleMotorID = 4;
            public static final int canCoderID = 13;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-113);//-113 //67
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }

        /* Front Right Module - Module 1 */
        public static final class Mod1 { //done
            public static final int driveMotorID = 2;
            public static final int angleMotorID = 1;
            public static final int canCoderID = 16;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(132.75); //132.75 //-47.25
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }
        
        /* Back Left Module - Module 2 */
        public static final class Mod2 { //done
            public static final int driveMotorID = 6;
            public static final int angleMotorID = 7;
            public static final int canCoderID = 15;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-39.25);//-39.25 //140.75
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }

        /* Back Right Module - Module 3 */
        public static final class Mod3 { //done
            public static final int driveMotorID = 10;
            public static final int angleMotorID = 9;
            public static final int canCoderID = 12;
            public static final Rotation2d angleOffset = Rotation2d.fromDegrees(154.75);//154.75 //-25.25
            public static final SwerveModuleConstants constants = 
                new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
        }
    }

    public static final class AutoConstants { 
        
        public static double kMaxSpeedMetersPerSecond = 1;
        public static double kMaxAccelerationMetersPerSecondSquared = 1;
        
        public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
        public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;
    
        public static final double kPXController = 0.5;
        public static final double kPYController = 0.5;
        public static final double kPThetaController = 1;
    
        static {
            Pigeon2 pigeon = new Pigeon2(17);
            
            if (pigeon.getRoll() < -0.5){
                kMaxSpeedMetersPerSecond = 0.25;
                kMaxAccelerationMetersPerSecondSquared = 0.25;
            }
            else {
                kMaxSpeedMetersPerSecond = 0.5;
                kMaxAccelerationMetersPerSecondSquared = 0.5;
            }
        }
        
        /* Constraint for the motion profilied robot angle controller */
   
        public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
            new TrapezoidProfile.Constraints(
                kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
    }
}
