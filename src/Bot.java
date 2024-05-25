import Battlefield.Battlefield;
import Player_Info.Player;
import Warrior.Horseman.Horseman;
import Warrior.Warrior;
import Warrior.FootWarrior.Axeman;
import Warrior.FootWarrior.SpadesMan;
import Warrior.FootWarrior.Swordman;
import Warrior.Horseman.Knigth;
import Warrior.Horseman.Cuirassier;
import Warrior.Horseman.HorseBowman;
import Warrior.Bowman.ShortBowman;
import Warrior.Bowman.LongBowman;
import Warrior.Bowman.Crossbowman;
import Warrior.Ninja.Ninja;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class Bot {
    public String[] symbolArray = new String[7];
    Bot(Battlefield bf){
        this.bf = bf;
        this.array[6] = Cr;
        this.array[1] = Sw;
        this.array[2] = Kn;
        this.array[3] = Ax;
        this.array[4] = Lb;
        this.array[5] = Cu;
        this.array[0] = Nj;
        this.symbolArray[6] = Cr.getStockSymbol();
        this.symbolArray[1] = Sw.getStockSymbol();
        this.symbolArray[2] = Kn.getStockSymbol();
        this.symbolArray[3] = Ax.getStockSymbol();
        this.symbolArray[4] = Lb.getStockSymbol();
        this.symbolArray[5] = Cu.getStockSymbol();
        this.symbolArray[0] = Nj.getStockSymbol();
        changeColour();
    }
    private final int money=200;
    private Warrior[] array = new Warrior[7];
    private Battlefield bf = new Battlefield();
    private Ninja Nj = new Ninja(bf);
    private Crossbowman Cr = new Crossbowman(bf);
    private Swordman Sw = new Swordman(bf);
    private Knigth Kn = new Knigth(bf);
    private Axeman Ax = new Axeman(bf);
    private LongBowman Lb = new LongBowman(bf);
    private Cuirassier Cu = new Cuirassier(bf);
    public void move(){
//реализовать ход не на одну клетку, а на все возможно расстояние
        for (int i=0; i < array.length; i++){
            if (array[i].getYCord()>0) {
                if (bf.show(array[i].getYCord() - 1, array[i].getXCord()) == "▒") {
                    array[i].move(array[i].getXCord(), array[i].getYCord() - 1, bf);
                    bf.replace(array[i].getXCord(), array[i].getYCord(), array[i].getYCord() + 1, array[i].getXCord(), this.array, i, false);
                    return;
                }
            }
            if (array[i].getXCord()<9) {
                if (bf.show(array[i].getYCord(), array[i].getXCord() + 1) == "▒") {
                    array[i].move(array[i].getXCord() + 1, array[i].getYCord(), bf);
                    bf.replace(array[i].getXCord(), array[i].getYCord(), array[i].getYCord(), array[i].getXCord() - 1, this.array, i, false);
                    return;
                }
            }
            if (array[i].getXCord()>0) {
                if (bf.show(array[i].getYCord(), array[i].getXCord() - 1) == "▒") {
                    array[i].move(array[i].getXCord() - 1, array[i].getYCord(), bf);
                    bf.replace(array[i].getXCord(), array[i].getYCord(), array[i].getYCord(), array[i].getXCord() + 1, this.array, i, false);
                    return;
                }
            }
            if (array[i].getYCord()>0 && array[i].getXCord()<9) {
                if (bf.show(array[i].getYCord() - 1, array[i].getXCord() + 1) == "▒") {
                    array[i].move(array[i].getXCord() + 1, array[i].getYCord() - 1, bf);
                    bf.replace(array[i].getXCord(), array[i].getYCord(), array[i].getYCord() + 1, array[i].getXCord() - 1, this.array, i, false);
                    return;
                }
            }
            if (array[i].getYCord()>0 && array[i].getXCord()>0) {
                if (bf.show(array[i].getYCord() - 1, array[i].getXCord() - 1) == "▒") {
                    array[i].move(array[i].getXCord() - 1, array[i].getYCord() - 1, bf);
                    bf.replace(array[i].getXCord(), array[i].getYCord(), array[i].getYCord() + 1, array[i].getXCord() + 1, this.array, i, false);
                    return;
                }
            }
        }
    }

    private void ninjaMove(){
        if (Nj.getXCord() != 1 && Nj.getYCord() != 3) {
            Nj.setxCord(Nj.getXCord()-2);
            Nj.setyCord(Nj.getYCord()-2);
        }
        else {
            Nj.setxCord(1);
            Nj.setyCord(1);
        }
    }
    public Warrior[] attack(Warrior[] playerArray, Battlefield bf){
        this.bf = bf;
        for (int i = 0; i < array.length; i++){
            if (i==0 && array[i] == Nj) { //Прописать новый метод для Ниндзи, чтобы он шел к королю
                if (!Nj.getTransparent()) {
                    Nj.setTransparent(true);
                    bf.setBattleField(Nj.getYCord(), Nj.getXCord(), "▒");
                }
                if (Nj.getXCord()==1 && Nj.getYCord()==1){
                    bf.setBattleField(1, 0, Nj.getSymbol());
                    bf.toString();
                    System.out.println("Король умер, да здравствует Питикин Алексей Русланович");
                    System.exit(0);
                }
                ninjaMove();
                break;
                }
            else{
                int X = array[i].getXCord();
                int Y = array[i].getYCord();
                for (int j=0; j < playerArray.length; j++){
                    int strenght = array[i].attack(playerArray[j].getXCord(), playerArray[j].getYCord());
                    if (strenght!=0) {
                        boolean death = playerArray[j].damage(strenght, this.bf);
                        if (death){
                            Warrior[] newPlayerArray = new Warrior[playerArray.length-1];
                            System.arraycopy(playerArray, 0, newPlayerArray, 0, j);

                            System.arraycopy(playerArray, j + 1, newPlayerArray, j, playerArray.length - 1 - j);
                            playerArray = newPlayerArray;
                        }
                        return playerArray;
                    }
                }
                move();
            }
        }
        return playerArray;
    }
    public Warrior[] getArray(){return array;}
    public int search(int X, int Y){
        for (int i=0; i< array.length; i++){
            if (array[i].getXCord() == X && array[i].getYCord() == Y){
                return i;
            }
        }
        return -1;
    }
    public void setArray(Warrior[] array){
        this.array = array;
    }
    private void changeColour(){
        for (int i=0; i< array.length; i++){
            array[i].botColour(symbolArray[i]);
        }
    }
    public void showNinja(Battlefield bf){
        this.bf = bf;
    }

    public Battlefield getBf(){return this.bf;}
}
