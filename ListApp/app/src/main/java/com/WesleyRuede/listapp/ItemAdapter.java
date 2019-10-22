package com.WesleyRuede.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Wesley Ruede on 10/17/19
 */

public class ItemAdapter extends BaseAdapter {

    // field variables from MainActivity
    String[] items;
    String[] prices;
    String[] descriptions;

    // LayoutInflater which moves items from my_listview_detail to MainActivty
    // which is a member (m) of the class
    LayoutInflater mInflater;

    // a constructor which initializes items, prices, and descriptions
    public ItemAdapter(Context c, String[] i, String[] p, String[] d ) {
        items = i;
        prices = p;
        descriptions = d;
        // initialize LayoutInflater
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    // used to find how many items are in the list
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        // index the items
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        // return index
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // a view type variable that takes a LayoutInflater to be inflated  with
        // the layout resource which is my_listview_detail
        View v = mInflater.inflate(R.layout.my_listview_detail, null);
        // look inside the view created by the inflated mInflater for a
        // control named nameTextView e.g. a reference to the respective
        // layout items in my_listview_detail.xml
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView) v.findViewById(R.id.priceTextView);

        // i is the current item in the array of items e.g. item 1 is a peach
        // and item 2 is tomatoes and so on
        String name = items[i];
        // i is the current description in the array of descriptions e.g. a peach's
        // and then a tomato's description
        String desc =  descriptions[i];
        // i is the current price in the array of prices e.g. a peach's price
        // and a tomato's price
        String cost = prices[i];

        // putting the indexed arrays into the TextView
        nameTextView.setText(name);
        descriptionTextView.setText(desc);
        priceTextView.setText(cost);

        // return the views
        return v;
    }
}
