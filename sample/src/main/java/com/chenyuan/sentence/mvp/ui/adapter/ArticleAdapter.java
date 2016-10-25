package com.chenyuan.sentence.mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chenyuan.sentence.R;
import com.chenyuan.sentence.mvp.model.entity.SentenceSimple;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 名人名句
 */
public class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;

    private Fragment mContext;

    private List<SentenceSimple> mDatas;

    private View.OnClickListener onItemClick;

    public ArticleAdapter(Fragment context, List<SentenceSimple> datas, View.OnClickListener onItemClick) {

        this.mContext = context;

        this.mDatas = datas;

        this.onItemClick = onItemClick;

        mInflater = LayoutInflater.from(context.getActivity());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item_scene_article, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;

        SentenceSimple sentenceSimple = mDatas.get(position);

        if (sentenceSimple != null) {

            Glide.with(mContext)
                    .load(sentenceSimple.getImgUrl())
                    .asBitmap()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(viewHolder.imgView);

            viewHolder.textDesc.setText(sentenceSimple.getContent());

        }
    }

    @Override
    public int getItemCount() {

        return mDatas != null ? mDatas.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgView)
        public ImageView imgView;

        @BindView(R.id.textDesc)
        public TextView textDesc;


        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}