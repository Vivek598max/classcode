package com.gsv.multitread1;

class one{
	public void set(int value) {
		int i=value/10;
		System.out.println("value of"+Thread.currentThread().getName()+":"+i);
	}
}
class Two{
	int i;
	Two(int i){
		this.i=i;
	}
	void callSet() {
		new one().set(i);
	}
}
class OneTwo extends Thread{
	public void run() {
		Two t=new Two(10);
		t.callSet();
	}
}
class First{
	public void set(int value) {
		int i=value/10;
		System.out.println("Value of"+Thread.currentThread().getName()+":"+i);
	}
}
class second{
	int i;
	second(int i){
		this.i=i;
	}
	void callSet() {
		new First().set(i);
	}
}
class FirstSecond extends Thread  {
	public void run() {
		second t=new second(10);
		t.callSet();
	}
}
public class NameThreadDemo {
	public static void main(String []args) {
		System.out.println(Thread.currentThread().getName());
		OneTwo ot=new OneTwo();
		ot.start();
		FirstSecond fs=new FirstSecond();
		fs.start();
	}
}