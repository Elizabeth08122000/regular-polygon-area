import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class RegularPolygonTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Test
    void testMain1() {
        double expected = 72.69017017488385;
        String input = "5\n6,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RegularPolygon.main(null);
        double actual = Double.parseDouble(outContent.toString());
        assertEquals(expected, actual);
    }

    @Test
    void testMain2() {
        String expected = "NO";
        String input = "2\n6,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RegularPolygon.main(null);
        String actual = outContent.toString().replaceAll("(\\r|\\n)", "");
        assertEquals(expected, actual);
    }

    @Test
    void testMain3() {
        String expected = "NO";
        String input = "5\n-2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RegularPolygon.main(null);
        String actual = outContent.toString().replaceAll("(\\r|\\n)", "");
        assertEquals(expected, actual);
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

}