package threads.com;
class Calculator extends Thread{
	int total=0;
	public void run() {
		for(int i=0;i<=10;i++) {
			total=total+1;
		}
	}
}
class Reader extends Thread{
	Calculator c1=null;
	public Reader(Calculator c1) {
		this.c1=c1;
	}
	public void run() {
		System.out.println("Total 1 to 1000: "+c1.total);
	}
}
public class CalculatorReader {
    public static void main(String []args) {
    		Calculator c1=new Calculator();
    		new Reader(c1).start();
    		new Reader(c1).start();
    		new Reader(c1).start();
    		c1.start();
    }
}
