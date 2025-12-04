package frc.robot;

import static edu.wpi.first.units.Units.Milliseconds;
import static edu.wpi.first.units.Units.Seconds;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.SwerveDriveTeleopCommand;
import frc.robot.subsystems.SubsystemSwerveDrivetrain;


public class Robot extends TimedRobot {
//  WoodSubsystem wood = new WoodSubsystem();
 
 CommandXboxController controller = new CommandXboxController(0);

 SubsystemSwerveDrivetrain drivetrain = new SubsystemSwerveDrivetrain();
  public Robot() {
 

    drivetrain.setDefaultCommand(new SwerveDriveTeleopCommand(drivetrain, controller));

  }
  @Override
  public void autonomousInit() {
  
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}