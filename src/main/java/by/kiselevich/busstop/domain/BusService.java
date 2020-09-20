package by.kiselevich.busstop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class BusService {
    private final ServiceName serviceName;
    private final LocalTime departureTime;
    private final LocalTime arrivalTime;
}
