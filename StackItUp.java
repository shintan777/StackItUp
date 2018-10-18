import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.Random;

@SuppressWarnings({ "serial", "unused" })
class StackItUp extends JFrame{
	static int cntr=0,t=0;
	int i;
	JLabel  t1;
	Random r=new Random();
	

	Block actual =new Block();
	Block nextblk =new Block();
	
	
		StackItUp()
		{
			   
		super("StackItUp!!!");
				t1 = new JLabel() ;
			t1.setBounds(200,100,50,30) ; 
			
			

ArrayList<Block> b = new ArrayList();
for( i=0;i<30;i++)
{
	Block blk= new Block();
	blk.y-=blk.h;
	blk.x=0;
	
	b.add(blk);
	
}
//actual=b.get(0);
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
					cntr++;
				nextblk=b.get(t++);
				
				//nextblk.nextrect();
				t1.setText("SCORE :  "+cntr);
					
				
				}
			});
			setFocusable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(720,720);
			
			//setBackground(Color.red);
			
			setResizable(false);
			setVisible(true);
			add(t1);
		for(int i=0;i<30;i++)
		{
			Block[i]=new Block(i,r.nextInt(255),r.nextInt(255),r.nextInt(255));
		}

			
			}
			
		public void updateColors(){
		for(int i=0;i<30;i++)
		{
			Block[i].setColor(r.nextInt(255),r.nextInt(255),r.nextInt(255));
		}	
		}
		
	    public void actionPerformed(ActionEvent arg0)
		{
			updateColors();
		}
			
		public void move() {
			actual.moverect();
			nextblk.moverect();
			
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			actual.paint(g);
		nextblk.paint(g);
		for(int i=0;i<30;i++)
		{
			Block[i].draw(g);
		}
		
			
		}
		public static void main(String[]args)throws InterruptedException {
		{
			 StackItUp rect=new StackItUp();
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
 class Block extends JFrame {
	double vel=2.0;
	int x=0,w=250,h=50,y=600,R,G,B;
	 Block(int R,int G,int B){
		double vel=2.0;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h= h;
		this.vel=vel;
		this.R=R;
		this.G=G;
		this.B=B;
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
	 g.setColor(new Color(R,G.B)); 
	 g.fillRect(x,y,w,h);
	}
	
	public void setColor(int R,int G,int B)
	{
		this.R=R;
		this.G=G;
		this.B=B;
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			vel = 0;		
		}
	}
}