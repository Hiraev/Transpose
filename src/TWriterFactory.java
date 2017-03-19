import java.io.File;

public final class TWriterFactory {
    public static TWriter getInstance(final File file) {
        TWriter instance;
        if (file == null) instance = new TCommandLineWriter();
        else instance = new TFileWriter(file);
        return instance;
    }
}
