package jingda.algo.calc;

/**
 * 数组的位置i是第i天股票的价值，求哪天出售股票会获取最大利益
 */
public class StockDeal1 {

    public static void main(String[] args) {
        StockDeal1 stockDeal1 = new StockDeal1();
        double[] prices = new double[] {1.2, 1.4, 1.3, 1.5, 2, 3, 4, 0.6, 3, 10, 1};
        double maxRevenue = stockDeal1.maxRevenue(prices);
        System.out.println("max revenue is " + maxRevenue);
    }

    public double maxRevenue(double[] stockPrice) {
        int dayNum = stockPrice.length;
        double dayMinPrice = Double.MAX_VALUE;
        double maxRevenue = 0;
        for (double v : stockPrice) {
            if (v < dayMinPrice) {
                dayMinPrice = v;
            }
            maxRevenue = Math.max(maxRevenue, v - dayMinPrice);
        }
        return maxRevenue;
    }
}
