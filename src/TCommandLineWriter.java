import javax.annotation.Nonnull;
import java.util.Arrays;

public final class TCommandLineWriter implements TWriter {
    @Override
    public void write(@Nonnull String[] lines) {
        Arrays.stream(lines).forEach(System.out::println);
    }
}