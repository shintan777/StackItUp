import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
class Stac extends JFrame
{int x=600,y=600,w=300,h=50;
private void moverect(double v)
{
if(x>0)
x-=v;
else 
x+=v;	
}
private void nextrect()
{
x=600;
y+=50;	
}

	
public Stac()
{

 super("StackItUp!!!");

 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(30,30,750,750);

setBackground(Color.darkGray);
setResizable(false);
setVisible(true);
 
 //setSize(500,500);

 

}
@Override
public void paint(Graphics g)
{
 super.paint(g);

 
// g.drawRect(x,y,w,h);

 
 g.setColor(Color.RED);

 
 g.fillRect(x,y,w,h);
}

public static void main(String[]args)throws InterruptedException {
{
 Stac rect=new Stac();
 while(true)
 {
	rect.moverect(1.5);
			rect.repaint();
			Thread.sleep(10);
	 
	 
 }
 
}
}



}