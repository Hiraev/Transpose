import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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