package PrepApp.codingbat.EvenlySpaced;

public class EvenlySpaced {
	public boolean evenlySpaced(int a, int b, int c) {
		int i=0;
		while (i < 3){
			if(a > b){
				int temp = b;
				b = a;
				a = temp;
			}
			if(c < b){
				int temp = b;
				b = c;
				c = temp;
			}
			i++;
		}
		return c - b == b - a;
	}
}
