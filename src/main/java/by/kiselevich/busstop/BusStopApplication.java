package by.kiselevich.busstop;

import by.kiselevich.busstop.exception.NoFilenameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BusStopApplication {

    private static final Logger LOG = LogManager.getLogger(BusStopApplication.class);

    public static void main(String[] args) {
        LOG.info("Get args count: {}", args.length);
        if (args.length > 0) {
            LOG.info("Get filename: {}", args[0]);
            System.out.println("Hello World!");
        } else {
            LOG.error("No input filename");
            throw new NoFilenameException("No input filename!");
        }
    }
}
