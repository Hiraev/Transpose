import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  Класс - реализаиция интерфеса TReader.
 *  Считывает текст с консоли.
 *  Перед считыванием печатает информационное сообщение.
 *  Имеет защиту от повторного вызова метода read.
 *  Поле isRead помогает понять был ли уже считан текст.
 *
 *  Строки отделяются друг от друга символом перевода
 *  строки.
 *
 *  При вводе символа переноса строки два раза подряд,
 *  считывание прекращается.
 *
 *  Метод getLines возвращает прочитанные строки.
 *  Если до этого не было считывания, то метод
 *  выбросит исключение.
 *
 *  @see TReader
 */

public final class TCommandLineReader implements TReader {
    private List<String> lines;
    private boolean isRead;

    {
        lines = new ArrayList<>();
    }

    @Override
    public void read() {
        System.out.println(
                "+------------------------------------------------------------+\n" +
                "| Введите строки. После ввода каждой строки нажимайте Enter. |\n" +
                "| Для завершения ввода нажмите Enter два раза подряд.        |\n" +
                "+------------------------------------------------------------+");
        if (!isRead) {
            final Scanner scanner = new Scanner(System.in);
            String str;
            while (!(str = scanner.nextLine()).isEmpty()) {
                lines.add(str);
            }
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
