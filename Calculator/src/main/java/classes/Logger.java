package classes;

import java.time.LocalDateTime;

public class Logger {
    protected int num = 1;
    private static Logger logger;

    private Logger() {
    }

    public static synchronized Logger getLogger() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }

    public void getInfo(String str) {
        System.out.println("[ " + LocalDateTime.now() + " шаг №_" + num++ + " ] " + str);
    }
}
