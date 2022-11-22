package nqryCodingChallenge;

import java.util.ArrayList;

import nqryCodingChallenge.coffee.Coffee;

/**
 * Simple class to hold a list of coffee orders and calculate the total cost of
 * the order.
 */
public class Order {
    ArrayList<IChargeable> items = new ArrayList<>();

    public void addCoffeeOrder(Coffee coffee) {
        this.items.add(coffee);

    }

    public void addCoffeeOrder(ArrayList<Coffee> coffees) {
        this.items.addAll(coffees);
    }

    public float calculateCost() {
        int tally = 0;
        for (IChargeable item : items) {
            tally = item.tallyCost(tally);
        }

        // Convert to dollars on return
        return tally / 100f;
    }

}
