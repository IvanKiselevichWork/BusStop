package by.kiselevich.busstop.service;

import by.kiselevich.busstop.domain.BusService;
import by.kiselevich.busstop.domain.ServiceName;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class BusStopParserTest {

    private static final String TEST_FILENAME = "TEST_FILE.txt";

    private final BusServiceParser busServiceParser = new BusServiceParser();

    @BeforeClass
    public static void init() throws IOException {
        Files.write(Path.of(TEST_FILENAME), "Posh 10:10 11:00\nGrotty 10:10 11:00".getBytes());
    }

    @AfterClass
    public static void deInit() throws IOException {
        Files.delete(Path.of(TEST_FILENAME));
    }

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

    @Test
    public void test4() throws IOException {
        List<BusService> actualBusServiceList = busServiceParser.parseInputData(TEST_FILENAME);
        List<BusService> expectedBusServiceList = List.of(
                new BusService(ServiceName.POSH, LocalTime.of(10, 10), LocalTime.of(11, 0)),
                new BusService(ServiceName.GROTTY, LocalTime.of(10, 10), LocalTime.of(11, 0)));
        Assert.assertArrayEquals(actualBusServiceList.toArray(), expectedBusServiceList.toArray());
    }

    @Test
    public void test5() throws IOException {
        List<BusService> actualBusServiceList = busServiceParser.parseInputData(TEST_FILENAME);
        List<BusService> expectedBusServiceList = List.of(
                new BusService(ServiceName.POSH, LocalTime.of(10, 10), LocalTime.of(11, 0)),
                new BusService(ServiceName.GROTTY, LocalTime.of(10, 10), LocalTime.of(11, 1)));
        Assert.assertFalse(Arrays.equals(actualBusServiceList.toArray(), expectedBusServiceList.toArray()));
    }

    @Test
    public void test6() {
        Assert.assertThrows(NoSuchFileException.class, () -> busServiceParser.parseInputData(TEST_FILENAME + "123"));
    }
}
