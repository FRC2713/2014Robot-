/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.MoveArm;

/**
 *
 * @author Finn
 */
public class Arm extends Subsystem {
    
    CANJaguar arm;
    public void initDefaultCommand() {
        setDefaultCommand(new MoveArm());
    }
    
    public Arm(){ 
        try {
            //creates the motors
            arm = new CANJaguar(RobotMap.ARM_MOTOR);//, CANJaguar.ControlMode.kSpeed);    
            
        } catch(CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void Lift(double value, double deadband){
        try {
            arm.setX(calcDeadban(value, deadband));
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
   
   private double calcDeadban(double value, double deadban) {
        int sign = (value > 0 ? 1 : -1);                //checks the sign of the value
        value *= sign;                                  //changes the value to positive
        if(value <= deadban) {                          
            return 0.0;                                 //returns 0 if it is less than deadban
        } else{
            return (value - deadban) * sign;            //returns vale minus deadban
        }
    }
   
}
