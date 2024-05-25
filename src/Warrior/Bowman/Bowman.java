package Warrior.Bowman;

import Battlefield.Battlefield;
import Warrior.Warrior;

public class Bowman extends Warrior {
    public Bowman(int health, int strength, int attack_range, int protection, int movement, int cost, float swamp, float hill, float tree, Battlefield map, String s, String name){
        super(health, strength, attack_range, protection, movement, cost, swamp = 1.8f, hill = 2.2f, tree = 1f, map, s, name);
    }
}
