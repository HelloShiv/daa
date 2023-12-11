

public class zero1k {
    public static void main(String[] args) {
        int capacity = 8;
        int[] weight = {2,3,4,5};
        int[] profit = {1,2,5,6};
        int n = profit.length;

        System.out.println("maximum profit : "  + zero1knapsack(n,profit,weight,capacity));
    }

    static int zero1knapsack(int n , int[] profit , int[] weight ,int capacity){
        int[][] v = new int[n+1][capacity+1];
        for(int i = 0 ; i <= n ; i++){
            for(int w = 0 ; w <= capacity ; w++){
                if( i == 0 || w == 0)
                    v[i][w] = 0;
                else if(weight[i-1] <= w){
                    v[i][w] = Math.max(v[i-1][w],v[i-1][w-weight[i-1]]+profit[i-1]);
                }else{
                    v[i][w] = v[i-1][w];
                }
            }
        }
        return v[n][capacity];
    }
}
