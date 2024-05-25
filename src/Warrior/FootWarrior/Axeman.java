package Warrior.FootWarrior;

import Battlefield.Battlefield;

public class Axeman extends FootWarrior {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String stockSymbol = "4";
    private String name = "Топорщик";
    public Axeman(int health, int strength, int attack_range, int protection, int movement, int cost, float swamp, float hill, float tree, Battlefield map, String s, String name) {
        super(health, strength, attack_range, protection, movement, cost, swamp, hill, tree, map, ANSI_GREEN+"4"+ANSI_RESET, name);
    }

    public Axeman(Battlefield map) {
        super(45, 9, 1, 3, 4, 20, 1.5f, 1.2f,2f, map, ANSI_GREEN+"4"+ANSI_RESET, "Топорщик");
    }

    public String getName() {
        return name;
    }
    public String getStockSymbol(){return stockSymbol;}
}
