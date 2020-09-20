package by.kiselevich.busstop.service;

import by.kiselevich.busstop.domain.BusService;
import by.kiselevich.busstop.domain.ServiceName;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class BusStopService {

    private static final String OUTPUT_FILENAME = "output.txt";

    private final BusServiceParser busServiceParser = new BusServiceParser();
    private final BusServiceFileWriter busServiceFileWriter = new BusServiceFileWriter();

    public void generateGeneralTimetable(String inputFilename) throws IOException {
        List<BusService> busServiceList = busServiceParser.parseInputData(inputFilename);
        List<BusService> newTimetable = new ArrayList<>(busServiceList);
        busServiceList.forEach(busService -> removeLessEfficientService(newTimetable, busService));
        sortNewTimetable(newTimetable);
        busServiceFileWriter.writeToFile(OUTPUT_FILENAME, newTimetable);
    }

    private void removeLessEfficientService(List<BusService> busServiceList, BusService busService) {
        if (getBusServiceDurationInMinutes(busService) > 60) {
            return;
        }

        Iterator<BusService> busServiceIterator = busServiceList.iterator();
        BusService currentBusService;
        while (busServiceIterator.hasNext()) {
            currentBusService = busServiceIterator.next();

            if ((currentBusService.getDepartureTime().equals(busService.getDepartureTime())
                    && currentBusService.getArrivalTime().isAfter(busService.getArrivalTime()))
                    ||
                    (currentBusService.getArrivalTime().equals(busService.getArrivalTime())
                            && currentBusService.getDepartureTime().isBefore(busService.getDepartureTime()))
                    ||
                    (currentBusService.getDepartureTime().isBefore(busService.getDepartureTime())
                            && currentBusService.getArrivalTime().isAfter(busService.getArrivalTime()))
                    ||
                    (currentBusService.getDepartureTime().equals(busService.getDepartureTime())
                            && currentBusService.getArrivalTime().equals(busService.getArrivalTime())
                            && currentBusService.getServiceName() == ServiceName.GROTTY
                            && busService.getServiceName() == ServiceName.POSH)) {
                busServiceIterator.remove();
            }
        }
    }

    private void sortNewTimetable(List<BusService> busServiceList) {
        busServiceList.sort(Comparator.comparing(BusService::getServiceName).thenComparing(BusService::getDepartureTime));
    }

    private int getBusServiceDurationInMinutes(BusService busService) {
        return (int) Duration.between(busService.getArrivalTime(), busService.getDepartureTime()).getSeconds() / 60;
    }

}
