class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new ArrayDeque<>();
        
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = nums.pop();
                int num1 = nums.pop();
                
                switch (token) {
                    case "+": nums.push(num1 + num2); break;
                    case "-": nums.push(num1 - num2); break;
                    case "*": nums.push(num1 * num2); break;
                    case "/": nums.push(num1 / num2); break;
                }
            } else {
                nums.push(Integer.valueOf(token));
            }
        }
        
        return nums.pop();
    }
}