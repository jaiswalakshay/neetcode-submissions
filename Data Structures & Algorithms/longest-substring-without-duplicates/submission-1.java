class Solution {
    // public int lengthOfLongestSubstring(String s) {
    //     int maxLen = 0;
    //     for(int i=0;i<s.length();i++){
    //         Set<Character> set = new HashSet<>();
    //         int len = 0;
    //         //int maxLen = 0;
    //         for(int j=i;j<s.length();j++){
    //             if(!set.contains(s.charAt(j))){
    //                 set.add(s.charAt(j));
    //                 len++;
    //                 maxLen = Integer.max(len,maxLen);
    //             }else{
    //                 len=0;
    //                 break;
    //             }
    //         }
    //     }
    //     return maxLen;
    // }

   public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();

        while (r < s.length()) {
            char c = s.charAt(r);

            if (!set.contains(c)) {
                set.add(c);
                maxLen = Math.max(maxLen, r - l + 1);
                r++;
            } else {
                set.remove(s.charAt(l)); // remove left char
                l++;
            }
        }
        return maxLen;
    }
}
