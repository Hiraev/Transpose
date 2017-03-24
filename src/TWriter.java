import javax.annotation.Nonnull;
import java.io.IOException;

/**
 *  Данный интерфейс представляет собой "записыватель".
 *  Метод write записывает строки. Для метода предусмотрено
 *  исключение IOException, так как реализация может работать
 *  с I/O, которое бросает подобное исключение.
 *
 *  На данный момент существует две реализации:
 *  @see TFileWriter
 *  @see TCommandLineWriter
 */

public interface TWriter {
    void write(@Nonnull String[] lines) throws IOException;
}