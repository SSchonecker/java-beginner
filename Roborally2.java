import java.util.ArrayList;
import java.util.List;

public class Roborally {
	
	public static void main(String[] args) {
		Robot my_first_robot = new Robot();
		Robot my_second_robot = new Robot(1, 0, Direction.WEST);
		
		System.out.println("My first robot starts.");
		my_first_robot.printState();
		System.out.println("It should move 2 to the left, turn back and go backward.");
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

public enum Direction {
		NORTH (0, 1),
		EAST (1, 0),
		SOUTH (0, -1),
		WEST (-1, 0);
		
		int xchange;
		int ychange;
		private Direction leftTurn;
		private Direction rightTurn;
		Direction (int xChangeInDir, int yChangeInDir) {
			xchange = xChangeInDir;
			ychange = yChangeInDir;
		}
		
		public void setTurning() {
			switch (this) {
				case NORTH: 
					leftTurn = WEST;
					rightTurn = EAST;
					break;
				case EAST: 
					leftTurn = NORTH;
					rightTurn = SOUTH;
					break;
				case SOUTH: 
					leftTurn = EAST;
					rightTurn = WEST;
					break;
				case WEST: 
					leftTurn = SOUTH;
					rightTurn = NORTH;
					break;
			}
		}
		
		public Direction getLeftTurn() {
			return leftTurn;
		}
		
		public Direction getRightTurn() {
			return rightTurn;
		}
}

class Robot {
	
	int[] position = {0, 0};
	Direction facing = Direction.NORTH;

	private List<Runnable> commandList = new ArrayList<>();

	Robot() {
		facing.setTurning();
	} // For the default
	
	Robot(int xcoor, int ycoor, Direction direction) {
		position[0] = xcoor;
		position[1] = ycoor;
		facing = direction;
		facing.setTurning();
	}
	
	void printState() {
		System.out.format("This robot is at (%d, %d) facing " + facing.toString(),
			position[0], position[1]);
		System.out.println("");
	}
	
	void turnLeft() {
		commandList.add( () -> {
			facing = facing.getLeftTurn();
			facing.setTurning();
		});
	}
	
	void turnRight() {
		commandList.add( () -> {
			facing = facing.getRightTurn();
			facing.setTurning();
		});
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
		commandList.add( () -> {
			int steps = speedCheck(speed);
			position[0] += facing.xchange * steps;
			position[1] += facing.ychange * steps;
		});
	}
	
	void forward() {
		forward(1);
	}
	
	void backward(int speed) {
		commandList.add( () -> {
			int steps = speedCheck(speed);
			position[0] -= facing.xchange * steps;
			position[1] -= facing.ychange * steps;
		});
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