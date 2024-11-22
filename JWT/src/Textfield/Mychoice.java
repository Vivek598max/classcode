package Textfield;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Mychoice extends Frame implements ItemListener{
          Choice ch;
          String msg;
          String Item;
          public Mychoice(){
        	 setLayout(new FlowLayout());
        	 ch=new Choice();
        	 ch.add("english");
        	 ch.add("hindi");
        	 ch.add("science");
        	 
        	 add(ch);
        	 
        	 ch.addItemListener(this);
        	 addWindowListener(new WindowAdapter() {
        		 public void windowClosing(WindowEvent we) {
        			 System.exit(0);
        		 }
        	 });  
          }
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	public void paint(Graphics g) {
		g.drawString("Selected subject",10,100);
		msg=ch.getSelectedItem();
		msg=msg+" "+ch.getSelectedIndex();
		g.drawString(msg,10,120);	
		Item=ch.getItem(2); //get item AT index 2
		g.drawString(Item,10,140);
		//ch.remove(1); //remove item at index 1
		ch.remove("english");//remove english from list
		
		
	}
	public static void main(String []args) {
		Mychoice c=new Mychoice();
		c.setTitle("My choice");
		c.setSize(400,400);
		c.setVisible(true);
		
	}
}
