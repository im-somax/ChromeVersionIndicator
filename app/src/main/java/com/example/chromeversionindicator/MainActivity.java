package com.example.chromeversionindicator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        List<PackageInfo> packages = getPackageManager().getInstalledPackages(PackageManager.GET_META_DATA);

        PackageInfo pinfo = null;
        try
        {
            pinfo = getPackageManager().getPackageInfo("com.android.chrome",0);
        }catch(PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        try {
            long verCode = pinfo.versionCode;
            //getVersionName is Deprecated, instead use versionName
            String verName = pinfo.versionName;
            textView.setText(verName);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}