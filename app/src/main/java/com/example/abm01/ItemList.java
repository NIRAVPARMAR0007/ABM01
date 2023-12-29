package com.example.abm01;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ItemList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new FetchItemsTask().execute();
    }

    private class FetchItemsTask extends AsyncTask<Void, Void, List<Item>> {

        @Override
        protected List<Item> doInBackground(Void... voids) {
            List<Item> itemList = new ArrayList<>();

            try {
                URL url = new URL("http://192.168.1.105/CURDMySql/read.php");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                // Parse JSON data
                JSONArray jsonArray = new JSONArray(stringBuilder.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    int id = jsonObject.getInt("id");
                    String itemName = jsonObject.getString("itemName");
                    String itemDisplayName = jsonObject.getString("itemDisplayName");
                    String itemBarcode = jsonObject.getString("itemBarcode");
                    String itemOpenStock = jsonObject.getString("itemOpenStock");
                    String itemPurchaseRate = jsonObject.getString("itemPurchaseRate");
                    String itemPackingSize = jsonObject.getString("itemPackingSize");
                    String itemSaleRate = jsonObject.getString("itemSaleRate");
                    String itemRemark = jsonObject.getString("itemRemark");
                    // Parse other fields as needed...

                    Item item = new Item(id, itemName, itemDisplayName, itemBarcode, itemOpenStock, itemPurchaseRate, itemPackingSize, itemSaleRate, itemRemark);
                    itemList.add(item);
                }

                connection.disconnect();
            } catch (IOException | JSONException e) {
                // Handle error
                e.printStackTrace();
            }

            return itemList;
        }

        @Override
        protected void onPostExecute(List<Item> items) {
            if (items != null) {
                itemAdapter = new ItemAdapter(items);
                recyclerView.setAdapter(itemAdapter);
            } else {
                Toast.makeText(ItemList.this, "Failed to fetch items", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

