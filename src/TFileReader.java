import javax.annotation.Nonnull;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class TFileReader implements TReader {
    private final File file;
    private final List<String> lines;
    private boolean isRead;

    TFileReader(@Nonnull final File file) {
        lines = new ArrayList<>();
        isRead = false;
        this.file = file;
    }

    @Override
    public void read() throws IOException {
        if (!isRead) { //Избегаем повторного чтение
            final BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.lines().filter(s -> !s.isEmpty()).forEachOrdered(lines::add);
            isRead = true;
        }
    }

    @Override
    @Nonnull
    public List<String> getLines() throws UnsupportedOperationException {
        if (!isRead) throw new UnsupportedOperationException("Не обнаружен вызов метода read");
        return lines;
    }
}