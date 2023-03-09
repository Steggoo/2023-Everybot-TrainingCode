package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ArmPivot;


public class ManualArmCommand extends CommandBase {
    private final ArmPivot m_armPivot = ArmPivot.getInstance();
    private double speed;

    public ManualArmCommand(double speed) {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        this.speed = speed;
        addRequirements(m_armPivot);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        m_armPivot.moveArm(speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_armPivot.moveArm(0.0);
    }
}
