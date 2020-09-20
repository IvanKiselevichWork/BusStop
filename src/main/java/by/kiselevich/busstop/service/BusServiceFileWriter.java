package by.kiselevich.busstop.service;

import by.kiselevich.busstop.domain.BusService;
import by.kiselevich.busstop.domain.ServiceName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class BusServiceFileWriter {

    private static final String EMPTY_STRING = "";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public void writeToFile(String filename, List<BusService> busServiceList) throws IOException {
        Files.write(Path.of(filename), EMPTY_STRING.getBytes());
        for (int i = 0; i < busServiceList.size(); i++) {
            if (busServiceList.get(i).getServiceName() == ServiceName.GROTTY && i != 0 && busServiceList.get(i -1).getServiceName() == ServiceName.POSH) {
                Files.write(Path.of(filename), NEW_LINE.getBytes(), StandardOpenOption.APPEND);
            }
            Files.write(Path.of(filename), getBusServiceLine(busServiceList.get(i)).getBytes(), StandardOpenOption.APPEND);
            if (i != busServiceList.size() - 1) {
                Files.write(Path.of(filename), NEW_LINE.getBytes(), StandardOpenOption.APPEND);
            }
        }
    }

    private String getBusServiceLine(BusService busService) {
        return busService.getServiceName() +
                SPACE +
                busService.getDepartureTime() +
                SPACE +
                busService.getArrivalTime();
    }
}
