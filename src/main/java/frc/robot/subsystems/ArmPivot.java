package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmPivot extends SubsystemBase {

    private final CANSparkMax m_armPivot;
    private final RelativeEncoder m_armEncoder;
    private final SparkMaxPIDController m_PIDController;
    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this ArmPivot. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private static final ArmPivot INSTANCE = new ArmPivot();

    /**
     * Returns the Singleton instance of this ArmPivot. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code ArmPivot.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static ArmPivot getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this ArmPivot. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private ArmPivot() {
        m_armPivot = new CANSparkMax(Constants.ArmConstants.ARM_PIVOT_ID, CANSparkMaxLowLevel.MotorType.kBrushless);
        m_armPivot.setSoftLimit(CANSparkMax.SoftLimitDirection.kForward, (float) Constants.ArmConstants.PIVOT_FORWARD_LIMIT);
        m_armPivot.setSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, (float) Constants.ArmConstants.PIVOT_REVERSE_LIMIT);
        m_armPivot.setIdleMode(CANSparkMax.IdleMode.kBrake);

        m_PIDController = m_armPivot.getPIDController();
        m_PIDController.setP(Constants.ArmConstants.PIVOT_KP);
        m_PIDController.setI(Constants.ArmConstants.PIVOT_KI);
        m_PIDController.setD(Constants.ArmConstants.PIVOT_KD);
        m_PIDController.setSmartMotionMaxVelocity(Constants.ArmConstants.PIVOT_MAX_VELOCITY, 0);
        m_PIDController.setSmartMotionMaxAccel(Constants.ArmConstants.PIVOT_MAX_ACCEL, 0);

        m_armEncoder = m_armPivot.getEncoder();
    }

    public void moveArm(double input)
    {
        m_armPivot.set(input);
    }

    public void armToSetpoint(double setpoint)
    {
        double clampedOutput = MathUtil.clamp(setpoint, Constants.ArmConstants.PIVOT_REVERSE_LIMIT, Constants.ArmConstants.PIVOT_FORWARD_LIMIT);
        m_PIDController.setReference(clampedOutput, CANSparkMax.ControlType.kPosition);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Pivot", m_armEncoder.getPosition());
    }
}

