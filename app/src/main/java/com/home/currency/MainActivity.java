package com.home.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText ed_ntd;
    private TextView tv_result_jp;
    private TextView tv_result_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

    }

    private void findViews() {
        ed_ntd = findViewById(R.id.ed_ntd);
        tv_result_jp = findViewById(R.id.tv_result_jp);
        tv_result_us = findViewById(R.id.tv_result_us);
    }

    public void go(View view){

        if (ed_ntd.getText().toString().equals("")){
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.enter_ntd)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        }else {

        float ntd = Float.parseFloat(ed_ntd.getText().toString());
        float result = ntd / 30.9f;
        float result2 = ntd / 0.28f;
            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.usd_is) + result)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ed_ntd.setText("");
                        }
                    })
                    .show();
            tv_result_us.setText(getString(R.string.result)+result);
            tv_result_jp.setText(getString(R.string.result)+result2);
        }

    }
}