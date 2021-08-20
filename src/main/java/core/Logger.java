package core;

/**
 * Class used to create logging of all the operations inside program
 */
public class Logger {
    private static final org.apache.log4j.Logger LOG4J = org.apache.log4j.Logger.getLogger(Logger.class);
    private static Logger instance = null;

    /**
     * Method to create and initialize object of class Logger
     *
     * @return object of class Logger
     */
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * Method to log information with passed message
     *
     * @param message Massage of the info
     */
    public void info(String message) {
        LOG4J.info(message);
    }

    /**
     * Method to log warning with passed message
     *
     * @param message Massage of the warning
     */
    public void warn(String message) {
        LOG4J.warn(message);
    }

    /**
     * Method used for formatting test name at the test start
     *
     * @param testName Test name
     */
    public void logTestName(final String testName) {
        String formattedName = String.format("=====================  Test case: '%s' =====================", testName);

        String delims = "";
        int nChars = formattedName.length();
        for (int i = 0; i < nChars; i++) {
            delims += "-";
        }
        info(delims);
        info(formattedName);
        info(delims);
    }

    /**
     * Method used for formatting test name at the test end
     *
     * @param testName Test name
     */
    public void logTestEnd(final String testName) {
        info("");
        String formattedEnd = String.format("***** Test case: '%s' Passed *****", testName);
        String stars = "";
        int nChars = formattedEnd.length();
        for (int i = 0; i < nChars; i++) {
            stars += "*";
        }
        info(stars);
        info(formattedEnd);
        info(stars);
        info("");
    }
}
