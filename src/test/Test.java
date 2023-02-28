package test;

import java.util.NavigableSet;
import java.util.TreeSet;

class Test {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 606; i < 613; i++) {
            if (i % 2 == 0) {
                set.add(i);
            }
        }
        //subSet和set指向的是同一块数据
        // subSet(开始元素，是否包含开始元素，结束元素，是否包含结束元素)
        NavigableSet<Integer> subSet = set.subSet(608, true, 611, true);
        System.out.println("原集合" + set + "子集合" + subSet);
        //原集合[606, 608, 610, 612]子集合[608, 610]

        set.add(999);//在[608，611]之间，subSet取不到
        System.out.println("原集合" + set + "子集合" + subSet);
        //原集合[606, 608, 610, 612, 999]子集合[608, 610]

        set.add(609);//在[608，611]之间，subSet会取到
        System.out.println("原集合" + set + "子集合" + subSet);
        //原集合[606, 608, 609, 610, 612, 999]子集合[608, 609, 610]
    }
}

class B {
    public static B t1 = new B();
    public static B t2 = new B();

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        B t = new B();
    }
}

