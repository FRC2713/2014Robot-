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
public class Autonomous extends CommandBase {

    ShooterComputer shooter;
    boolean hot;
    private Timer clock;
    boolean stopped1;
    boolean stopped2;

    public Autonomous() {
        stopped1 = false;
        stopped2 = false;
        requires(catapult);
        requires(arm);
        requires(drive);
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
        if (clock.get() < 1.0) {
            arm.Lift(1.0, 0);
            drive.Move(1.0);
        }
        if (clock.get() < 4.2) {
            catapult.setMotor(-1);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (clock.get() > 1.0) {
            arm.Lift(0, 0);
            drive.Move(0);
        }
        if (clock.get() > 4.2) {
            catapult.Stop();

            if (hot == true) {
                return true;
            } else if (clock.get() > 7.0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        arm.Lift(0, 0);
        drive.Move(0);
        catapult.Stop();
        clock.stop();
        clock.reset();        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        arm.Lift(0, 0);
        drive.Move(0);
        catapult.Stop();
        clock.stop();
        clock.reset();
    }
}
