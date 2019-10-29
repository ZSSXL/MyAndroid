package com.zss.mysqlitedemo;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCreateDB; //创建数据库按钮
    TextView tbShowResult;//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tbShowResult = (TextView)findViewById(R.id.tvShowResult);
        btnCreateDB = (Button)findViewById(R.id.createDatabase);
        btnCreateDB.setOnClickListener(new CreateListener());
    }

    class CreateListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            StuDBHelper dbHelper = new StuDBHelper(MainActivity.this,"stu_db",null,1);
            //得到一个刻度的SQLiteDataBase对象
//            SQLiteDatabase db = new dbHelper.getReadableDatabase();
            String strResult = "创建数据库stu_db成功";


        }
    }
}
