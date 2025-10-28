public class ComparableNumber implements MyComparable <Number> {
    private Number value;

    public ComparableNumber(Number value) {
        this.value = value;
    }

    @Override
    public int compare(Number number) {
        double thisValue = this.value.doubleValue();
        double numberValue = number.doubleValue();

        if (thisValue > numberValue) {
            return 1;
        } else if (thisValue < numberValue) {
            return -1;
        } else {
            return 0;
        }
    }
}
