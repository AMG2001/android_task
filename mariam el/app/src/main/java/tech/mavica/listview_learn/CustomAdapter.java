package tech.mavica.listview_learn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> names;
    ArrayList<String> sections;
    LayoutInflater infalter;
    public  CustomAdapter(Context context,ArrayList<String> names,ArrayList<String> sections){
        this.context=context;
        this.names=names;
        this.sections=sections;
        infalter=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=infalter.inflate(R.layout.list_item,null);
        TextView tv_name = convertView.findViewById(R.id.tv_name);
        TextView tv_section = convertView.findViewById(R.id.tv_section);
        tv_name.setText(names.get(position));
        tv_section.setText(sections.get(position));
        return convertView;
    }
}
