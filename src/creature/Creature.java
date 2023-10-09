package creature;

import range.Range;

import java.util.Random;

public abstract class Creature {
    protected int attack; // Атака
    protected int defense; // Защита
    protected int health; // Здоровье
    protected Range damage; // Диапазон урона

    public Creature(int attack, int defense, int health, Range damage) {
        this.attack = Math.min(30, Math.max(1, attack));
        this.defense = Math.min(30, Math.max(1, defense));
        this.health = health;
        this.damage = damage;
    }

    // Геттеры для получения значений атаки, защиты, здоровья и диапазона урона
    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public Range getDamage() {
        return damage;
    }

    // Метод для выполнения атаки на другого персонажа
    public void attack(Creature creature) {
        int modifier = attack - creature.defense + 1;
        int roll = rollDice(modifier);
        if (roll >= 5) {
            int damage = this.damage.getRandomValue();
            creature.takeDamage(damage);
            System.out.println(this.getClass().getSimpleName() + " нанес " + creature.getClass().getSimpleName() + " " + damage + " урона.");
        } else {
            System.out.println(this.getClass().getSimpleName() + " промахнулся по " + creature.getClass().getSimpleName() + ".");
        }
    }

    // Метод для получения урона
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            die();
        }
    }

    //Метод для реакции на смерть персонажа
    public abstract void die();

    // Метод для бросания кубиков
    private int rollDice(int modifier) {
        Random rand = new Random();
        int result = 0;
        if (modifier > 0) {
            result = rand.nextInt(6) + 1;
            modifier--;
        }
        while (modifier > 0) {
            result += rand.nextInt(6) + 1;
            modifier--;
        }
        return result;
    }
}