package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LED;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Joystick;

public class TeleopLED extends CommandBase {

    private final LED subsystem;
    private final Joystick joystick;
    public AddressableLED leds = new AddressableLED(0);
    public AddressableLEDBuffer buffer = new AddressableLEDBuffer(27);

    public TeleopLED(LED subsystem, Joystick joystick) {
        this.subsystem = subsystem;
        this.joystick = joystick;
        
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        
        leds.setLength(27);
        for (int i = 0; i < buffer.getLength(); i++) {
            buffer.setRGB(i, 0, 0, 150);
        }
        leds.setData(buffer);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        leds.start();
        
    }
    @Override
    public void execute() {

        leds.setLength(buffer.getLength());

        if (joystick.getRawButtonPressed(11)) {
            for (int i = 0; i < buffer.getLength(); i++) {
                buffer.setRGB(i, 150, 0, 150);
            }

        } else if (joystick.getRawButtonPressed(12)) {
            for (int i = 0; i < buffer.getLength(); i++) {
                buffer.setRGB(i, 150, 150, 0);
            }

        } 


        leds.setData(buffer);
        leds.start();
        
        

    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}