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
public class Shooter extends Subsystem {
  
  //instantiate motor controllers
  private TalonSRX bottom;
  private TalonSRX top;

  private static final int PID_IDX = 0;
  private static final int CAN_TIMEOUT = 10;
  private static final int ENCODER_TICKS_PER_REVOLUTION = 4096;
  private static final double GEAR_RATIO = 84.0 / 54.0;
  private static final double TALON_100MS_IN_1S = 10.0;

  //constructor
  public Shooter() {
      
    //initialize motor controllers
      bottom = new TalonSRX(6);
      top = new TalonSRX(7);

      bottom.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, PID_IDX, CAN_TIMEOUT);
    	top.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, PID_IDX, CAN_TIMEOUT);
    	bottom.setSensorPhase(false);
      top.setSensorPhase(true);      
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

  public double toRotationsPerSecondFromNativeTalon(double talonNative) {
    return talonNative * ((Math.PI / ENCODER_TICKS_PER_REVOLUTION)) * GEAR_RATIO * TALON_100MS_IN_1S;
  }

  public double getTopRotationsPerSecond() {
    return toRotationsPerSecondFromNativeTalon(top.getSelectedSensorVelocity());
  }

  public double getBottomRotationsPerSecond() {
    return toRotationsPerSecondFromNativeTalon(bottom.getSelectedSensorVelocity());
  }

  //set default command
  public void initDefaultCommand(Command c) {
    setDefaultCommand(c);
  }

  @Override
  public void initDefaultCommand() {
  }
}

