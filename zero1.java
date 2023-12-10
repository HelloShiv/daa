public class zero1 {
    
    public static void main(String[] args) {
        int capacity = 8;
        int[] weight = {2,3,4,5};
        int[] profit = {1,2,5,6};
        int n = weight.length;

        System.out.println(maxValue(n,weight,profit,capacity));
    }

    static int maxValue(int n , int[] weight , int[] profit , int capacity){
        int[][] V = new int[n+1][capacity+1];
        for(int i = 0 ; i <= n ; i++){
            for(int w = 0 ; w <= capacity ; w++){
                if(i == 0 || w == 0)
                    V[i][w] = 0;
                else if(weight[i-1] <= w){ //Dont forgot the w is here
                    V[i][w] = Math.max(V[i-1][w] , V[i-1][w -weight[i-1]] + profit[i-1]);
                } else {
                    V[i][w] = V[i-1][w];
                }
            }
        }
        return V[n][capacity];
    }
}
