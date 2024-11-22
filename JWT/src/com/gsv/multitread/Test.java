package com.gsv.multitread;

public class Test extends Thread {
	public void run() {
		for(int i=0;i<1000;i+=2) {
			if(i==400) {
				stop();
			}
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
			setName("ODD: ");  //with the help of constructor we can also change the name of child class
			System.out.println(getName()+":"+i);
		}
	}

}
class Sample extends Thread{
	public void run() {
		for(int i=1;i<1000;i+=2) {
		try {
			Thread.sleep(100);
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		setName("EVEN: ");
		System.out.println(getName()+":"+i);
	}
}
}
class Manager{
	public static void main(String []args) {
		System.out.println(Thread.currentThread().getName());
		Test t1=new Test();
		t1.start();
		Sample s1=new Sample();
		s1.start();
	}
}