import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Login extends JFrame
{
	Container container;
	JLabel loginLogo,userName,password,portNo,ipaddress;
	JTextField namefield,port,ip;
	JPasswordField passField;
	JButton login;
	JPanel panel;
	
	Login()
	{
		setSize(450,600);
		setTitle("Login Form");
		setLocationRelativeTo(null);
		container=getContentPane();
		container.setBackground(new Color(7,94,84));
		loginLogo=new JLabel("Login ");
		loginLogo.setBounds(160,40,200,50);
		loginLogo.setForeground(Color.WHITE);
		loginLogo.setFont(new Font("SAN_SERIF",Font.BOLD,30));
		container.add(loginLogo);

		panel=new JPanel();
		panel.setBounds(70,120,300,400);
		panel.setBorder(BorderFactory.createLineBorder(new Color(0,0,80)));
		panel.setLayout(null);
		
		userName=new JLabel("Username:");
		namefield=new JTextField();
		password=new JLabel("Password:");
		passField=new JPasswordField();
		portNo=new JLabel("Port No:");
		ipaddress=new JLabel("IP Add:");
		ip=new JTextField();
		login=new JButton("Login");
		try
		{
			ObjectInputStream obis = new ObjectInputStream(new FileInputStream("credentials.txt"));
			ip= new JTextField((String)obis.readObject());
			port= new JTextField((String)obis.readObject());
			ip.setEnabled(false);
			port.setEnabled(false);
			obis.close();
		}
		catch(Exception ex)
		{
			ip = new JTextField();
			port = new JTextField();
		}
		
		
		userName.setBounds(10,50,100,30);
		namefield.setBounds(130,50,150,30);
		password.setBounds(10,100,100,30);
		passField.setBounds(130,100,150,30);
		portNo.setBounds(10,150,100,30);
		port.setBounds(130,150,150,30);
		ipaddress.setBounds(10,200,100,30);
		ip.setBounds(130,200,150,30);
		login.setBounds(80,280,140,60);
		
		userName.setForeground(new Color(7,94,84));
		password.setForeground(new Color(7,94,84));
		portNo.setForeground(new Color(7,94,84));
		ipaddress.setForeground(new Color(7,94,84));
		
		userName.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		password.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		portNo.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		ipaddress.setFont(new Font("SAN_SERIF",Font.BOLD,16));
		login.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		
		namefield.setBorder(BorderFactory.createLineBorder(Color.black));
		passField.setBorder(BorderFactory.createLineBorder(Color.black));
		port.setBorder(BorderFactory.createLineBorder(Color.black));
		ip.setBorder(BorderFactory.createLineBorder(Color.black));
		login.setBorder(BorderFactory.createBevelBorder(1));
		

		
		login.addActionListener(new LoginService(this));
		panel.add(userName);
		panel.add(password);
		panel.add(portNo);
		panel.add(port);
		panel.add(passField);
		panel.add(namefield);
		panel.add(ip);
		panel.add(ipaddress);
		panel.add(login);
		container.add(panel);
		
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String...args)
	{
		new Login().setVisible(true);
	}
}
