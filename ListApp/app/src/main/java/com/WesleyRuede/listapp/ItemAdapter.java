package com.WesleyRuede.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
    public ItemAdapter(Context, c, String[] i, String[] p, String[] d ) {
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
        return null;
    }
}
