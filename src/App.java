public class App {
    public static void main(String[] args) throws Exception {
        while(true)
        {
            System.out.println("Please enter using the following format:");
            System.out.println("coefficient1 exponent1 coefficient2 exponent2 ...");
            System.out.println("Example: 1 2 3 4 5 6");
            System.out.println("This will create a polynomial of 1x^2 + 3x^4 + 5x^6");
            System.out.println("Please enter your first polynomial:");
            String input = System.console().readLine();
            String[] inputArray = input.split(" ");
            if (inputArray.length % 2 != 0)
            {
                System.out.println("Please enter a valid polynomial");
                continue;
            }
            Polynomial poly1 = new Polynomial();
            for(int i = 0; i < inputArray.length; i+=2) 
            {
                poly1.addPolyUnit(Integer.parseInt(inputArray[i]), Integer.parseInt(inputArray[i+1]));
            }

            System.out.println("Please enter your second polynomial:");
            input = System.console().readLine();
            inputArray = input.split(" ");
            if (inputArray.length % 2 != 0)
            {
                System.out.println("Please enter a valid polynomial");
                continue;
            }
            Polynomial poly2 = new Polynomial();
            for(int i = 0; i < inputArray.length; i+=2) 
            {
                poly2.addPolyUnit(Integer.parseInt(inputArray[i]), Integer.parseInt(inputArray[i+1]));
            }

            System.out.println("Please enter the operation you would like to perform:");
            System.out.println("+ / -");
            input = System.console().readLine();
            Polynomial result = new Polynomial();
            if (input.equals("+"))
            {
                System.out.println("The result is:");
                result = result.add(poly1, poly2);
                System.out.println(result.toString());
            }
            else if (input.equals("-"))
            {
                System.out.println("The result is:");
                result = result.multiply(poly1, poly2);
                System.out.println(result.toString());
            }
            else
            {
                System.out.println("Please enter a valid operation");
                continue;
            }

        }
        

    }
}
