package pers.tan.sort;

/**
 * BubbleSort class
 *
 * @author tanwei
 * @date 17-11-14
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1,0};
        System.out.println("排序前:");
        for(int num:nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        bubbleSort(nums);
        System.out.println("排序后:");
        for(int num:nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 冒泡排序算法
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        if (0 == nums.length) {
            return ;
        }
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                   int temp = nums[j];
                   nums[j] = nums[j + 1];
                   nums[j + 1] = temp;
                }
            }
        }
    }
}
