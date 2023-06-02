public class PolyUnit {
    PolyUnit prev;
    int coefficient;
    int exponent;
    PolyUnit next;

    public PolyUnit(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
}