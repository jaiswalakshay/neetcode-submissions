
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> indexes = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert the count array to a string key
            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append('#'); // delimiter to avoid ambiguity
                sb.append(i);
            }
            String key = sb.toString();

            indexes.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(indexes.values());
    }
}