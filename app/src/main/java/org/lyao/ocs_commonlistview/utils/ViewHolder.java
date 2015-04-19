package org.lyao.ocs_commonlistview.utils;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.lyao.ocs_commonlistview.R;

/**
 * Created by lyao on 2015/4/18.
 */
public class ViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;
    private Integer mPosition;

    private ViewHolder(Context ctx, ViewGroup parent, int layoutId) {
        this.mContext = ctx;
        this.mViews = new SparseArray<>();
        this.mConvertView = View.inflate(mContext, layoutId, parent);
        this.mConvertView.setTag(this);
    }

    public static ViewHolder get(@NonNull Context ctx, @Nullable View convertView, @Nullable ViewGroup parent, int position, @LayoutRes int layoutId) {
        ViewHolder holder;
        holder = convertView == null ? new ViewHolder(ctx, parent, layoutId) : (ViewHolder) convertView.getTag();
        holder.setPosition(position);
        return holder;
    }


    public Integer getPosition() {
        return this.mPosition;

    }

    private void setPosition(Integer mPosition) {
        this.mPosition = mPosition;
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public <T extends View> T getView(@IdRes int id) {
        View childView = mViews.get(id);
        if (childView == null) {
            childView = mConvertView.findViewById(id);
            mViews.put(id, childView);
        }
        return (T) childView;
    }

    public TextView getTextView(@IdRes int id) {
        return getView(id);
    }

    public void setText(@IdRes int id, String text) {
        getTextView(id).setText(text);
    }

    public void setImageUrl(@IdRes int id, String url) {
        Glide.with(mContext)
                .load(url)
                .placeholder(R.mipmap.avator)
                .centerCrop()
                .error(R.drawable.img_circle_placeholder)
                .into((ImageView) getView(id));

    }

    public ImageView getImageView(@IdRes int id) {
        return getView(id);
    }
}

