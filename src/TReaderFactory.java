import java.io.File;

public final class TReaderFactory {
    public static TReader getInstance(final File file) {
        TReader instance;
        if (file == null) instance = new TCommandLineReader();
        else instance = new TFileReader(file);
        return instance;
    }
}