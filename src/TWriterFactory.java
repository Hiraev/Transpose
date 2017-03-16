import java.io.File;

public class TWriterFactory {

    private static TWriter instance;

    public static TWriter getInstance(final File file) {
        if (instance == null) {
            if (file == null) instance = new TCommandLineWriter();
            else instance = new TFileWriter(file);
            return instance;
        }
        return instance;
    }
}
