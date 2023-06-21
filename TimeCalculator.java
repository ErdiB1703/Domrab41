import java.util.HashMap;
import java.util.Map;

public class TimeCalculator {
    public static void main(String[] args) {
        int seconds = 3662; // Входное значение секунд

        int[] timeUnits = { 365 * 24 * 60 * 60, 30 * 24 * 60 * 60, 7 * 24 * 60 * 60, 24 * 60 * 60, 60 * 60, 60 };
        String[] timeFormats = { "год", "месяц", "неделю", "день", "час", "минуту", "секунду" };

        Map<String, Integer> timeValues = new HashMap<>();

// Вычисление значений для каждого формата времени
        for (int i = 0; i < timeUnits.length; i++) {
            int value = seconds / timeUnits[i];
            if (value > 0) {
                timeValues.put(timeFormats[i], value);
                seconds %= timeUnits[i];
            }
        }

// Создание строки с результатом
        StringBuilder result = new StringBuilder();
        int formatCount = 0;

        for (String format : timeFormats) {
            if (timeValues.containsKey(format)) {
                int value = timeValues.get(format);
                if (formatCount > 0 && formatCount == timeValues.size() - 1) {
                    result.append(" и ");
                } else if (formatCount > 0) {
                    result.append(", ");
                }

                if (format.equals("месяц") || format.equals("секунду")) {
                    if (value > 1) {
                        format += "а";
                    }
                } else {
                    if (value > 1) {
                        format += "ов";
                    }
                }

                result.append(value).append(" ").append(format);
                formatCount++;
            }
        }

        System.out.println(result.toString()); // Вывод результата
    }
}