package SortingAndSearchingMedianOfTwoSortedArrays;


public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int combinedLength = (nums1 != null ? nums1.length : 0) + (nums2 != null ? nums2.length : 0);
        int medianIndex = combinedLength / 2;
        int i = 0, j = 0, k = 0, median = 0, medianPrevious = 0;
        while (true) {
            if (j >= nums2.length) {
                medianPrevious = median;
                median = nums1[i++];
            } else if (i >= nums1.length) {
                medianPrevious = median;
                median = nums2[j++];
            } else if (nums1[i] <= nums2[j]) {
                medianPrevious = median;
                median = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                medianPrevious = median;
                median = nums2[j++];
            }

            if (k == medianIndex) {
                break;
            }
            k++;
        }
        if (combinedLength % 2 == 0) return (Double.valueOf(median) + Double.valueOf(medianPrevious)) / 2;
        return median;
    }


    public static void main(String[] args) {
        MedianOfTwoSortedArrays instance = new MedianOfTwoSortedArrays();
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3, 4};
        System.out.println(instance.findMedianSortedArrays(num1, num2));
    }
}
