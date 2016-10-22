package com.nexpetapp;
import static com.nexpetapp.Functions.*;

import java.io.File;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class Main {

	public static void main(String[] args) {
		//Intro
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
					File f = new File("config.np");
					if(f.exists()){
						ArrayList<String> a = new Functions().read(f);
						new Login().login(a.get(0),a.get(1), false);
					}else{
						new Login().setVisible(true);
					}

				}catch(Exception e){}
			}
		}.start();
	}

}
