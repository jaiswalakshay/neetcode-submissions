class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        // Find the maximum pile
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canEat(mid, piles, h)) {
                // mid works, so try a smaller speed
                right = mid - 1;
            } else {
                // mid doesn't work, need a larger speed
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canEat(int speed, int[] piles, int h) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile - 1) / speed + 1;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}
