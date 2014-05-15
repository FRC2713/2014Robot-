 
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.templates.inputs.Gamepad;
import edu.wpi.first.wpilibj.templates.inputs.XBoxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.LiftArm;
import edu.wpi.first.wpilibj.templates.commands.UnWind;
import edu.wpi.first.wpilibj.templates.commands.WindUp;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
    public static final int GAME_PAD_PORT = 1;
    public static final int JOY_STICK_PORT1 = 2;
    public static final int JOY_STICK_PORT2 = 3;
    public static final int XBOX_PORT = 4;
    
    private Gamepad gamepad;
    private Joystick driveJoystick1;
    private Joystick driveJoystick2;
    private JoystickButton ArmJoystickUp;
    private JoystickButton ArmJoystickDown;
    private JoystickButton ArmXboxUp;
    private JoystickButton ArmXboxDown;
    private JoystickButton WindUp;
    private JoystickButton Release;
    private JoystickButton OpenNet;    
    private JoystickButton CloseNet;
    private JoystickButton DumpBall;        
    private XBoxController xbox;
    
    
    public OI() {
       driveJoystick1 = new Joystick(JOY_STICK_PORT1);
       driveJoystick2 = new Joystick(JOY_STICK_PORT2);
       gamepad = new Gamepad(GAME_PAD_PORT);   
       xbox = new XBoxController(XBOX_PORT);
       
       ArmJoystickUp = new JoystickButton(driveJoystick1, 3);
       ArmJoystickUp.whenPressed(new LiftArm(0.2));
       
       ArmJoystickDown = new JoystickButton (driveJoystick1, 2);
       ArmJoystickDown.whenPressed(new LiftArm(-0.2));
       

       ArmXboxUp = new JoystickButton (xbox, 5);
       ArmXboxUp.whileHeld(new LiftArm(.5));

       ArmXboxDown = new JoystickButton (xbox, 6);
       ArmXboxDown.whileHeld(new LiftArm(-0.5));
       
       WindUp = new JoystickButton (xbox, 4);
       WindUp.whileHeld(new WindUp());
       
//     WindUp = new JoystickButton (xbox, 4);
//     WindUp.whenPressed(new WindUp());       

       Release = new JoystickButton (xbox, 1);
       Release.whenPressed(new UnWind());       
       
     /*  OpenNet = new JoystickButton (xbox, 6);
       OpenNet.whenPressed(new OpenNet());
       
       CloseNet = new JoystickButton(xbox, 5);
       CloseNet.whenPressed(new CloseNet());
       
       DumpBall = new JoystickButton (xbox, 4);
       DumpBall.whenPressed(new DumpBall());    */  
    }
    
    public Joystick getDriveJoystick1(){
        return driveJoystick1;
    }
    
    public Joystick getDriveJoystick2(){
        return driveJoystick2;
    }    
    
    public Gamepad getGamepad(){
        return gamepad;
    }
    
    public XBoxController getXbox(){
        return xbox;
    }

 }


