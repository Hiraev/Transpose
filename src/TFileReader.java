import javax.annotation.Nonnull;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  Класс - реализация интерфеса TReader.
 *  Читает данные из файла и хранит их в себе.
 *  Данные хранятся в поле lines в виде списка
 *  строк.
 *  Конструктор получает File, и инициализирует
 *  все поля объекта.
 *
 *  Поле isRead необходимо для избежания повторного чтения
 *  одного и того же файла. После вызова метода read
 *  поле isRead становится true и больше не меняется.
 *
 *  Метод getLines возвращает список строк lines.
 *  Если ранее не был вызван метод read, то попытка
 *  вызова getLines приведет к исключению.
 *
 *  @see TReader
 */

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
        if (!isRead) {
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