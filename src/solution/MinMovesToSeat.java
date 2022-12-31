package solution;

import java.util.Arrays;

//2037. 使每位学生都有座位的最少移动次数
//https://leetcode.cn/problems/minimum-number-of-moves-to-seat-everyone/
//
public class MinMovesToSeat {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}
