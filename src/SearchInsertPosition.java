public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // found
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left; // insert position
    }
    public static void main(String[] args) {
        SearchInsertPosition app = new SearchInsertPosition();
        int[] nums = {1,3,5,6};
        int target = 5;
        int result = app.searchInsert(nums, target);
        System.out.println("Insert Position: " + result);
    }
}