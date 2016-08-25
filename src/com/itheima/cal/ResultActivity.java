package com.itheima.cal;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ResultActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		TextView tv_name = (TextView) findViewById(R.id.tv_name);
		TextView tv_sex = (TextView) findViewById(R.id.tv_sex);
		TextView tv_result = (TextView) findViewById(R.id.tv_result);
		
		Intent intent = getIntent();
		String name = intent.getStringExtra("name");//获取姓名
		int sex = intent.getIntExtra("sex",0);//获取性别
		tv_name.setText(name);
		
		byte[] bytes = null;
		try {
			switch (sex) {
			case 1:
				tv_sex.setText("男");
				bytes = name.getBytes("gbk");
				break;
			case 2:
				tv_sex.setText("女");
				bytes = name.getBytes("utf-8");
				break;
			case 3:
				tv_sex.setText("人妖");
				bytes = name.getBytes("iso-8859-1");
				break;

			default:
				break;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//根据姓名和性别显示得分结果
		
		int total = 0;
		for(byte b :bytes){
			int number = b&0xff;
			total += number;
		}
		
		int score = Math.abs(total)%100;
		if (score>90) {
			tv_result.setText("您的人品太好了  您家的祖坟都冒青烟了");
		}else if (score>70) {
			tv_result.setText("有你这样的人品算不错了...");
		}else if (score>60) {
			tv_result.setText("您的人品刚刚及格...");
		}else if (score<60) {
			tv_result.setText("你小时候被雷劈过吗");
		}
		
		
		
	}
	
	
}
