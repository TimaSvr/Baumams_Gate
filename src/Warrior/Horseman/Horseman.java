package Warrior.Horseman;

import Battlefield.Battlefield;
import Warrior.Warrior;

public class Horseman extends Warrior {
    public Horseman(int health, int strength, int attack_range, int protection, int movement, int cost, float swamp, float hill, float tree, Battlefield map, String s, String name){
        super(health, strength, attack_range, protection, movement, cost, 2.2f, 1.2f,1.5f, map, s, name);
    }
}
