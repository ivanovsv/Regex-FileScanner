package logic;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Application that scans files for HTTP response codes and counts them.
 *
 * Created by IvanovsV on 02/07/2015.
 */
public class AppFileScanner {
    public static void main(String[] args) {
        Container container = new Container();
        File[] files = container.getFiles();
        Pattern[] patterns = container.getPatterns();
        FileScanner fs = new FileScanner();

        for (File f : files){
            try {
                fs.scanSingleFile(f, patterns);
            } catch (IOException e) {
                System.out.println("Problems with a file. Please check.");
                e.printStackTrace();
            }
        }
        fs.printResults();
    }
}
