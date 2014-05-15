package edu.wpi.first.wpilibj.templates.inputs;

import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 * @author David Samuelson
 */
public class Gamepad extends Joystick {

    private final double DEAD_BAND = 0.1;
    
    private final int LEFT_STICK_AXIS_X = 1;
    private final int LEFT_STICK_AXIS_Y = 2;
    private final int RIGHT_STICK_AXIS_X = 3;
    private final int RIGHT_STICK_AXIS_Y = 4;
    private final int D_PAD_AXIS_X = 5;
    private final int D_PAD_AXIS_Y = 6;
  
    
    
    public Gamepad(int port) {
        super(port);
    }
    
    public double getRawAxis(int axis) {
        return (super.getRawAxis(axis));
    }
    
    public double getLeftStickAxisX() {
        return getRawAxis(LEFT_STICK_AXIS_X);
    }
    
    public double getLeftStickAxisY() {
        return -getRawAxis(LEFT_STICK_AXIS_Y);
    }
    
    public double getRightStickAxisX() {
        return getRawAxis(RIGHT_STICK_AXIS_X);
    }
    
    public double getRightStickAxisY() {
        return -getRawAxis(RIGHT_STICK_AXIS_Y);
    }
    
    public double getDPadAxisX() {
        return getRawAxis(D_PAD_AXIS_X);
    }
    
    public double getDPadAxisY() {
        return getRawAxis(D_PAD_AXIS_Y);
    }
}
//stolen from D Sammyson by Finn