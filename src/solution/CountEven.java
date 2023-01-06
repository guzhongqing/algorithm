package solution;

public class CountEven {

    public int countEven(int num) {

        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            int number = i, sum = 0;
            while (number > 0) {
                int temp = number % 10;
                sum += temp;
                number /= 10;
            }
            if (sum % 2 == 0) cnt++;
        }
        return cnt;
    }


}
