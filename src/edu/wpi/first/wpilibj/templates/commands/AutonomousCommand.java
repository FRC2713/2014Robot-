package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 * @author Ryan Bradford
 */
public class AutonomousCommand extends CommandGroup {//i hate evrything from nate shu

    public AutonomousCommand() {
        addSequential(new AutonomousInit());
        addSequential(new UnWind());
        
//        addSequential(new GoForward(1),1.0);
//        addSequential(new LiftArm(1),1.0);
//        addSequential(new WindUp(),4.2); 
//        addSequential(new UnWind()); 
        
    }
   // protected void execute() {
   //      new WindUp();
   //      if(clock.get() > 4.5) {
   //          //if(shooter.getHot() == true) {
   //      addSequential(new UnWind());
   //      addSequential(new GoForward(1), 1);
             //}
         }
            

