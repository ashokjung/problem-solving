package Stack;
import java.util.Stack;
import java.util.HashMap;

public class ValidParentheses {

   
    public boolean isValid(String s){
        
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "({[]})";
        System.out.println("Is valid: " + validParentheses.isValid(s));
    }
}
