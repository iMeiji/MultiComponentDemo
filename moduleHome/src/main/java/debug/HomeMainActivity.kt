package debug

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.alibaba.android.arouter.launcher.ARouter
import com.meiji.commonbase.BaseActivity
import com.meiji.commonbase.Constant
import com.meiji.commonbase.router.IModuleHomeProvider
import com.meiji.modulehome.R

/**
 * 此 Activity 用于模块单独调试，需要在 AndroidManifestDebug.xml 里声明
 * 宿主 App 不需要此 Activity，因此不需要在 AndroidManifest.xml 里声明
 */
class HomeMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modulehome_activity_main)

        val home = ARouter.getInstance()
                .build(Constant.Router.toHomeFragment)
                .withString(Constant.EXTRA_KEY, "from HomeMainActivity")
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
                val provider = ARouter.getInstance()
                        .build(Constant.Router.toHomeProvider)
                        .navigation() as IModuleHomeProvider
                Toast.makeText(this, provider.showMsg("from HomeMainActivity"), Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}