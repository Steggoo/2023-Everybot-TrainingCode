package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ArmPivot;


public class ManualArmCommand extends CommandBase {
    private final ArmPivot armPivot = ArmPivot.getInstance();
    private final CommandXboxController m_controller;

    public ManualArmCommand(CommandXboxController controller) {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        m_controller = controller;
        addRequirements(this.armPivot);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if(m_controller.rightBumper().getAsBoolean())
        {
            armPivot.moveArm(1);
        }
        else if (m_controller.leftBumper().getAsBoolean())
        {
            armPivot.moveArm(-1);
        }
        else
        {
            armPivot.moveArm(0);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
