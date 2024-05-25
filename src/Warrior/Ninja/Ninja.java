package Warrior.Ninja;


import Battlefield.Battlefield;
import Warrior.Warrior;

public class Ninja extends Warrior {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private boolean transparent = false;

    public static final String stockSymbol = "¥";
    private String name = "Ниндзя";
    public Ninja(int health, int strength, int attack_range, int protection, int movement, int cost, float swamp, float tree, float hill, Battlefield map, String s, String name){
        super(health, strength, attack_range, protection, movement, cost, swamp = 1f, hill = 1f, tree = 1f, map, ANSI_RED+"¥"+ANSI_RESET, name);
    };
    public Ninja(Battlefield map) {
        super(200, 1, 1, 4, 4, 0, 1f, 1f,1f, map, ANSI_GREEN+"4"+ANSI_RESET, "Ниндзя");
    }

    public String getName() {
        return name;
    }

    public String getStockSymbol(){return stockSymbol;}

    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }
    public boolean getTransparent(){
        return this.transparent;
    }
}
