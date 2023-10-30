package com.ydlab.mntb_client.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ydlab.mntb_client.R;
import com.ydlab.mntb_client.bean.MajorInfo;

import java.util.List;

public class DialogueActivity_04_Adapter extends BaseAdapter {
    private Context context;
    private List<MajorInfo> recommend_major_info_list;
    public int[] recommend_favorite_position = new int[]{0, 0, 0, 0, 0};

    public DialogueActivity_04_Adapter(Context context, List<MajorInfo> recommend_major_info_list) {
        this.context = context;
        this.recommend_major_info_list = recommend_major_info_list;
    }

    @Override
    public int getCount() {
        return recommend_major_info_list.size();
    }

    @Override
    public Object getItem(int position) {
        return recommend_major_info_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        ViewHolder viewHolder = null;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_view_item_dialogue_04, null);
            viewHolder = new ViewHolder();
            viewHolder.textView_college_name = view.findViewById(R.id.textView_college_name);
            viewHolder.textView_major_group_name = view.findViewById(R.id.textView_major_group_name);
            viewHolder.textView_major_name = view.findViewById(R.id.textView_major_name);
            viewHolder.textView_major_notes = view.findViewById(R.id.textView_major_notes);
            viewHolder.textView_major_score_1 = view.findViewById(R.id.textView_major_score_1);
            viewHolder.textView_major_score_2 = view.findViewById(R.id.textView_major_score_2);
            viewHolder.textView_major_score_3 = view.findViewById(R.id.textView_major_score_3);
            viewHolder.textView_major_score_4 = view.findViewById(R.id.textView_major_score_4);
            viewHolder.textView_major_score_5 = view.findViewById(R.id.textView_major_score_5);
            viewHolder.imageView_favorite = view.findViewById(R.id.imageView_favorite);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        MajorInfo major_info = recommend_major_info_list.get(position);
        viewHolder.textView_college_name.setText(major_info.getCollege_name());
        viewHolder.textView_major_group_name.setText(major_info.getMajor_group_name());
        viewHolder.textView_major_name.setText(major_info.getMajor_name());
        viewHolder.textView_major_notes.setText(major_info.getMajor_notes());
        viewHolder.textView_major_score_1.setText(major_info.getMajor_score_1());
        viewHolder.textView_major_score_2.setText(major_info.getMajor_score_2());
        viewHolder.textView_major_score_3.setText(major_info.getMajor_score_3());
        viewHolder.textView_major_score_4.setText(major_info.getMajor_score_4());
        viewHolder.textView_major_score_5.setText(major_info.getMajor_score_5());
        ViewHolder finalViewHolder = viewHolder;
        viewHolder.imageView_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recommend_favorite_position[position] == 0) {
                    recommend_favorite_position[position] = 1;
                    finalViewHolder.imageView_favorite.setImageResource(R.drawable.pic_favorite);
                } else {
                    recommend_favorite_position[position] = 0;
                    finalViewHolder.imageView_favorite.setImageResource(R.drawable.pic_favorite_not);
                }
            }
        });
        return view;
    }

    class ViewHolder {
        TextView textView_college_name;
        TextView textView_major_group_name;
        TextView textView_major_name;
        TextView textView_major_notes;
        TextView textView_major_score_1;
        TextView textView_major_score_2;
        TextView textView_major_score_3;
        TextView textView_major_score_4;
        TextView textView_major_score_5;
        ImageView imageView_favorite;
    }
}
