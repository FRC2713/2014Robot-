package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 * @author Ryan Bradford
 */
public class AutonomousInit extends CommandGroup {

    public AutonomousInit() {
        addParallel(new GoForward(1),1.0);
        addParallel(new LiftArm(1),1.0);      
        addParallel(new WindUp(),4.2); 
        addParallel(new VTracking());        
        
    }
   // protected void execute() {
   //      new WindUp();
   //      if(clock.get() > 4.5) {
   //          //if(shooter.getHot() == true) {
   //      addSequential(new UnWind());
   //      addSequential(new GoForward(1), 1);
             //}
         }
            

