package SeveralFrames;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Textfield.Mychoice;


public class Frame1 extends Frame implements ActionListener{
        Button b1,b2;
        Frame1(){
        	setLayout(new FlowLayout());
        	b1=new Button("NEXT");
        	b2=new Button("BACK");
        	
        	b1.setBounds(100,100,70,40);
        	b2.setBounds(200,100,70,40);
        	
        	b1.addActionListener(this);
        	b2.addActionListener(this);
        	
        	add(b1);
        	add(b2);
        }
	@Override
	public void actionPerformed(ActionEvent ae) {
	       if(ae.getSource()==b1) {
	    	   Mychoice f2=new Mychoice();
	    	   f2.setSize(400,400);
	    	   f2.setVisible(true);
	       }
	       else {
	    	   System.exit(0);
	       }
	}
	public static void main(String args[]) {
		Frame1 f1=new Frame1();
		f1.setSize(500,500);
		f1.setTitle("First Frame");
		f1.setVisible(true);
	}
}
