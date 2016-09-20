package com.example.saneef.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



import java.util.ArrayList;

public class listAdapter extends BaseAdapter {
    private ArrayList<Person> listData;
    private LayoutInflater layoutInflater;

    public listAdapter(Context context, ArrayList<Person> listData)
    {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    public void addContact(Person person) {
        listData.add(person);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    static class ViewHolder {
        TextView nameView;
        TextView numberView;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if (convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.each_item, null);
            holder = new ViewHolder();
            holder.nameView = (TextView) convertView.findViewById(R.id.item_name);
            holder.numberView = (TextView) convertView.findViewById(R.id.item_phone_no);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.nameView.setText(listData.get(position).getPersonName());
        holder.numberView.setText(listData.get(position).getPhoneNumber());
        return convertView;
    }


}


