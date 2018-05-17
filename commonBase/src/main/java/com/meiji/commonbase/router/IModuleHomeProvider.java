package com.meiji.commonbase.router;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IModuleHomeProvider extends IProvider {

    String getHomeName(int newsId);
}
