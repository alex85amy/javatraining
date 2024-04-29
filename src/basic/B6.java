package basic;

public class B6 {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int num = Integer.parseInt(args[0]);
                int result = num + 10;
                String s = Integer.toString(result);
                System.out.println("Input number: " + num);
                System.out.println("Input number + 10 : " + result);
            } catch (NumberFormatException e) {
                System.err.println("輸入無效！ 請輸入有效的整數！");
            }
        } else {
            System.err.println("請提供一個整數作為命令列參數。");
        }
    }
}
