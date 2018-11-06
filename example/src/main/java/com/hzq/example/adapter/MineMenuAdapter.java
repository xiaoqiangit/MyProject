package com.hzq.example.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hzq.baselibs.glide.GlideUtils;
import com.hzq.example.R;
import com.hzq.example.data.entity.MenuEntity;

import java.util.List;

/**
 * @author 小强
 * @time 2018/11/6  11:32
 * @desc 我的页面中的菜单适配器
 */
public class MineMenuAdapter extends BaseQuickAdapter<MenuEntity, BaseViewHolder> {

    public MineMenuAdapter(@Nullable List<MenuEntity> data) {
        super(R.layout.item_mine_menu, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MenuEntity item) {

        //图标
        GlideUtils.loadImage(mContext,item.getIconId(),helper.getView(R.id.iv_menu),R.drawable.load);

        //名字
        helper.setText(R.id.tv_menu,item.getName());
    }
}
