package pers.tan.sort;

/**
 * SelectSort class
 *
 * @author tanwei
 * @date 17-11-14
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,5,2,4,45,24,78,92,1};
        System.out.println("排序前:");
        for(int num:nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        selectSort(nums);
        System.out.println("排序后:");
        for(int num:nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 选择排序算法
     * @param nums
     */
    public static void selectSort(int[] nums) {
        if (0 == nums.length) {
            return ;
        }
        for(int i = 0; i < nums.length; i++) {
            int index = i;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[index]) {
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}
