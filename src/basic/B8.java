package basic;

public class B8 {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("請輸入參數");
        } else if (args[0].equals("-a")) {
            if (args.length < 2) {
                throw new IllegalArgumentException("Argument 2 is required.");
            } else {
                for (String arg : args) {
                    System.out.print(arg + " ");
                }
                System.out.println();
            }
        } else {
            for (String arg : args) {
                System.out.print(arg + " ");
            }
            System.out.println();
        }
    }
}
