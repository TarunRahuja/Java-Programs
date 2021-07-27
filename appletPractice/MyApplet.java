package appletPractice;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
//<applet code="MyApplet.java" width="300" height="220">
	//<param name="site" value="abc.com"/>
//</applet>
public class MyApplet extends Applet {
	private String defaultMessage = "Hello";
	@Override
	 public void paint(Graphics g) {
		String s1 = this.getParameter("site");
		if(s1==null)
			s1 = defaultMessage;
		g.drawString(s1, 100, 100);
	}
//	Label l1,l2,l3;
//	TextField t1,t2;
//	Button b1;
//	@Override
//	public void init() {
//		l1 = new Label("First Number");
//		l2 = new Label("Second Number");
//		l3 = new Label();
//		t1 = new TextField();
//		t2 = new TextField();
//		b1 = new Button("Add");
//		setLayout(null); //by default its flow layout
//		l1.setBounds(30,50,100,20);//x,y,width, height
//		l2.setBounds(30,100,100,20);
//		t1.setBounds(150, 50, 100, 20);
//		t2.setBounds(150, 100, 100, 20);
//		b1.setBounds(100, 150, 80, 20);
//		l3.setBounds(30,180,100,20);
//		add(l1);
//		add(t1);
//		add(l2);
//		add(t2);
//		add(b1);
//		add(l3);
//		b1.addActionListener(new MyHandler());
//	}
//	public class MyHandler implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			int a,b,s;
//			a = Integer.parseInt(t1.getText());
//			b = Integer.parseInt(t2.getText());
//			s = a+b;
//			l3.setText("Sum is"+s);
//			
//		}
	}

