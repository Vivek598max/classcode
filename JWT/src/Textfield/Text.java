package Textfield;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Text extends Frame implements ActionListener{
		TextField name,password;
		Text(){
			setLayout(new 	FlowLayout());
			Label n=new Label("Name",Label.LEFT);
			Label p=new Label("Password", Label.LEFT);
			
			TextField name= new TextField(20);
			TextField password= new TextField(78);
			
			password.setEchoChar('*');
			name.setBackground(Color.yellow);
			name.setForeground(Color.red);
			Font f= new Font("Arial",Font.BOLD,25);
			name.setFont(f);
			
			add(n);
			add(p);
			add(name);
			add(password);
			
			name.addActionListener(this);
			password.addActionListener(this);
			
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we) {
					System.exit(0);
				}
			});
		}
			public static void main(String []args) {
				Text ta=new Text();
				ta.setTitle("Text Field");
				ta.setVisible(true);
				ta.setSize(400,400);
				System.out.println("hello");
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Graphics g=this.getGraphics();
				//public void paint(Graphics g) {
				g.drawString("name: "+name.getText(),10,200);
				g.drawString("password"+password.getText(),10,240);
				
			}
		}
	   
