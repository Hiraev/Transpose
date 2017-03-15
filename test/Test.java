@SuppressWarnings("IOException")
public class Test {
    public static void main(String[] args) throws Exception{
        //Вот здесь вот пишем название файла, откуда надо считывать строки
        //Либо передаем null, если хотим считывать строки с консоли
        //При этом ввод завершается, когда пользователь два раза подряд нажал "Ввод"
        TReader reader = TReaderFactory.getInstance("input/input4.txt");
        reader.read();
        //Настройка, длина слова, обрезать или нет, выравнивание справа или слева

        //!!!НАПИСАТЬ ПРОВЕРКУ НА НЕОТРИЦАТЕЛЬНОСТЬ ДЛИНЫ!!!
        String[] a = Transpose2.transpose(reader.getLines(), 5, true, true);
        //Имя выходного файла. Если хотим вывести в консоль, то передае null
        TWriter writer = TWriterFactory.getInstance(null);
        writer.write(a);
    }
}
