package Warrior.Horseman;

import Battlefield.Battlefield;
import Warrior.Horseman.Horseman;

public class HorseBowman extends Horseman {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String stockSymbol = "8";
    private String name = "Конный лучник";
    public HorseBowman(int health, int strength, int attack_range, int protection, int movement, int cost, float swamp, float hill, float tree, Battlefield map, String s, String name) {
        super(health, strength, attack_range, protection, movement, cost, swamp, hill, tree, map, ANSI_GREEN+"8"+ANSI_RESET, name);
    }

    public HorseBowman(Battlefield map) {
        super(25, 3, 3, 2, 5, 25, 2.2f, 1.2f,1.5f, map, ANSI_GREEN+"9"+ANSI_RESET, "Конный Лучник");
    }

    public String getName() {
        return name;
    }
    public String getStockSymbol(){return stockSymbol;}
}
