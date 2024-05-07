package basic;

import java.io.IOException;

public class B9 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("請輸入參數");
        } else {
            switch (args[0]) {
                case "notepad.exe" -> Runtime.getRuntime().exec("notepad");//調用CMD開啟系統
                case "calc.exe" -> Runtime.getRuntime().exec("calc");
                default -> System.out.println("輸入無效！ 請輸入有效指令");
            }
        }
    }
}
