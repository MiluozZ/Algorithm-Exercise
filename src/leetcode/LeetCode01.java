package leetcode;

/**
 * @className: LeetCode2
 * @description:
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 输入：x = -123
 * 输出：-321
 *
 * 输入：x = 120
 * 输出：21
 * @author: Miluo
 **/
public class LeetCode01 {
    public static void main(String[] args) {
        int x = 1563847412;
        System.out.println( reverse(x));
    }
    public static int reverse(int x) {
        if(x == 0){
            return 0;
        }
        String s = Integer.toString(x);
        int[] arr ;

        if (x < 0){
            arr = new int[s.length()-1];
            for (int i = 1; i < s.length() ; i++) {

                String s1 = String.valueOf(s.charAt(i));
                arr[i-1] = Integer.parseInt(s1);
            }
        }else {
            arr = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                String s1 = String.valueOf(s.charAt(i));
                arr[i] = Integer.parseInt(s1);
            }
        }

        for (int i = 0; i < (arr.length / 2); i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        String s1 = "";
        for (int i = 0; i < arr.length; i++) {
            int k = arr[i];
            s1 = s1.concat(String.valueOf(k));
        }
        long l = Long.parseLong(s1);
        if (l <= -Math.pow(2,31) ||  l>=Math.pow(2,31)){
            return 0;
        }else{
            int num = (int) l;
            if (x > 0){
                return num;
            }else {
                return -num;
            }
        }

    }
}
