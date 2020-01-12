/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.KajDrive;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  //instantiate global variables
  private Command defaultDrive;
  Joystick xBox;
  double leftY;
  double rightY;
  double rightX;


  //constructor (takes drive train)
  public OI(Drivetrain dt) {
    
    //initialize variables
    xBox = new Joystick(0);
    //defaultDrive = new TankDrive(dt, this);
    defaultDrive = new KajDrive(dt, this);
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

}
