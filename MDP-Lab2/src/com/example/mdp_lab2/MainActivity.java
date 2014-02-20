package com.example.mdp_lab2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.mdp_lab2.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("g54mdp", "MainActivity onCreate");

		final Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				final EditText textBox = (EditText) findViewById(R.id.editText1);
				Log.d("g54mdp", "test Button clicked");
				sendTextToSecondActivity(textBox.getText().toString());
			}
		});
	}

	protected void sendTextToSecondActivity(String string) {
		Intent intent = new Intent(this, SecondActivity.class);
		intent.putExtra(EXTRA_MESSAGE, string);
		startActivityForResult(intent, 1);
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		// if (requestCode == 1) {

		if (resultCode == RESULT_OK) {
			String result = data.getStringExtra("result");
			final TextView textView = (TextView) findViewById(R.id.textView1);
			textView.setText("test");
			Log.d("g54mdp", "Result returned");
		}
		if (resultCode == RESULT_CANCELED) {
			Log.d("g54mdp", "No result returned");
		}
		// }
	}// onActivityResult

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("g54mdp", "MainActivity onDestroy");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("g54mdp", "MainActivity onPause");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.d("g54mdp", "MainActivity onResume");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
