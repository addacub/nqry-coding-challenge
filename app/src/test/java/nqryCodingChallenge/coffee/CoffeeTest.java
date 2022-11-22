package nqryCodingChallenge.coffee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeTest {
    @Test
    void sumBasicCoffee() {
        // Arrange
        Coffee classUnderTest = new Coffee.Builder(BlendType.DARK_ROAST,
                PreparationStyle.MACCHIATO,
                SizeType.STANDARD).build();
        int tally = 0;
        int expectedTally = BlendType.DARK_ROAST.getcost() + PreparationStyle.MACCHIATO.getcost();

        // Act
        tally = classUnderTest.tallyCost(tally);

        // Assert
        assertEquals(expectedTally, tally);
    }

    @Test
    void sumLargeCoffee() {
        // Arrange
        Coffee classUnderTest = new Coffee.Builder(BlendType.DARK_ROAST,
                PreparationStyle.MACCHIATO,
                SizeType.LARGE).build();
        int tally = 0;
        int expectedTally = Math.round((BlendType.DARK_ROAST.getcost() + PreparationStyle.MACCHIATO.getcost())
                * SizeType.LARGE.getcostFactor());

        // Act
        tally = classUnderTest.tallyCost(tally);

        // Assert
        assertEquals(expectedTally, tally);
    }

    @Test
    void sumCoffeeWithCondiments() {
        // Arrange
        Coffee classUnderTest = new Coffee.Builder(BlendType.DARK_ROAST,
                PreparationStyle.MACCHIATO,
                SizeType.LARGE).addCondiment(CondimentType.MILK).addCondiment(CondimentType.SUGAR)
                .addCondiment(CondimentType.COCO_POWDER).addCondiment(CondimentType.SUGAR).build();
        int tally = 0;
        int expectedTally = Math.round((BlendType.DARK_ROAST.getcost() + PreparationStyle.MACCHIATO.getcost())
                * SizeType.LARGE.getcostFactor()) + CondimentType.MILK.getCost()
                + CondimentType.SUGAR.getCost()
                + CondimentType.COCO_POWDER.getCost() + CondimentType.SUGAR.getCost();

        // Act
        tally = classUnderTest.tallyCost(tally);

        // Assert
        assertEquals(expectedTally, tally);
    }
}
