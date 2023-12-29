package com.example.abm01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class ItemAdd extends AppCompatActivity {

    Toolbar toolbar;
    EditText itemName, itemDisplayName, itemBarcode, itemOpenStock, itemPurchaseRate, itemPackingSize, itemSaleRate, itemRemark;
    Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemName = findViewById(R.id.idItenName);
        itemDisplayName = findViewById(R.id.idItemDisplayName);
        itemBarcode = findViewById(R.id.idItemBarcode);
        itemOpenStock = findViewById(R.id.idItemOpenStock);
        itemPurchaseRate = findViewById(R.id.idItemPurchaseRate);
        itemPackingSize = findViewById(R.id.idItemPackingSize);
        itemSaleRate = findViewById(R.id.idItemSaleRate);
        itemRemark = findViewById(R.id.idItemRemark);

        btnAddItem = findViewById(R.id.idBtnAddItem);

        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Add item");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(view -> onBackPressed());

        btnAddItem.setOnClickListener(v -> {
            String itemNameValue = itemName.getText().toString();
            String itemDisplayNameValue = itemDisplayName.getText().toString();
            String itemBarcodeValue = itemBarcode.getText().toString();
            String itemOpenStockValue = itemOpenStock.getText().toString();
            String itemPurchaseRateValue = itemPurchaseRate.getText().toString();
            String itemPackingSizeValue = itemPackingSize.getText().toString();
            String itemSaleRateValue = itemSaleRate.getText().toString();
            String itemRemarkValue = itemRemark.getText().toString();

            if (!itemNameValue.isEmpty() && !itemDisplayNameValue.isEmpty() && !itemBarcodeValue.isEmpty() &&
                    !itemOpenStockValue.isEmpty() && !itemPurchaseRateValue.isEmpty() &&
                    !itemPackingSizeValue.isEmpty() && !itemSaleRateValue.isEmpty() && !itemRemarkValue.isEmpty()) {

                String[] field = {
                        "itemName",
                        "itemDisplayName",
                        "itemBarcode",
                        "itemOpenStock",
                        "itemPurchaseRate",
                        "itemPackingSize",
                        "itemSaleRate",
                        "itemRemark"
                };
                String[] data = {
                        itemNameValue,
                        itemDisplayNameValue,
                        itemBarcodeValue,
                        itemOpenStockValue,
                        itemPurchaseRateValue,
                        itemPackingSizeValue,
                        itemSaleRateValue,
                        itemRemarkValue
                };

                PutData putData = new PutData("http://192.168.1.105/CURDMySql/insert.php", "POST", field, data);
                if (putData.startPut()) {
                    if (putData.onComplete()) {
                        String result = putData.getResult();
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                        if ("Data inserted successfully".equals(result)) {
                            Intent intent = new Intent(getApplicationContext(), ItemList.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            } else {
                Toast.makeText(getApplicationContext(), "All fields required", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
