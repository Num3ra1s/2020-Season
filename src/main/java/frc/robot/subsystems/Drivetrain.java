/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
/**
 * Drivetrain subsystem.
 */
public class Drivetrain extends Subsystem {

  //instantiate global variables
  private TalonSRX frontRightController;
  private TalonSRX frontLeftController;
  private TalonSRX backRightController;
  private TalonSRX backLeftController;
  //private CANSparkMax spark;

  //constructor
  public Drivetrain() {

    //initialize variables (motor controllers with IDs)

    frontRightController = new TalonSRX(1);
    frontLeftController = new TalonSRX(2);
    backRightController = new TalonSRX(4);
    backLeftController = new TalonSRX(3);
    //spark = new CANSparkMax(5, MotorType.kBrushless);
    
    //set back motor controllers to follow front motor controllers
    backLeftController.follow(frontLeftController);
		backRightController.follow(frontRightController);

  }

  //set motor controllers to percents
  public void drivePercent(double leftPercent, double rightPercent) {

    //multiply percents by forward constants
    double leftPercentForward = leftPercent * RobotMap.LEFT_DRIVETRAIN;
		double rightPercentForward = rightPercent * RobotMap.RIGHT_DRIVETRAIN;
    
    //set motor controllers to percents
    frontLeftController.set(ControlMode.PercentOutput, leftPercentForward);
		frontRightController.set(ControlMode.PercentOutput, rightPercentForward);
  }

  //public void setSpark(double percent){
    //spark.set(percent);
  //}

  //set default command
  public void initDefaultCommand(Command c) {
    setDefaultCommand(c);
  }

  @Override
  public void initDefaultCommand() {
  }
}

