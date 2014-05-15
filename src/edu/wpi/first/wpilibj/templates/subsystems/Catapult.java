/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author RyanBradford
 */
public class Catapult extends Subsystem {


    CANJaguar Arm2;

    public void initDefaultCommand() {

    }

    public Catapult() {
        try {
            //creates the motors
            Arm2 = new CANJaguar(RobotMap.CATAPULT_MOTOR);//, CANJaguar.ControlMode.kSpeed); 
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void WindUp() {
        try {
            Arm2.setX(-1);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
            Arm2.setX(-.5);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void UnWind() {
        try {
            Arm2.setX(1);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }            

        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void setMotor(double purple) {
        try {
            Arm2.setX(purple);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void Stop() {
        try {
            Arm2.setX(0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public boolean get() {
        try {
            return Arm2.getReverseLimitOK();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
