package LabelSWING;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameDemo extends JFrame {
       FrameDemo(){
    	   Label l=new Label("Hello Learners");
    	   Container c= this.getContentPane();
    	   c.setLayout(new FlowLayout());
    	   c.setBackground(Color.red);
    	   l.setFont(new Font("Arial",Font.BOLD,45));
    	   l.setForeground(Color.blue);
    	   c.add(l);
       }
       public static void main(String []args) {
    	   FrameDemo fd=new FrameDemo();
    	   fd.setTitle("My Frame");
    	   fd.setVisible(true);
    	   fd.setSize(400,400);
       }
}
