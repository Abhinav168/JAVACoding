package Easy;

public class TwoSum {
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        int sum = 0;
        for(int i = 0 ; i<nums.length -1; i++){
            for(int j = i+1 ;j<nums.length; j++){
                if(nums[i]+ nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
