package nqryCodingChallenge;

import org.junit.jupiter.api.Test;

import nqryCodingChallenge.coffee.BlendType;
import nqryCodingChallenge.coffee.Coffee;
import nqryCodingChallenge.coffee.CondimentType;
import nqryCodingChallenge.coffee.PreparationStyle;
import nqryCodingChallenge.coffee.SizeType;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class AppTest {
    @Test
    void calculateOrderCost() {
        // Arrange
        Coffee coffee1 = new Coffee.Builder(BlendType.ROBUSTA, PreparationStyle.ESPRESSO, SizeType.STANDARD).build();
        Coffee coffee2 = new Coffee.Builder(BlendType.ARABICA, PreparationStyle.CAPPUCCINO, SizeType.LARGE)
                .addCondiment(CondimentType.COCO_POWDER).addCondiment(CondimentType.SUGAR).build();
        Order classUnderTest = new Order();
        classUnderTest.addCoffeeOrder(new ArrayList<Coffee>(Arrays.asList(coffee1, coffee2)));

        int coffeeCost1 = BlendType.ROBUSTA.getcost() + PreparationStyle.ESPRESSO.getcost();
        int coffeeCost2 = Math.round(
                (BlendType.ARABICA.getcost() + PreparationStyle.CAPPUCCINO.getcost()) * SizeType.LARGE.getcostFactor())
                + CondimentType.COCO_POWDER.getCost() + CondimentType.SUGAR.getCost();
        float expectedCost = (coffeeCost1 + coffeeCost2) / 100f;

        // Act
        float actualCost = classUnderTest.calculateCost();

        // Assert
        assertEquals(expectedCost, actualCost);
    }
}
