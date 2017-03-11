import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Transpose {
    private Transpose() {
    }

    //    public static String[][] transpose(final String[] lines, final int length, final boolean trim){
//        return transpose(lines, 3, true);
//    }
    public static String[][] transpose(final ArrayList<String> lines, final int length, final boolean trim) {
        String[][] stringMatrix;
        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        //Обработка текста и добавление в список
        int maxLineWidth = 0;
        int maxLineHeight = 0;
        for (String line : lines) {
            int currentMaxLineHeight = 0;
            final List<String> list = Arrays.stream(line.split(" "))
                    .filter(e -> !e.equals("") && !e.equals(" "))
                    .collect(Collectors.toList());
            ArrayList<String> currentList = new ArrayList<>();
            for (String word : list) {
                // Нужно проверить меньше ли длина слова параметра length
                // Нужно посмотреть в каких случаях не нужно обрезать слово
                if (word.length() > length) word = word.substring(0, length);
                currentList.add(word);
                currentMaxLineHeight++;
            }
            if (currentMaxLineHeight > maxLineWidth) maxLineWidth = currentMaxLineHeight;
            matrix.add(currentList);
            maxLineHeight++;
        }
        stringMatrix = new String[maxLineWidth][maxLineHeight];
        int i = 0;
        for (ArrayList<String> outerList : matrix) {
            int j = 0;
            for (String string : outerList) {
                stringMatrix[j][i] = string;
                j++;
            }
            i++;
        }
        return stringMatrix;
    }
}
