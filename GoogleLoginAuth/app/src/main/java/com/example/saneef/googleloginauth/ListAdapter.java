package com.example.saneef.googleloginauth;

/**
 * Created by saneef on 20/9/16.
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import RetrofitClass.JsonModel.Person;

/**
 * Created by saneef on 7/9/16.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<Person> contacts;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView eachitem_displayName;
        public TextView eachitem_emailAddress;


        public ViewHolder(View v) {
            super(v);
            eachitem_displayName = (TextView) v.findViewById(R.id.each_item_display_name);
            eachitem_emailAddress = (TextView) v.findViewById(R.id.each_item_email_id);
        }
    }

    public ListAdapter(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    public void add(Person person) {
        this.contacts.add(person);

    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.eachitem_displayName.setText(contacts.get(position).getDisplayName());
        holder.eachitem_emailAddress.setText(contacts.get(position).getEmailAddress());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}