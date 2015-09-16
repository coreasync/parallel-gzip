import java.io.*;
import java.util.zip.GZIPInputStream;

import java.io.*;

public class GZLineCounter{
    public static int run(String filename) throws Exception {
        InputStream fileStream = new FileInputStream(filename);
        InputStream gzipStream = new GZIPInputStream(fileStream);
        Reader decoder = new InputStreamReader(gzipStream, "US-ASCII");
        BufferedReader buffered = new BufferedReader(decoder);
        int counter = 0;
        while (null != buffered.readLine())
            counter++;
        buffered.close();
        return counter;
    }
}
