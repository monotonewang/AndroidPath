package com.androidpath.project.sqlfunkilanguage.adapter;

import androidx.annotation.Nullable;

import com.androidpath.R;
import com.androidpath.project.sqlfunkilanguage.entity.LanguageResponse;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by ubuntu on 17-9-27.
 */

public class GetLanguageAdapter extends BaseQuickAdapter<LanguageResponse.LanBean, BaseViewHolder> {

    public GetLanguageAdapter(@Nullable List<LanguageResponse.LanBean> data) {
        super(R.layout.item_language,data);

    }

    @Override
    protected void convert(BaseViewHolder helper, LanguageResponse.LanBean item) {
        helper.setText(R.id.tv,item.language);
    }
}
