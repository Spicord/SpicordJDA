package org.spicord.log;

import java.util.logging.Logger;

public class LoggerFactory {

    private static final NOPLogger NOP = new NOPLogger();

    private static Logger spicordLogger;

    public static void init(Logger logger) {
        spicordLogger = logger;
    }

    public static org.spicord.log.Logger getLogger(String name) {
        if (spicordLogger == null) {
            return NOP;
        } else {
            return new LoggerImpl(spicordLogger, name);
        }
    }

    public static org.spicord.log.Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getSimpleName());
    }
}
