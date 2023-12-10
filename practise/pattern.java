
public class pattern {
   public static void main(String[] args) {
        String text = "hello there how are u maya !";
        String pattern = "maya";
        System.out.println("Was the pattern found ?  " + patternFound(text,pattern));
   }

   static boolean patternFound(String text , String pattern){
        int tlen = text.length();
        int plen = pattern.length();

        for(int i = 0 ; i <= tlen -plen ; i++){
            int cpy = i;
            for(int j = 0 ; j < plen ; j++){
                if(text.charAt(cpy) != pattern.charAt(j)){
                    break;
                }else{
                    cpy++;
                    if(j == pattern.length() -1)
                        return true;
                }
            }
        }

    return false;
   }
}
