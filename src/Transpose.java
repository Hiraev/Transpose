import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *  Транспонирование
 *  Класс имеющий один единственный статический
 *  метод - transpose.
 *  Данный класс имеет закрытый конструктор, так
 *  как нет смысла создавать его объекты.
 *
 *  Алгоритм работы метода transpose:
 *  Метод получает массив строк, максимальную
 *  длину слова и указания: обрезать или нет,
 *  выравнивать справа или слева.
 *
 *  Для транспонирования используется отображение TreeMap,
 *  так как нам важен порядок.
 *  Каждую ячейку можно представить как один столбец.
 *  Метод берет одну строку, разбивает ее на слова по пробелам,
 *  затем фильтрует полученный список, так как там могут
 *  оказаться пустые строки. Далее с помощью метода map идет
 *  обрезка строк, если их длина превышает допустимое значение
 *  и флаг trim имеет значение true. После этого идет идет
 *  добавление пробелов слева или справа (в зависимости от right),
 *  если слово оказалось короче length. Затем слова добавляются
 *  в отображение с ключами от 0 до кол-ва строк - 1. Для
 *  удобства обращения с ключами используется AtomicInteger.
 *  Первое словоладется в отображение с ключем 0. Далее, второе
 *  слово кладется в отобраение с ключем 1 и так далее.
 *  Когда строка заканчивается, AtomicInteger обнуляется и процесс
 *  добавления слов продолжается со следующей строкой.
 *  В итоге получается что каждое первое слово из списка, попадает
 *  в ячейку с ключем 0, каждое второе - в ячейку с ключем 1 и т.д.
 *  Таким образом получается транспонированный текст.
 */

public final class Transpose {
    private Transpose() {
    }

    public static String[] transpose(@Nonnull final List<String> lines,
                                     final int length,
                                     final boolean trim,
                                     final boolean right) {
        Map<Integer, String> map = new TreeMap<>();
        AtomicInteger i = new AtomicInteger(0);
        final String isRight = right ? "" : "-";

        lines.stream().map(e -> (Arrays.stream(e.split(" ")))
                .map(s -> s.replace("\u0009", ""))
                .filter(s -> !s.isEmpty())
                .map(s -> (trim & s.length() > length) ? s.substring(0, length) : s)
                .map(s -> (s.length() < length) ? String.format("%" + isRight + length + "s", s) : s)
                .peek(s -> {
                    i.getAndIncrement();
                    if (!map.containsKey(i.get())) map.put(i.get(), "");
                    //Если добавляемая нами строка первая, то не ставим перед ней пробел, иначе ставим
                    map.put(i.get(), map.get(i.get()) + ((map.get(i.get()).isEmpty()) ? s : " " + s));
                })
                .collect(Collectors.joining())
        ).forEach(s -> i.set(0));

        return map.values().toArray(new String[map.size()]);
    }
}