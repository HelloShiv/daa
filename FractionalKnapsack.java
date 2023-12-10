import java.util.Arrays;
import java.util.Comparator;
class Item {
    int weight;
    int value;
    Item(int _weight , int _value){
        this.weight = _weight;
        this.value = _value;
    }
}

public class FractionalKnapsack  {
    

    public static double fractionalknapsack(Item[] items , int capacity){
        // Arrays.sort(items, java.util.Comparator.comparingDouble(item -> (double)items.value/items.weight).reversed());publ
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> (double) item.value / item.weight).reversed());


        double totalProfit  = 0.0;
        double currentWeigth = 0.0;
        for(Item item : items){
            if(currentWeigth + item.weight <= capacity){
                currentWeigth += item.weight;
                totalProfit += item.value;
            }else{
                double remaingWeight = capacity - currentWeigth;
                totalProfit  = totalProfit + (double) remaingWeight /item.weight *item.value;
                break;
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(10,60),
            new Item(20,100),
            new Item(30,120),
            
        };

        int capacity = 50;
        double maxValue = fractionalknapsack(items,capacity);
        System.out.println("maximum profit : " + maxValue);
    }
}


