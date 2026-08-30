class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();

        HashMap<Character,Integer> count = new HashMap();

        for (char c : s_arr){
            count.put(c,count.getOrDefault(c,0)+1);
        }

        for (char c : t_arr){
            int l = count.getOrDefault(c,0);
            if(!count.containsKey(c)){
                return false;
            }
            if(l==1){
                count.remove(c);
            }else{
                count.put(c,l-1);
            }
        }

        
        for (int val : count.values()) {
            if (val != 0) return false;
        }

        return true;
    }
}
