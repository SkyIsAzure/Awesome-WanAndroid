package json.chao.com.wanandroid.ui.project.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import json.chao.com.wanandroid.core.bean.FeedArticleData;
import json.chao.com.wanandroid.R;
import json.chao.com.wanandroid.component.ImageLoader;
import json.chao.com.wanandroid.ui.project.viewholder.ProjectListViewHolder;

/**
 * @author quchao
 * @date 2018/2/24
 */

public class ProjectListAdapter extends BaseQuickAdapter<FeedArticleData, ProjectListViewHolder> {

    public ProjectListAdapter(int layoutResId, @Nullable List<FeedArticleData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(ProjectListViewHolder helper, FeedArticleData item) {
        if (!TextUtils.isEmpty(item.getEnvelopePic())) {
            ImageLoader.load(mContext, item.getEnvelopePic(), helper.getView(R.id.item_project_list_iv));
        }
        if (!TextUtils.isEmpty(item.getTitle())) {
            helper.setText(R.id.item_project_list_title_tv, item.getTitle());
        }
        if (!TextUtils.isEmpty(item.getDesc())) {
            helper.setText(R.id.item_project_list_content_tv, item.getDesc());
        }
        if (!TextUtils.isEmpty(item.getNiceDate())) {
            helper.setText(R.id.item_project_list_time_tv, item.getNiceDate());
        }
        if (!TextUtils.isEmpty(item.getAuthor())) {
            helper.setText(R.id.item_project_list_author_tv, item.getAuthor());
        }
        if (!TextUtils.isEmpty(item.getApkLink())) {
            helper.getView(R.id.item_project_list_install_tv).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.item_project_list_install_tv).setVisibility(View.GONE);
        }
//        if (item.isCollect()) {
//            helper.setImageResource(R.id.item_project_list_like_iv, R.mipmap.icon_like_article_selected);
//        } else {
//            helper.setImageResource(R.id.item_project_list_like_iv, R.mipmap.icon_like_article_not_selected);
//        }

        helper.addOnClickListener(R.id.item_project_list_install_tv);
//        helper.addOnClickListener(R.id.item_project_list_like_iv);
    }
}
