package a;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class A4 {
    public static void main(String[] args) throws IOException {
        Logger logger = LogManager.getLogger();
        if (args.length != 2) {
            System.out.println("請輸入正確參數");
        } else {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream(args[0] + ".properties");
            Properties properties = new Properties();
            properties.load(new InputStreamReader(inputStream, "utf-8"));

            File file = new File(args[1]);
            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            for (String key : properties.stringPropertyNames()) {
                logger.info(key + " : " + properties.getProperty(key));
                writer.write("[" + key + ", " + properties.getProperty(key) + "]\n");
            }

            inputStream.close();
            writer.close();
        }
    }
}





