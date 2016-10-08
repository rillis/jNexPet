package com.nexpetapp;

public class Main {

	public static void main(String[] args) {
		Intro i = new Intro();
		i.setOpacity(0f);
		i.setVisible(true);
		new Thread(){
			public void run(){
				try{
					for (float j = 0f; j < 1f; j += 0.01f) {
						i.setOpacity(j);
						Thread.sleep(10);
					}
					Thread.sleep(1500);
					for (float j = 1f; j > 0f; j -= 0.01f) {
						i.setOpacity(j);
						Thread.sleep(10);
					}
					i.dispose();
				}catch(Exception e){}
			}
		}.start();
	}

}
