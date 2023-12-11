// package practise1;
import java.util.Set;
import java.util.HashSet;
public class set {
    public static void main(String[] args) {
        int[][] sets  = {
                {1, 2, 3},
                {2, 4},
                {3, 5},
                {4, 5},
                {5, 6}
        };
        Set<Integer> result = setCover(sets);
        System.out.println("Set cover is: " + result);

    }

    static Set<Integer> setCover(int[][] sets){
        Set<Integer> elements = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int[] set : sets){
            for(int element : set){
                elements.add(element);
            }
        }

        while(!elements.isEmpty()){
            int bestSet = -1;
            Set<Integer> bestSetElements = new HashSet<>();

            for(int i = 0 ; i < sets.length ; i++){ //dont forget its sets.length and all are sets inside
                Set<Integer> setElements = new HashSet<>();
                for(int element : sets[i]){
                    setElements.add(element);
                }
                setElements.retainAll(elements);
                if(setElements.size() > bestSetElements.size()){
                    bestSet = i;
                    bestSetElements = setElements;
                }
            }
            result.add(bestSet);
            elements.removeAll(bestSetElements);
        }

        return result;
    }
}
