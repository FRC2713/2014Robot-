/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.templates.commands.AutonomousCommand;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.commands.SetStation;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class TestRobot extends IterativeRobot {

    Preferences prefs;
    
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        
        SmartDashboard.putData("Tank Drive", new SetStation(1));
        SmartDashboard.putData("Arcade Drive", new SetStation(2));
        SmartDashboard.putData("XBox Controller Tank", new SetStation(3));
        SmartDashboard.putData("XBox Controller Arcade", new SetStation(4));
        /**
         * Adds buttons to SmartDAshboard
        */        
        // instantiate the command used for the autonomous period
        autonomousCommand = new AutonomousCommand();
        prefs = Preferences.getInstance();
        prefs.putDouble("Deadband",0.1);
        prefs.putDouble("ArmDeadband", 0.1);
        prefs.putDouble("LeftPolarity", -1);
        prefs.putDouble("RightPolarity", -1);
        prefs.putDouble("Scaler", 1);
        prefs.putDouble("HueLow", 80);
        prefs.putDouble("HueHigh", 200);
        prefs.putDouble("SaturationLow",100);
        prefs.putDouble("SaturationHigh",300);
        prefs.putDouble("BrightnessLow",200);
        prefs.putDouble("BrightnessHigh", 240);
        /**
         * Adds variables to the Preferences Table in SmartDashboard,
         */
        // Initialize all subsystems
        CommandBase.init();

        System.out.println("--------------------2713-----------------------");
        System.out.println("*Awsome-sauce code produced by Fid  inc.      *");
        System.out.println("*WARNING: might not possibly work             *");
        System.out.println("-----------------TEST-ROBOT--------------------");       
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        autonomousCommand.cancel();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
