// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.Intake;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
    public static class OperatorConstants
    {
        public static final int DRIVER_CONTROLLER_PORT = 0;
    }
    public static class DriveConstants
    {
        public static final int RIGHT_MASTER_ID = 1;
        public static final int RIGHT_FOLLOWER_ID = 2;
        public static final int LEFT_MASTER_ID = 3;
        public static final int LEFT_FOLLOWER_ID = 4;

        public static final double MAX_DRIVE_SPEED = 0.75;
        public static final double MAX_TURN_SPEED = 0.75;
    }
    public static class ArmConstants
    {
        public static final int ARM_PIVOT_ID = 5;
        public static final int ARM_INTAKE_ID = 6;
        public static final int PIVOT_CURRENT_LIMIT = 30;
        public static final int INTAKE_CURRENT_LIMIT = 30;
        public static final double PIVOT_FORWARD_LIMIT = 35;
        public static final double PIVOT_REVERSE_LIMIT = 0.0;
        public static final double PIVOT_MAX_VELOCITY = 0.5;
        public static final double PIVOT_MAX_ACCEL = 0.5;

        public static final double INTAKE_SPEED = 1.0;
        public static final double INTAKE_SPEED_HOLD = -0.2;
        public static final double PIVOT_SPEED_OUT = 0.5;
        public static final double PIVOT_SPEED_IN = -0.2;
        public static final double PIVOT_KP = 0.1;
        public static final double PIVOT_KI = 0.0;
        public static final double PIVOT_KD = 0.75;

        public static final double SUBSTATION_CONE = 29.0;
        public static final double SUBSTATION_CUBE = 27.0;

        public static final double MIDDLE_SCORE = 20.0;
    }
}
