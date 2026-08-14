class Solution {
    public String reverseParentheses(String s) {

        Stack<String> st = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char ch :s.toCharArray()) {

            if (ch=='(') {
               
                st.push(curr.toString());
                curr.setLength(0);

            } 
            
            else if (ch==')') {
               
                curr.reverse();
            curr.insert(0, st.pop());

            } else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}