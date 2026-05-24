class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // can't reach this position
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        int[] nums = {2, 3, 1, 1, 4}; // Example input
        boolean result = jg.canJump(nums);
        System.out.println("Can jump to the end: " + result);
        
    }
}