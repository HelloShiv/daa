class Items{
    int weight;
    int profit;

    Items(int _weight , int _profit){
        this.weight = _weight;
        this.profit = _profit;
    }
}

public class fractionalknapsack {
    public static void main(String[] args) {
        Items[] items ={
            new Items(2,10),
            new Items(3,15),
            new Items(5,25),
            new Items(6,30),
            new Items(18,36),
            new Items(8,40),
        };
        int capacity = 14;
        double totalProfit = fractionalknapsackF(items,capacity);
        System.out.println("first Maximum profit available: " + totalProfit);
        
    }

    static double fractionalknapsackF(Items[] items, int capacity){
        java.util.Arrays.sort(items,java.util.Comparator.comparingDouble((Items item)-> (double)item.profit/item.weight).reversed());
        double totalProfit = 0.0 , currentWeigth = 0.0 ;
        
        for(Items item : items){
            if(item.weight + currentWeigth <= capacity){
                currentWeigth += item.weight;
                totalProfit += item.profit;
            }else{
                double leftweight = capacity - currentWeigth;
                totalProfit += (double) (leftweight / item.weight) * item.profit;
                break;
            }
        }

        return totalProfit;
    }
}
