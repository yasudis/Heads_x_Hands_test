package creature;

import range.Range;

public class Monster extends Creature {
    public Monster(int attack, int defense, int health, Range damage) {
        super(attack, defense, health, damage);
    }

    @Override
    public void die() {
        System.out.println("Монстр погиб.");
    }
}