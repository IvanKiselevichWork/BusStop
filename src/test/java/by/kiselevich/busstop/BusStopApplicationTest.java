package by.kiselevich.busstop;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BusStopApplicationTest {

    @Test
    public void test1() throws IOException, URISyntaxException {
        String fullFilename = Paths.get(getClass().getClassLoader().getResource("test_data1.txt").toURI()).toString();
        BusStopApplication.main(new String[]{fullFilename});
        List<String> expectedData = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("output1.txt").toURI()));
        List<String> actualData = Files.readAllLines(Path.of("output.txt"));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void test2() throws IOException, URISyntaxException {
        String fullFilename = Paths.get(getClass().getClassLoader().getResource("test_data2.txt").toURI()).toString();
        BusStopApplication.main(new String[]{fullFilename});
        List<String> expectedData = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("output2.txt").toURI()));
        List<String> actualData = Files.readAllLines(Path.of("output.txt"));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void test3() throws IOException, URISyntaxException {
        String fullFilename = Paths.get(getClass().getClassLoader().getResource("test_data3.txt").toURI()).toString();
        BusStopApplication.main(new String[]{fullFilename});
        List<String> expectedData = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("output3.txt").toURI()));
        List<String> actualData = Files.readAllLines(Path.of("output.txt"));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void test4() throws IOException, URISyntaxException {
        String fullFilename = Paths.get(getClass().getClassLoader().getResource("test_data4.txt").toURI()).toString();
        BusStopApplication.main(new String[]{fullFilename});
        List<String> expectedData = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("output4.txt").toURI()));
        List<String> actualData = Files.readAllLines(Path.of("output.txt"));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void test5() throws IOException, URISyntaxException {
        String fullFilename = Paths.get(getClass().getClassLoader().getResource("test_data5.txt").toURI()).toString();
        BusStopApplication.main(new String[]{fullFilename});
        List<String> expectedData = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("output5.txt").toURI()));
        List<String> actualData = Files.readAllLines(Path.of("output.txt"));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }

    @Test
    public void test6() throws IOException, URISyntaxException {
        String fullFilename = Paths.get(getClass().getClassLoader().getResource("test_data6.txt").toURI()).toString();
        BusStopApplication.main(new String[]{fullFilename});
        List<String> expectedData = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("output6.txt").toURI()));
        List<String> actualData = Files.readAllLines(Path.of("output.txt"));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }
}
