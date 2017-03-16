import javax.annotation.Nonnull;
import java.io.IOException;

public interface TWriter {
    void write(@Nonnull String[] lines) throws IOException;
}