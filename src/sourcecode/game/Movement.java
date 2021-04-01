package sourcecode.game;

import sourcecode.SystemConfig;

public class Movement implements IMovement {
    private Game game = Game.getGame();
    private static Movement movement = null;

    @Override
    public void move() {
        for (int i = game.getDots(); i > 0; i--){
            int[] temp1 = SystemConfig.getUniqueInstance().getX();
            temp1[i] = temp1[i-1];
            SystemConfig.getUniqueInstance().setX(temp1);

            int[] temp2 = SystemConfig.getUniqueInstance().getY();
            temp2[i] = temp2[i-1];
            SystemConfig.getUniqueInstance().setY(temp2);
        }

        if (CurrentDirection.getCurrentDirection().isLeftDirection()){
            int[] temp = SystemConfig.getUniqueInstance().getX();
            temp[0] -= SystemConfig.getUniqueInstance().getDOT_SIZE();
            SystemConfig.getUniqueInstance().setX(temp);
        }
        if (CurrentDirection.getCurrentDirection().isRightDirection()){
            int[] temp = SystemConfig.getUniqueInstance().getX();
            temp[0] += SystemConfig.getUniqueInstance().getDOT_SIZE();
            SystemConfig.getUniqueInstance().setX(temp);
        }
        if (CurrentDirection.getCurrentDirection().isUpDirection()){
            int[] temp = SystemConfig.getUniqueInstance().getY();
            temp[0] -= SystemConfig.getUniqueInstance().getDOT_SIZE();
            SystemConfig.getUniqueInstance().setY(temp);
        }
        if (CurrentDirection.getCurrentDirection().isDownDirection()){
            int[] temp = SystemConfig.getUniqueInstance().getY();
            temp[0] += SystemConfig.getUniqueInstance().getDOT_SIZE();
            SystemConfig.getUniqueInstance().setY(temp);        }
    }

    public static Movement getMovement() {
        if (movement == null)
            movement = new Movement();
        return movement;
    }
}
