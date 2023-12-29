References

1. https://www.youtube.com/watch?v=ahNruIZX130
2. https://github.com/android-knowledge/BottomNavWithBottomDialogSheet/blob/master/app/src/main/java/com/example/bottomnavigationdemo/MainActivity.java
3. https://github.com/android-knowledge/BottomNavWithBottomDialogSheet/blob/master/app/src/main/res/menu/bottom_menu.xml
4. https://androidknowledge.com/navigation-drawer-android-studio/
5. https://chat.openai.com/

Certainly! Here's a brief summary of each file:

### PHP Files:

1. **`DataBaseConfig.php`:**
   - Configures database connection parameters.

2. **`DataBase.php`:**
   - Manages database interactions and connections.
   - Includes methods for database connection, data preparation, and insertion.

3. **`read.php`:**
   - Retrieves data from the database (`items` table) and outputs it in JSON format.
   - Uses `DataBase.php` for database operations.

4. **`insert.php`:**
   - Handles form submissions and inserts data into the database (`items` table).
   - Uses `DataBase.php` for database operations.

### Java Files:

1. **`ItemList.java`:**
   - Android activity for displaying a list of items.
   - Uses `RecyclerView` for efficient item display.
   - Executes `FetchItemsTask` to retrieve data from the server.

2. **`FetchItemsTask (AsyncTask in ItemList.java)`:**
   - AsyncTask for background data retrieval in `ItemList.java`.
   - Parses JSON response and updates the UI with retrieved items.

3. **`ItemAdapter.java`:**
   - RecyclerView adapter for binding data to item views.
   - Uses a custom layout (`item_list_item.xml`) for each item view.

### XML Files:

1. **`activity_item_list.xml`:**
   - Defines the layout for the `ItemList` activity, containing a `RecyclerView` to display items.

2. **`item_list_item.xml`:**
   - Defines the layout for individual items in the `RecyclerView` (`ItemAdapter` uses this layout).

These files collectively demonstrate a client-server architecture for a basic Android app that communicates with a PHP server to perform CRUD operations on a MySQL database. The Android app displays a list of items retrieved from the server using a `RecyclerView`.
