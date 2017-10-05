import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * The Class MyLogging. Used for logging in user input.
 */
public class MyLogging {
  
  /** The logger. */
  private static Logger logger;
  
  /**
   * Instantiates a new my logging.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
    private MyLogging() throws IOException{
    //instance the logger
    logger = Logger.getLogger(MyLogging.class.getName());
    //instance the filehandler
    Handler fileHandler = new FileHandler("myLog.txt",true);
    //instance formatter, set formatting, and handler
    SimpleFormatter plainText = new SimpleFormatter();
    fileHandler.setFormatter(plainText);
    logger.addHandler(fileHandler);
}
  
  /**
   * Gets the logger.
   *
   * @return the logger
   */
  private static Logger getLogger() {
    if (logger == null) {
      try {
        new MyLogging();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return logger;
  }

  /**
   * Logs the level and the message.
   *
   * @param level the level
   * @param msg the message to log.
   */
  public static void log(Level level, String msg) {
    getLogger().log(level, msg);
    System.out.println(msg);
  }
}
