package Battlefield;

import Warrior.Warrior;

import static java.lang.Math.pow;

public class Battlefield {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private String[][] battleField;
    private String[] symbols;
    private final int kingXCord = 0;
    private final int kingYCord = 1;

    public Battlefield(){
        this.battleField = new String[10][10];
        this.symbols = new String []{"▒", "▒", "▒", "!", "@", "^"};
        fillBattleField();
        setBattleField(1, 0, ANSI_GREEN+"Ö"+ANSI_RESET);
    }
    public void fillBattleField(){
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                battleField[i][j] = symbols[(int) (Math.random()*6)];
            }
        }

    }

    @Override
    public String toString(){
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i=0; i<10; i++){
            String myString = "";
            for (int j=0; j<10; j++){
                myString += (this.battleField[i][j]);
                myString += ' ';
            }
            System.out.print(i);
            System.out.print(" ");
            System.out.println(myString);
        }
        return null;
    }
    public String show(int i, int j){
        return battleField[i][j];
    }
    public void setBattleField(int i, int j, String c){this.battleField[i][j] = c;}

    public void fillWithUnits(Warrior[] array, int mode){
        switch (mode){
            case 0: {
                if (array.length==1 || array.length==2){
                    setBattleField(0, 4, array[0].getSymbol());
                    array[0].setyCord(0);
                    array[0].setxCord(4);
                    if (array.length==2){
                        setBattleField(0, 5, array[1].getSymbol());
                        array[1].setyCord(0);
                        array[1].setxCord(5);
                    }
                    break;
                }
                for (int i=0; i < array.length; i++){
                    setBattleField(0, i, array[i].getSymbol());
                    array[i].setyCord(0);
                    array[i].setxCord(i);
                }
                if (array.length<9){centuring(0, array.length, array);}
                break;
                }
            case 1:{
                if (array.length==1 || array.length==2){
                    setBattleField(9, 4, array[0].getSymbol());
                    array[0].setyCord(9);
                    array[0].setxCord(4);
                    if (array.length==2){
                        setBattleField(9, 5, array[1].getSymbol());
                        array[1].setyCord(9);
                        array[1].setxCord(5);
                    }
                    break;
                }
                for (int i=0; i < array.length; i++){
                    setBattleField(9, i, array[i].getSymbol());
                    array[i].setyCord(9);
                    array[i].setxCord(i);
                }
                if (array.length<9){centuring(9, array.length, array);}
                break;
            }
        }
    }

    public void replace(int i, int j, int p, int q, Warrior[] array, int num, boolean flag){
        String u = this.battleField[p][q];
        this.battleField[p][q] = this.battleField[j][i];
        this.battleField[j][i] = u;
        if (flag){
        array[num].setxCord(q);
        array[num].setyCord(p);
        }
    }
    public void centuring(int f, int length, Warrior[] array){
        if (f==0){
            for (int i=0; i<(10-length)/2; i++) {
                replace(i, 0, 0, length+i, array, i, true);
            }
        }
        else{
            for (int i=0; i<(10-length)/2; i++) {
                replace(i, 9, 9, length+i, array, i, true);
            }
        }
    }
}
