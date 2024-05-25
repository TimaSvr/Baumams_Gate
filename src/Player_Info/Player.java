package Player_Info;

import Warrior.Warrior;

import java.util.HashMap;
import java.util.Set;

public class Player {
    private int money;
    private int[] units;
    private int unitsAmount;

    public Player(int money, int unitsAmount) {
        this.money = money;
        this.unitsAmount = unitsAmount;
        units = new int[unitsAmount];
    }

    public int count(Integer[] array){
        int count=0;
        for (int i=0; i<array.length; i++){
            count+=array[i];
        }
        return count;
    }
    public Integer[] buy(HashMap<Warrior, Integer> shop_list) {
        Integer[] array_counter = shop_list.values().toArray(new Integer[0]);
        Set<Warrior> key = shop_list.keySet();
        Warrior[] array = key.toArray(new Warrior[0]);
        int i = 0;
        while (money > 0 && count(array_counter)>0) {
            if (i == 9) {
                i = 0;
            }
            if (shop_list.get(array[i]) != 0) {
                if (money >= array[i].getCost()) {
                    money -= array[i].getCost();
                    shop_list.put(array[i], shop_list.get(array[i]) - 1);
                    array_counter[i] -= 1;
                }
                else break;
            }
            i++;
        }
        Integer[] arr = new Integer[9];
        for (int j = 0; j < array.length; j++) {
            arr[j] = shop_list.get(array[j]);
        }
        return arr;
    }


    public void setUnitsAmount(int unitsAmount) {
        this.unitsAmount = unitsAmount;
    }

    public int getUnitsAmount() {
        return unitsAmount;
    }

    public int getMoney(){return this.money;}
}