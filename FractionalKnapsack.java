import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int value;

    Item(int _weight, int _value) {
        this.weight = _weight;
        this.value = _value;
    }
}

public class FractionalKnapsack {

    public static double fractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> (double) item.value / item.weight).reversed());
        //Dont forgot Profit/weight
        //leftover/item.weight * item.profit

        double totalProfit = 0.0;
        double currentWeight = 0.0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalProfit += item.value;
            } else {
                double remainingCapacity = capacity - currentWeight;
                totalProfit += ((double) remainingCapacity / item.weight) * item.value;
                break;
            }
        }

        return totalProfit;
    }

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
}
