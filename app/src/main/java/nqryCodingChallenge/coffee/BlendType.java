package nqryCodingChallenge.coffee;

import nqryCodingChallenge.IChargeable;

/**
 * The coffee blends available.
 * <p>
 * The coffee blends (and their cost) are a fixed menu item. They shouldn't
 * need to change regularly. If prices and blends do change, it can easily be
 * modified in this enum class without needing to touch any other classes.
 * <p>
 * Similarly, the implementation of tallyCost can be updated in this class
 * without the need to touch other classes.
 * <p>
 * Note, prices are shown in cents.
 */
public enum BlendType implements IChargeable {
    HOUSE_BLEND(100),
    DARK_ROAST(150),
    ROBUSTA(200),
    ARABICA(250);

    private final int cost;

    private BlendType(int cost) {
        this.cost = cost;
    }

    public int getcost() {
        return this.cost;
    }

    @Override
    public int tallyCost(int tally) {
        return tally + this.cost;
    }
}
