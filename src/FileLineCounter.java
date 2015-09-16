import java.io.*;

public class FileLineCounter{
	public static int run(String filename) throws Exception {
            InputStream fileStream = new FileInputStream(filename);
            Reader decoder = new InputStreamReader(fileStream, "US-ASCII");
            BufferedReader buffered = new BufferedReader(decoder);
            int counter = 0;
            while (null != buffered.readLine())
                counter++;
            buffered.close();
            return counter;
	}
}
