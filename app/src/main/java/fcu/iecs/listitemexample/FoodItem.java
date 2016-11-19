package fcu.iecs.listitemexample;

import java.io.Serializable;

/**
 * Created by sammy on 2016/11/19.
 */
public class FoodItem implements Serializable{

    private String itemName;

    private int price;

    private int amount = 0;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
