package nqryCodingChallenge.coffee;

import nqryCodingChallenge.IChargeable;

/**
 * Additional optional condiments (1 or more) which can be added.
 * <p>
 * The optional condiments (and their cost) are a fixed menu item. They
 * shouldn't need to change regularly. If prices and coffee styles do change, it
 * can easily be modified in this enum class without needing to touch any other
 * classes.
 * <p>
 * Similarly, the implementation of tallyCost can be updated in this class
 * without the need for touching other classes.
 * <p>
 * Note, prices are shown in cents.
 */
public enum CondimentType implements IChargeable {
    MILK(100),
    SUGAR(25),
    COCO_POWDER(10);

    private final int cost;

    private CondimentType(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }

    @Override
    public int tallyCost(int tally) {
        return tally + this.cost;
    }
}
