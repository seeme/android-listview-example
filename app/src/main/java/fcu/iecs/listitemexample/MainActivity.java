package fcu.iecs.listitemexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mMenuListView;

    private MenuListAdaptor mAdaptor;

    private FoodItem mSelectedItem;


    public static int GET_AMOUNT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mMenuListView = (ListView) findViewById(R.id.menuList);

        mAdaptor = new MenuListAdaptor(this, android.R.layout.activity_list_item, getTestMenuList());
        mMenuListView.setAdapter(mAdaptor);

        mMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mSelectedItem = (FoodItem) mMenuListView.getAdapter().getItem(i);
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,FoodItemActivity.class);
                intent.putExtra("FoodItem", mSelectedItem);
                startActivityForResult(intent, MainActivity.GET_AMOUNT);
            }
        });

    }

    private List<FoodItem> getTestMenuList() {
        List<FoodItem> lsItems = new ArrayList<FoodItem>();
        FoodItem item1 = new FoodItem();
        item1.setItemName("豆漿");
        item1.setPrice(15);
        lsItems.add(item1);

        FoodItem item2 = new FoodItem();
        item2.setItemName("招牌漢堡");
        item2.setPrice(30);
        lsItems.add(item2);

        return lsItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == GET_AMOUNT) {
            int updatedAmount = data.getIntExtra("UpdateAmount", 0);
            if(updatedAmount != mSelectedItem.getAmount()) {
                mSelectedItem.setAmount(updatedAmount);
                mAdaptor.notifyDataSetChanged();
            }
        }
    }
}
