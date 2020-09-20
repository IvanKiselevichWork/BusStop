package by.kiselevich.busstop.service;

import by.kiselevich.busstop.domain.BusService;
import by.kiselevich.busstop.domain.ServiceName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class BusServiceParser {

    private static final String RAW_DATA_SPLIT_REGEX = " ";
    private static final int SERVICE_NAME_INDEX = 0;
    private static final int DEPARTURE_TIME_INDEX = 1;
    private static final int ARRIVAL_TIME_INDEX = 2;

    public List<BusService> parseInputData(String inputFilename) throws IOException {
        return Files.readAllLines(Path.of(inputFilename)).stream().map(this::parseLine).collect(Collectors.toList());
    }

    public BusService parseLine(String string) {
        String[] strings = string.split(RAW_DATA_SPLIT_REGEX);
        return new BusService(
                ServiceName.valueOf(strings[SERVICE_NAME_INDEX].toUpperCase()),
                LocalTime.parse(strings[DEPARTURE_TIME_INDEX]),
                LocalTime.parse(strings[ARRIVAL_TIME_INDEX]));
    }
}
