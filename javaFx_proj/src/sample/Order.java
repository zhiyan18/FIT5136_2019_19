package sample;

import java.util.ArrayList;

public class Order {
    private String userName;
    private String data;
    private ArrayList<String> foods;
    private double price;


    public Order(String userName, String data, ArrayList<String> foods, double price) {
        this.userName = userName;
        this.data = data;
        this.foods = foods;
        this.price = price;
    }
}
