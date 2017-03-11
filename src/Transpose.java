import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Transpose {
    private Transpose() {
    }

    public static String[][] transpose(final ArrayList<String> lines,
                                       final int length,
                                       final boolean trim,
                                       final boolean right) {
        String[][] stringMatrix;
        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        //Если выравнивание справа, то ставим минус, он добавится в формат строки
        String isRight = right ? "" : "-";
        //Обработка текста и добавление в список
        int maxLineWidth = 0; //Переменный необходимые для определения размера массива
        int maxLineHeight = 0; //Хранят максимальное число строк и максимальное число слов в строках
        for (String line : lines) {
            int currentMaxLineHeight = 0;
            final List<String> list = Arrays.stream(line.split(" "))
                    .filter(e -> !e.equals("") && !e.equals(" "))
                    .collect(Collectors.toList());
            ArrayList<String> currentList = new ArrayList<>();
            for (String word : list) {
                // Если trim = true и слово длиннее ограничения, то мы его обрезаем
                if (trim && word.length() > length || word.length() > length) word = word.substring(0, length);
                // Дополняем строку пробелами
                if (word.length() < length) word = String.format("%" + isRight + length + "s", word);
                currentList.add(word);
                currentMaxLineHeight++;
            }
            if (currentMaxLineHeight > maxLineHeight) maxLineHeight = currentMaxLineHeight;
            matrix.add(currentList);
            maxLineWidth++;
        }
        stringMatrix = new String[maxLineHeight][maxLineWidth];
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