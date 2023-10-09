package range;

import java.util.Random;

public class Range {
    private  int minValue; // Минимальное значение диапазона
    private  int maxValue; // Максимальное значение диапазона

    public Range(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    // Метод для получения произвольного значения из диапазона
    public int getRandomValue() {
        return new Random().nextInt(maxValue - minValue + 1) + minValue;
    }

    // Геттеры для получения минимального и максимального значения
    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}