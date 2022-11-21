package utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Utils {
    public static String normalizeString(String value) {
        String normalizer = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }
}
