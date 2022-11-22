package nqryCodingChallenge;

/**
 * Any chargeable item should implement this interface. The implementation
 * should be specific to the chargeable item. For example, some may be a simple
 * addition while others may be a function of the input tally.
 * 
 * This means each class that implements IChargeable only needs to know how to
 * account for itself in the total cost. The caller does not care about the
 * implementation.
 * 
 * @param tally This is the current tally passed in
 * @return int This returns the tally with the chargeable item accounted for.
 */
public interface IChargeable {
    public int tallyCost(int tally);
}
