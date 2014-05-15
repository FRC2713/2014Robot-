/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Ryan Bradford, as well as finn
 */
public class UnWind extends CommandBase {

    Timer clock;

    public UnWind() {
        requires(catapult);
        clock = new Timer();
    }


    // Called just before this Command runs the first time
    protected void initialize() {
        clock.reset();
        clock.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        catapult.setMotor(1);
        
    }
          

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (clock.get() > 0.25){
            return true;
        }else{
            return false;
        }
    }


    // Called once after isFinished returns true
    protected void end() {
        catapult.setMotor(0);
        clock.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        catapult.setMotor(0);
        clock.stop();
    }
}