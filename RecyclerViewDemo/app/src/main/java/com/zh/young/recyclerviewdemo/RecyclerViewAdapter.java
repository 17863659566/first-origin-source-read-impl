package com.zh.young.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * adapter在写法上和ListAdapter类似，不同的地方在与ViewHolder需要继承RecyclerView.ViewHolder
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private static final String TAG = "RecyclerViewAdapter";
    private Context mContext;
    private String[] mData = new String[]{
            "1","2","3","4","5",
            "1","2","3","4","5",
            "1","2","3","4","5",
            "1","2","3","4","5",
            "1","2","3","4","5",
            "1","2","3","4","5",
            "1","2","3","4","5",
            "1","2","3","4","5",
    };
    private ViewHolder viewHolder;
    private int count;
    public RecyclerViewAdapter(Context context){
        mContext = context;
    }


    @Override
    public int getItemCount() {
        return mData.length;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewHolder.desc.setText(mData[position]);
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.recycler_view_item, null);
        viewHolder = new ViewHolder(view);
        viewHolder.icon = (ImageView) view.findViewById(R.id.iv_icon);
        viewHolder.desc = (TextView) view.findViewById(R.id.tv_desc);
        Log.i(TAG,"viewholder 创建"+ (count ++));
        return viewHolder;
    }


    private class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }

        ImageView icon;
        TextView desc;
    }
}
