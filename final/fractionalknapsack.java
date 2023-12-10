
class Item{
    int weight;
    int profit;
    Item(int _weight , int _profit){
        this.weight = _weight;
        this.profit = _profit;
    }
}

public class fractionalknapsack {
    public static void main(String[] args) {
        Item[] items = {
            new Item(10,60),
            new Item(20,100),
            new Item(30,120),
        };
        int capacity = 50;
        System.out.println("maximum profit in fractional: " + calcFrac(items ,capacity));
        
    }

    static double calcFrac(Item[] items , int capacity){
        double totalProfit = 0.0;
        double currentWeigth = 0.0;
        java.util.Arrays.sort(items,java.util.Comparator.comparingDouble((Item item) -> (double) item.profit / item.weight ).reversed());

        
        for(Item item : items){
            if(currentWeigth + item.weight <= capacity){
                currentWeigth += item.weight;
                totalProfit += item.profit;
            }else{
                double leftCapacity = capacity - currentWeigth;
                totalProfit  += (double) leftCapacity/item.weight * item.profit;
            }
        }

        return totalProfit;
    }
}


