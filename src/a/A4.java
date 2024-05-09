package a;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class A4 {
    public static void main(String[] args) throws IOException {
        Logger logger = LogManager.getLogger();
        InputStream inputStream = null;
        FileWriter writer = null;
        if (args.length != 2) {
            System.out.println("請輸入正確參數");
        } else {
            try {
                inputStream = ClassLoader.getSystemResourceAsStream(args[0] + ".properties");
                Properties properties = new Properties();
                if (inputStream != null) {
                    properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                    logger.info(properties);

                    File file = new File(args[1] + ".txt");
                    writer = new FileWriter(file);

                    for (String key : properties.stringPropertyNames()) {
                        writer.write("[" + key + ", " + properties.getProperty(key) + "]\n");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                        writer.close();
                }
                if (inputStream != null) {
                        inputStream.close();
                }

            }
        }
    }
}






