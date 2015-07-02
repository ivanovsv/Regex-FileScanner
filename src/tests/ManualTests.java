package tests;

import logic.Container;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Manual test for methods in Container class.
 *
 * Created by IvanovsV on 02/07/2015.
 */
public class ManualTests {
    public static void main(String[] args) throws IOException {
        Container c = new Container();

        File[] files = c.getFiles();
        for (File f : files) {
            System.out.println();
        }

        Pattern[] patterns = c.getPatterns();
        for (Pattern p : patterns) {
            System.out.println(p);
        }
    }
}
