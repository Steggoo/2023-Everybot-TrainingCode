package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.
    private WPI_TalonSRX m_leftMaster;
    private WPI_TalonSRX m_rightMaster;
    private WPI_TalonSRX m_leftFollower;
    private WPI_TalonSRX m_rightFollower;

    private DifferentialDrive m_differentialDrive;

    /**
     * The Singleton instance of this Drivetrain. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static Drivetrain INSTANCE = new Drivetrain();

    /**
     * Returns the Singleton instance of this Drivetrain. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code Drivetrain.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static Drivetrain getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this Drivetrain. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private Drivetrain() {
        m_leftMaster = new WPI_TalonSRX(Constants.DriveConstants.LEFT_MASTER_ID);
        m_rightMaster = new WPI_TalonSRX(Constants.DriveConstants.RIGHT_MASTER_ID);
        m_leftFollower = new WPI_TalonSRX(Constants.DriveConstants.LEFT_FOLLOWER_ID);
        m_rightFollower = new WPI_TalonSRX(Constants.DriveConstants.RIGHT_FOLLOWER_ID);

        m_rightMaster.setInverted(false);
        m_rightFollower.setInverted(false);
        m_leftMaster.setInverted(true);
        m_leftFollower.setInverted(true);

        m_leftFollower.follow(m_leftMaster);
        m_rightFollower.follow(m_rightMaster);

        m_differentialDrive = new DifferentialDrive(m_leftMaster, m_rightMaster);
    }

    public void drive(double leftInput, double rightInput)
    {
        m_differentialDrive.arcadeDrive(leftInput, rightInput);
    }
}

