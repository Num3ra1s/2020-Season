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
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Drivetrain subsystem.
 */
public class Shooter extends Subsystem {
  
  //instantiate motor controllers
  private TalonSRX bottom;
  private TalonSRX top;

  //constructor
  public Shooter() {
      
    //initialize motor controllers
      bottom = new TalonSRX(6);
      top = new TalonSRX(7);
  }

  //ready ball

  //set bottom motor speed
  public void setBottomShooterSpeed(double speed){
    bottom.set(ControlMode.PercentOutput, speed);
  }

  //set bottom motor speed
  public void setTopShooterSpeed(double speed){
    top.set(ControlMode.PercentOutput, speed);
  }

  //set default command
  public void initDefaultCommand(Command c) {
    setDefaultCommand(c);
  }

  @Override
  public void initDefaultCommand() {
  }
}

