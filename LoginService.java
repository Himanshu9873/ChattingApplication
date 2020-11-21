import java.awt.event.*;
import java.io.*;
import java.net.*;
class LoginService implements ActionListener
{
	private Login  client;
	private ObjectInputStream obis;
	private ObjectOutputStream obos;
	Socket socket;
	LoginService(Login client)
	{
		this.client = client;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == client.login)
		{
			try
			{
				obis = new ObjectInputStream(new FileInputStream("credentials.txt"));
				obis.close();
			}
			catch(Exception ex)
			{
				try
				{
					obos = new ObjectOutputStream(new FileOutputStream("credentials.txt"));
					obos.writeObject(client.ip.getText());
					obos.writeObject(client.port.getText());
					obos.close();
				}
				catch(Exception exc)
				{
					exc.printStackTrace();
				}
			}
			try
			{
				socket = new Socket(client.ip.getText(),Integer.parseInt(client.port.getText()));
			}
			catch(Exception ex)
			{
				System.out.println("Server is not online");
			}
		}
	}
}