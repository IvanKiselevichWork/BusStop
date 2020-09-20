package by.kiselevich.busstop.service;

import by.kiselevich.busstop.domain.BusService;
import by.kiselevich.busstop.domain.ServiceName;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

public class BusStopParserTest {

    private BusServiceParser busServiceParser = new BusServiceParser();

    @Test
    public void test1() {
        BusService actualBusService = busServiceParser.parseLine("Posh 10:15 11:10");
        BusService expectedBusService = new BusService(ServiceName.POSH, LocalTime.of(10, 15), LocalTime.of(11, 10));
        Assert.assertEquals(actualBusService, expectedBusService);
    }

    @Test
    public void test2() {
        BusService actualBusService = busServiceParser.parseLine("Posh 10:15 11:10");
        BusService expectedBusService = new BusService(ServiceName.POSH, LocalTime.of(10, 15), LocalTime.of(11, 0));
        Assert.assertNotEquals(actualBusService, expectedBusService);
    }

    @Test()
    public void test3() {
        Assert.assertThrows(ArrayIndexOutOfBoundsException.class, () -> busServiceParser.parseLine("Posh 10:15"));
    }
}
