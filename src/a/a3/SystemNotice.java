package a.a3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SystemNotice {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("SystemNotice");

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

    }
}
