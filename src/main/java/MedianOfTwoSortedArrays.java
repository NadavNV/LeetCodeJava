import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int partitionSize = (m + n + 1) / 2;
        int left = 0;
        int right = m;
        while (left <= right) {
            int mid1 = (left + right) / 2;
            int mid2 = partitionSize - mid1;
            // Largest number in the small partition of nums1
            int maxLeft1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            // Smallest number in the large partition of nums1
            int minRight1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];
            // Largest number in the small partition of nums1
            int maxLeft2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            // Smallest number in the large partition of nums2
            int minRight2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Partitioning is complete.
                // If there's an even number of elements, we take the median of the middle two.
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // maxLeft1 is too large to be in the smaller partition,
                // we need fewer numbers from nums1, so we move to the
                // smaller half of the search space.
                right = mid1 - 1;
            } else {  // minRight1 < maxLeft2
                // minRight1 is too small to be in the larger partition,
                // we need more numbers from nums1, so we move to the
                // larger half of the search space.
                left = mid1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        System.out.println(test.findMedianSortedArrays(
                new int[]{1, 3}, new int[]{2}
        ) == 2.0);
        System.out.println(test.findMedianSortedArrays(
                new int[]{1, 2}, new int[]{3, 4}
        ) == 2.5);
        System.out.println(test.findMedianSortedArrays(
                new int[]{}, new int[]{1}
        ) == 1);
    }
}
