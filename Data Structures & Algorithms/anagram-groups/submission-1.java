class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            String sorted = sortString(s);
            if(!map.containsKey(sorted))
            {
                map.put(sorted, new ArrayList<String>(Arrays.asList(s)));
            }else{
                List<String> res = map.get(sorted);
                res.add(s);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }


    private String sortString(String x) {
        char[] arr = x.toCharArray();
        Arrays.sort(arr);
        return new String(arr); // Corrected from arr.toString() to new String(arr)
    }

}
