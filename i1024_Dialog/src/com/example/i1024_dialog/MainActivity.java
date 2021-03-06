package com.example.i1024_dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button btnShow;
	TextView txt;
	String msg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnShow = (Button) findViewById(R.id.btnShow);
		txt = (TextView) findViewById(R.id.txt);

		btnShow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				AlertDialog dialog = createDialogBox();
				dialog.show();
			}
		});
	}

	private AlertDialog createDialogBox() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("안내");
		builder.setMessage("종료하시겠습니까?");

		// 예 버튼 설정
		builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				msg = "예 버튼이 눌렀습니다. " + Integer.toString(whichButton);
				txt.setText(msg);
			}
		});

		// 취소 버튼 설정
		builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				msg = "취소 버튼이 눌렸습니다. " + Integer.toString(whichButton);
				txt.setText(msg);
			}
		});

		// 아니오 버튼 설정
		builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				msg = "아니오 버튼이 눌렸습니다. " + Integer.toString(whichButton);
				txt.setText(msg);
			}
		});

		// 빌더 객체의 create() 메소드 호출하면 대화상자 객체 생성
		AlertDialog dialog = builder.create();

		return dialog;
	}
}
