package com.haoroid.mylocationprovider;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/10/15.
 */
public class MySharePreferences extends Activity {
    EditText edit1,edit2;Button btn,btn2;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysharepreferences);
        edit1= (EditText)findViewById(R.id.editText);
        edit2 = (EditText)findViewById(R.id.editText2);
        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        MySharedPreferences.stuSaveSharePreferences(MySharePreferences.this, "cookie456", "大超哥", "http:///222", "0", "15520836821", "1", "2015-7-24");
        MySharedPreferences saveAndRead = new MySharedPreferences(MySharePreferences.this,"login");
        edit1.setText(saveAndRead.getCookie());
        edit2.setText(saveAndRead.getAvatar() + "///" + saveAndRead.getNickname() + "//" + saveAndRead.getStart_point());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "2015.10.24";
                Toast.makeText(MySharePreferences.this,DateToWeekUtils.dateToWeek(s)+"//"+s,Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySharedPreferences.teacherSaveSharePreferences(MySharePreferences.this,"cookie123","超哥","http:///111","1","15520836851","0","2015-2-24"
                        ,"犀浦","电子科大,西南交大","人民公园","1,3,5","23:58","1");
                MySharedPreferences.personalSaveSharePreferences(MySharePreferences.this, "cookie456", "小超哥", "http:///222", "0", "15520836821", "1", "2015-7-24"
                        , "犀浦地铁", "电子科大2,西南交大2", "人民公园2", "1,3,5,6", "23:45", "0");
                MySharedPreferences.stuSaveSharePreferences(MySharePreferences.this, "cookie456", "小超哥", "http:///222", "0", "15520836821", "1", "2015-7-24");
            }
        });
    }

    boolean isfinished;
    @Override
    protected void onStop() {
        super.onStop();
        if (!isfinished)
        {
            Toast.makeText(MySharePreferences.this,"按下home键",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void finish() {
        super.finish();
        isfinished = true;
    }
}
