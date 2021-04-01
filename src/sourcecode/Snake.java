package sourcecode;

import sourcecode.game.Board;

import javax.swing.*;
import java.awt.*;

public class Snake extends JFrame {

    public Snake(){
        initUI();
    }

    private void initUI(){
        add(new Board());
        setResizable(false);
        pack();

        setTitle("Snake Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame jFrame = new Snake();

            jFrame.setVisible(true);
        });
    }

}