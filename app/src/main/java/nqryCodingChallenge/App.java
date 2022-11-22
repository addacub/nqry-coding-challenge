package nqryCodingChallenge;

import java.util.ArrayList;
import java.util.Arrays;

import nqryCodingChallenge.coffee.BlendType;
import nqryCodingChallenge.coffee.Coffee;
import nqryCodingChallenge.coffee.CondimentType;
import nqryCodingChallenge.coffee.PreparationStyle;
import nqryCodingChallenge.coffee.SizeType;

public class App {

    public static void main(String[] args) {
        Coffee coffee_1 = new Coffee.Builder(BlendType.ARABICA, PreparationStyle.LATTE, SizeType.STANDARD)
                .addCondiment(CondimentType.SUGAR).build();
        Coffee coffee_2 = new Coffee.Builder(BlendType.HOUSE_BLEND, PreparationStyle.MACCHIATO, SizeType.ADDICT)
                .addCondiment(CondimentType.SUGAR).addCondiment(CondimentType.COCO_POWDER).build();

        Order coffeeOrder = new Order();
        coffeeOrder.addCoffeeOrder(new ArrayList<Coffee>(Arrays.asList(coffee_1, coffee_2)));

        System.out.println(coffeeOrder.calculateCost());
    }
}
