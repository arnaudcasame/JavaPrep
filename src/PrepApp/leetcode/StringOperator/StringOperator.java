package PrepApp.leetcode.StringOperator;

public class StringOperator {

    public String reverseWords(String s) {
        String word = "";
        String reversed = "";
        for (int i = 0; i < s.length(); i++) {
            int index = s.length() - i - 1;
            if(s.charAt(index) != ' '){
                word = word + Character.toString(s.charAt(index));
            }else{
                reversed = word + " " + reversed;
                word = "";
            }
        }
        reversed = word.concat(" ").concat(reversed);
        return reversed.trim();
    }

    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        if(s.length()%2 != 0){
            return false;
        }
        int tracker = 0;

        for (int i = 0; i <s.length(); i++) {
            char ch = s.charAt(i);
            if(i < s.length()/2 && vowels.contains(String.valueOf(ch))){
                tracker++;
            }else if(i >= s.length()/2 && vowels.contains(String.valueOf(ch))){
                tracker--;
            }
        }
        return tracker == 0;
    }
}
