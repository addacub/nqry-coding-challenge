package nqryCodingChallenge.coffee;

import java.util.ArrayList;

import nqryCodingChallenge.IChargeable;

/**
 * Represents a coffee order. Each coffee must have a blend, preparation style,
 * and size. Additional optional condiments (1 or more) can be added.
 * 
 * As the components of coffee all implement the IChargeable interface, to
 * determine the cost of the coffee, the Coffee class needs to simply invoke the
 * tallyCost for each component (in the appropriate order) and pass in the
 * current tally cost of the coffee.
 */
public class Coffee implements IChargeable {
    private final BlendType blend;
    private final PreparationStyle preparationStyle;
    private final SizeType size;
    private final ArrayList<CondimentType> condiments;
    // Alternatively could have stored all the parts of the coffee order
    // in an ArrayList<IChargeable> and iterate over list calling tallyCost

    private Coffee(Builder builder) {
        this.blend = builder.blend;
        this.preparationStyle = builder.preparationStyle;
        this.size = builder.size;
        this.condiments = builder.condiments;
    }

    @Override
    public int tallyCost(int tally) {
        int coffeeTally = 0;
        coffeeTally = blend.tallyCost(coffeeTally);
        coffeeTally = preparationStyle.tallyCost(coffeeTally);
        // Assuming the size cost factor is applied to both blend and preparation style.
        // Can easily move around if this is not the case.
        coffeeTally = size.tallyCost(coffeeTally);
        for (CondimentType condiment : condiments) {
            coffeeTally = condiment.tallyCost(coffeeTally);
        }

        return tally + coffeeTally;
    }

    public static class Builder {
        // Requried parameters
        private final BlendType blend;
        private final PreparationStyle preparationStyle;
        private final SizeType size;

        // Optional parameters
        private final ArrayList<CondimentType> condiments = new ArrayList<>();

        public Builder(BlendType blend, PreparationStyle preparationStyle, SizeType size) {
            this.blend = blend;
            this.preparationStyle = preparationStyle;
            this.size = size;
        }

        public Builder addCondiment(CondimentType condiment) {
            this.condiments.add(condiment);
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }

    }

}
