class PowofXN {
    public double myPow(double x, int n) {
        long N = n; // handle negative overflow
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }

    private double power(double x, long n) {
        if (n == 0) return 1;

        double half = power(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public static void main(String[] args) {
        PowofXN app = new PowofXN();
        double x = 2.0;
        int n = 10;
        double result = app.myPow(x, n);
        System.out.println(x + " raised to the power of " + n + " is: " + result);
    }
}