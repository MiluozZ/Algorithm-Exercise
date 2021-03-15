package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @className: LeetCode04
 * @description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * @author: Miluo
 * @date: 2021/3/14
 **/
public class LeetCode04 {
    public boolean isValid(String s) {
        //奇数为false
        if ((s.length() % 2) != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                if (stack.isEmpty()){
                    return false;
                }

                if (map.get(s.charAt(i)) == stack.peek()){
                    stack.pop();
                }else {
                    return false;
                };
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
