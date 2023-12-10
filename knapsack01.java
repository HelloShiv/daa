public class knapsack01 {
    public static void main(String[] args) {
        int capacity = 8;
        int[] profit = {1,2,5,6};
        int[] weight = {2,3,4,5};
        int n = profit.length;

        System.out.println("Maximum profit to expect: " + maxProfit(n , profit, weight , capacity));
    }

    public static int maxProfit(int n , int[] profit , int[] weight , int capacity){
        int[][] value = new int[n+1][capacity+1];
        for(int i = 0 ; i <= n ; i++){
            for(int w = 0 ; w <= capacity ; w++){
                if(i == 0 || w == 0){
                    value[i][w] = 0;
                }else if(weight[i-1] <= w){
                    value[i][w] = Math.max(value[i-1][w],value[i-1][w-weight[i-1]] + profit[i-1]);
                    // remember in the formula add i-1 everywhere in the rhs
                }else{
                    value[i][w] = value[i-1][w];
                }
            }
        }
        return value[n][capacity];
    }

}
