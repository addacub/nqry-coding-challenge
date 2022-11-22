package nqryCodingChallenge.coffee;

import nqryCodingChallenge.IChargeable;

/**
 * The coffee styles available.
 * <p>
 * The coffee styles (and their cost) are a fixed menu item. They shouldn't
 * need to change regularly. If prices and coffee styles do change, it can
 * easily be modified in this enum class without needing to touch any other
 * classes.
 * <p>
 * Similarly, the implementation of tallyCost can be updated in this class
 * without the need for touching other classes.
 * <p>
 * Note, prices are shown in cents.
 */
public enum PreparationStyle implements IChargeable {
    ESPRESSO(100),
    LATTE(125),
    CAPPUCCINO(150),
    MACCHIATO(175),
    MOCHA(200);

    private final int cost;

    private PreparationStyle(int cost) {
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
