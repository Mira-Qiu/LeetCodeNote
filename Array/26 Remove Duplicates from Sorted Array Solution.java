class Solution {
    /*
    从index 1 开始比较。用res++ 删除重复
    */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] != nums[i]){
                nums[res++] = nums[i];
            }
        }
        return res;
    }
}
