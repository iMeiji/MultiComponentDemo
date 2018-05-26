package com.meiji.multicomponentdemo;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.meiji.commonbase.BaseActivity;
import com.meiji.commonbase.Constant;
import com.meiji.commonbase.router.IModuleHomeProvider;

/**
 * App 主界面
 */
public class AppMainActivity extends BaseActivity {

    private FrameLayout mFrameLayout;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                // UI 跳转
                Fragment home = (Fragment) ARouter.getInstance()
                        .build(Constant.Router.toHomeFragment)
                        .withString(Constant.EXTRA_KEY, "from AppMainActivity")
                        .navigation();
                if (home != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, home).commit();
                }
                return true;
            case R.id.navigation_dashboard:
                Fragment dash = (Fragment) ARouter.getInstance()
                        .build(Constant.Router.toDashFragment)
                        .withString(Constant.EXTRA_KEY, "from AppMainActivity")
                        .navigation();
                if (dash != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, dash).commit();
                }
                return true;
            case R.id.navigation_notifications:
                Fragment noti = (Fragment) ARouter.getInstance()
                        .build(Constant.Router.toNotiFragment)
                        .withString(Constant.EXTRA_KEY, "from AppMainActivity")
                        .navigation();
                if (noti != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, noti).commit();
                }
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
        navigation.setSelectedItemId(R.id.navigation_home);
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
                // 调用组件某个类的方法
                IModuleHomeProvider o = (IModuleHomeProvider) ARouter.getInstance()
                        .build(Constant.Router.toHomeProvider)
                        .navigation();
                if (o != null) {
                    String homeName = o.showMsg("from AppMainActivity");
                    Toast.makeText(this, homeName, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
