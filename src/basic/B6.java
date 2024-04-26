package basic;

public class B6 {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int num = Integer.parseInt(args[0]);
                int result = num + 10;
                String s = Integer.toString(result);
                System.out.println("Input number: " + num);
                System.out.println("Result after adding 10: " + result);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input! Please enter a valid integer.");
            }
        } else {
            System.err.println("Please provide an integer as command line argument.");
        }
    }
}
