package com.zss.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {


    private final Context context;
    private final ArrayList<String> strings;
    private final LayoutInflater inflayter;


    public ListAdapter(Context context, ArrayList<String>strings){
        this.context = context;
        this.strings = strings;
        inflayter = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //注意这里，一定要将parent传递到inflate方法中
        return new ViewHolder(inflayter.inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(strings.get(position));
    }

    /**
     * 显示有多少条数据
     * @return
     */
    @Override
    public int getItemCount() {
        return 0;
    }


    /**
     *
     * 创建一个ViewHolder
     * 简单理解为这个控件显示到界面上需要的对象是ViewHolder
     *
     * 为什么要ViewHolder，是因为Android是微型设备，内存和计算能力相对电脑
     * 而言较弱
     */
    class ViewHolder extends  RecyclerView.ViewHolder{


        private final TextView mText1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mText1 = itemView.findViewById(android.R.id.text1);
        }

        public void bindData(String s){
            mText1.setText(s);
        }
    }

}
