class Solution {
    public boolean isValid(String s) {
        
        Deque<Character> stck = new ArrayDeque<>();
        for (int i=0;i<s.length();i++){
            char e= s.charAt(i);
            if(e == '(' || e == '{' || e == '[')
            {
                stck.push(s.charAt(i));
            }else{
                 if (stck.isEmpty()) return false;
                char c = stck.pop();
                if(e == ')' && c== '('){
                    continue;
                }
                 else if(e == '}' && c== '{'){
                    continue;
                }
                 else if(e == ']' && c== '['){
                    continue;
                }else{
                    return false;
                }
            }
        }
        return stck.isEmpty();
     }
}
