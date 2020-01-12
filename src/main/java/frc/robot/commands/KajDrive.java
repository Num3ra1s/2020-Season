/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;

public class KajDrive extends Command {

    //insantiate global variables
    Drivetrain dt;
    OI oi;
	double turnPercent, forwardPercent;
    
    //constructor (takes in drivetrain, left percent, and right percent)
	public KajDrive(Drivetrain driveTrain, OI operatorInterface) {
        
        //initialize variables
        dt = driveTrain;
        oi = operatorInterface;

        //needs drivetrain to run
        requires(dt);
        
        //set command to be interruptible
		setInterruptible(true);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        turnPercent = oi.rightXAxis();
        forwardPercent = oi.leftYAxis();

        double leftSideSpeed = (forwardPercent + turnPercent * (Math.abs(forwardPercent)));
		double rightSideSpeed = (forwardPercent - turnPercent * (Math.abs(forwardPercent)));

        //call drivePercent with left percent and right percent speed
        dt.drivePercent(leftSideSpeed, rightSideSpeed);

        //dt.setSpark(oi.rightYAxis());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; 
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
