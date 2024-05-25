package Warrior.FootWarrior;

import Battlefield.Battlefield;
import Warrior.Warrior;

public class FootWarrior extends Warrior {
    public FootWarrior(int health, int strength, int attack_range, int protection, int movement, int cost, float swamp, float tree, float hill, Battlefield map, String s, String name){
        super(health, strength, attack_range, protection, movement, cost, swamp=1.5f, tree=1.2f, hill=2, map, s, name);
    }
}
