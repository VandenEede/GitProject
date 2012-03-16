package view;
import java.awt.Dimension;		//nodig om het midden te berekenen
import java.awt.Toolkit;			

public class StartUp
{
	public static void main(String args[])
	{
		Login login = new Login();
		login.setSize(1000, 700);
		login.setVisible(true);
		
		//plaatst het venster in het midden
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();
		login.setLocation((int)(scrnsize.getWidth()/2-login.getWidth()/2),(int)(scrnsize.getHeight()/2-login.getHeight()/2));		
	}
}
