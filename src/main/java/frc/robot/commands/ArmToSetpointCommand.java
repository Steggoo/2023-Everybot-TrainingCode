package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmPivot;


public class ArmToSetpointCommand extends CommandBase {
    private final ArmPivot armPivot = ArmPivot.getInstance();

    private final double target;
    public ArmToSetpointCommand(double setpoint) {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        target = setpoint;
        addRequirements(this.armPivot);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        armPivot.armToSetpoint(target);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
