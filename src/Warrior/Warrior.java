package Warrior;

import Battlefield.Battlefield;

import java.util.HashMap;

public class Warrior {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    protected int health;
    protected int strength;
    protected int attack_range;
    protected int protection;
    protected int movement;
    protected int cost;
    protected int xCord;
    protected int yCord;
    protected float swamp;
    protected float tree;
    protected float hill;
    protected float simple;
    protected Battlefield map = new Battlefield();
    protected String symbol;
    protected String name;
    protected HashMap<String, Float> penalty = new HashMap<>();

    public Warrior(int health, int strength, int attack_range, int protection, int movement, int cost, float swamp, float hill, float tree, Battlefield map, String symbol, String name){
        this.attack_range = attack_range;
        this.health = health;
        this.cost = cost;
        this.protection = protection;
        this.movement = movement;
        this.strength = strength;
        this.map = map;
        this.tree = tree;
        this.hill = hill;
        this.simple = 1;
        this.swamp = swamp;
        this.symbol = symbol;
        this.name = name;
        this.penalty.put("@", swamp);
        this.penalty.put("▒", 1F);
        this.penalty.put("!", tree);
        this.penalty.put("^", hill);
    }
    public int attack(int xEnemy, int yEnemy){
        if (distance(xEnemy, yEnemy) <= attack_range){
            return strength;
        }
        return 0;
    };
    public boolean move(int xMove, int yMove, Battlefield bf){
        this.map = bf;
        if (map.show(yMove, xMove) != "▒") {
            System.out.println("Нельзя сходить в эту клетку");
            return false;
        }
        if (distance(xMove, yMove) <= this.movement){
            int dist = 0;
            int stockX = this.xCord;
            int stockY = this.yCord;
            while (this.xCord - xMove !=0 || this.yCord - yMove !=0) {
                if (this.movement - dist <= 0) {
                    this.xCord = stockX;
                    this.yCord = stockY;
                    System.out.println("Клетка слишком далеко");
                    return false;
                };
                if (this.xCord - xMove < 0 && this.yCord - yMove < 0){
                    this.xCord += 1;
                    this.yCord += 1;
                }
                else if (this.xCord - xMove == 0 && this.yCord - yMove < 0) {
                    this.yCord += 1;
                }
                else if (this.xCord - xMove > 0 && this.yCord - yMove < 0) {
                    this.xCord -= 1;
                    this.yCord += 1;
                }
                else if (this.xCord - xMove > 0 && this.yCord - yMove == 0) {
                    this.xCord -= 1;
                }
                else if (this.xCord - xMove < 0 && this.yCord - yMove == 0) {
                    this.xCord += 1;
                }
                else if (this.xCord - xMove > 0 && this.yCord - yMove > 0) {
                    this.xCord -= 1;
                    this.yCord -= 1;
                }
                else if (this.xCord - xMove < 0 && this.yCord - yMove == 0) {
                    this.xCord += 1;
                }
                else if (this.xCord - xMove < 0 && this.yCord - yMove > 0) {
                    this.xCord += 1;
                    this.yCord -= 1;
                }
                else if (this.xCord - xMove == 0 && this.yCord - yMove > 0) {
                    this.yCord -= 1;
                }
                dist += penalty.get(map.show(yCord, xCord)).intValue();
            }
            return true;
        }
        System.out.println("Клетка слишком далеко");
        return false;
    };
    public boolean damage(int strike, Battlefield bf){
        this.map = bf;
        if (protection - strike >= 0){
            this.protection -= strike;
        }
        else{
            this.protection = 0;
            this.health -= (strike - protection);
        }
        if (this.health<=0){
            this.map.setBattleField(this.yCord, this.xCord,"▒");
            return true;
        }
        return false;
    }
    public int distance(int xEnemy, int yEnemy){
        return (int) Math.sqrt(Math.pow(this.xCord - xEnemy, 2) + Math.pow(this.yCord - yEnemy, 2));
    }
    public void getInfo(int position){
        String cout0 = "Имя: ";
        cout0 += this.name;
        System.out.print(cout0+=' ');

        String cout = "Здоровье: ";
        cout += Integer.toString(this.health);
        System.out.print(cout+=' ');

        String cout1 = "Сила: ";
        cout1 += Integer.toString(this.strength);
        System.out.print(cout1+=' ');

        String cout2 = "Дальность аттаки: ";
        cout2 += Integer.toString(this.attack_range);
        System.out.print(cout2+=' ');

        String cout3 = "Защита: ";
        cout3 += Integer.toString(this.protection);
        System.out.print(cout3+= ' ');

        String cout4 = "Перемещение: ";
        cout4 += Integer.toString(this.movement);
        System.out.print(cout4+=' ');

        String cout5 = "Стоимость: ";
        cout5 += Integer.toString(this.cost);
        System.out.print(cout5+= ' ');

        String cout6 = "Обозначение: ";
        cout6 += this.symbol;
        System.out.println(cout6+=' ');

        String cout7 = "Позиция: ";
        cout7 += position;
        System.out.println(cout7+=' ');
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack_range() {
        return attack_range;
    }

    public void setAttack_range(int attack_range) {
        this.attack_range = attack_range;
    }

    public String getSymbol(){return this.symbol; }

    public String getName(){return this.name;}

    public int getXCord(){return xCord;}
    public int getYCord(){return yCord;}

    public void setxCord(int x){this.xCord = x;}
    public void setyCord(int y){this.yCord = y;}
    public void botColour(String oldSymbol){
        this.symbol = ANSI_RED + oldSymbol +ANSI_RESET;
    }

    public static class Ninja {
    }
}
