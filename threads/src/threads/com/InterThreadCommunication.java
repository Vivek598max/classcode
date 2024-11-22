package threads.com;

class TestSum extends Thread{
	int Total=0;
	public synchronized void run() {
		for(int i=0;i<=10;i++) {
			Total=Total+1;
		}
	}
}
public class InterThreadCommunication {
              
}
public class CalculatorReader{
	public static void main() {
		Calculator c1= new Calculator();
	}
}