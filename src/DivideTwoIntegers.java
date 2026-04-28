class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        
        // Edge case to prevent overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert to long to avoid overflow
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int result = 0;

        while (dvd >= dvs) {
            long temp = dvs;
            int multiple = 1;

            // Increase divisor exponentially
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            result += multiple;
        }

        // Handle sign
        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }

        return result;
    }
    public static void main(String[] args) {
        DivideTwoIntegers app = new DivideTwoIntegers();
        int dividend = 10;
        int divisor = 3;
        int quotient = app.divide(dividend, divisor);
        System.out.println("Quotient: " + quotient);
    }
}
