import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SubsystemShooter extends SubsystemBase{
    SparkMax motorIntake = new SparkMax(0,MotorType.kBrushless); // placeholder ids
    SparkMax motorShooter = new SparkMax(2,MotorType.kBrushless); // placeholder ids

    public SubsystemShooter() {
        
    }
}
