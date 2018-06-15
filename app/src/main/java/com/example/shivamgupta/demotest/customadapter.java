package com.example.shivamgupta.demotest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shivam gupta on 13-06-2018.
 */

public class customadapter extends RecyclerView.Adapter<customadapter.ViewHolder> {

    private List<modelclass_qstn_answer> listItems;
    private Context context;

    public customadapter(List<modelclass_qstn_answer> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public customadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customadapter_layout,parent,false);
        return new ViewHolder(v,context,listItems);
    }

    @Override
    public void onBindViewHolder(customadapter.ViewHolder holder, int position) {

        modelclass_qstn_answer listItem = listItems.get(position);
        holder.ds_qstn.setText(listItem.getQuestion());
        holder.ds_answer.setText(listItem.getAnswer());


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView ds_qstn,ds_answer;


        List<modelclass_qstn_answer> listItems = new ArrayList<modelclass_qstn_answer>();
        Context ctx;



        public ViewHolder(View itemView, Context ctx, List<modelclass_qstn_answer> listItems) {
            super(itemView);
            this.listItems=listItems;
            this.ctx=ctx;

            ds_qstn=(TextView)itemView.findViewById(R.id.Qstn);
            ds_answer=(TextView)itemView.findViewById(R.id.answer);
            ds_answer.setMovementMethod(new ScrollingMovementMethod());
        }


    }
}
