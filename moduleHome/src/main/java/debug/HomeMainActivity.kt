package debug

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.meiji.commonbase.BaseActivity
import com.meiji.commonbase.RouterConstant
import com.meiji.commonbase.router.IModuleHomeProvider
import com.meiji.modulehome.R

@Route(path = RouterConstant.toHomeMainActivity)
class HomeMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modulehome_activity_main)

        val home = ARouter.getInstance()
                .build(RouterConstant.toHomeFragment)
                .withString("key", "from HomeMainActivity")
                .navigation() as Fragment
        supportFragmentManager.beginTransaction().replace(R.id.module_home_framelayout, home).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.common_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_toHomeProvider -> {
                val provider = ARouter.getInstance().build(RouterConstant.toHomeProvider).navigation() as IModuleHomeProvider
                Toast.makeText(this, provider.getHomeName(233), Toast.LENGTH_SHORT).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}