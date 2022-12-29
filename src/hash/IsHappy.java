package hash;

import java.util.HashSet;
import java.util.Set;

//202. 快乐数
//https://leetcode.cn/problems/happy-number/
//set作为哈希表
public class IsHappy {

    //方法一:使用哈希表
    public boolean isHappy(int n) {
        //创建哈希表
        Set<Integer> map = new HashSet<>();

        //当n不是1，且哈希表里没有开始无限循环时，
        while (n != 1 && !map.contains(n)) {
            map.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    //方法二:使用快慢指针(弗洛伊德循环查找算法),查找是否有无限循环，即是否有环
    public boolean fastAndSlow(int n) {
        //初始化快慢指针
        int slow = getSum(n);
        int fast = getSum(getSum(n));

        //当fast快指针不是1，且快慢指针不相等，
        while (fast != 1 && fast != slow) {
            //慢指针一次一步
            slow = getSum(slow);

            //快指针一次两步
            fast = getSum(getSum(fast));
        }
        return fast == 1;
    }


    //获取这个数所有数位的和
    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            //取个位上的数字
            int temp = n % 10;
            //求这个位的平方加到sum
            sum += temp * temp;
            //这个数除以10，使用/自动取整，当这个数为个位数时，/10就会为0，结束循环
            n /= 10;
        }
        return sum;
    }


}
