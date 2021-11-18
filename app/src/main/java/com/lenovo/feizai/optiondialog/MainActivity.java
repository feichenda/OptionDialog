package com.lenovo.feizai.optiondialog;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lenovo.feizai.optiondialog.customView.OptionButton;
import com.lenovo.feizai.optiondialog.listen.ButtonOnClickListener;

/**
 * Author:feizai
 * Date:2021/11/18-0018 上午 09:20:12
 * Describe:
 */
public class MainActivity extends AppCompatActivity {

    private Context context;
    private OptionDialog dialog;
    private Button shooting;
    private OptionButton shoot, select, ok;
    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        dialog = new OptionDialog(context);
        findView();
    }

    private void findView() {
        shooting = findViewById(R.id.shooting);
    }

    @Override
    protected void onStart() {
        super.onStart();
        shoot = new OptionButton(context, "shoot", (view) -> {
            Log.i(TAG, "shoot");
        });
        select = new OptionButton(context, "select", (view) -> {
            Log.i(TAG, "select");
        });
        ok = new OptionButton(context, "ok", (view) -> {
            Log.i(TAG, "ok");
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        shooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.addButton(shoot, select, ok);
//                dialog.setCancelButtonLinter((view) -> {
//                    Log.i(TAG, "cancel");
//                    dialog.dismisss();
//                });
                dialog.show();
            }
        });
    }
}
