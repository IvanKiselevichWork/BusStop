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
        String fullFilename = getClass().getClassLoader().getResource("test_data1.txt").getFile();
        BusStopApplication.main(new String[]{fullFilename});
        List<String> expectedData = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("output1.txt").toURI()));
        List<String> actualData = Files.readAllLines(Path.of("output.txt"));
        Assert.assertArrayEquals(expectedData.toArray(), actualData.toArray());
    }
}
