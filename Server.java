package ChatPack;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Server extends JFrame implements ActionListener
{
	JLabel label;
	JPanel panel1 ;
	JTextField testfield1;
	JButton button1;
	Static ServerSocket skt;
    Static Socket s;
	Static DataInputStream din;
	static DataOutputStream dout;
	static JPanel panel2;
	Boolean typing;
	Server()
	{
		panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(new Color(7,94,84));
		panel1.setBounds(0,0,450,70);
		add(panel1);
		
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("E:\MyJava\JavaProject\Icon\3.png"));
		Image i2=icon.getImage.getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l1=new JLabel(icon);
		li.setBounds(5,17,30,30);
		panel1.add(l1);
		
		l1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent ae)
			{
				System.exit(0);
			}
		});
		ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("E:\MyJava\JavaProject\Icon\3.png"));
		Image i5=i4.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon i6=new ImageIcon(i5);
		JLabel l2=new JLabel(i6);
		l2.setBounds(40,5,60,60);
		panel1.add(l2);
		
		ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("E:\MyJava\JavaProject\Icon\3.png"));
		Image i8=i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon i9=new ImageIcon(i8);
		JLabel l5=new JLabel(i9);
		l5.setBounds(290,20,30,30);
		panel1.add(l5);
		
		ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("E:\MyJava\JavaProject\Icon\3.png"));
		Image i11=i10.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon i12=new ImageIcon(i11);
		JLabel l6=new JLabel(i12);
		l5.setBounds(350,20,35,30);
		panel1.add(l6);
		
		ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("E:\MyJava\JavaProject\Icon\3.png"));
		Image i14=i13.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
		ImageIcon i15=new ImageIcon(i14);
		JLabel l7=new JLabel(i15);
		l5.setBounds(410,20,13,25);
		panel1.add(l7);
		
		JLabel l3=new JLabel("Server");
		l3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		l3.setForeground(Color.WHITE);
		L3.setBounds(110,15,100,18);
		panel1.add(l3);
		
		JLabel l4=new JLabel("Active Now");
		l4.setFont(new Font("SAN_SERIF",Font.BOLD,18));
		l4.setForeground(Color.WHITE);
		L4.setBounds(110,35,100,20);
		panel1.add(l4);
		
		Timer t=new Timer(1,new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				if(!typing)
				{
					l4.setText("Active Now");
				}
			}
		});
		t.setInitialDelay(2000);
		
		panel2=new JPanel();
		panel2.setBounds(5,75,440,570);
		panel2.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		add(panel2);
		
		testfield1=new JTextField();
		testfield1.setBounds(5,655,310,40);
		testfield1.sentFont("SAN_SERIF",Font.PLAIN,16);
		add(testfield1);
		testfield1.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke)
			{
				l4.setText("typing...");
				t.stop();
				typing=true;
			}
			public void keyReleased(KeyEvent ke)
			{
				typing=false;
				if(!t.isRunning(){
					t.start();
				}
			}
		});
		
		button1=new JButton("Send");
		button1.setBounds(320,655,123,40);
		button1.setBackground(new Color(7,94,84));
        button1.setForeground(Color.WHITE);
		button1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
		button1.addActionListener(this);
		add(button1);
		
		Container container=getContentPane().setBackground(Color.WHITE);
		setSize(500,500);
		setLocationRelativeTo(null);
		
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			String out=testfield1.getText();
			JPanel p2=formatLabel(out);
			panel2.setLayout(new BorderLayout());
			JPanel right=new JPanel(new BorderLayout());
			right.add(p2,BorderLayout.LINE_END);
			vertical.add(right);
			vertical.add(Box.createVerticalStrut(15));
			panel2.add(vertical,BorderLayout.PAGE_START);
			dout.writeUTF(out);
			testfield1.setText("");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static JPanel formatLabel(String out)
	{
		JPanel p3=new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout));
	}
	public static void main(String...args)
	{
		new Server().setVisible(true);
	}
}