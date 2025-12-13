package frc.robot;

import static edu.wpi.first.units.Units.Second;
import static edu.wpi.first.units.Units.Seconds;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.SwerveDriveTeleopCommand;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.SubsystemShooter;
import frc.robot.subsystems.SubsystemSwerveDrivetrain;

public class Robot extends TimedRobot {
  // WoodSubsystem wood = new WoodSubsystem();

  CommandXboxController controller = new CommandXboxController(0);
  SubsystemSwerveDrivetrain drivetrain = new SubsystemSwerveDrivetrain();
  IndexerSubsystem indexer = new IndexerSubsystem();
  SubsystemShooter shooter = new SubsystemShooter();

  public Robot() {
    drivetrain.setDefaultCommand(new SwerveDriveTeleopCommand(drivetrain, controller));

    controller.a().whileTrue(indexer.intakeCommand().alongWith(shooter.reverseAgaintIndexerCommand()));
    controller.x().whileTrue(indexer.outtakeCommand());
    controller.b().whileTrue(
        indexer.outtakeCommand().withTimeout(Seconds.of(0.6)).andThen(
            shooter.shootCommand().alongWith(
                new WaitCommand(Seconds.of(0.6))
                    .andThen(indexer.intakeCommand()))));
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}