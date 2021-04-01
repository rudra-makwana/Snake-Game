package sourcecode.game;

public class CurrentDirection {

    private static CurrentDirection currentDirection = null;

    private boolean leftDirection;
    private boolean rightDirection;
    private boolean upDirection;
    private boolean downDirection;


    public CurrentDirection(){
        leftDirection = false;
        rightDirection = true;
        upDirection = false;
        downDirection = false;
    }

    public static CurrentDirection getCurrentDirection() {
        if (currentDirection == null)
            currentDirection = new CurrentDirection();
        return currentDirection;
    }

    public boolean isLeftDirection() {
        return leftDirection;
    }

    public void setLeftDirection(boolean leftDirection) {
        this.leftDirection = leftDirection;
    }

    public boolean isRightDirection() {
        return rightDirection;
    }

    public void setRightDirection(boolean rightDirection) {
        this.rightDirection = rightDirection;
    }

    public boolean isUpDirection() {
        return upDirection;
    }

    public void setUpDirection(boolean upDirection) {
        this.upDirection = upDirection;
    }

    public boolean isDownDirection() {
        return downDirection;
    }

    public void setDownDirection(boolean downDirection) {
        this.downDirection = downDirection;
    }
}
