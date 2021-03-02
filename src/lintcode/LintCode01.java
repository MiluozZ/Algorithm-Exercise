package lintcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @className: Algorithm1
 * @description: 在给定的数组中，找到出现次数最多的数字,出现次数相同时，返回数值最小的数字。
 *   样例：
 *      Input:
 *          [1,1,2,3,3,3,4,5]
 *      Output:
 *          3
 * @author: Miluo
 * @date: 2021/2/7
 **/
public class LintCode01 {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,1,2,3,3,3,4,5};
        int[] arr = new int[]{5,5,5,1,1,2,3,3,3,4};
        System.out.println(findNumber(arr));
    }


    public static int findNumber(int[] array) {
        if (array.length == 1){
            return array[0];
        }

        //将值作为key，值的数量作为value存入map中
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : array) {
            if (hashMap.containsKey(i)){
                Integer count = hashMap.get(i);
                hashMap.put(i,count+1);
            }else{
                hashMap.put(i,1);
            }
        }

        //找到出现值数量的最大值
        Integer max = hashMap.entrySet().stream().map(entry -> entry.getValue()).max(Comparator.comparing(x -> x)).get();
        //在map中找出值数量最大值的数值存入list当中
        LinkedList<Integer> list = new LinkedList<>();
        hashMap.forEach((key,value) -> {
            if (value.equals(max)){
                list.add(key);
            }
        });

        if (list.size() == 1){
            //最多数量只有一个
            return list.get(0);
        }else {
            //最多数量有多个，找出数值最小的那个
            return list.stream().min(Integer::compareTo).get();
        }

    }
}
