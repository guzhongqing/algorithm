package test;

import EntityClass.Student;

import java.util.Arrays;

public class ArraysToString {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 5, 4};
        System.out.println(Arrays.toString(arr));

        char[] chars = {'a', 'b', 'c'};
        System.out.println(Arrays.toString(chars));

        String[] strings = {"ab", "ac", "ad"};
        System.out.println(Arrays.toString(strings));

        //对象数组初始化
        Student[] stu = new Student[3];
        for (int i = 0; i < stu.length; i++) {
            stu[i] = new Student();
        }
//        这种方法创建数组里面的对象不行
//        for (Student o : stu
//        ) {
//            o = new Student();
//        }
        stu[0].setInfo("a", 1);
        stu[1].setInfo("c", 3);
        stu[2].setInfo("b", 2);

        //另一种对象数组创建方法，建议使用
        Student[] stu1 = new Student[3];
        stu1[0] = new Student("d", 4);
        stu1[1] = new Student("e", 5);
        stu1[2] = new Student("f", 6);
        //重写自定义类的toString，则会依次显示每个数组每个元素的内容
        System.out.println(Arrays.toString(stu));
        System.out.println(Arrays.toString(stu1));
    }

}
