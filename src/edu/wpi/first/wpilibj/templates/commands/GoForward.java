package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author ryanbradford
 * and jay made that terrible timer thing #contributar
 */
public class GoForward extends CommandBase {

    private double speed;
    private Timer clock;

    public GoForward(double speed1) {
        speed = speed1;
        requires(drive);
        clock = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        clock.reset();
        clock.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.Move(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(clock.get() > 1){
            drive.Move(0);
            return true;
        }else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        drive.Move(0);
        clock.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        drive.TankDrive(0, 0);
        clock.stop();
    }
}
//e