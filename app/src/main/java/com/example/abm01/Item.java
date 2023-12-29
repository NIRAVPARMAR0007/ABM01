package com.example.abm01;

public class Item {
    private int id;
    private String itemName, itemDisplayName, itemBarcode, itemOpenStock, itemPurchaseRate, itemPackingSize, itemSaleRate, itemRemark;
    // Add more fields as needed...

    public Item(int id, String itemName, String itemDisplayName, String itemBarcode, String itemOpenStock, String itemPurchaseRate, String itemPackingSize, String itemSaleRate, String itemRemark) {
        this.id = id;
        this.itemName = itemName;
        this.itemDisplayName = itemDisplayName;
        this.itemBarcode = itemBarcode;
        this.itemOpenStock = itemOpenStock;
        this.itemPurchaseRate = itemPurchaseRate;
        this.itemPackingSize = itemPackingSize;
        this.itemSaleRate = itemSaleRate;
        this.itemRemark = itemRemark;
        // Initialize other fields...
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDisplayName() {
        return itemDisplayName;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public String getItemOpenStock() {
        return itemOpenStock;
    }

    public String getItemPurchaseRate() {
        return itemPurchaseRate;
    }

    public String getItemPackingSize() {
        return itemPackingSize;
    }

    public String getItemSaleRate() {
        return itemSaleRate;
    }

    public String getItemRemark() {
        return itemRemark;
    }
    // Add getters for other fields...
}

