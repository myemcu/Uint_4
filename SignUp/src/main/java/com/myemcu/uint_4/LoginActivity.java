package com.myemcu.uint_4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class LoginActivity extends AppCompatActivity{

    private TextView user,psd,sexy,xueli,aihao;
    private String rec_user,rec_psd,rec_sex,rec_xueli,rec_car,rec_house,rec_gnd;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);    // 布局文件必须用小写

        user = (TextView) findViewById(R.id.user);
        psd = (TextView) findViewById(R.id.psd);
        sexy = (TextView) findViewById(R.id.sexy);
        xueli = (TextView) findViewById(R.id.xueli);
        aihao = (TextView) findViewById(R.id.aihao);

        Bundle bundle = this.getIntent().getExtras();
        rec_user=bundle.getString("username");
        rec_psd=bundle.getString("password");
        rec_sex=bundle.getString("sex");
        rec_xueli=bundle.getString("xueli");
        rec_car=bundle.getString("car","");
        rec_house=bundle.getString("house","");
        rec_gnd=bundle.getString("gnd","");

        user.setText(rec_user);
        psd.setText(rec_psd);
        sexy.setText(rec_sex);
        xueli.setText(rec_xueli);
        aihao.setText(rec_car+" "+rec_house+" "+rec_gnd+" ");
    }
}
