import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    String[] inputs = {"(()", ")()())", ")(()())", ")("};

    for (String input : inputs) {
      int maxLength = 0;
      String validParentheses = "";

      Stack<Integer> stack = new Stack<>();
      stack.push(-1);

      for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c == '(') {
          stack.push(i);
        } else {
          stack.pop();
          if (!stack.isEmpty()) {
            int currentLength = i - stack.peek();
            if (currentLength > maxLength) {
              maxLength = currentLength;
              validParentheses = input.substring(stack.peek() + 1, i + 1);
            }
          } else {
            stack.push(i);
          }
        }
      }

      if (maxLength == 0) {
        System.out.println("0");
      } else {
        System.out.println(maxLength + " - " + validParentheses);
      }
    }
  }
}