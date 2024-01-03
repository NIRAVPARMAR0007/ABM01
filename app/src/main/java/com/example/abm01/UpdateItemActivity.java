package com.example.abm01;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UpdateItemActivity extends AppCompatActivity {

    private EditText itemNameEditText;
    private Button btnUpdateItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_item);

        // Initialize UI elements
        itemNameEditText = findViewById(R.id.editTextItemName);
        btnUpdateItem = findViewById(R.id.btnUpdateItem);

        // Retrieve data passed from ItemAdapter
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int itemId = extras.getInt("item_id", -1);
            String itemName = extras.getString("item_name", "");

            // Populate UI elements with existing item details
            itemNameEditText.setText(itemName);

            // Implement logic to handle item update on button click
            btnUpdateItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Get updated item details from UI elements
                    String updatedItemName = itemNameEditText.getText().toString();

                    // Execute AsyncTask to update item in the database
                    new UpdateItemTask(itemId, updatedItemName).execute();
                }
            });
        }
    }

    private class UpdateItemTask extends AsyncTask<Void, Void, String> {
        private int itemId;
        private String updatedItemName;

        public UpdateItemTask(int itemId, String updatedItemName) {
            this.itemId = itemId;
            this.updatedItemName = updatedItemName;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://192.168.1.105/CURDMySql/update.php"); // Replace with your server URL
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // Set request method to POST
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);

                // Prepare data to send to the server
                Map<String, String> postData = new HashMap<>();
                postData.put("item_id", String.valueOf(itemId));
                postData.put("item_name", updatedItemName);

                // Write the data to the output stream
                OutputStream os = connection.getOutputStream();
                os.write(getPostDataString(postData).getBytes());
                os.flush();
                os.close();

                // Get the response from the server
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    // Read the response
                    // You can handle the response as needed
                    // For example, you might receive a success message or an error message from the server
                }

                connection.disconnect();
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if (result == null) {
                Toast.makeText(UpdateItemActivity.this, "Item updated successfully", Toast.LENGTH_SHORT).show();
                finish(); // Finish the activity after updating
            } else {
                Toast.makeText(UpdateItemActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        }

        private String getPostDataString(Map<String, String> params) {
            StringBuilder result = new StringBuilder();
            boolean first = true;

            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(entry.getKey());
                result.append("=");
                result.append(entry.getValue());
            }

            return result.toString();
        }
    }
}
