package hard.challenge165.entity;

import hard.challenge165.util.Location;

public class Lumberjack extends Entity {

    private static final int MOVES_PER_TICK = 3;

    public Lumberjack(Location location) {
        super(location);
    }

    @Override
    public char getDisplayCharacter() {
        return 'L';
    }

    @Override
    public void update(Entity[][] grid) {
        int totalMoves = 0;
//        while (totalMoves != MOVES_PER_TICK) {
//            Location attemptLocation = attemptMove(grid);
//            if (grid[attemptLocation.getY()][attemptLocation.getX()] instanceof Empty) {
//
//            }
//        }
    }

    private Location attemptMove(Entity[][] grid) {
        return Location.randomLocation(5);
    }

}
