package hard.challenge165.util;

import hard.challenge165.Core;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Location randomLocation(int MAXIMUM) {
        return new Location(Core.RANDOM.nextInt(MAXIMUM), Core.RANDOM.nextInt(MAXIMUM));
    }

}
