package sourcecode.game;

import sourcecode.Snake;
import sourcecode.SystemConfig;
import sourcecode.image.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements IGame{
    private static Game game = null;

    private int dots;
    private int apple_x;
    private int apple_y;

    public Game(){
        dots = 3;

        for (int z = 0; z < dots; z++) {

            int[] temp1 = SystemConfig.getUniqueInstance().getX();
            temp1[z] = 50 - z * 10;
            SystemConfig.getUniqueInstance().setX(temp1);

            int[] temp2 = SystemConfig.getUniqueInstance().getY();
            temp2[z] = 50;
            SystemConfig.getUniqueInstance().setY(temp2);

        }

        locateApple();
    }

    @Override
    public void gameOver(Graphics graphics) {

        String message = SystemConfig.getUniqueInstance().getGAME_OVER_MSG();
        Font font = new Font(SystemConfig.getUniqueInstance().getFONT_TYPE(),
               Font.BOLD,
               SystemConfig.getUniqueInstance().getFONT_SIZE());

        FontMetrics fontMetrics = graphics.getFontMetrics(font);

        graphics.setColor(Color.white);
        graphics.setFont(font);
        graphics.drawString(message,
               (SystemConfig.getUniqueInstance().getBOARD_WIDTH()-fontMetrics.stringWidth(message))/2,
                SystemConfig.getUniqueInstance().getBOARD_HEIGHT()/2);

    }


    public static Game getGame() {
        if(game == null)
            game = new Game();
        return game;
    }

    @Override
    public void locateApple(){
        int r = (int) (Math.random() * SystemConfig.getUniqueInstance().getRANDOM_POSITION());

        apple_x = r * SystemConfig.getUniqueInstance().getDOT_SIZE();

        r = (int) (Math.random() * SystemConfig.getUniqueInstance().getRANDOM_POSITION());

        apple_y = r * SystemConfig.getUniqueInstance().getDOT_SIZE();
    }

    @Override
    public void checkApple() {
        if(SystemConfig.getUniqueInstance().getX()[0] == apple_x && SystemConfig.getUniqueInstance().getY()[0] == apple_y){
            dots++;
            locateApple();
        }
    }

    public int getApple_x() {
        return apple_x;
    }

    public void setApple_x(int apple_x) {
        this.apple_x = apple_x;
    }

    public int getApple_y() {
        return apple_y;
    }

    public void setApple_y(int apple_y) {
        this.apple_y = apple_y;
    }

    public int getDots() {
        return dots;
    }

    public void setDots(int dots) {
        this.dots = dots;
    }
}
