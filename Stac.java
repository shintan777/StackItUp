package com.mini.project;

import javax.swing.*;
import java.awt.*;
import java.util.*;

@SuppressWarnings({ "serial", "unused" })
class Stac extends JFrame{
	int x=0,y=600,w=250,h=50;
	double vel=2.0;
	private void moverect()
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
	private void nextrect()
	{
	x=600;
	y+=50;	
	}
			
		Stac()
		{
			super("StackItUp!!!");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(30,30,720,720);
			//setSize(720,720);
			setBackground(Color.darkGray);
			setResizable(false);
			setVisible(true);
			}
	@Override
			public void paint(Graphics g)
			{
			 super.paint(g);
			 //Graphics2D g2d = (Graphics2D) g;
			 g.setColor(Color.RED); 
			 g.fillRect(x,y,w,h);
			}
					
		public static void main(String[]args)throws InterruptedException {
		{
			 Stac rect=new Stac();
			 while(true)
			 {
				rect.moverect();
				rect.repaint();
				Thread.sleep(15);	 
			 }
		}
	}



}