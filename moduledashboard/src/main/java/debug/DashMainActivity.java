package debug;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.meiji.commonbase.RouterConstant;
import com.meiji.moduledashboard.R;


public class DashMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduledashboard_activity_main);
        Fragment fragment = (Fragment) ARouter.getInstance()
                .build(RouterConstant.toDashFragment)
                .withString("key", "from DashMainActivity")
                .navigation();
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.module_dash_framelayout, fragment)
                    .commit();
        }
    }
}
