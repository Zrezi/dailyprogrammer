package hard.challenge165.entity;

import hard.challenge165.util.Location;

public class Bear extends Entity {

    public Bear(Location location) {
        super(location);
    }

    @Override
    public char getDisplayCharacter() {
        return 'B';
    }

    @Override
    public void update(Entity[][] grid) {

    }
}
