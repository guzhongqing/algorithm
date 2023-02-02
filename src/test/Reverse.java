package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Reverse {
    public static void main(String[] args) {

        //StringBuffer类反转,调用对象的reverse()方法
        StringBuffer stringBuffer = new StringBuffer("reffub");
        stringBuffer.append("gnirts");
        System.out.println(stringBuffer.reverse());//返回StringBuffer类
        stringBuffer.delete(0, stringBuffer.length());//清空stringbuffer缓冲区

        //String类反转，先转为StringBuffer类，再调用reverse()
        char[] ch = {'g', 'n', 'i', 'r', 't', 's'};
        String string = new String(ch);
        stringBuffer.append(string);
        string = stringBuffer.reverse().toString();//返回String类
        System.out.println(string);

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //直接反转数组,强烈建议基本数据类型用
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(array));

        //数组反转，先用Arrays.aslist()方法将数组转为List，再用collections.reverse()方法
        String[] strings1 = {"aa", "bb", "cc"};//String数组
        String[] strings2 = {"aa", "bb", "cc"};//String数组
        List stringList1 = Arrays.asList(strings1);//这里共享数组,stringList1不能add
        List stringList2 = new ArrayList(Arrays.asList(strings2));//这里通过new没有共享数组，stringList2可以add
        Collections.reverse(stringList1);
        Collections.reverse(stringList2);//Collections.reverse()返回值void
        System.out.println(Arrays.toString(strings1));//共享数组使string1发生反转
        System.out.println(Arrays.toString(strings2));//没有共享数组，string2不反转

        //注意：基本数据类型不能直接转换,要用Arrays.stream().boxed().collect(Collectors.toList());
        //或者如下方式

        List<Integer> list = new ArrayList<>();
        for (Integer i : array) {//整型数组直接用Integer引用,int也可以
            list.add(i);
        }
        Collections.reverse(list);
        System.out.println(list.toString());//集合自带toString.();
        System.out.println(Arrays.toString(array));


    }
}
