package com.example.abm01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item currentItem = itemList.get(position);

        holder.itemNameTextView.setText(currentItem.getItemName());
        holder.itemDisplayNameTextView.setText(currentItem.getItemDisplayName());
        holder.itemBarcodeTextView.setText(currentItem.getItemBarcode());
        holder.itemOpenStockTextView.setText(currentItem.getItemOpenStock());
        holder.itemPurchaseRateTextView.setText(currentItem.getItemPurchaseRate());
        holder.itemPackingSizeTextView.setText(currentItem.getItemPackingSize());
        holder.itemSaleRateTextView.setText(currentItem.getItemSaleRate());
        holder.itemRemarkTextView.setText(currentItem.getItemRemark());
        // Bind other fields as needed...
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemNameTextView, itemDisplayNameTextView, itemBarcodeTextView, itemOpenStockTextView, itemPurchaseRateTextView, itemPackingSizeTextView, itemSaleRateTextView, itemRemarkTextView;
        // Declare other views as needed...

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.itemNameTextView);
            itemDisplayNameTextView = itemView.findViewById(R.id.itemDisplayNameTextView);
            itemBarcodeTextView = itemView.findViewById(R.id.itemBarcodeTextView);
            itemOpenStockTextView = itemView.findViewById(R.id.itemOpenStockTextView);
            itemPurchaseRateTextView = itemView.findViewById(R.id.itemPurchaseRateTextView);
            itemPackingSizeTextView = itemView.findViewById(R.id.itemPackingSizeTextView);
            itemSaleRateTextView = itemView.findViewById(R.id.itemSaleRateTextView);
            itemRemarkTextView = itemView.findViewById(R.id.itemRemarkTextView);
            // Initialize other views...
        }
    }
}

