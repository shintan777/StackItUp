import javax.swing.*;
import java.awt.*;

class Stac extends JFrame
{
public Stac()
{

 super("Draw A Rectangle In JFrame");

 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(30,30,750,750);

setBackground(Color.darkGray);
setResizable(false);
setVisible(true);
 
 //setSize(500,500);

 

}

public void paint(Graphics g)
{
 super.paint(g);

 
 g.drawRect(20,20,300,50);

 
 g.setColor(Color.RED);

 
 g.fillRect(50,50,300,100);
}

public static void main(String[]args)
{
 Stac rect=new Stac();
}
}