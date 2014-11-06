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
 * 리스트뷰를 사용하는 방법에 대해 알 수 있습니다.
 * 
 * @author Mike
 * 
 */
public class MainActivity extends Activity {

	/**
	 * 리스트뷰 객체
	 */
	ListView list;

	/**
	 * 어댑터 객체
	 */
	IconTextListAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 타이틀 없애기
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);

		// 리스트뷰 객체 참조
		list = (ListView) findViewById(R.id.listview);

		// 어댑터 객체 생성
		adapter = new IconTextListAdapter(this);

		// 아이템 데이터 만들기
		Resources res = getResources();

		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.i1),
				"Twitter", "트위터", ""));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.i2),
				"Facebook", "페이스북", ""));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.i3),
				"Google+", "구글플러스", ""));
		adapter.addItem(new IconTextItem(res.getDrawable(R.drawable.i4),
				"Apple", "애플", ""));

		// 리스트뷰에 어댑터 설정
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
