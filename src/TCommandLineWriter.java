import javax.annotation.Nonnull;
import java.util.Arrays;

public final class TCommandLineWriter implements TWriter {
    @Override
    public void write(@Nonnull String[] lines) {
        System.out.println("" +
                "+------------------------------------------------------------+\n" +
                "|                          РЕЗУЛЬТАТ                         |\n" +
                "+------------------------------------------------------------+"
        );
        Arrays.stream(lines).forEach(System.out::println);
    }
}