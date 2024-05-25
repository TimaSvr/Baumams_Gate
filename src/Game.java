import Battlefield.Battlefield;
import Player_Info.Player;
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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Game {
    protected HashMap<Warrior, Integer> shop_list = new HashMap<>();
    public Battlefield bf = new Battlefield();
    protected Player p = new Player(200, 0);
    private Crossbowman Cr = new Crossbowman(bf);
    private LongBowman Lb = new LongBowman(bf);
    private ShortBowman Sb = new ShortBowman(bf);
    private Axeman Ax = new Axeman(bf);
    private SpadesMan Sp = new SpadesMan(bf);
    private Swordman Sw = new Swordman(bf);
    private Cuirassier Cu = new Cuirassier(bf);
    private HorseBowman Hb = new HorseBowman(bf);
    private Knigth Kn = new Knigth(bf);
    private Bot bt = new Bot(bf);
    Scanner sc = new Scanner(System.in);

    private Warrior[] unitsArray = new Warrior[5];

    public void startGame() {
        System.out.println("Добро пожаловать в игру Baumans Gate! \n Выберите своих юнитов, исходя из таблицы, приведенной ниже:");
        UnitsTable();
        String s = bf.toString();
        System.out.println("Сколько вы хотите закупить Арбалетчиков?");
        hashMapFiller(Cr);
        System.out.println("Сколько вы хотите закупить Дальних Лучников?");
        hashMapFiller(Lb);
        System.out.println("Сколько вы хотите закупить Слабых Лучников?");
        hashMapFiller(Sb);
        System.out.println("Сколько вы хотите закупить Топорщиков?");
        hashMapFiller(Ax);
        System.out.println("Сколько вы хотите закупить Копейщиков?");
        hashMapFiller(Sp);
        System.out.println("Сколько вы хотите закупить Мечников?");
        hashMapFiller(Sw);
        System.out.println("Сколько вы хотите закупить Кирасиров?");
        hashMapFiller(Cu);
        System.out.println("Сколько вы хотите закупить Конных лучников?");
        hashMapFiller(Hb);
        System.out.println("Сколько вы хотите закупить Рыцарей?");
        hashMapFiller(Kn);
        HashMap<Warrior, Integer> shop_list_copy = new HashMap<>();
        Set<Warrior> key = shop_list.keySet();
        Warrior[] array = key.toArray(new Warrior[key.size()]);
        for (int i = 0; i < array.length; i++) {
            shop_list_copy.put(array[i], shop_list.get(array[i]));
        }
        Integer[] diff = p.buy(shop_list_copy);
        for (int j = 0; j < array.length; j++) {
            shop_list.put(array[j], shop_list.get(array[j]) - diff[j]);
        }
        p.setUnitsAmount(p.count(shop_list.values().toArray(new Integer[0])));
        unitsArrayFiller();
        this.bf.fillWithUnits(this.unitsArray, 0);
        Bot bt = new Bot(this.bf);
        this.bf.fillWithUnits(this.bt.getArray(), 1);
        this.bf.toString();
        play();
    }


    public void UnitsTable() {
        System.out.println(Cr.getName());
        Cr.getInfo(0);

        System.out.println(Lb.getName());
        Lb.getInfo(0);

        System.out.println(Sb.getName());
        Sb.getInfo(0);

        System.out.println(Ax.getName());
        Ax.getInfo(0);

        System.out.println(Sp.getName());
        Sp.getInfo(0);

        System.out.println(Sw.getName());
        Sw.getInfo(0);

        System.out.println(Cu.getName());
        Cu.getInfo(0);

        System.out.println(Hb.getName());
        Hb.getInfo(0);

        System.out.println(Kn.getName());
        Kn.getInfo(0);
    }

    private void hashMapFiller(Warrior Wr) {
        int amount;
        amount = sc.nextInt();
        this.p.setUnitsAmount(p.getUnitsAmount() + amount);
        this.shop_list.put(Wr, amount);
    }

    private void unitsArrayFiller() {
        this.unitsArray = new Warrior[this.p.getUnitsAmount()];

        int i = 0, i1 = 0, i2 = 0, i3 = 0, i4 = 0, i5 = 0, i6 = 0, i7 = 0, i8 = 0;
        for (i = i; i < this.shop_list.get(Cr); i++) {
            this.unitsArray[i] = new Crossbowman(this.bf); //this.shop_list.get(Lb) + уже выбранное количество
        }
        for (i1 = i; i1 < this.shop_list.get(Lb) + i; i1++) {
            this.unitsArray[i1] = new LongBowman(this.bf);
        }
        for (i2 = i1; i2 < this.shop_list.get(Sb) + i1; i2++) {
            this.unitsArray[i2] = new ShortBowman(this.bf);
        }
        for (i3 = i2; i3 < this.shop_list.get(Ax) + i2; i3++) {
            this.unitsArray[i3] = new Axeman(this.bf);
        }
        for (i4 = i3; i4 < this.shop_list.get(Sp) + i3; i4++) {
            this.unitsArray[i4] = new SpadesMan(this.bf);
        }
        for (i5 = i4; i5 < this.shop_list.get(Sw) + i4; i5++) {
            this.unitsArray[i5] = new Swordman(this.bf);
        }
        for (i6 = i5; i6 < this.shop_list.get(Cu) + i5; i6++) {
            this.unitsArray[i6] = new Cuirassier(this.bf);
        }
        for (i7 = i6; i7 < this.shop_list.get(Hb) + i6; i7++) {
            this.unitsArray[i7] = new HorseBowman(this.bf);
        }
        for (i8 = i7; i8 < this.shop_list.get(Kn) + i7; i8++) {
            this.unitsArray[i8] = new Knigth(this.bf);
        }
    }

    int heathCheck(Warrior[] array) {
        int currentHeath = 0;
        for (int i = 0; i < array.length; i++) {
            currentHeath += array[i].getHealth();
        }
        return currentHeath;
    }

    void play() {
        int neX = 0, neY = 0;
        while (heathCheck(this.unitsArray) != 0 && heathCheck(bt.getArray()) != 0) {
            System.out.println("Если Вы хотите сходить - нажмите 0, если хотите аттаковать - нажмите 1, если хотите посмотреть, где ниндзя - нажмите 2 (стоимость просмотра 20 коинов)");
            int answer = sc.nextInt();
            if (answer==2){
                if (p.getMoney() < 20) {
                    System.out.println("Недостаточно средств, чтобы посмотреть, где ниндзя, поторопись, он может быть рядом...");
                }
                else {
                    neX = bt.getArray()[0].getXCord();
                    neY = bt.getArray()[0].getYCord();
                    String stockSym = bf.show(neY, neX);
                    bf.setBattleField(neY, neX, bt.getArray()[0].getSymbol());
                    this.bf.toString();
                    bf.setBattleField(neY, neX, "▒");
                }
                System.out.println("Если Вы хотите сходить - нажмите 0, если хотите аттаковать - нажмите 1");
                answer = sc.nextInt();
            }
            switch (answer) {
                case 0:
                    System.out.println("Выберите юнита, которым Вы хотели бы сходить");
                    answer = sc.nextInt();
                    System.out.println("Введите X и Y координты клетки, куда сходить");
                    int X = sc.nextInt();
                    int Y = sc.nextInt();
                    int stockX = unitsArray[answer].getXCord();
                    int stockY = unitsArray[answer].getYCord();
                    boolean flag = this.unitsArray[answer].move(X, Y, bf);
                    if (flag) {
                        this.bf.replace(stockX, stockY, Y, X, unitsArray, answer, false);
                    }
                    break;
                case 1: {
                    System.out.println("Выберите юнита, которым Вы хотели бы сходить");
                    answer = sc.nextInt();
                    System.out.println("Выберите координаты юнита, которого Вы хотели бы атаковать (Y:X)");
                    int YtoAttack = sc.nextInt();
                    int XtoAttack = sc.nextInt();
                    int unitToAttack = bt.search(XtoAttack, YtoAttack);
                    if (unitToAttack != -1) {
                        boolean death = bt.getArray()[unitToAttack].damage(unitsArray[answer].attack(XtoAttack, YtoAttack), bf);
                        if (death) {
                            Warrior[] newBotArray = new Warrior[bt.getArray().length - 1];
                            System.arraycopy(bt.getArray(), 0, newBotArray, 0, unitToAttack);

                            System.arraycopy(bt.getArray(), unitToAttack + 1, newBotArray, unitToAttack, bt.getArray().length - 1 - unitToAttack);
                            bt.setArray(newBotArray);
                        }
                    }
                    break;
                }
            }

        unitsArray = bt.attack(unitsArray, this.bf);
        System.out.println("Ваши юниты");
        for (int i = 0; i < unitsArray.length; i++) {
            unitsArray[i].getInfo(i);
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Юниты соперника");
        for (int j = 0; j < bt.getArray().length; j++) {
            bt.getArray()[j].getInfo(j);
        }
        this.bf = bt.getBf();
        this.bf.toString();
    }

    }


    public Battlefield getbf(){return bf;}

}

