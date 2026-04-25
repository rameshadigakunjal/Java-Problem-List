public class RemoveDuplicatesArr {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // slow pointer

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++; // move slow pointer
                nums[i] = nums[j]; // update unique element
            }
        }

        return i + 1; // length of unique elements
    }
    public static void main(String[] args) {
        RemoveDuplicatesArr app = new RemoveDuplicatesArr();
        int[] nums = {1, 1, 2, 2, 3};
        int newLength = app.removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        System.out.print("Unique elements: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    
}