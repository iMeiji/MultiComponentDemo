package com.meiji.modulehome;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.meiji.commonbase.Constant;
import com.meiji.commonbase.router.IModuleHomeProvider;

/**
 * 模块服务，其他组件通过 IModuleHomeProvider 接口来调用服务
 */
@Route(path = Constant.Router.toHomeProvider)
public class HomeProvider implements IModuleHomeProvider {
    @Override
    public String showMsg(String msg) {

        return msg;
    }

    @Override
    public void init(Context context) {

    }
}
