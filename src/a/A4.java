package a;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class A4 {
    public static void main(String[] args) throws IOException {
        Logger logger = LogManager.getLogger();
        if (args.length != 2) {
            System.out.println("請輸入正確參數");
        } else {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(args[0] + ".properties");
            Properties properties = new Properties();
            if (inputStream != null) {
                properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                logger.info(properties);

                File file = new File(args[1]);
                FileWriter writer = new FileWriter(file);

                for (String key : properties.stringPropertyNames()) {
                    writer.write("[" + key + ", " + properties.getProperty(key) + "]\n");
                }
                writer.close();
            }
            System.out.println("請輸入正確參數");

            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}





