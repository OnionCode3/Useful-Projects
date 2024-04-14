package JavaPractice.ProjectsAndMisc;
import java.util.*;

class p1{
    public static void main(String[] args) {
        int[] ra = generateRandomNumbers(0,9,10);
        System.out.println(Arrays.toString(ra));
    }
    public static int[] generateRandomNumbers(int min, int max, int count) {
        // Check if the count of unique numbers required is greater than the range
        if (max - min + 1 < count) {
            throw new IllegalArgumentException("Range is smaller than the required count of unique numbers");
        }

        // Create an array to store numbers within the range
        int[] numbers = new int[max - min + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = min + i;
        }

        // Shuffle the array using Fisher-Yates shuffle algorithm
        Random random = new Random();
        for (int i = numbers.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap numbers[index] and numbers[i]
            int temp = numbers[index];
            numbers[index] = numbers[i];
            numbers[i] = temp;
        }

        // Return the first 'count' elements of the shuffled array
        int[] result = new int[count];
        System.arraycopy(numbers, 0, result, 0, count);
        return result;
    }
}
