package edu.desu.cis.robot.control;

import edu.desu.cis.robot.service.SensorSnapshot;

/**
 * A specific implementation of a robot controller that navigates a maze,
 * identifies objects, and performs actions based on the object's color.
 *
 */
public class RovingRobot extends RobotController {

    /**
     * Constructs a new MazeRobot.
     */
    public RovingRobot(String robotName) {
        super(robotName);
    }


    public void run(){
        mbot.avoidCrashing(15);
        mbot.forward(50);
        while(true){
            SensorSnapshot sensors = awaitNewData();
            if (sensors.distance() < 15){
                mbot.turnRight(90);
                mbot.forward(50);
            }
        }
    }

    /**
     * The main entry point for the MazeRobot application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try (RovingRobot amazin = new RovingRobot("StingBot")) {
            amazin.run();
        }
    }
}
