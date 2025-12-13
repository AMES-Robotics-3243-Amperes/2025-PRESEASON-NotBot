package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IndexerSubsystem extends SubsystemBase {
  SparkMax motor = new SparkMax(14, MotorType.kBrushless);

  public IndexerSubsystem() {
    SparkMaxConfig config = new SparkMaxConfig();
    config.idleMode(IdleMode.kBrake);
    config.inverted(true);
    motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public Command runSpeedCommand(double speed) {
    return runEnd(() -> motor.set(speed), () -> motor.set(0));
  }

  public Command intakeCommand() {
    return runSpeedCommand(0.3);
  }

  public Command outtakeCommand() {
    return runSpeedCommand(-0.08);
  }
}