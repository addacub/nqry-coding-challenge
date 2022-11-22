package nqryCodingChallenge.coffee;

import nqryCodingChallenge.IChargeable;

/**
 * The coffee sizes available.
 * <p>
 * The coffee sizes (and their cost factor) are a fixed menu item. They
 * shouldn't need to change regularly. If cost factor and coffee sizes do
 * change, it
 * can easily be modified in this enum class without needing to touch any other
 * classes.
 * 
 * Similarly, the implementation of tallyCost can be updated in this class
 * without the need for touching other classes.
 */
public enum SizeType implements IChargeable {
    STANDARD(1f),
    CHILD(0.75f),
    LARGE(1.5f),
    ADDICT(2f);

    private final float costFactor;

    private SizeType(float costFactor) {
        this.costFactor = costFactor;
    }

    public float getcostFactor() {
        return this.costFactor;
    }

    @Override
    public int tallyCost(int tally) {
        return Math.round(tally * this.costFactor);
    }
}
