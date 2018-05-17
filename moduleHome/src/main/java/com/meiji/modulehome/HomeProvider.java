package com.meiji.modulehome;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.meiji.commonbase.RouterConstant;
import com.meiji.commonbase.router.IModuleHomeProvider;

@Route(path = RouterConstant.toHomeProvider)
public class HomeProvider implements IModuleHomeProvider {
    @Override
    public String getHomeName(int newsId) {

        return getClass().getSimpleName() + " " + newsId;
    }

    @Override
    public void init(Context context) {

    }
}
