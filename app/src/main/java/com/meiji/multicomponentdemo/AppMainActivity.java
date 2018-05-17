package com.meiji.multicomponentdemo;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.meiji.commonbase.RouterConstant;
import com.meiji.commonbase.router.IModuleHomeProvider;

public class AppMainActivity extends AppCompatActivity {

    private FrameLayout mFrameLayout;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Fragment home = (Fragment) ARouter.getInstance()
                        .build(RouterConstant.toHomeFragment)
                        .withString("key", "from AppMainActivity")
                        .navigation();
                if (home != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, home).commit();
                }
                return true;
            case R.id.navigation_dashboard:
                Fragment dash = (Fragment) ARouter.getInstance()
                        .build(RouterConstant.toDashFragment)
                        .withString("key", "from AppMainActivity")
                        .navigation();
                if (dash != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, dash).commit();
                }
                return true;
            case R.id.navigation_notifications:
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);
        initView();
    }

    private void initView() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mFrameLayout = findViewById(R.id.frameLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_toHomeProvider:
                IModuleHomeProvider o = (IModuleHomeProvider) ARouter.getInstance().build(RouterConstant.toHomeProvider).navigation();
                if (o != null) {
                    String homeName = o.getHomeName(233);
                    Toast.makeText(this, homeName, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
