package sourcecode.game;

import sourcecode.SystemConfig;
import sourcecode.image.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    private SystemConfig systemConfig = SystemConfig.getUniqueInstance();
    private Game game;
    private ImageLoader imageLoader;

    private boolean inGame = true;
    private Timer timer;

    public Board(){

        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);

        setPreferredSize(new Dimension(systemConfig.getBOARD_WIDTH(), systemConfig.getBOARD_HEIGHT()));

        //Images are loaded
        imageLoader = ImageLoader.getImageLoader();

        //Game object is initialized
        game = Game.getGame();

        timer = new Timer(SystemConfig.getUniqueInstance().getDELAY(), this);
        timer.start();
    }

    public void doDrawing(Graphics graphics){
        if(inGame){

            graphics.drawImage(imageLoader.getAppleImage(), game.getApple_x(), game.getApple_y(), this);

            for (int z = 0; z < game.getDots(); z++){
                if(z == 0){
                    graphics.drawImage(imageLoader.getHeadImage(), systemConfig.getX()[z], systemConfig.getY()[z], this);
                }else{
                    graphics.drawImage(imageLoader.getDotImage(), systemConfig.getX()[z], systemConfig.getY()[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        }else {
            game.gameOver(graphics);
        }
    }

    public void checkCollision(){
        for(int i = game.getDots(); i > 0; i--){

            if((i > 4) && (systemConfig.getX()[0] == systemConfig.getX()[i]) && (systemConfig.getY()[0] == systemConfig.getY()[i])){
                inGame = false;
            }

            if(systemConfig.getY()[0] >= systemConfig.getBOARD_HEIGHT())
                inGame = false;

            if (systemConfig.getY()[0] < 0 )
                inGame = false;

            if (systemConfig.getX()[0] >= systemConfig.getBOARD_WIDTH())
                inGame = false;

            if (systemConfig.getX()[0] < 0)
                inGame = false;

            if(!inGame)
                timer.stop();

        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        doDrawing(graphics);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(inGame){

            game.checkApple();
            checkCollision();
            Movement.getMovement().move();

        }

        repaint();
    }
}
