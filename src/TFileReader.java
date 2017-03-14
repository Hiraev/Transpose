import java.io.*;
import java.util.ArrayList;

public final class TFileReader implements TReader {
    private final File file;
    private ArrayList<String> lines;

    TFileReader(final String fileName) throws FileNotFoundException {
        lines = new ArrayList<>();
        final File file = new File(fileName);
        //Необходимо исправить
        if (!file.isFile()) throw new FileNotFoundException("Файл с таким именем не обнаружен!");
        this.file = file;
    }

    @Override
    public void read() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.lines().forEachOrdered(lines::add);
    }

    @Override
    public ArrayList<String> getLines() {
        return lines;
    }
}