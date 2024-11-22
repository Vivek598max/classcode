package com.gsv.multitread;

    class computer extends Thread
    {
    	public computer(String name) 
    	{
    		super(name);
    	}
    	public void run() 
    	{
    		for(int i=0;i<100;i++) 
    		{
    			System.out.println(getName()+":"+i);
    		}
    	}
    }
class NameThreadDemo
{
    	public static void main(String []args) 
    	{
    		computer c=new computer("AIDS");
    		c.start();
    	}
}

