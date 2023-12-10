public class GCD{

    static int gcdCalculate(int a , int b){
        if (b == 0){
            return a;
        }
        return gcdCalculate(b , a%b);
    }
    public static void main(String[] args) {
        
        System.out.println("GCD: " + gcdCalculate(5,15));
    }

}