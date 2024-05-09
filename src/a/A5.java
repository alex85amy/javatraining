package a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class A5 {

    public static String generateSalt() {
        // 創建一個安全的隨機數據生成器
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        // 將 salt 陣列轉換為 Base64 字串並返回
        return Base64.getEncoder().encodeToString(salt);// Base64 是一種可以把二進位的資料編碼成 ASCII 字元的方法
    }

    public static String generateHash(String input, String algorithm, boolean useSalt) {
        try {
            // 獲取指定演算法的 MessageDigest 實例
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            // 如果使用 salt，則生成 salt 並將其添加到 MessageDigest 中
            if (useSalt) {
                String salt = generateSalt();
                digest.update(Base64.getDecoder().decode(salt));
            }
            // 計算哈希值
            byte[] hash = digest.digest(input.getBytes());

            // 將二進制 byte 陣列轉換為十六進制字串
            StringBuffer hexString = new StringBuffer();
            for (byte b : hash) {
                String hex = Integer.toHexString(b & 0xff); //這裡使用 b & 0xff 的位元運算來確保得到的十六進制字串是兩位數的
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the input string:");
        String input = scanner.nextLine();
        System.out.println("Choose the hash algorithm (SHA-224, SHA-256):");
        String algorithm = scanner.nextLine();
        System.out.println("Do you want to use salt? (yes/no):");
        String useSaltStr = scanner.nextLine();
        boolean useSalt = useSaltStr.equalsIgnoreCase("yes");

        String hash = generateHash(input, algorithm, useSalt);
        System.out.println("Hash of '" + input + "' using " + algorithm + " algorithm " + (useSalt ? "with salt" : "without salt") + ": ");
        System.out.println(hash);
        scanner.close();
    }

}
