public class gcd {
    public static void main(String[] args) {
        System.out.println("GCD OF: " + gcdF(3,15));
    }

    static int gcdF(int a , int b){
        if(b == 0)
            return a;
        return gcdF(b,a%b);
    }
}
