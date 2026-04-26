public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0; // position for next valid element

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
    public static void main(String[] args) {
        RemoveElement app = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int newLength = app.removeElement(nums, val);
        System.out.println("New length: " + newLength);
        System.out.print("Elements after removal: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}