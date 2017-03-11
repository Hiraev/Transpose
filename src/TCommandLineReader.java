import java.util.ArrayList;
import java.util.Scanner;

public final class TCommandLineReader implements TReader {
    private ArrayList<String> lines;

    TCommandLineReader() {
        lines = new ArrayList<>();
        this.read();
    }
    //Считываем строки из консоли. При печати пустой строки прекращаем считывание.
    private void read() {
        final Scanner scanner = new Scanner(System.in);
        String str;
        while (!(str = scanner.nextLine()).isEmpty()) {
            lines.add(str);
        }
    }

    @Override
    public ArrayList<String> getLines() {
        return lines;
    }
}
