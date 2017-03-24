import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Tests {
    /**
     *  Метод для проверки содержимого файла
     * */
    private void assertFileContent(File file, String expectedContent) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String content = bufferedReader.lines().collect(Collectors.joining("\n"));
        assertEquals(expectedContent, content);
    }

    File input1 = new File("input/input1.txt");
    File input2 = new File("input/input2.txt");
    File input3 = new File("input/input3.txt");
    File input4 = new File("input/input4.txt");
    File output1 = new File("output/output1.txt");
    TReader reader1 = TReaderFactory.getInstance(input1);
    TReader reader2 = TReaderFactory.getInstance(input2);
    TReader reader3 = TReaderFactory.getInstance(input3);
    TReader reader4 = TReaderFactory.getInstance(input4);

    @Before
    public void setUp() throws IOException{
        this.reader1.read();
        this.reader2.read();
        this.reader3.read();
        this.reader4.read();
    }

    /**
     *  Тест проверяет методы-фабрики TReaderFactory
     *  и TWriterFactory. Первый и второй возвращают
     *  реализации работающие с командной строкой, в случае
     *  если они получают в качестве аргумента null. В случае,
     *  если они получают объект File, то возращают
     *  реализации, работающие с файлами.
     *  @see TReaderFactory
     *  @see TWriterFactory
     */
    @Test
    public void checkFactoryMethods() {
        TReader reader = TReaderFactory.getInstance(null);
        TWriter writer = TWriterFactory.getInstance(null);
        assertTrue(reader instanceof TCommandLineReader);
        assertTrue(writer instanceof TCommandLineWriter);
        TReader reader1 = TReaderFactory.getInstance(input1);
        TWriter writer1 = TWriterFactory.getInstance(output1);
        assertTrue(reader1 instanceof TFileReader);
        assertTrue(writer1 instanceof TFileWriter);
    }

    /**
     *  Тест сравнивает полученные тексты из файлов,
     *  лежащих в директории input. Затем сравнивает
     *  с массивами строк, лежащими в классе Texts.
     *  @see Texts
     *  @see TReader
     *  @see TFileReader
     */
    @Test
    public void checkTFileReader(){
        assertEquals(Texts.inputText1, reader1.getLines());
        assertEquals(Texts.inputText2, reader2.getLines());
        assertEquals(Texts.inputText3, reader3.getLines());
        assertEquals(Texts.inputText4, reader4.getLines());
    }

    /**
     *  Тест проверяет метод transpose из класса
     *  Transpose. В классе Texts лежат строки - эталоны.
     *  Метод вызывает transpose с разными параметрами.
     *  1 вызов - обрезать: да, выравнивать по правому краю: да
     *  2 вызов - обрезать: да, выравнивать по правому краю: нет
     *  3 вызов - обрезать: нет, выравнивать по правому краю: да
     *  4 вызов - обрезать: нет, выравнивать по правому краю: нет
     *  @see Texts
     *  @see Transpose
     */
    @Test
    public void checkTransposeWithTFileReader(){
        String[] stringsRightWithTrim = Transpose.transpose(reader1.getLines(), 5, true, true);
        for (int i = 0; i < stringsRightWithTrim.length; i++) {
            assertEquals(Texts.textRightWithTrim[i], stringsRightWithTrim[i]);
        }
        String[] stringsLeftWithTrim = Transpose.transpose(reader1.getLines(), 5, true, false);
        for (int i = 0; i < stringsLeftWithTrim.length; i++) {
            assertEquals(Texts.textLeftWithTrim[i], stringsLeftWithTrim[i]);
        }
        String[] stringsRightWithoutTrim = Transpose.transpose(reader1.getLines(), 5, false, true);
        for (int i = 0; i < stringsLeftWithTrim.length; i++) {
            assertEquals(Texts.textRightWithoutTrim[i], stringsRightWithoutTrim[i]);
        }
        String[] stringsLeftWithoutTrim = Transpose.transpose(reader1.getLines(), 5, false, false);
        for (int i = 0; i < stringsLeftWithTrim.length; i++) {
            assertEquals(Texts.textLeftWithoutTrim[i], stringsLeftWithoutTrim[i]);
        }
    }

    /**
     *  Следующие два теста проверяют правильность работы
     *  проверки, которая определяет был ли вызван метод read,
     *  перед вызовом метода getLines. Если нет, то выбрасывается
     *  исключение.
     *  @see TReaderFactory
     */
    @Test(expected = UnsupportedOperationException.class)
    public void checkReadUnsupportedExceptionInTCommandLineReader() {
        TReader reader = TReaderFactory.getInstance(null);
        reader.getLines();
    }
    @Test(expected = UnsupportedOperationException.class)
    public void checkReadUnsupportedExceptionInTFileReader() {
        TReader reader = TReaderFactory.getInstance(input1);
        reader.getLines();
    }

    /**
     *  Проверяем записанные файлы после транспонирования
     *  +-----------------------------------------------+
     *  # метода |  input file  | length | trim | right |
     *  +-----------------------------------------------+
     *  |   1    | input/input1 |   4    |  no  |  yes  |
     *  |   2    | input/input2 |   2    |  no  |  no   |
     *  |   3    | input/input3 |   3    |  yes |  yes  |
     *  |   4    | input/input4 |   6    |  yes |  no   |
     *  +-----------------------------------------------+
     */
    @Test
    public void checkOutputFile1() throws Exception {
        File output = new File("output/outputTest1.txt");
        String[] transposeText = Transpose.transpose(reader1.getLines(), 4, false, true);
        TWriter writer = TWriterFactory.getInstance(output);
        writer.write(transposeText);
        assertFileContent(output, Texts.textOutput1);
    }

    @Test
    public void checkOutputFile2() throws Exception {
        File output = new File("output/outputTest2.txt");
        String[] transposeText = Transpose.transpose(reader2.getLines(), 2, false, false);
        TWriter writer = TWriterFactory.getInstance(output);
        writer.write(transposeText);
        assertFileContent(output, Texts.textOutput2);
    }

    @Test
    public void checkOutputFile3() throws Exception {
        File output = new File("output/outputTest3.txt");
        String[] transposeText = Transpose.transpose(reader3.getLines(), 3, true, true);
        TWriter writer = TWriterFactory.getInstance(output);
        writer.write(transposeText);
        assertFileContent(output, Texts.textOutput3);
    }

    @Test
    public void checkOutputFile4() throws Exception {
        File output = new File("output/outputTest4.txt");
        String[] transposeText = Transpose.transpose(reader4.getLines(), 6, true, false);
        TWriter writer = TWriterFactory.getInstance(output);
        writer.write(transposeText);
        assertFileContent(output, Texts.textOutput4);
    }
}