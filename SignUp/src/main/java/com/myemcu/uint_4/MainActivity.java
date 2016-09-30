package com.myemcu.uint_4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText user,psd1;
    private RadioGroup sex;
    private RadioButton radio;
    private Spinner spinner;
    private CheckBox car,house,gnd;

    private String str_user;
    private String str_psd1;
    private String str_radio;
    private String[] spinner_str;
    private String str_xueli;
    private String str_car,str_house,str_gnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        user = (EditText) findViewById(R.id.user);
        psd1 = (EditText) findViewById(R.id.psd1);

        // 监听单选组
        sex = (RadioGroup) findViewById(R.id.sex);
        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radio = (RadioButton) findViewById(checkedId);
            }
        });

        // 监听列表框
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner_str=getResources().getStringArray(R.array.xueli);
                str_xueli=spinner_str[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 监听复选框——买车
        car = (CheckBox) findViewById(R.id.car);
        car.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (car.isChecked()) {
                    str_car=buttonView.getText().toString();
                }
            }
        });

        // 监听复选框——买房
        house = (CheckBox) findViewById(R.id.house);
        house.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (house.isChecked()) {
                    str_house=buttonView.getText().toString();
                }
            }
        });

        // 监听复选框——买地
        gnd = (CheckBox) findViewById(R.id.gnd);
        gnd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (gnd.isChecked()) {
                    str_gnd=buttonView.getText().toString();
                }
            }
        });
    }

    public void btn_Click(View v) {

        /*Toast.makeText(this,spinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();*/

        str_user=user.getText().toString();
        str_psd1=psd1.getText().toString();
        str_radio=radio.getText().toString();

        Intent intent = new Intent(this,LoginActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("username",str_user);
        bundle.putString("password",str_psd1);
        bundle.putString("sex",str_radio);
        bundle.putString("xueli",str_xueli);
        if (car.isChecked())
            bundle.putString("car",str_car);
        if (house.isChecked())
            bundle.putString("house",str_house);
        if (gnd.isChecked())
            bundle.putString("gnd",str_gnd);
        intent.putExtras(bundle);

        // Activity跳转
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
