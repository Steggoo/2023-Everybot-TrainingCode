package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;


public class DriveCommand extends CommandBase {
    private final Drivetrain m_drivetrain = Drivetrain.getInstance();
    private CommandXboxController m_controller;

    public DriveCommand(CommandXboxController controller) {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        m_controller = controller;
        addRequirements(m_drivetrain);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        m_drivetrain.drive(m_controller.getLeftY() * Constants.DriveConstants.MAX_DRIVE_SPEED,
                        m_controller.getLeftX() * Constants.DriveConstants.MAX_TURN_SPEED);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
