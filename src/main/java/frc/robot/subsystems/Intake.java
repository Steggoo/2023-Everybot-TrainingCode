package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this Intake. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static Intake INSTANCE = new Intake();

    private final CANSparkMax m_intake;
    /**
     * Returns the Singleton instance of this Intake. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code Intake.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static Intake getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this Intake. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private Intake() {
        m_intake = new CANSparkMax(Constants.ArmConstants.ARM_INTAKE_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        m_intake.setIdleMode(CANSparkMax.IdleMode.kBrake);
        m_intake.setSmartCurrentLimit(Constants.ArmConstants.INTAKE_CURRENT_LIMIT);
    }

    public void runIntake (Double speed) {
        m_intake.set(speed);
    }
}

