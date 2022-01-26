import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void checkGetLinks() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-page.html");
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
}