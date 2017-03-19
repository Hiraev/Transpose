import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;

public interface TReader {
    void read() throws IOException;

    @Nonnull
    List<String> getLines() throws UnsupportedOperationException;
}