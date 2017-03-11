import java.io.FileNotFoundException;

public final class TReaderFactory {
    private static TReader instance;

    public static TReader getInstance(String fileName) throws FileNotFoundException{
        if (instance == null) {
            if (fileName == null) instance = new TCommandLineReader();
            else instance = new TFileReader(fileName);
            return instance;
        }
        return instance;
    }
}
