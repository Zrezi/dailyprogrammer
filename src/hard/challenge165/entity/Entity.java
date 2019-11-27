package hard.challenge165.entity;

import hard.challenge165.util.Location;

public abstract class Entity {

    private Location location;

    Entity(Location location) {
        this.location = location;
    }

    abstract public char getDisplayCharacter();

    abstract public void update(Entity[][] grid);

    public Location getLocation() {
        return location;
    }

}
