package com.example.saneef.googleloginauth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import RetrofitClass.JsonModel.Person;
import RetrofitClass.ProfileData;

/**
 * Created by saneef on 23/9/16.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private List<String> listDataHeader;
    private Map<String, List<ProfileData>> listChildData;
    private Context context;
    public ExpandableListAdapter(Context context,
                                 List<String> listDataHeader,
                                 Map<String, List<ProfileData>> listChildData)
    {
        this.context=context;
        this.listChildData=listChildData;
        this.listDataHeader=listDataHeader;


    }

    public List<String> getListDataHeader() {
        return listDataHeader;
    }

    public void setListDataHeader(List<String> listDataHeader) {
        this.listDataHeader = listDataHeader;
    }

    public Map<String, List<ProfileData>> getListChildData() {
        return listChildData;
    }

    public void setListChildData(Map<String, List<ProfileData>> listChildData) {
        this.listChildData = listChildData;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }



    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (groupPosition == 0) {

                convertView = layoutInflater.inflate(R.layout.item_profile_info, null);

            }

            else
            {
                convertView = layoutInflater.inflate(R.layout.contact, null);
            }



        if(groupPosition==0)
        {
            TextView textViewItem,textViewValue;
            textViewItem=(TextView)convertView.findViewById(R.id.profile_info_item);
            textViewValue=(TextView)convertView.findViewById(R.id.profile_info_value);
            textViewItem.setText(listChildData.get(listDataHeader.get(groupPosition)).get(childPosition).getFirstContent());
            textViewValue.setText(listChildData.get(listDataHeader.get(groupPosition)).get(childPosition).getSecondContent());


        }
        else
        {
            TextView textViewName,textViewEmail;
            textViewName=(TextView)convertView.findViewById(R.id.each_item_display_name);
            textViewEmail=(TextView)convertView.findViewById(R.id.each_item_email_id);
            textViewName.setText(listChildData.get(listDataHeader.get(groupPosition)).get(childPosition).getFirstContent());
            textViewEmail.setText(listChildData.get(listDataHeader.get(groupPosition)).get(childPosition).getSecondContent());

        }
        return convertView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.expandable_list_group_header, null);
        }

        String headerTitle ;
        headerTitle=listDataHeader.get(groupPosition);
        TextView group_title = (TextView) convertView.findViewById(R.id.each_group_header);

        group_title.setText(headerTitle);

        return convertView;


    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listChildData.get(this.listDataHeader.get(groupPosition)).size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listChildData.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }



    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

}
