package com.wesleyruede.contactmanagerrecycler.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wesleyruede.contactmanagerrecycler.DetailActivity;
import com.wesleyruede.contactmanagerrecycler.R;
import com.wesleyruede.contactmanagerrecycler.model.Contact;
import java.util.List;

/* Created to display Views in a ViewHolder pattern for the RecyclerView.
   This java file is essentially an ArrayAdapter used for ListViews */

//Todo: save each baby item to db


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Contact> contactList;

    public RecyclerViewAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    /* Create a view to be displayed @MainActivity inside the RecyclerView */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_row,viewGroup,false);
        // return the ViewHolder instance and get access to the elements
        return new ViewHolder(view);
    }

    /* Bind the data from the database to the views */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Contact contact = contactList.get(position); // each contact object inside of our list
        viewHolder.phoneNumber.setText(contact.getPhoneNumber());
        viewHolder.contactName.setText(contact.getName());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView contactName;
        public TextView phoneNumber;
        public ImageView iconImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contactName = itemView.findViewById(R.id.contact_name);
            phoneNumber = itemView.findViewById(R.id.phone_number);
            iconImg = itemView.findViewById(R.id.icon_image);

            iconImg.setOnClickListener(this); // just the icon is clickable
            // itemView.setOnClickListener(this); // the entire view is clickable

        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            Contact contact = contactList.get(position);

            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("name",contact.getName());
            intent.putExtra("number",contact.getPhoneNumber());

            context.startActivity(intent);

//            switch (view.getId()) {
//                case R.id.icon_image:
//                    Log.d("IconClicked", "onClick: " + contact.getName());
//                    break;
//            }
//            Log.d("Clicked", "onClick: " + position);
        }
    }
}