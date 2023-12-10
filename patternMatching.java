public class patternMatching {

    static boolean patternfind(String pattern, String text){
       int plen = pattern.length();
       int tlen = text.length();

       for(int i = 0 ; i <=  tlen - plen ; i++){
            int cpy = i;
            for(int j = 0 ; j < plen ; j++){
                if(text.charAt(cpy) != pattern.charAt(j)){
                    break;
                }else{
                    cpy++;
                    if(j == plen - 1){
                        return true;
                    }

                }
            }
       }

       return false; 
    }
    public static void main(String[] args) {
        String text = "Hello there how are you";
        String pattern = "Hello";
        System.out.println("Patter found: " + patternfind(pattern ,text));
        // System.out.println(text.contains(pattern)); DIRECT IF U FORGET
    }
}
