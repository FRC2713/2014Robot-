/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Drive;
/**
 *
 * @author Finn
 */
public class RoboDrive extends Subsystem {
    
    CANJaguar aLeft;
    CANJaguar bLeft;
    CANJaguar aRight;
    CANJaguar bRight;
    
    RobotDrive roboDrive;
    
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
    
    public RoboDrive(){
        
        try {
            //creates the motors
            aLeft = new CANJaguar(RobotMap.LEFT_DRIVE_MOTOR_ALPHA);
            bLeft = new CANJaguar(RobotMap.LEFT_DRIVE_MOTOR_BETA);//, CANJaguar.ControlMode.kSpeed);
            aRight = new CANJaguar(RobotMap.RIGHT_DRIVE_MOTOR_ALPHA);
            bRight = new CANJaguar(RobotMap.RIGHT_DRIVE_MOTOR_BETA);//, CANJaguar.ControlMode.kSpeed);

            //creates the drive train
            roboDrive = new RobotDrive(aLeft, bLeft, aRight, bRight);
            roboDrive.setSafetyEnabled(false);  
            
        } catch(CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void TankDrive(double left, double right){ //left value, right value 
        roboDrive.tankDrive(left, right);              //Must plug in axes' values, not the actual Joystick
    }
    
    public void TankDrive(double left, double right, double deadban){ //left value, right value 
        double ban = deadban;
        roboDrive.tankDrive(calcDeadban(left, ban), calcDeadban(right, ban));              //Must plug in axes' values, not the actual Joystick
    }
    
    public void ArcadeDrive(Joystick joystick1){ //left value, right value 
        roboDrive.arcadeDrive(joystick1); //Must plug in axes' values, not the actual Joystick
    }
    
    public void ManualeArcadeDrice(double move, double rotate){
        roboDrive.arcadeDrive(move, rotate);
    }
    
    public void ManualeArcadeDrice(double move, double rotate, double deadban){
        double ban = deadban;
        roboDrive.arcadeDrive(calcDeadban(move, ban), calcDeadban(rotate, ban));
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
    
    public void Move(double speed){
        roboDrive.drive(speed, 0);
    }
}
