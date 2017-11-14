package pers.tan.sort;

/**
 * InsertSort class
 *
 * @author tanwei
 * @date 17-11-14
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,5,2,4,45,24,78,92,1};
        System.out.println("排序前:");
        for(int num:nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        insertSort(nums);
        System.out.println("排序后:");
        for(int num:nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 插入排序算法
     * @param nums
     */
    public static void insertSort(int[] nums) {
        if (0 == nums.length) {
           return ;
        }
        int i = 1;
        while(i < nums.length) {
            int j = i - 1;
            int key = nums[i];
            while(j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j--];
            }
            nums[j + 1] = key;
            i++;
        }
    }
}
