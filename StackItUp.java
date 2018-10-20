import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;
import java.io.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

@SuppressWarnings({ "serial" })
class StackItUp extends JFrame{
	static int cntr=0,t=0;
	int i;
	JLabel  t1;
	Block nextblk =new Block();
	ArrayList<Block> b = new ArrayList<Block>();
	
		StackItUp()
		{super("StackItUp!!!");
			   
		
				t1 = new JLabel() ;
				t1.setLocation(0,0) ; 

				addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
				}
				@Override
				public void keyReleased(KeyEvent e) {
				}			
				@Override
				public void keyPressed(KeyEvent e) {
					b.add(new Block());
					System.out.println(b.size());
					nextblk = b.get(cntr);
					cntr++;
					t1.setText("SCORE :  "+cntr);
					nextblk.y-=nextblk.h*cntr;
					//if(cntr>=8) nextblk.drop();
					actual=nextblk;
					//sound();
				}
			});
			setFocusable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(720,720);
			setResizable(false);
			setVisible(true);
			add(t1);
			}
			
		public void move() {
			nextblk.moverect();
			
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			for (Block nb : b) 
			nb.paint(g);
		}
		public static void main(String[]args)throws InterruptedException {
		{
			 StackItUp rect=new StackItUp();
			 File Sal= new File("Sal.wav"); 
	         	PlaySound(Sal);
			 while(true)
			 {
				rect.move();
				rect.repaint();
				Thread.sleep(15);	 
			 }
		}
	}
}
/*class Sound
{
	
public static class AL implements ActionListener{
	public final void actionPerformed(ActionEvent e)
	{
		sound();
	}
}
	
public static void sound(){
	
	AudioPlayer MGP = AudioPlayer.player;
	AudioStream BGM;
	AudioData MD;
ContinousAudioDataStream loop=null;

try{
BGM =new AudioStream(new FileInputStream("Sound.wav"));
MD =BGM.getData();
loop= new ContinousAudioDataStream(MD);
}catch(IOException error){}
	
	MGP.start(loop);
}

}*/
class Music
{
	
	static void PlaySound(File Sound)
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
}
@SuppressWarnings("serial")
 class Block extends JFrame{
	double vel=2.0;
	int x=0,w=250,h=50,y=600,r=255,gn=255,b=255;
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
}
