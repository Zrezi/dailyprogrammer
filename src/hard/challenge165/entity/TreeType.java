package hard.challenge165.entity;

public enum TreeType {
    SAPLING('+', 0f),
    TREE('┬', 0.1f),
    ELDER_TREE('T', 0.2f);

    private char displayCharacter;
    private float saplingChance;

    TreeType(char displayCharacter, float saplingChance) {
        this.displayCharacter = displayCharacter;
        this.saplingChance = saplingChance;
    }

    public char getDisplayCharacter() {
        return displayCharacter;
    }

    public float getSaplingChance() {
        return saplingChance;
    }

}
