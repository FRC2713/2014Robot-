/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.Preferences;
/**
 *
 * @author Finn
 */
public class MoveArm extends CommandBase {
    
    public double armdeadband = 0.1;
    Preferences prefs;
    
    public MoveArm() {
        requires(arm);
        prefs = Preferences.getInstance();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        armdeadband=prefs.getDouble("ArmDeadband",0.1);
        arm.Lift(oi.getXbox().getTriggerAxis(), armdeadband);
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