package hard.challenge165.entity;

import hard.challenge165.Core;
import hard.challenge165.util.Location;

public class Tree extends Entity {

    private TreeType treeType;
    private int age = 0;

    public Tree(Location location, TreeType treeType) {
        super(location);
        this.treeType = treeType;
    }

    @Override
    public char getDisplayCharacter() {
        return treeType.getDisplayCharacter();
    }

    @Override
    public void update(Entity[][] grid) {
        age++;
        if (TreeType.SAPLING.equals(treeType) && age > 11) {
            treeType = TreeType.TREE;
        } else if (TreeType.TREE.equals(treeType) && age > 119) {
            treeType = TreeType.ELDER_TREE;
        }

        int top    = Math.max(getLocation().getY() - 1, 0);
        int bottom = Math.min(getLocation().getY() + 1, grid.length);
        int left   = Math.max(getLocation().getX() - 1, 0);
        int right  = Math.min(getLocation().getX() + 1, grid.length);

        if (Core.RANDOM.nextFloat() < treeType.getSaplingChance()) {
            for (int i = top; i < bottom; i++) {
                for (int j = left; j < right; j++) {
                    if (grid[i][j] instanceof Empty) {
                        grid[i][j] = new Tree(new Location(j, i), TreeType.SAPLING);
                        return;
                    }
                }
            }
        }
    }

}
