import java.io.IOException;
import java.util.ArrayList;

public interface TReader {
    void read() throws IOException;
    ArrayList<String> getLines();
}