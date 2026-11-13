class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i=0;
        int j=0;
        int max_length = 0;
        int max_freq = 0;

        for (j =0 ;j <s.length() ; j++){
            char c = s.charAt(j);
            int c_index = c - 'A';

            freq[c_index]++;
            int charCount = freq[c_index];
            max_freq = Math.max(charCount, max_freq);

            while(j-i-max_freq+1 > k){
                char c1 = s.charAt(i);
                freq[c1-'A']--;
                i++;                
            }
            if(j-i-max_freq <= k)
            max_length = Math.max(max_length,j-i+1);
        }

        return max_length;
    }
}
