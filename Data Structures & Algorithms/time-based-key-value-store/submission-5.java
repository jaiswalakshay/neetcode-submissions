class TimeMap {

    private Map<String, Map<Integer, String>> timeMap = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {

        Map<Integer, String> values;

        if (timeMap.containsKey(key)) {
            values = timeMap.get(key);
            values.put(timestamp, value);
        } else {
            timeMap.put(key, new HashMap<>());
            values = timeMap.get(key);
            values.put(timestamp, value);
        }
    }

    public String get(String key, int timestamp) {

        if (!timeMap.containsKey(key)) {
            return "";
        }

        Map<Integer, String> vals = timeMap.get(key);

        Set<Integer> keys = vals.keySet();

        Integer[] arr = keys.toArray(new Integer[0]);

        Arrays.sort(arr); // REQUIRED for binary search

        int best = search(arr, timestamp);

        if (best == -1) {
            return "";
        }

        return vals.get(arr[best]);
    }

    private int search(Integer[] keys, int target) {

        int left = 0;
        int right = keys.length - 1;
        int best = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (keys[mid] == target) {
                return mid;
            }

            if (keys[mid] < target) {

                best = mid;
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return best;
    }
}