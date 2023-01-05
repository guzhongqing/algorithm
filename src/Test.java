import java.util.HashSet;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int patternNum = scanner.nextInt();
        int matchNum = scanner.nextInt();

        HashSet<Integer> set = new HashSet<>();


        for (int i = 0; i < patternNum; i++) {
            int number = scanner.nextInt();
            set.add(number);
        }

        for (int i = 0; i < matchNum; i++) {
            int number = scanner.nextInt();
            if (set.contains(number)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


    }
}
