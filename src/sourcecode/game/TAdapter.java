package sourcecode.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TAdapter extends KeyAdapter {
    CurrentDirection currentDirection = CurrentDirection.getCurrentDirection();

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        int key = keyEvent.getKeyCode();

        if(key == KeyEvent.VK_LEFT && !currentDirection.isRightDirection()){
            currentDirection.setLeftDirection(true);
            currentDirection.setDownDirection(false);
            currentDirection.setUpDirection(false);
        }

        if(key == KeyEvent.VK_RIGHT && !currentDirection.isLeftDirection()){
            currentDirection.setRightDirection(true);
            currentDirection.setDownDirection(false);
            currentDirection.setUpDirection(false);
        }

        if(key == KeyEvent.VK_UP && !currentDirection.isDownDirection()){
            currentDirection.setRightDirection(false);
            currentDirection.setLeftDirection(false);
            currentDirection.setUpDirection(true);
        }

        if(key == KeyEvent.VK_DOWN && !currentDirection.isUpDirection()){
            currentDirection.setRightDirection(false);
            currentDirection.setLeftDirection(false);
            currentDirection.setDownDirection(true);
        }

    }
}
