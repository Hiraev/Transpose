import java.io.*;
import java.util.ArrayList;

public final class TFileReader implements TReader {
    private final File file;
    private ArrayList<String> lines;

    TFileReader(final String fileName) throws FileNotFoundException {
        lines = new ArrayList<>();
        final File file = new File(fileName);
        if (!file.isFile()) throw new FileNotFoundException("Файл с таким именем не обнаружен!");
        this.file = file;
        this.read();
    }

    private void read() {
        final BufferedReader reader;
        String str;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((str = reader.readLine()) != null) {
                if (!str.isEmpty()) lines.add(str);
            }
        } catch (IOException e) {
        }
    }

    @Override
    public ArrayList<String> getLines() {
        return lines;
    }
}
