package marsrover;

class Rover {


	private int x;
    private int y;
    private String direction;
    private int gridX;
    private int gridY;

    public Rover(int x, int y, String direction, int gridX, int gridY) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.gridX = gridX;
		this.gridY = gridY;
	}
    public void processCommands(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'L') {
                turnLeft();
            } else if (command == 'R') {
                turnRight();
            } else if (command == 'M') {
                move();
            }
        }
    }

    private void turnLeft() {
        switch (direction) {
            case "N":
                direction = "W";
                break;
            case "W":
                direction = "S";
                break;
            case "S":
                direction = "E";
                break;
            case "E":
                direction = "N";
                break;
            default:
                throw new IllegalStateException("Unknown Direction");    
        }
    }

    private void turnRight() {
        switch (direction) {
            case "N":
                direction = "E";
                break;
            case "E":
                direction = "S";
                break;
            case "S":
                direction = "W";
                break;
            case "W":
                direction = "N";
                break;
            default:
                throw new IllegalStateException("Unknown Direction");      
        }
    }

    private void move() {
        switch (direction) {
            case "N":
                y = Math.min(y + 1, gridX);
                break;
            case "E":
                x = Math.min(x + 1, gridY);
                break;
            case "S":
                y = Math.max(y - 1, 0);
                break;
            case "W":
                x = Math.max(x - 1, 0);
                break; 
        }
    }

    public String getPosition() {
        return x + " " + y + " " + direction;
    }
}
