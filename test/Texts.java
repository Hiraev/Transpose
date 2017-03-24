import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Texts {

    final static List<String> inputText1 = Arrays.asList(
            "Духовной   жаждою  томим,",
            "В   пустыне   мрачной   я   влачился,",
            "И   шестикрылый   серафим",
            "На   перепутье   мне   явился."
    );

    final static List<String> inputText2 = Collections.singletonList("Четыре слова и одна строчка");

    final static List<String> inputText3 = Arrays.asList(
            "Четыре",
            "слова",
            "и",
            "один",
            "столбец"
    );

    final static List<String> inputText4 = Arrays.asList(
            "и\u20BD™°~љ°®ћ†÷ ўѕ°њ©†#$%^&*\u20BDѕў™ ѓњ†µ^&©*\u20BDѕ&^",
            "&^%$#џ$ћ%^&\u20BDѓ\u20BD *&^%®$#ћќ®†њ*{ѓ {{}љ‘ў~љ°°\u20BDµ≠≈џ#$%^ –}∆{*\u20BDњ",
            "}{*ѓ&њ^†%$#ќ$^÷&©\u20BD –}{ѕ*&^†%®$ќ#ћ÷®µ†ѓњ",
            "{*&њ^†%®^&*  {*&†^%®$%^&*{   }{*ѓ&њ†^%®$ќ#ћ%^&",
            "}–ў{*&њ^%$ќџ#$%^&  }{}*&^†%®$ы$ћ%^&"
    );

    final static String[] textRightWithTrim = {
            "Духов     В     И    На",
            "жаждо пусты шести переп",
            "томим мрачн сераф   мне",
            "    я явилс",
            "влачи"
    };
    final static String[] textLeftWithTrim = {
            "Духов В     И     На   ",
            "жаждо пусты шести переп",
            "томим мрачн сераф мне  ",
            "я     явилс",
            "влачи"
    };

    final static String[] textRightWithoutTrim = {
            "Духовной     В     И    На",
            "жаждою пустыне шестикрылый перепутье",
            "томим, мрачной серафим   мне",
            "    я явился.",
            "влачился,"
    };

    final static String[] textLeftWithoutTrim = {
            "Духовной В     И     На   ",
            "жаждою пустыне шестикрылый перепутье",
            "томим, мрачной серафим мне  ",
            "я     явился.",
            "влачился,"
    };

    final static String textOutput1 = "Духовной    В    И   На\n" +
            "жаждою пустыне шестикрылый перепутье\n" +
            "томим, мрачной серафим  мне\n" +
            "   я явился.\n" +
            "влачился,";

    final static String textOutput2 = "Четыре\n" +
            "слова\n" +
            "и \n" +
            "одна\n" +
            "строчка";

    final static String textOutput3 = "Чет сло   и оди сто";

    final static String textOutput4 = "и\u20BD™°~љ &^%$#џ }{*ѓ&њ {*&њ^† }–ў{*&\n" +
            "ўѕ°њ©† *&^%®$ –}{ѕ*& {*&†^% }{}*&^\n" +
            "ѓњ†µ^& {{}љ‘ў }{*ѓ&њ\n" +
            "–}∆{*\u20BD";
}