package hard.challenge165.entity;

import hard.challenge165.util.Location;

public class Empty extends Entity {

    public Empty(Location location) {
        super(location);
    }

    @Override
    public char getDisplayCharacter() {
        return ' ';
    }

    @Override
    public void update(Entity[][] grid) {
        // no-op
    }

}
