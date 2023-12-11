class Item{
    int weight;
    int profit;

    Item(int _weight , int _profit){
        this.weight = _weight;
        this.profit = _profit;
    }
}
public class fractional {
    public static void main(String[] args) {
        Item[] items = {
            new Item(2, 10),
                new Item(3, 15),
                new Item(5, 25),
                new Item(6, 30),
                new Item(18, 36),
                new Item(8, 40),
        };
        int capacity = 14;

        System.out.println("Maximum profit: " + fractionalknapsack(items,capacity));
    }

    static double fractionalknapsack(Item[] items , int capacity){
        double currentweight = 0.0 , totalprofit = 0.0;
        java.util.Arrays.sort(items,java.util.Comparator.comparingDouble((Item item)-> item.profit/item.weight).reversed());
        for(Item item: items){
            if(currentweight + item.weight <= capacity){
                currentweight += item.weight;
                totalprofit += item.profit;
            }else{
                double remainingWeight = capacity - currentweight;
                totalprofit += (double) (remainingWeight/item.weight )*item.profit;
                break;
                // Dont forget the break
            }
        }
        

        return totalprofit;
    } 
}
