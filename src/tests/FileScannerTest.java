package tests;

import logic.Container;
import logic.FileScanner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.regex.Pattern;

import static org.testng.Assert.*;

/**
 * Tests methods in FileScanner class.
 *
 * Created by IvanovsV on 02/07/2015.
 */
public class FileScannerTest {
    File file = new File("./src/tests/test.xlg");
    Pattern[] patterns;
    FileScanner fs;

    @BeforeClass
    private void setUp(){
        Container c = new Container();
        patterns = c.getPatterns();
        fs = new FileScanner();
    }

    @Test
    public void testScanSingleFile() throws Exception {
        fs.scanSingleFile(file, patterns);
        assertEquals(fs.getStatus1XXcount(),2);
        assertEquals(fs.getStatus2XXcount(),2);
        assertEquals(fs.getStatus3XXcount(),2);
        assertEquals(fs.getStatus4XXcount(),2);
        assertEquals(fs.getStatus5XXcount(),2);
    }
}