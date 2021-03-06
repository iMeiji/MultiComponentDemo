package com.meiji.moduledashboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.meiji.commonbase.Constant;


/**
 * 模块页面
 */
@Route(path = Constant.Router.toDashFragment)
public class DashFragment extends Fragment {

    private TextView mTextView;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.moduledashboard_fragment_dash, container, false);
        initView(v);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mTextView.setText(mTextView.getText() + "\n"
                    + "get getArguments = " + bundle.getString(Constant.EXTRA_KEY));
        }
        return v;
    }

    private void initView(View v) {
        mTextView = v.findViewById(R.id.module_dash_textView);
    }
}
