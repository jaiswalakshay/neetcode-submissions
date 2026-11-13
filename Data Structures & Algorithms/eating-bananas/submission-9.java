
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int p : piles) {
            max = Math.max(p, max);
        }

        int min = 1;
        int ans = max;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (canEat(mid, piles, h)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return ans;
    }

    public boolean canEat(int k, int[] piles, int h) {
        long sum = 0;

        for (int p : piles) {
            sum += (p + (long) k - 1) / k;

            if (sum > h) {
                return false;
            }
        }

        return true;
    }
}
