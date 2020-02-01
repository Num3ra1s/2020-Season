/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Drivetrain subsystem.
 */
public class Intake extends Subsystem {
  
  //instantiate motor controllers
  private TalonSRX talon1;
  
  //constructor
  public Intake() {
      
    //initialize motor controllers
      talon1 = new TalonSRX(6);     
  }

  //ready ball

  //set bottom motor speed
  public void setIntakeSpeed(double speed){
    talon1.set(ControlMode.PercentOutput, speed);
  }

  //set default command
  public void initDefaultCommand(Command c) {
    setDefaultCommand(c);
  }

  @Override
  public void initDefaultCommand() {
  }
}

