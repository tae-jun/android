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

		builder.setTitle("�ȳ�");
		builder.setMessage("�����Ͻðڽ��ϱ�?");

		// �� ��ư ����
		builder.setPositiveButton("��", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				msg = "�� ��ư�� �������ϴ�. " + Integer.toString(whichButton);
				txt.setText(msg);
			}
		});

		// ��� ��ư ����
		builder.setNeutralButton("���", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				msg = "��� ��ư�� ���Ƚ��ϴ�. " + Integer.toString(whichButton);
				txt.setText(msg);
			}
		});

		// �ƴϿ� ��ư ����
		builder.setNegativeButton("�ƴϿ�", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				msg = "�ƴϿ� ��ư�� ���Ƚ��ϴ�. " + Integer.toString(whichButton);
				txt.setText(msg);
			}
		});

		// ���� ��ü�� create() �޼ҵ� ȣ���ϸ� ��ȭ���� ��ü ����
		AlertDialog dialog = builder.create();

		return dialog;
	}
}