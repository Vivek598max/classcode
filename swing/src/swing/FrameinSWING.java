package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

class MyPanel extends JPanel{
	MyPanel(){
		this.setBackground(Color.green);  //grren color panel
	}
	public void paintcomponent(Graphics g) {  //taking graphics
		super.paintComponent(g);   //JPanel class method
		g.setColor(Color.blue);   //color of that component
		g.setFont(new Font("Arial",Font.BOLD,32));  //setting font 
		g.drawString("HELLO WORLD",50,100);  //write the string 
	}
}

class FrameinSWING extends JFrame {
	FrameinSWING(){
		 Container c=this.getContentPane(); //creating container class object and grtting content pane
		   MyPanel mp=new MyPanel();  //Jpanel is used to paint the portion
		   c.add(mp);  //adding mypanel content to the content pane
	}
   public static void main(String []args){
	   FrameinSWING jf=new FrameinSWING();  //create JFrame
	   jf.setTitle("My Frame");
	   jf.setSize(400,400);
	   jf.setVisible(true);
	  // jf.getGlassPane();
	   //JRootPane jrp=new JRootPane();
	   //jrp.getRootPane();
	   jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//EXIT_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE
   }
}*/
class MyPanel extends JPanel{
	MyPanel(){
		this.setBackground(Color.red);
	}
	public void paintcomponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.setFont(new Font("Arial",Font.BOLD,34));
		g.drawString("HELLO LEARNER",100,50);
	}
}
class FrameinSWING extends JFrame {
		FrameinSWING(){
		   Container c= this.getContentPane();
		   MyPanel mp=new MyPanel();
		   c.add(mp);
		}
		public static void main(String []args) {
			FrameinSWING fs=new FrameinSWING();
			fs.setTitle("MY SWING");
			fs.setVisible(true);
			fs.setSize(400,400);
			
		}
		}