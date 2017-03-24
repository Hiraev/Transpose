import java.io.File;

/**
 *  Класс с единственным методом-фабрикой.
 *  Метод getInstance получает File, если файл не null, /
 *  то возращается TFileReader с переданным в констуктор
 *  файлом. Если File является null, то возвращается
 *  TCommandLineReader
 *
 *  @see TReader
 *  @see TFileReader
 *  @see TCommandLineReader
 */

public final class TReaderFactory {
    public static TReader getInstance(final File file) {
        TReader instance;
        if (file == null) instance = new TCommandLineReader();
        else instance = new TFileReader(file);
        return instance;
    }
}