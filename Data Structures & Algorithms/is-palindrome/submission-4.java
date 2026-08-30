class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            c = Character.toLowerCase(c);

            if((c >= 'a' && c <= 'z') || Character.isDigit(c))
                sb.append(c+"");
        }
        String str = sb.toString();
        for(int i=0, j= str.length()-1 ; i <= j ; i++,j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
