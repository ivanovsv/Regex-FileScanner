package logic;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Contains an array of patterns and an array of files to be scanned
 * for HTTP response codes.
 *
 * Created by IvanovsV on 02/07/2015.
 */
public class Container {
    private String dirToScan = ".";
    private String fileFormat = ".xlg";

    //Patterns of HTTP response codes
    private Pattern[] patterns = {
            Pattern.compile("status=\"1[0-2]++"),
            Pattern.compile("status=\"2[0-2]++"),
            Pattern.compile("status=\"3[0-2]++"),
            Pattern.compile("status=\"4[0-2]++"),
            Pattern.compile("status=\"5[0-2]++"),
    };

    /**
     * Returns an array of patterns generated from regular expressions,
     * which describe HTTP response codes.
     *
     * @return patterns
     */
    public Pattern[] getPatterns(){
        return this.patterns;
    }

    /**
     * Returns an array of files in a given directory dirToScan
     * with a file extension fileFormat.
     *
     * @return files An array of files in a directory (current by default)
     */
    public File[] getFiles() {
        File dir = new File(this.dirToScan);
        File[] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(fileFormat);
            }
        });
        return files;
    }
}
