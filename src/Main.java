import creature.Monster;
import creature.Player;
import range.Range;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(10, 20, 100, new Range(1, 6), 0);
        Monster monster = new Monster(15, 10, 80, new Range(5, 10));

        player.attack(monster);
        monster.attack(player);
        player.heal();
        player.attack(monster);
        monster.attack(player);
        player.attack(monster);
        monster.attack(player);
        player.attack(monster);
        monster.attack(player);
    }
}