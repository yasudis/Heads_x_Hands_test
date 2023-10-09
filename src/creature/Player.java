package creature;

import range.Range;

public class Player extends Creature {
    private int healCount = 4; // Количество возможных самолечений для игрока
    private final int healAmount; // Количество здоровья, восстанавливаемое за одно лечение

    public Player(int attack, int defense, int health, Range damage, int healAmount) {
        super(attack, defense, health, damage);
        this.healAmount = (int) Math.round(0.3 * health);
    }

    // Метод для выполнения лечения игрока
    public void heal() {
        if (healCount > 0) {
            health += healAmount;
            System.out.println("Игрок восстановил " + healAmount + " здоровья. Теперь у него " + health + " здоровья.");
            healCount--;
        } else {
            System.out.println("У игрока больше нет возможности исцелить себя.");
        }
    }

    @Override
    public void die() {
        System.out.println("Игрок погиб.");
    }
}