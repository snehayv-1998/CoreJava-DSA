package Strings;

import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("ValidParentheses:"+isValid("{{{()}}}]"));
    }
    static boolean isValid(String t) {
        if(t.length()==0)return false;
        Stack<Character> s = new Stack<>();
        for(char c: t.toCharArray()){

            if(c =='('||c=='{'||c=='['){
                s.push(c);
            }
            if(s.isEmpty()) return false;
            else if(c ==')'){
                if(s.peek() !='(') return false;
                s.pop();
            }
            else if(c =='}'){
                if(s.peek() !='{') return false;
                s.pop();
            }
            else if(c ==']'){
                if(s.peek() !='[') return false;
                s.pop();
            }
        }
        return s.isEmpty();
    }
}
