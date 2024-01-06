package PrepApp.codingbat.BlackJack;

public class BlackJack {

    public int calculateNearest(int a, int b){
        if(a > 21 && b > 21){
            return 0;
        }
        if(a > 21 && b < 21){
            return b;
        }
        if(a < 21 && b > 21){
            return a;
        }
        if(21 - a > 21 - b){
            return b;
        }
        return a;
    }
}
