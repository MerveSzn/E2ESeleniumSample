package seleniumE2E.Util;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

/**
 * @author merve.sozen
 */
public class ReadFile {


    public Ini fileRead() throws IOException {
        String path="src/test/java/seleniumE2E/Tests/inputs.ini";
        Ini ini = new Ini(new File(path));
        return ini;
    }
}
