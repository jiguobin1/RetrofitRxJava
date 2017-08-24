package jiguobin.example.com.retrofitrxjava;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by acer-PC on 2017/8/23.
 */

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private List<String> path;

    public MyAdapter(Context mContext, List<String> path) {
        this.mContext = mContext;
        this.path = path;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mLayoutInflater=LayoutInflater.from(mContext);
        View inflate = mLayoutInflater.inflate(R.layout.recy_item, parent,false);
        ViewHolder myViewHolder = new ViewHolder(inflate);//把条目的布局传递给viewholer
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(mContext).load(path.get(position)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.re_icon);
    }

    @Override
    public int getItemCount() {
        return path.size();
    }
}
class ViewHolder extends RecyclerView.ViewHolder{

    public ImageView re_icon;
    public ViewHolder(View itemView) {
        super(itemView);
        re_icon=itemView.findViewById(R.id.re_icon);
    }
}
