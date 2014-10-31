package org.androidtown.ui.listview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

/**
 * ����Ʈ�並 ����ϴ� ����� ���� �� �� �ֽ��ϴ�.
 * 
 * @author Mike
 * 
 */
public class MainActivity extends Activity {

	/**
	 * ����Ʈ�� ��ü
	 */
	ListView list;

	/**
	 * ����� ��ü
	 */
	IconTextListAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Ÿ��Ʋ ���ֱ�
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);

		// ����Ʈ�� ��ü ����
		list = (ListView) findViewById(R.id.listview);

		// ����� ��ü ����
		adapter = new IconTextListAdapter(this);

		// ������ ������ �����
		Resources res = getResources();

		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.i1),
				"Twitter", "Ʈ����", ""));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.i2),
				"Facebook", "���̽���", ""));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.i3),
				"Google+", "�����÷���", ""));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.i4),
				"Apple", "����", ""));

		// ����Ʈ�信 ����� ����
		list.setAdapter(adapter);

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				IconTextItem curItem = (IconTextItem) adapter.getItem(position);
				String[] curData = curItem.getData();

				String url = "http://";
				switch (curData[0]) {
				case "Twitter":
					url += "www.twitter.com";
					break;
				case "Facebook":
					url += "www.facebook.com";
					break;
				case "Google+":
					url += "plus.google.com";
					break;
				case "Apple":
					url += "www.apple.com";
					break;
				}

				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
						.parse(url));
				startActivity(browserIntent);
			}
		});

	}

}
