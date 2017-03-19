import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class TCommandLineReader implements TReader {
    private List<String> lines;
    private boolean isRead;

    {
        lines = new ArrayList<>();
    }

    //Считываем строки из консоли. При печати пустой строки прекращаем считывание.
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
