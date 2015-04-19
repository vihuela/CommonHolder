package org.lyao.ocs_commonlistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import org.lyao.ocs_commonlistview.adapter.CommonAdapter;
import org.lyao.ocs_commonlistview.bean.New;
import org.lyao.ocs_commonlistview.utils.ViewHolder;

import java.util.ArrayList;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.lv)
    ListView mListView;
    private ArrayList<New> mNews;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        ButterKnife.inject(this);
        initData();
        initWidget();
    }

    private void initWidget() {
        mListView.setAdapter(new CommonAdapter<New>(mContext, mNews, R.layout.item_lv) {
            @Override
            public void getHolder(ViewHolder holder, New item) {
                holder.setText(R.id.tv_title, item.title);
                holder.setText(R.id.tv_detail, item.datail);
                holder.setText(R.id.tv_follow, item.follow);
                holder.setImageUrl(R.id.iv_photo, item.avator);
            }
        });
    }

    private void initData() {
        mNews = new ArrayList<>();
        final String[] mAvators = mContext.getResources().getStringArray(R.array.avator);
        final String[] mTitles = mContext.getResources().getStringArray(R.array.title);
        final String[] mDetails = mContext.getResources().getStringArray(R.array.detail);
        final String[] mFollows = new String[20];
        final Random r = new Random();
        for (int i = 0; i < 20; i++) mFollows[i] = r.nextInt(1001) + "跟帖";
        /*构造数据集*/
        for (int i = 0; i < mAvators.length; i++)
            mNews.add(new New(mAvators[i], mDetails[i], mFollows[i], mTitles[i]));
    }


}
