public class App {
    public static void main(String[] args) throws Exception {
        Polynomial polynomial = new Polynomial();
        polynomial.addPolyUnit(1, 2);
        polynomial.addPolyUnit(0, 1);
        polynomial.addPolyUnit(3, 0);
        polynomial.addPolyUnit(4, -1);
        polynomial.addPolyUnit(5, -2);
        System.out.println(polynomial.toString());
    }
}
