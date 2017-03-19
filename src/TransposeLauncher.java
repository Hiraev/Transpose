import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;

public class TransposeLauncher {
    @Option(name = "-a", usage = "Максимальная длина строки", help = true)
    private int length;

    @Option(name = "-t", usage = "Обрезать строки, длинее -а")
    private boolean trim;

    @Option(name = "-r", usage = "Выравнивать по правому краю?")
    private boolean isRight;

    @Option(name = "-o", usage = "Имя выходного файла")
    private String outputFileName;

    @Argument(usage = "Имя входного файла")
    private String inputFileName;

    public TransposeLauncher() {
    }

    public static void main(String[] args) {
        TransposeLauncher transposeLauncher = new TransposeLauncher();
        CmdLineParser parser = new CmdLineParser(transposeLauncher);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            e.printStackTrace();
            return;
        }

        TReader reader = TReaderFactory.getInstance(
                transposeLauncher.inputFileName == null ? null : new File(transposeLauncher.inputFileName));
        TWriter writer = TWriterFactory.getInstance(
                transposeLauncher.outputFileName == null ? null : new File(transposeLauncher.outputFileName));
        try {
            reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] strings = Transpose.transpose(
                reader.getLines(),
                transposeLauncher.length,
                transposeLauncher.trim,
                transposeLauncher.isRight);
        try {
            writer.write(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
