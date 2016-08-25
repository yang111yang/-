package com.itheima.cal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_name;
	private RadioGroup rg_group;
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		et_name = (EditText) findViewById(R.id.et_name);
		rg_group = (RadioGroup) findViewById(R.id.rg_group);
	}

	// 点击按钮，跳转页面
	public void click(View v) {

		// 获取姓名
		String name = et_name.getText().toString().trim();

		if (TextUtils.isEmpty(name)) {
			Toast.makeText(mContext, "用户名不能为空", Toast.LENGTH_LONG).show();
			return;
		}

		// 判断性别
		int checkedRadioButtonId = rg_group.getCheckedRadioButtonId();
		// 判断选中的性别的id
		int sex = 0;
		switch (checkedRadioButtonId) {
		case R.id.rb_male:// 选中的是男
			sex = 1;
			
			break;
		case R.id.rb_female:// 选中的是女
			sex = 2;
			break;
		case R.id.rb_other:// 选中的是人妖
			sex = 3;
			break;

		default:
			break;
		}
		
		if (sex==0) {
			Toast.makeText(mContext, "亲 请选择性别", 0).show();
			return;
		}
		
		//跳转页面
		Intent intent = new Intent(mContext,ResultActivity.class);
		//底层是一个HashMap
		intent.putExtra("name", name);
		intent.putExtra("sex", sex);
		
		startActivity(intent);
		
	}

}
