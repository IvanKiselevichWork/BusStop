package by.kiselevich.busstop.service;

import by.kiselevich.busstop.domain.BusService;
import by.kiselevich.busstop.domain.ServiceName;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class BusServiceFileWriterTest {

    private static final String TEST_FILENAME = "TEST_FILE.txt";
    private static final String EMPTY_STRING = "";

    private final BusServiceFileWriter busServiceFileWriter = new BusServiceFileWriter();

    @Before
    public void init() throws IOException {
        Files.write(Path.of(TEST_FILENAME), EMPTY_STRING.getBytes());
    }

    @After
    public void deInit() throws IOException {
        Files.delete(Path.of(TEST_FILENAME));
    }

    @Test
    public void test1() throws IOException {
        busServiceFileWriter.writeToFile(TEST_FILENAME,
                List.of(
                        new BusService(ServiceName.POSH, LocalTime.of(10, 10), LocalTime.of(11, 0)),
                        new BusService(ServiceName.GROTTY, LocalTime.of(10, 10), LocalTime.of(11, 0)))
        );
        List<String> expectedData = List.of(
                "Posh 10:10 11:00",
                "",
                "Grotty 10:10 11:00"
        );
        List<String> actualData = Files.readAllLines(Path.of(TEST_FILENAME));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void test2() throws IOException {
        busServiceFileWriter.writeToFile(TEST_FILENAME,
                List.of(
                        new BusService(ServiceName.POSH, LocalTime.of(10, 10), LocalTime.of(11, 0)),
                        new BusService(ServiceName.GROTTY, LocalTime.of(10, 10), LocalTime.of(11, 0)))
        );
        List<String> expectedData = List.of(
                "Posh 10:10 11:00",
                "",
                "Grotty 10:10 11:01"
        );
        List<String> actualData = Files.readAllLines(Path.of(TEST_FILENAME));
        Assert.assertFalse(Arrays.equals(expectedData.toArray(), actualData.toArray()));
    }

    @Test
    public void test3() throws IOException {
        busServiceFileWriter.writeToFile(TEST_FILENAME,
                List.of(
                        new BusService(ServiceName.POSH, LocalTime.of(10, 10), LocalTime.of(11, 0)),
                        new BusService(ServiceName.POSH, LocalTime.of(10, 10), LocalTime.of(11, 1)))
        );
        List<String> expectedData = List.of(
                "Posh 10:10 11:00",
                "Posh 10:10 11:01"
        );
        List<String> actualData = Files.readAllLines(Path.of(TEST_FILENAME));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void test4() throws IOException {
        busServiceFileWriter.writeToFile(TEST_FILENAME,
                List.of(
                        new BusService(ServiceName.POSH, LocalTime.of(10, 10), LocalTime.of(11, 0)))
        );
        List<String> expectedData = List.of(
                "Posh 10:10 11:00"
        );
        List<String> actualData = Files.readAllLines(Path.of(TEST_FILENAME));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void test5() throws IOException {
        busServiceFileWriter.writeToFile(TEST_FILENAME,
                List.of(
                        new BusService(ServiceName.GROTTY, LocalTime.of(10, 10), LocalTime.of(11, 0)))
                );
        List<String> expectedData = List.of(
                "Grotty 10:10 11:00"
        );
        List<String> actualData = Files.readAllLines(Path.of(TEST_FILENAME));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void test6() throws IOException {
        busServiceFileWriter.writeToFile(TEST_FILENAME,
                List.of(
                        new BusService(ServiceName.GROTTY, LocalTime.of(10, 10), LocalTime.of(11, 0)),
                        new BusService(ServiceName.GROTTY, LocalTime.of(10, 10), LocalTime.of(11, 1)))
        );
        List<String> expectedData = List.of(
                "Grotty 10:10 11:00",
                "Grotty 10:10 11:01"
        );
        List<String> actualData = Files.readAllLines(Path.of(TEST_FILENAME));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void test7() throws IOException {
        busServiceFileWriter.writeToFile(TEST_FILENAME,
                List.of(
                        new BusService(ServiceName.POSH, LocalTime.of(10, 10), LocalTime.of(11, 0)),
                        new BusService(ServiceName.POSH, LocalTime.of(10, 10), LocalTime.of(11, 0)),
                        new BusService(ServiceName.GROTTY, LocalTime.of(10, 10), LocalTime.of(11, 0)),
                        new BusService(ServiceName.GROTTY, LocalTime.of(10, 10), LocalTime.of(11, 0)))
        );
        List<String> expectedData = List.of(
                "Posh 10:10 11:00",
                "Posh 10:10 11:00",
                "",
                "Grotty 10:10 11:01",
                "Grotty 10:10 11:01"
        );
        List<String> actualData = Files.readAllLines(Path.of(TEST_FILENAME));
        Assert.assertFalse(Arrays.equals(expectedData.toArray(), actualData.toArray()));
    }
}
