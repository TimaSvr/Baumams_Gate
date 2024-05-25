package Warrior.FootWarrior;

import Battlefield.Battlefield;

public class SpadesMan extends FootWarrior {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String stockSymbol = "5";
    private String name = "Копейщик";
    public SpadesMan(int health, int strength, int attack_range, int protection, int movement, int cost, float swamp, float hill, float tree, Battlefield map, String s, String name) {
        super(health, strength, attack_range, protection, movement, cost, swamp, hill, tree, map, ANSI_GREEN+"5"+ANSI_RESET, name);
    }

    public SpadesMan(Battlefield map) {
        super(35, 3, 1, 4, 6, 15, 1.5f, 1.2f,2f, map, ANSI_GREEN+"5"+ANSI_RESET, "Копейщик");
    }

    public String getName() {
        return name;
    }
    public String getStockSymbol(){return stockSymbol;}
}
