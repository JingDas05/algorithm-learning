package jingda.algo.duplicate;

/**
 *
 */
public class HyperLogLog {
    private final int b;
    private final int m;
    private final double alphaMM;
    private final double[] M;

    public HyperLogLog(int b) {
        this.b = b;
        this.m = 1 << b;
        this.alphaMM = getAlphaMM(m);
        this.M = new double[m];
    }

    private static double getAlphaMM(int m) {
        double alpha;
        switch (m) {
            case 16:
                alpha = 0.673;
                break;
            case 32:
                alpha = 0.697;
                break;
            case 64:
                alpha = 0.709;
                break;
            default:
                alpha = 0.7213 / (1 + 1.079 / m);
                break;
        }
        return alpha * m * m;
    }

    public void add(Object o) {
        int hash = o.hashCode();
        int index = hash >>> (32 - b);
        int rank = Integer.numberOfLeadingZeros((hash << b) | (1 << (b - 1))) + 1;
        M[index] = Math.max(M[index], rank);
    }

    public long count() {
        double sum = 0;
        for (double v : M) {
            sum += 1.0 / (1 << (int) v);
        }
        double estimate = alphaMM / sum;

        // apply small range correction
        if (estimate <= 5.0 * m / 2.0) {
            int zeros = 0;
            for (double v : M) {
                if (v == 0) {
                    zeros++;
                }
            }
            if (zeros != 0) {
                estimate = m * Math.log(m * 1.0 / zeros);
            }
        }
        return (long) estimate;
    }
}
