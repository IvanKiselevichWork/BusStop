package by.kiselevich.busstop.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class BusService {
    private final ServiceName serviceName;
    private final LocalTime departureTime;
    private final LocalTime arrivalTime;
}
