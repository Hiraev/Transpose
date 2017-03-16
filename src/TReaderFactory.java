import java.io.File;

public final class TReaderFactory {
    private static TReader instance;

    public static TReader getInstance(final File file) {
        if (instance == null) {
            if (file == null) instance = new TCommandLineReader();
            else instance = new TFileReader(file);
            return instance;
        }
        return instance;
    }
}
