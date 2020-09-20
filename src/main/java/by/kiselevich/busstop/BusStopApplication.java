package by.kiselevich.busstop;

import by.kiselevich.busstop.service.BusStopService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BusStopApplication {

    private static final Logger LOG = LogManager.getLogger(BusStopApplication.class);

    public static void main(String[] args) {
        LOG.info("Get args count: {}", args.length);
        if (args.length < 1) {
            LOG.error("No input filename");
        }
        try {
            LOG.info("Get filename: {}", args[0]);
            BusStopService busStopService = new BusStopService();
            busStopService.generateGeneralTimetable(args[0]);
            LOG.info("New timetable generated!");
        } catch (Exception e) {
            LOG.error("Error timetable generating!", e);
        }
    }
}
