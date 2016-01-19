package com.asmt.listngrid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class SplashScreen extends Activity {

	TextView count;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splashscreen);
		count = (TextView)findViewById(R.id.txtCountDown);	
		
		
		new CountDownTimer(4000, 1000) {

		     public void onTick(long millisUntilFinished) {
		    	 count.setText(""+millisUntilFinished / 1000);
		     }

		     public void onFinish() {
		    	 count.setText("");
		     }
		  }.start();
		  
		Thread timerThread = new Thread(){
			public void run(){
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//count.setText("OK");
				Message msgObj = handler.obtainMessage();
				Bundle b = new Bundle();
				b.putString("status", "OK");
				msgObj.setData(b);
				handler.sendMessage(msgObj);
				
				
			}		
			public final Handler handler = new Handler(){
				public void handleMessage(Message ms){
					String aResponse = ms.getData().getString("status");	
					count.setText(aResponse);
					Intent intent = new Intent(SplashScreen.this,MainActivity.class);
					startActivity(intent);
					SplashScreen.this.finish();
				}
			};
			};
			timerThread.start();
		
	}

}
