import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;

/**
 *  Данный интерфейс представляет собой "читатель".
 *  Он читает данные и его реализации должны иметь поле,
 *  в котором эти данные будут храниться.
 *  Метод read читает данные. Для него предусмотрено исключение
 *  IOException, так как подразумевается, что данный интерфес будет
 *  реализован классами, которые работают с I/O.
 *  Метод getLines возвращает прочитанные дынные. Для метода
 *  предусмотрено исключение UnsupportedOperationException,
 *  которое должно выбрасываться при попытке получения данных до
 *  их прочтения.
 *
 *  На данный момент существует две реализации:
 *  @see TFileReader
 *  @see TCommandLineReader
 */
public interface TReader {
    void read() throws IOException;

    @Nonnull
    List<String> getLines() throws UnsupportedOperationException;
}