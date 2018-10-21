import java.awt.event.KeyEvent;
//javac StackItUp.java
//java StackItUp
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.JPanel;

@SuppressWarnings({ "serial" })
class StackItUp extends JFrame{
	static int cntr=0,t=0;
	int i,x1,x2,diff,xe1,xe2,width=250,yc=650;
	Block nextblk =new Block();
	Block temp =new Block();
	ArrayList<Block> b = new ArrayList<Block>();
	
	//JPanel panel;
	
	StackItUp()
	{
    super("StackItUp");
	
	JPanel newPanel = new JPanel();
	newPanel.setBackground(Color.BLACK);
	JLabel  t1 = new JLabel();
	t1.setBounds(10,10,50,50);
	t1.setForeground(Color.WHITE);
		newPanel.add(t1);
		add(newPanel);
		
       
			addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}			
			@Override
			public void keyPressed(KeyEvent e) {
				if(cntr<10)		
				{	
					b.add(new Block());
					nextblk = b.get(cntr);
					nextblk.w=width;
					//xpos2=nextblk.x;
					cntr++;
					t1.setText("SCORE :  "+cntr);//score needs to be corrected
					nextblk.y-=nextblk.h*cntr;
				
				}
				else {
					
					b.add(new Block());
					Block temp = b.get(b.size()-1);
					//temp.y+=temp.h;
					nextblk =temp;
					t1.setText("SCORE :  "+(cntr-1));//score needs to be corrected
					//nextblk.y-=nextblk.h*cntr;
					nextblk.y-=550;
					nextblk.w=width;
					cntr++;
					drop();
				}
			}
		});
			
			//setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720,720);
	    setResizable(false);
	    
		//getContentPane().setBackground(Color.BLACK);
		setVisible(true);
    
		
		
		
		}
			
		public void move() {
			nextblk.moverect();
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			for (Block nb : b) 
				nb.paint(g);
		}
		void drop()
		{ 	for (Block nb : b)
				{nb.y+=nb.h;
				}
		}
		
		/*public static void PlaySound(File Sound)
		{
			try{
				Clip clip = AudioSystem.getClip();
				clip.open(AudioSystem.getAudioInputStream(Sound));
				clip.start();
				
				Thread.sleep(clip.getMicrosecondLength()/1000);
				
			}catch(Exception e)
			{
				
			}
		}
*/
		
		
		public static void main(String[]args)throws InterruptedException {
		{  
		//JFrame frame = new JFrame();
		
	    
		StackItUp rect=new StackItUp();
		//JPanel panel = (JPanel) frame.getContentPane();
		//panel.setLayout(null);
		//JLabel  t1 = new JLabel();
		
			 
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
	int x,w,h=50,y=650,r=255,gn=255,b=255;
	//int x,w,h=50,y=650,r,gn,b;
	 Block(){
		 int r = (int)(Math.random()*((255+1)));
		 int gn = (int)(Math.random()*((255+1)));
		 int b = (int)(Math.random()*((255+1)));
		//double vel=2.0;
		this.x=x;
		this.y=y;
		this.w=w;
		this.h= h;
		this.vel=vel;
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
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.vel = 0.000;		
		}
	}
}