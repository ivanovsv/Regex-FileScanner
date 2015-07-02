package logic;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains methods for scanning files for matches.
 *
 * Created by IvanovsV on 01/07/2015.
 */
public class FileScanner {

    private int status1XXcount = 0;
    private int status2XXcount = 0;
    private int status3XXcount = 0;
    private int status4XXcount = 0;
    private int status5XXcount = 0;

    /**
     * Scans each line of a document for pattern matches and counts them.
     *
     * @param file file to be scanned
     * @param patterns An array of patterns used during the scanning
     * @throws IOException
     */
    public void scanSingleFile(File file, Pattern[] patterns) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line; //line of document to be scanned
        Pattern pattern; //pattern used to scan line of document

        while ((line = reader.readLine()) != null){
            for (int count = 0; count < patterns.length; count ++) {
                pattern = patterns[count];
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    if (count == 0) status1XXcount++;
                    if (count == 1) status2XXcount++;
                    if (count == 2) status3XXcount++;
                    if (count == 3) status4XXcount++;
                    if (count == 4) status5XXcount++;
                }
            }
        }
    }

    /**
     * Prints the results. When app is started from bash output can
     * be piped into text file.
     */
    public void printResults(){
        System.out.println("100: " + status1XXcount);
        System.out.println("200: " + status2XXcount);
        System.out.println("300: " + status3XXcount);
        System.out.println("400: " + status4XXcount);
        System.out.println("500: " + status5XXcount);
    }

    //Helper getters for testNG

    public int getStatus1XXcount() {
        return status1XXcount;
    }

    public int getStatus2XXcount() {
        return status2XXcount;
    }

    public int getStatus3XXcount() {
        return status3XXcount;
    }

    public int getStatus4XXcount() {
        return status4XXcount;
    }

    public int getStatus5XXcount() {
        return status5XXcount;
    }
}
