import java.util.Set;
import java.util.HashSet;
public class set {
    public static void main(String[] args) {
        int[][] sets = {
            {1,2,3},
            {2,4},
            {3,5},
            {4,5},
            {5,6},
        };
        java.util.Set<Integer> result = getSetCover(sets);
        System.out.println("Set cover is : " + result);
    }

    static java.util.Set<Integer> getSetCover(int[][] sets){
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

            for(int i = 0 ; i < sets.length ; i++){
                Set<Integer> setElements = new HashSet<>();
                for(int set : sets[i]){
                    setElements.add(set);
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
