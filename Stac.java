package com.mini.project;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;

@SuppressWarnings({ "serial", "unused" })
class Stac extends JFrame{
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
			      //blk.keyReleased(e);
				}
				@Override
				public void keyPressed(KeyEvent e) {
					blk.keyPressed(e);
					nblk.nextrect();
				/*	if(blk.cntr>=1)
					{nblk.keyPressed(e);
				}*/}
			});
			setFocusable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(30,30,720,720);
			setBackground(Color.darkGray);
			setResizable(false);
			setVisible(true);
			
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
	int x,w,h,cntr,y;
	double vel=2.0;
	Block(){
		int x=0,w=250,h=50,cntr=0,y=600;
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
	{	cntr+=1;
	System.out.println(cntr);
		y-=2*h;
		
	}
	public void drop(){
		
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
