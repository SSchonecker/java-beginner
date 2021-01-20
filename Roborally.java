import java.util.ArrayList;
import java.util.List;

public class Roborally {
	
	public static void main(String[] args) {
		
		Robot my_first_robot = new Robot();
		Robot my_second_robot = new Robot(1, 0, "West");
		
		System.out.println("My first robot starts.");
		my_first_robot.printState();
		System.out.println("It should move 2 to the left, turn back and go backward");
		my_first_robot.turnLeft();
		my_first_robot.forward(2);
		my_first_robot.turnRight();
		my_first_robot.backward();
		my_first_robot.execute();
		my_first_robot.printState();
		
		System.out.println("My second robot starts.");
		my_second_robot.printState();
		System.out.println("My second robot walks back.");
		System.out.println("And then 4 steps to the right.");
		my_second_robot.backward();
		my_second_robot.turnRight();
		my_second_robot.forward(4);
		my_second_robot.execute();
		my_second_robot.printState();
	}

}

class Robot {
	
	int[] position = {0, 0};
	String facing = "North";
	
	private String[] directionList = {"North", "East", "South", "West"};
	private int[] ychange = {1, 0, -1, 0};
	private int[] xchange = {0, 1, 0, -1};
	private List<Runnable> commandList = new ArrayList<>();

	Robot() {
	} // For the default
	
	Robot(int xcoor, int ycoor, String direction) {
		position[0] = xcoor;
		position[1] = ycoor;
		boolean contained = false;
		for (String dir : directionList) {
			if (dir.equals(direction)) {
			facing = direction;
			contained = true;
			break;
			}
		}
		if (!contained) {
			System.out.println(direction + " is not a valid direction. Default will be used.");
		}
	}
	
	void printState() {
		System.out.format("This robot is at (%d, %d) facing %s.",
			position[0], position [1], facing);
		System.out.println("");
	}
	
	private int getFacingInd() {
		for (int i = 0; i < directionList.length; i++) {
			if (facing.equals(directionList[i])) {
				return i;
			}
		}
		return -1; // Shouldn't occur & would give an error, but is required for compilation
	}
	
	void turnLeft() {
		Runnable tL = () -> {
			int oldFacingIndex = getFacingInd();
			facing = directionList[(oldFacingIndex + 3) % 4];
			// Index-1 for left turn, compensated with +4 for index 0 gives the +3
		};
		commandList.add(tL);
	}
	
	void turnRight() {
		Runnable tR = () -> {
			int oldFacingIndex = getFacingInd();
			facing = directionList[(oldFacingIndex + 1) % 4];
		};
		commandList.add(tR);
	}
	
	private int speedCheck(int speed) {
		if (speed > 3) {
			System.out.println("Robot can't move so fast... "
				+ "Speed will be adjusted.");
			return 3;
		}
		else if (speed < 1) {
			System.out. println("So you don't want to move in this direction?");
			return 0;
		}
		return speed;
	}	
	
	void forward(int speed) {
		Runnable fw = () -> {
			int steps = speedCheck(speed);
			int facingIndex = getFacingInd();
			position[0] += xchange[facingIndex] * steps;
			position[1] += ychange[facingIndex] * steps;
		};
		commandList.add(fw);
	}
	
	void forward() {
		forward(1);
	}
	
	void backward(int speed) {		
		Runnable bw = () -> {
			int steps = speedCheck(speed);
			int facingIndex = getFacingInd();
			position[0] -= xchange[facingIndex] * steps;
			position[1] -= ychange[facingIndex] * steps;
		};
		commandList.add(bw);
	}
	
	void backward() {
		backward(1);
	}
	
	void execute() {
		for (Runnable command : commandList) {
			command.run();
		}
		commandList.clear();
	}

}