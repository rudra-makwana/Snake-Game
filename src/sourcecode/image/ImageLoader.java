package sourcecode.image;

import javax.swing.*;
import java.awt.*;

public class ImageLoader {

    private static ImageLoader imageLoader = null;

    private final Image appleImage;
    private final Image dotImage;
    private final Image headImage;
    private final Image restartImage;

    private ImageLoader(){
        ImageIcon apple = new ImageIcon("src/resources/apple.png");
        appleImage = apple.getImage();

        ImageIcon dot = new ImageIcon("src/resources/dot.png");
        dotImage = dot.getImage();

        ImageIcon head = new ImageIcon("src/resources/head.png");
        headImage = head.getImage();

        ImageIcon restart = new ImageIcon("src/resources/restart.png");
        restartImage = restart.getImage();
    }

    public static ImageLoader getImageLoader() {
        if(imageLoader == null)
            imageLoader = new ImageLoader();
        return imageLoader;
    }

    public Image getAppleImage() {
        return appleImage;
    }

    public Image getDotImage() {
        return dotImage;
    }

    public Image getHeadImage() {
        return headImage;
    }

    public Image getRestartImage() {
        return restartImage;
    }
}
