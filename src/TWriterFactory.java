import java.io.FileNotFoundException;

public class TWriterFactory {

        private static TWriter instance;

        public static TWriter getInstance(String fileName) {
            if (instance == null) {
                if (fileName == null) instance = new TCommandLineWriter();
                else instance = new TFileWriter(fileName);
                return instance;
            }
            return instance;
        }
}
