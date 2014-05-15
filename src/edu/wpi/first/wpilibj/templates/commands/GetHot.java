
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.ShooterComputer;

/**
 *
 * @author bradmiller
 */
public class GetHot extends CommandBase {
    Timer clock;
    ShooterComputer shooter;
    boolean hot;
    public GetHot() {
        clock=  new Timer();
        shooter = new ShooterComputer();
        hot = false;
        clock.reset();
        clock.start();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        hot = shooter.getHot();
        System.out.println(hot);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(hot == true) {
            return true;
        } else {
        if(clock.get() > 7){
            drive.Move(0);
            return true;
        }else {
            return false;
        }        }
        
    }

    // Called once after isFinished returns true
    protected void end() {
        clock.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {   
        clock.stop();
    }
}
