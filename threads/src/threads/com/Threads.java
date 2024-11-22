package threads.com;

class booking extends Thread{
	Object train=null;
	Object comp=null;
	public booking(Object train,Object comp) {
		super();
		this.train=train;
		this.comp=comp;
	}
	public void run() {
		System.out.println(getName()+"Booking start");
		synchronized (train) {
			System.out.println(getName()+"Book train");
			try {
				sleep(100);
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			synchronized(comp) {
				System.out.println(getName()+"Bookcomp");
			}
		}
		System.out.println(getName()+"Booking end");
	}
}
class cancel extends Thread{
	Object train=null;
	Object comp=null;
	
	public cancel(Object train,Object comp) {
		super();
		this.train=train;
		this.comp=comp;
	}
	public void run() {
		System.out.println(getName()+"cancel comp");
		try {
			sleep(100);
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		synchronized(train) {
			System.oot.println(getName()+"cancel train");
		}
	}
	System.out.println(getName()+"cancel end");
}
public class Threads {
    public static void main(String []args) {
    	Object train
    }
}
class 