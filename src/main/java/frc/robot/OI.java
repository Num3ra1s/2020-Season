/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  //instantiate global variables
  private Command defaultDrive;
  Joystick xBox;
  Button[] xBoxButtons;
  double leftShoulder;
  double rightShoulder;
  double leftY;
  double rightY;
  double rightX;

  public static final double DEADBAND_WIDTH = 0.1;

  //constructor (takes drive train)
  public OI(Drivetrain dt, Shooter sh, Intake in, Indexer ind) {
    
    //initialize variables
    xBox = new Joystick(0);
    xBoxButtons = getButtons(xBox);

    //defaultDrive = new TankDrive(dt, this);
    defaultDrive = new KajDrive(dt, this);

   // xBoxButtons[1].whileHeld(new ShootConstant(sh, this, 1, 1));
  //  xBoxButtons[2].whileHeld(new ShootConstant(sh, this, 0.25, 0.25));
    xBoxButtons[3].whileHeld(new ShootConstant(sh, this, 0.5, 0.5));
  //  xBoxButtons[4].whileHeld(new ShootConstant(sh, this, 0.75, 0.75));

    //xBoxButtons[5].whileHeld(new ShootManual(sh, this));
    //xBoxButtons[1].whileHeld(new IntakeBall(in, this, 1));
    //xBoxButtons[2].whileHeld(new IntakeBall(in, this, -1));

    //xBoxButtons[6].whenPressed(new ExtendIntake(in, this));
    //xBoxButtons[6].whenPressed(new RetractIntake(in, this));

    xBoxButtons[1].whileHeld(new IndexTowardsShooter(ind, this));
    xBoxButtons[2].whileHeld(new IndexAwayShooter(ind, this));


  }

  public static Button[] getButtons(Joystick controller) {
		Button[] controllerButtons = new Button[controller.getButtonCount() + 1];
		for(int i = 1; i < controllerButtons.length; i++) {
			controllerButtons[i] = new JoystickButton(controller, i);
		}
		return controllerButtons;
	}

  public Command defaultDrive() {
		return defaultDrive;
  }
  
  public double leftYAxis(){
    leftY = xBox.getRawAxis(1) * -1;
    return leftY;
  }

  public double rightYAxis(){
    rightY = xBox.getRawAxis(5) * -1;
    return rightY;
  }

  public double rightXAxis(){
    rightX = xBox.getRawAxis(4) * 1;
    return rightX;
  }

  public double leftShoulder(){
    leftShoulder = xBox.getRawAxis(2) * 1;
    return leftShoulder;
  }

  public double rightShoulder(){
    rightShoulder = xBox.getRawAxis(3) * 1;
    return rightShoulder;
  }

}
