import javax.annotation.Nonnull;
import java.util.Arrays;

/**
 *  Класс - реализаиция интерфеса TWriter.
 *  Печатает текст в консоль.
 *  Перед самим текстом печатает информационное сообщение.
 *
 *  @see TWriter
 */

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