package sourcecode;

public class SystemConfig {

    private static SystemConfig uniqueInstance = null;

    private final int BOARD_WIDTH;
    private final int BOARD_HEIGHT;
    private final int DOT_SIZE;
    private final int ALL_DOTS;
    private final int RANDOM_POSITION;
    private final int DELAY;
    private int[] x;
    private int[] y;



    private final String appleImagePath;
    private final String dotImagePath;
    private final String headImagePath;

    private final String GAME_OVER_MSG;
    private final String FONT_TYPE;
    private final int FONT_SIZE;

    public SystemConfig() {

        this.BOARD_WIDTH = 1000;
        this.BOARD_HEIGHT = 1000;
        this.DOT_SIZE = 10;
        this.ALL_DOTS = 900;
        this.RANDOM_POSITION = 100;
        this.DELAY = 140;
        this.x = new int[ALL_DOTS];
        this.y = new int[ALL_DOTS];

        appleImagePath = "resources\\apple.png";
        dotImagePath = "resources\\dot.png";
        headImagePath = "resources\\head.png";

        GAME_OVER_MSG = "GAME OVER";
        FONT_TYPE = "Helvetica";
        FONT_SIZE = 14;

    }

    public static SystemConfig getUniqueInstance() {
        if(uniqueInstance == null)
            uniqueInstance = new SystemConfig();
        return uniqueInstance;
    }

    public int getBOARD_WIDTH() {
        return BOARD_WIDTH;
    }

    public int getBOARD_HEIGHT() {
        return BOARD_HEIGHT;
    }

    public int getDOT_SIZE() {
        return DOT_SIZE;
    }

    public int getALL_DOTS() {
        return ALL_DOTS;
    }

    public int getRANDOM_POSITION() {
        return RANDOM_POSITION;
    }

    public int getDELAY() {
        return DELAY;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public String getAppleImagePath() {
        return appleImagePath;
    }

    public String getDotImagePath() {
        return dotImagePath;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public String getGAME_OVER_MSG() {
        return GAME_OVER_MSG;
    }

    public String getFONT_TYPE() {
        return FONT_TYPE;
    }

    public int getFONT_SIZE() {
        return FONT_SIZE;
    }
}
