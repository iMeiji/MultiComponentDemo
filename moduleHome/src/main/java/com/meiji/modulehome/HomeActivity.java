package com.meiji.modulehome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.meiji.commonbase.BaseActivity;

/**
 * 此 Activity 用于正式生产环境，需要在 AndroidManifestDebug.xml 和 AndroidManifest.xml 里声明
 */
public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "HomeActivity", Toast.LENGTH_SHORT).show();
    }
}
