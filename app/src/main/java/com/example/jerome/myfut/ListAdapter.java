package com.example.jerome.myfut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jerome on 30/12/2014.
 */
public class ListAdapter extends ArrayAdapter<Infos> {

    private List<Infos> itemList;
    private Context context;
    public ListAdapter(List<Infos> itemList, Context ctx) {
        super(ctx, android.R.layout.simple_list_item_1, itemList);
        this.itemList = itemList;
        this.context = ctx;
    }
    public int getCount() {
        if (itemList != null)
            return itemList.size();
        return 0;
    }
    public Infos getItem(int position) {
        if (itemList != null)
            return itemList.get(position);
        return null;
    }
   public long getItemId(int position) {
        if (itemList != null)
            return itemList.get(position).hashCode();
        return 0;
   }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }
        Infos c = itemList.get(position);
        TextView text = (TextView) v.findViewById(R.id.name);
        text.setText(c.getName());

        TextView text1 = (TextView) v.findViewById(R.id.surname);
        text1.setText(c.getSurname());

        TextView text2 = (TextView) v.findViewById(R.id.email);
        text2.setText(c.getEmail());

        TextView text3 = (TextView) v.findViewById(R.id.phone);
        text3.setText(c.getPhoneNum());
        return v;
        }

        public List<Infos> getItemList() {
          return itemList;
        }

        public void setItemList(List<Infos> itemList) {
            this.itemList = itemList;
        }
}
