package debug;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;
import com.meiji.commonbase.BaseActivity;
import com.meiji.commonbase.Constant;
import com.meiji.modulenotifications.R;

/**
 * 此 Activity 用于模块单独调试，需要在 AndroidManifestDebug.xml 里声明
 * 宿主 App 不需要此 Activity，因此不需要在 AndroidManifest.xml 里声明
 */
public class NotiMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulenotifications_activity_main);
        Fragment fragment = (Fragment) ARouter.getInstance()
                .build(Constant.Router.toNotiFragment)
                .withString(Constant.EXTRA_KEY, "from NotiMainActivity")
                .navigation();
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.module_noti_framelayout, fragment)
                    .commit();
        }
    }
}
