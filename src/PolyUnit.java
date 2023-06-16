public class PolyUnit {
    PolyUnit prev;
    int coefficient;
    int exponent;
    PolyUnit next;

    public PolyUnit(int coefficient, int exponent) {
        this.prev = null;
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}