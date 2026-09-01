class TimeMap {

    private Map<String, List<Entry>> timeMap = new HashMap<>();

    static class Entry {
        int timestamp;
        String value;

        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {

        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }

        timeMap.get(key).add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {

        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Entry> entries = timeMap.get(key);

        int index = search(entries, timestamp);

        if (index == -1) {
            return "";
        }

        return entries.get(index).value;
    }

    private int search(List<Entry> entries, int target) {

        int left = 0;
        int right = entries.size() - 1;

        int best = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (entries.get(mid).timestamp == target) {
                return mid;
            }

            if (entries.get(mid).timestamp < target) {

                // Valid candidate.
                // Try to find a larger valid timestamp.
                best = mid;
                left = mid + 1;

            } else {

                // Timestamp is too large.
                right = mid - 1;
            }
        }

        return best;
    }
}