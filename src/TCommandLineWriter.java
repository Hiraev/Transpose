import java.util.Arrays;

public final class TCommandLineWriter implements TWriter {
    @Override
    public void write(String[] lines) {
        Arrays.stream(lines).forEach(System.out::println);
    }
}
