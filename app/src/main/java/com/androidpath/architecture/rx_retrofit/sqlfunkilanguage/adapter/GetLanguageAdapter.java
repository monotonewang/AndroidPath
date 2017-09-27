package com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.adapter;

import android.support.annotation.Nullable;

import com.androidpath.R;
import com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.entity.LanguageResponse;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by ubuntu on 17-9-27.
 */

public class GetLanguageAdapter extends BaseQuickAdapter<LanguageResponse.LanBean,BaseViewHolder> {

    public GetLanguageAdapter(@Nullable List<LanguageResponse.LanBean> data) {
        super(R.layout.item_language,data);

    }

    @Override
    protected void convert(BaseViewHolder helper, LanguageResponse.LanBean item) {
        helper.setText(R.id.tv,item.language);
    }
}
