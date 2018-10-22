import java.awt.event.KeyEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
	Block blk =new Block();
	Block nextblk =new Block();
	Block temp =new Block();
	Block temp2 =new Block();
	ArrayList<Block> b = new ArrayList<Block>();
	

	StackItUp()
	{
    super("StackItUp");
	JLabel background;
	ImageIcon img = new ImageIcon("sal.jpg");
	background = new JLabel("",img,JLabel.CENTER);
	background.setBounds(0,0,720,720);
	add(background);
	
	JPanel newPanel = new JPanel();
	newPanel.setBackground(Color.BLACK);
	JLabel  t1 = new JLabel();
	t1.setBounds(10,10,50,50);
	t1.setForeground(Color.WHITE);
		newPanel.add(t1);
		add(newPanel);
		

		File bg =  new File(".//bg.wav");
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(bg);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			
		
		
		} catch(Exception e) {System.out.println(e);}

       
			addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}			
			@Override
			public void keyPressed(KeyEvent e) {
				if(width>0)
				{	
				
					b.add(new Block());
					nextblk = b.get(cntr);
					nextblk.w=width;
					if(cntr>0)
					{	temp=b.get(cntr-1);
				        x1=temp.x;
						xe1=temp.x+temp.w;
						System.out.println(x1+"  "+xe1);
						if(cntr>1)
						{temp2=b.get(cntr-2);
				        x2=temp2.x;
						xe2=temp2.x+temp2.w;
						System.out.println(x2+"  "+xe2);
						System.out.println("  \n");
					if(x1<=x2&&xe1>=x2)
					{
						diff=x2-x1;
						//blk=b.get(cntr-2);
						//blk.x=x2;
						
						}
			        else if(x1<=x2&&xe1<x2)	
					{
						diff=width;
						
					}
					else if(x1>x2&&x1<=xe2)	
					{
						diff=xe1-xe2;
						
					}
					else if(x1>x2&&x1>xe2){
						diff=width;
					}
					
						}
					
					
					width-=diff;	
					}
					if(cntr<10)	
					nextblk.y-=nextblk.h*cntr;
				else {
					nextblk.y-=500;
				drop();
					}
					
					
					cntr++;
					t1.setText("SCORE :  "+(cntr-1));
			}
			else
			{
				t1.setText("GAME OVER YOUR SCORE:"+(cntr-1));
				
			}
			}
		});
			

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720,720);
	    setResizable(false);
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
 class Block extends JFrame{
	double vel=2.0;
	int x,w,h=50,y=650,r=255,gn=255,b=255;

	 Block(){
		 int r = (int)(Math.random()*((255+1)));
		 int gn = (int)(Math.random()*((255+1)));
		 int b = (int)(Math.random()*((255+1)));
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

	 g.setColor(new Color(r, gn, b));

	 g.fillRect(x,y,w,h);
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.vel = 0.000;		
		}
	}
}



//w-=cum_diff
//cum_diff+=diff