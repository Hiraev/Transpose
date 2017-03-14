import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class Transpose2 {
    private Transpose2() {
    }

    public static String[] transpose(final List<String> lines,
                                     final int length,
                                     final boolean trim,
                                     final boolean right) {
        Map<Integer, String> map = new TreeMap<>();
        AtomicInteger i = new AtomicInteger(0);
        final String isRight = right ? "" : "-";

        lines.stream().map(e -> (Arrays.stream(e.split(" ")))
                .filter(s -> !s.isEmpty())
                .map(s -> (trim & s.length() > length) ? s.substring(0, length - 1) : s)
                .map(s -> (s.length() < length) ? String.format("%" + isRight + length + "s", s) : s)
                .peek(s -> {
                    i.getAndIncrement();
                    if (!map.containsKey(i.get())) map.put(i.get(), "");
                    map.put(i.get(), map.get(i.get()) + " " + (s));
                })
                .collect(Collectors.joining())
        ).peek(s -> i.set(0))
                .forEach(e -> System.out.print(""));

        return map.values().toArray(new String[map.size()]);
    }
}