/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.ShooterComputer;

/**
 *
 * @author Ryan Bradford, as well as finn
 */
public class VTracking extends CommandBase {

    ShooterComputer shooter;
    boolean hot;
    private Timer clock;

    public VTracking() {
        clock = new Timer();
        shooter = new ShooterComputer();
        hot = false;

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        clock.reset();
        clock.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        hot = shooter.getHot();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (clock.get() > 4.2) {
            if (hot == true) {
                return true;
            }
        }
        if (clock.get() > 7.0) {
            return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        clock.stop();
        clock.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        clock.stop();
        clock.reset();
    }
}
