// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmToSetpointCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ManualArmCommand;
import frc.robot.subsystems.ArmPivot;
import frc.robot.subsystems.Drivetrain;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer
{
    // The robot's subsystems and commands are defined here...
    
    // Replace with CommandPS4Controller or CommandJoystick if needed
    private final CommandXboxController m_controller =
            new CommandXboxController(OperatorConstants.DRIVER_CONTROLLER_PORT);
    private final Drivetrain m_drive = Drivetrain.getInstance();
    private final ArmPivot m_armPivot = ArmPivot.getInstance();
    
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer()
    {
        configDashboard();
        configureBindings();
    }
    
    
    /**
     * Use this method to define your trigger->command mappings. Triggers can be created via the
     * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
     * predicate, or via the named factories in {@link
     * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
     * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
     * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
     * joysticks}.
     */
    private void configureBindings()
    {
        m_drive.setDefaultCommand(new DriveCommand(m_controller));
        m_armPivot.setDefaultCommand(new ManualArmCommand(m_controller));

        m_controller.a().whileTrue(new ArmToSetpointCommand(2.0));
        // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
        // cancelling on release.)
    }

    private void configDashboard()
    {
        ShuffleboardTab testCommands = Shuffleboard.getTab("Commands");

        testCommands.add("Arm to 5", new ArmToSetpointCommand(5));
    }
    
    
    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
//    public Command getAutonomousCommand()
//    {
//        // An example command will be run in autonomous
//        return;
//    }
}
