package hard.challenge165;

import hard.challenge165.entity.Bear;
import hard.challenge165.entity.Empty;
import hard.challenge165.entity.Entity;
import hard.challenge165.entity.Lumberjack;
import hard.challenge165.entity.Tree;
import hard.challenge165.entity.TreeType;
import hard.challenge165.util.Location;

public class Forest {

    private static final int FOREST_SIZE = 400;
    private static final float TREE_PERCENT = 0.5f;
    private static final float LUMBERJACK_PERCENT = 0.1f;
    private static final float BEAR_PERCENT = 0.02f;

    private Entity[][] grid;
    private int tick = 0;

    public Forest() {
        this.grid = new Entity[FOREST_SIZE][FOREST_SIZE];

        initWithEmpties();
        init(Tree.class, TREE_PERCENT);
        init(Lumberjack.class, LUMBERJACK_PERCENT);
        init(Bear.class, BEAR_PERCENT);
    }

    private void initWithEmpties() {
        for (int i = 0; i < FOREST_SIZE; i++) {
            for (int j = 0; j < FOREST_SIZE; j++) {
                grid[i][j] = new Empty(new Location(j, i));
            }
        }
    }

    private void init(Class stuff, float spawnPercentage) {
        int totalEntities = (int) ((FOREST_SIZE * FOREST_SIZE) * spawnPercentage);
        int entitiesSpawned = 0;
        while (entitiesSpawned != totalEntities) {
            Location location = Location.randomLocation(FOREST_SIZE);
            if (grid[location.getY()][location.getX()] instanceof Empty) {
                if (stuff.equals(Tree.class)) {
                    grid[location.getY()][location.getX()] = new Tree(location, TreeType.TREE);
                } else if (stuff.equals(Lumberjack.class)) {
                    grid[location.getY()][location.getX()] = new Lumberjack(location);
                } else if (stuff.equals(Bear.class)) {
                    grid[location.getY()][location.getX()] = new Bear(location);
                }
                entitiesSpawned++;
            }
        }
    }

    public void tick() {
        for (int i = 0; i < FOREST_SIZE; i++) {
            for (int j = 0; j < FOREST_SIZE; j++) {
                grid[i][j].update(grid);
            }
        }
        tick++;
    }

    public int getTick() {
        return tick;
    }

    public void printForest() {
        for (int i = 0; i < FOREST_SIZE; i++) {
            for (int j = 0; j < FOREST_SIZE; j++) {
                System.out.print(grid[i][j].getDisplayCharacter() + " ");
            }
            System.out.print("\n");
        }
    }

}
