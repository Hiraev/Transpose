import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class TFileWriter implements TWriter {
    private final File file;
    private final static File dir;

    static {
        dir = new File("output");
        dir.mkdir();
    }

    TFileWriter(String fileName) {
        file = new File("output/" + fileName);
    }

    @Override //Может быть FileNotFoundException (No such file or directory)
    public void write(String[] lines) throws IOException {
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        int i = 0;
        for (String line : lines) {
            bufferedWriter.write(line);
            i++;
            if (i < lines.length) bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}