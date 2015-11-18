package com.example.sampletokenviewlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	TokenLayout tokenLayout;
	int num = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tokenLayout = (TokenLayout)findViewById(R.id.token_layout);
		Button btn = (Button)findViewById(R.id.btn_add);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView tv = (TextView)getLayoutInflater().inflate(android.R.layout.simple_list_item_1, tokenLayout, false);
				tv.setText("dynamic text " + num++);
				tokenLayout.addView(tv, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
			}
		});

		btn = (Button)findViewById(R.id.btn_remove);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int count = tokenLayout.getChildCount();
				tokenLayout.removeViewAt(count - 1);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
