import java.io.File;

/**
 *  Класс с единственным методом-фабрикой.
 *  Метод getInstance получает File, если файл не null, /
 *  то возращается TFileWriter с переданным в констуктор
 *  файлом. Если File является null, то возвращается
 *  TCommandLineWriter
 *
 *  @see TWriter
 *  @see TFileWriter
 *  @see TCommandLineWriter
 */

public final class TWriterFactory {
    public static TWriter getInstance(final File file) {
        TWriter instance;
        if (file == null) instance = new TCommandLineWriter();
        else instance = new TFileWriter(file);
        return instance;
    }
}
