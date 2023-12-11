
class Item{
    int weight;
    int profit;

    Item(int weight , int profit){
        this.weight = weight;
        this.profit = profit;
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
    double maxValue = fractionalKnapsack(items, capacity);
    System.out.println("Maximum profit: " + maxValue);
    }

    static double fractionalKnapsack(Item[] items , int capacity){
        double totalProfit = 0.0 , currentWeight  = 0.0;
        java.util.Arrays.sort(items,java.util.Comparator.comparingDouble((Item item)-> (double)item.profit/item.weight).reversed());

        for(Item item: items){
            if(item.weight + currentWeight <= capacity ){
                totalProfit += item.profit;
                currentWeight += item.weight;;
            }else{
                double leftweight = capacity - currentWeight;
                totalProfit += (double) (leftweight/item.weight)*item.profit;
                break;
            }
        }

        return totalProfit;
    }
}
