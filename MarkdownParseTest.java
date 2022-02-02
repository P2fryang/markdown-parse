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
    public void checkGetLinks1() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://something.com");
        expected.add("some-page.html");
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void checkGetLinks2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("a.html");
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void checkGetLinks3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void checkGetLinks4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
}
