import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;

@SuppressWarnings({ "serial" })
class StackItUp extends JFrame{
	static int cntr=0,t=0,width=250;
	int i,xpos,xpos2,diff;
	JLabel  t1;
	Block actual =new Block();
	Block nextblk =new Block();
	ArrayList<Block> b = new ArrayList<Block>();
	
		StackItUp()
		{super("StackItUp!!!");
			   
		        setSize(720,720);
				setVisible(true);
				t1 = new JLabel() ;
				t1.setBounds(0,0,100,100) ; 
                add(t1);
			addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
				}
				@Override
				public void keyReleased(KeyEvent e) {
				}			
				@Override
				public void keyPressed(KeyEvent e) {
					actual.keyPressed(e);
					xpos2=actual.x;
					//xpos2=actual.x+actual.w;
					System.out.println(xpos2+" "+xpos);
					//ArrayList<Block> b = new ArrayList();
					b.add(new Block());
					//System.out.println(b.size());
					nextblk=b.get(cntr);
					cntr++;
					t1.setText("SCORE :  "+cntr);
					nextblk.w=width;
					if(cntr==2)
						diff=0;
					else
					{diff=Math.abs(xpos-xpos2);}
					System.out.println(diff);
					width-=diff;
					xpos=xpos2;
					nextblk.y-=nextblk.h*cntr;
					//if(cntr>=8) nextblk.drop();
					actual=nextblk;
				}
			});
			setFocusable(true);
		   
			setResizable(false);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
		public void move() {
			//actual.moverect();
			nextblk.moverect();
			
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			//actual.paint(g);
			for (Block nb : b) 
			nb.paint(g);
		}
		public static void main(String[]args)throws InterruptedException {
		{
			 StackItUp rect=new StackItUp();
			 while(true)
			 {
				rect.move();
				rect.repaint();
				Thread.sleep(20);	 
			 }
		}
	}
}
@SuppressWarnings("serial")
 class Block extends JFrame{
	double vel=2.0;
	int x=0,h=50,y=600,r=255,gn=255,b=255;
	  int w;
	 Block(){
		 int r = (int)(Math.random()*((255+1)));
		 int gn = (int)(Math.random()*((255+1)));
		 int b = (int)(Math.random()*((255+1)));
		//double vel=2.0;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h= h;
		this.vel=2.0;
		this.r=r;
		this.gn=gn;
		this.b=b;
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
	 g.setColor(new Color(r, gn, b)); //apply random value using rand()
		//g.setColor(Color.RED);
	 g.fillRect(x,y,w,h);
	}
	void drop() {
		
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.vel = 0.000;		
		}
	}
	
	/*public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}*/
}