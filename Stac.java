
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;

@SuppressWarnings({ "serial", "unused" })
class Stac extends JFrame{
	static int cntr=0;
	JLabel  t1;
	Block blk = new Block();
	Block nblk = new Block();
	
		Stac()
		{   super("StackItUp!!!");
			addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {
				}
				@Override
				public void keyReleased(KeyEvent e) {
					
			      //nblk.keyReleased(e);
				}
				@Override
				public void keyPressed(KeyEvent e) {
					blk.keyPressed(e);
					nblk.nextrect();
					 cntr++;
				System.out.println(cntr);
				t1.setText("SCORE :  "+cntr);
					
				//if(blk.cntr>=1)
					//{nblk.keyPressed(e);
				//}
				}
			});
				t1 = new JLabel() ;
			t1.setBounds(30,30,100,30) ; 
			setFocusable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0,0,720,720);
			setBackground(Color.darkGray);
			setResizable(false);
			setVisible(true);
			
		
			
			
			add(t1);
			
			}

	
	
		
		public void move() {
			blk.moverect();
			nblk.moverect();
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			blk.paint(g);
			nblk.paint(g);
		}

		public static void main(String[]args)throws InterruptedException {
		{
			 Stac rect=new Stac();
			 while(true)
			 {
				rect.move();
				rect.repaint();
				Thread.sleep(15);	 
			 }
		}
	}
}
@SuppressWarnings("serial")
class Block extends JFrame{
	
	
	
	double vel=2.0;
	int x=0,w=250,h=50,y=600;
	 
	Block(){
		
		
		double vel=2.0;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h= h;
		this.vel=vel;
		
	
	}
	public void moverect()
	{	
		if(x+vel<720 && x+vel>0)
		{x+=vel;
		}
		if(x+vel>=720-w)
		 {vel=vel*(-1);
		  x+=vel;
		 }
		if(x+vel==0)
		{vel=vel*(-1);
		  x+=vel;
		 }
	}
	public void nextrect()
	{	
	
	

		y-=h;
		x=0;
		
	}
	
	@Override
	public void paint(Graphics g)
	{
	 g.setColor(Color.RED); 
	 g.fillRect(x,y,w,h);
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			
			
			vel = 0;		
		}
	
	}
	

	
}