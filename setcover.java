import java.util.HashSet;
import java.util.Set;

public class setcover {

    public static void main(String[] args) {
        int[][] sets = {
                {1, 2, 3},
                {2, 4},
                {3, 5},
                {4, 5},
                {5, 6}
        };

        Set<Integer> result = setCover(sets);

        System.out.println("Selected elements: " + result);
    }

    public static Set<Integer> setCover(int[][] sets) {
        Set<Integer> elements = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        // Create a set of all elements in the sets
        for (int[] set : sets) {
            for (int element : set) {
                elements.add(element);
            }
        }

        // Continue selecting sets until all elements are covered
        while (!elements.isEmpty()) {
            int bestSet = -1;
            Set<Integer> bestSetElements = new HashSet<>();

            // Find the set that covers the maximum number of uncovered elements
            for (int i = 0; i < sets.length; i++) {
                Set<Integer> setElements = new HashSet<>();
                for (int element : sets[i]) {
                    setElements.add(element);
                }

                setElements.retainAll(elements);

                if (setElements.size() > bestSetElements.size()) {
                    bestSet = i;
                    bestSetElements = setElements;
                }
            }

            // Select the best set
            result.add(bestSet);

            // Remove covered elements
            elements.removeAll(bestSetElements);
        }

        return result;
    }
}
