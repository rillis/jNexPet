package com.notify;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Notify {
	private static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	private static DialogNotifier dN = new DialogNotifier();
	private static int h = d.height;
	private static int w = d.width;
	private static int d_w = dN.getWidth();
	private static int d_h = dN.getHeight();
	
	public static void notificar(String title, String msg, int time){
		dN.setBounds(w-d_w,h,d_w,d_h);
		dN.lblTitulo.setText(title);
		dN.txtMsg.setText(msg);
		dN.setVisible(true);
		new Thread(){
			public void run(){
				try{
				for (int i = h; i > (h-40)-d_h; i-=2) {
					dN.setBounds(w-d_w,i,d_w,d_h);
					Thread.sleep(1);
				}
				Thread.sleep(time);
				for (int i = (h-40)-d_h; i < h; i+=2) {
					dN.setBounds(w-d_w,i,d_w,d_h);
					Thread.sleep(1);
				}
				dN.dispose();
				}catch(Exception e){}
			}
		}.start();
	}
	public static void notificar(String title, String msg, int time, int delay){
		dN.setBounds(w-d_w,h,d_w,d_h);
		dN.lblTitulo.setText(title);
		dN.setAlwaysOnTop(true);
		dN.txtMsg.setText(msg);
		dN.setVisible(true);
		new Thread(){
			public void run(){
				try{
					Thread.sleep(delay);
				for (int i = h; i > (h-40)-d_h; i-=2) {
					dN.setBounds(w-d_w,i,d_w,d_h);
					Thread.sleep(1);
				}
				Thread.sleep(time);
				for (int i = (h-40)-d_h; i < h; i+=2) {
					dN.setBounds(w-d_w,i,d_w,d_h);
					Thread.sleep(1);
				}
				dN.dispose();
				}catch(Exception e){}
			}
		}.start();
	}
}
