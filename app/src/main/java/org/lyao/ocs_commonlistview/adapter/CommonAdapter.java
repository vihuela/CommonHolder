package org.lyao.ocs_commonlistview.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;

import org.lyao.ocs_commonlistview.utils.ViewHolder;

import java.util.List;

/**
 * Created by lyao on 2015/4/18.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    private static final String TAG = "CommonAdapter";
    protected Context mContext;
    private List<T> mList;
    private Integer mLayoutId;
    private Boolean mEnterAnim;

    /**
     * @param ctx      上下文
     * @param list     数据源
     * @param layoutId 适配器对应的item布局
     */
    public CommonAdapter(@NonNull Context ctx, @NonNull List<T> list, @LayoutRes int layoutId) {
        this(ctx, list, layoutId, true);
    }

    public CommonAdapter(@NonNull Context ctx, @NonNull List<T> list, @LayoutRes int layoutId, Boolean enterAnim) {
        this.mContext = ctx;
        this.mList = list;
        this.mLayoutId = layoutId;
        this.mEnterAnim = enterAnim;
    }

    @Override
    final public int getCount() {
        return this.mList.size();
    }

    @Override
    final public long getItemId(int position) {
        return position;
    }

    @Override
    final public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    final public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, null, position, mLayoutId);
        getHolder(holder, getItem(position));
        if (mEnterAnim) runEnterAnim(holder);
        return holder.getConvertView();
    }

    private void runEnterAnim(ViewHolder holder) {
        View item = holder.getConvertView();
        item.setTranslationY(100);
        item.setAlpha(0f);
        item.animate()
                .alpha(1f)
                .setInterpolator(new DecelerateInterpolator())
                .translationY(0)
                .setStartDelay(300)
                .setDuration(300)
                .start();
    }

    public abstract void getHolder(ViewHolder holder, T item);

}
