class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int i : nums)
        {
            map.compute(i, (key, val) -> val == null ? 1 : val + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());

        maxHeap.addAll(map.entrySet());

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = maxHeap.poll().getKey();
        }
        return result;
    }
}
