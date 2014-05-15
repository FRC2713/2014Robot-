/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.templates.subsystems.Passer;
import edu.wpi.first.wpilibj.Preferences;
/*
 *
 * @author Finn
 */
public class Drive extends CommandBase {
    
    int driveerStationNum = 1;
    Preferences prefs;
    public double Deadband = 0.1;
    double PolarityLeft = -1;
    double PolarityRight = -1;
    double Scaler = 1;  
    public Drive() {
        requires(drive);
        prefs = Preferences.getInstance();
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {  
        driveerStationNum = Passer.getNum();
        Deadband = prefs.getDouble("Deadband",0);
        PolarityLeft = prefs.getDouble("LeftPolarity",-1);
        PolarityRight = prefs.getDouble("RightPolarity",-1);
        Scaler = prefs.getDouble("Scaler",1);
   /*     switch (driveerStationNum) {
            case 1:
                drive.TankDrive(oi.getDriveJoystick1().getY()*PolarityLeft*Scaler, oi.getDriveJoystick2().getY()*PolarityRight*Scaler);
                
                break; //Positive on both controllers
            case 2:
                drive.ManualeArcadeDrice(oi.getDriveJoystick1().getY(), oi.getDriveJoystick1().getX());
                
                break; //positive on both controllers
            case 3:*/
                drive.TankDrive(oi.getXbox().getLeftY()*PolarityLeft*Scaler, oi.getXbox().getRightY()*PolarityRight*Scaler, Deadband);
    /*            
                break; //Negative on two controllers
            case 4:
                drive.ManualeArcadeDrice(oi.getXbox().getRightY()*PolarityRight*Scaler, oi.getXbox().getTriggerAxis(), Deadband);
                
                break; //Negative on controller  
        }*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
