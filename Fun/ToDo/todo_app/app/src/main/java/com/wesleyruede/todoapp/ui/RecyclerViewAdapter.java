package com.wesleyruede.todoapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.wesleyruede.todoapp.R;
import com.wesleyruede.todoapp.model.Item;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Item> itemList;

    public RecyclerViewAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_row,viewGroup,false);

        return new ViewHolder(view,context);
    }

    /* Set the text from database to the elements in list_row layout */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {

        Item item = itemList.get(position); // object Item
        viewHolder.itemName.setText(item.getItemName());
        viewHolder.itemColor.setText(item.getItemColor());
        viewHolder.itemAmount.setText(item.getItemAmount());
        viewHolder.itemSize.setText(item.getItemSize());
        viewHolder.dateAdded.setText(item.getDateCreated());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    /* Get all elements in the list_row layout such as TextViews and Buttons */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView itemName;
        public TextView itemColor;
        public TextView itemAmount;
        public TextView itemSize;
        public TextView dateAdded;
        public Button editButton;
        public Button deleteButton;
        public int id;

        public ViewHolder(@NonNull View itemView, Context ctx) {
            super(itemView);
            context = ctx;

            itemName = itemView.findViewById(R.id.item_name_card);
            itemColor = itemView.findViewById(R.id.item_color_card);
            itemAmount = itemView.findViewById(R.id.item_amount_card);
            itemSize = itemView.findViewById(R.id.item_size_card);
            dateAdded = itemView.findViewById(R.id.item_date_card);
            editButton = itemView.findViewById(R.id.edit_button);
            deleteButton= itemView.findViewById(R.id.delete_button);

            editButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.edit_button:
                    break;
                case R.id.delete_button:
                    break;
            }
        }
    }
}
