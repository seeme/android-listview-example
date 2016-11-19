package fcu.iecs.listitemexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class FoodItemActivity extends AppCompatActivity {

    private static int MAX_NUMBER = 99;

    private static int MIN_NUMBER = 0;

    private NumberPicker mNumberPicker;

    private FoodItem mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item);

        Intent intent = this.getIntent();
        mItem = (FoodItem)intent.getSerializableExtra("FoodItem");
        TextView tvItemName = (TextView)findViewById(R.id.tv_food_item);
        tvItemName.setText(mItem.getItemName());

        mNumberPicker = (NumberPicker)findViewById(R.id.amount_items);
        mNumberPicker.setMaxValue(MAX_NUMBER);
        mNumberPicker.setMinValue(MIN_NUMBER);
        mNumberPicker.setValue(mItem.getAmount());

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("UpdateAmount", mNumberPicker.getValue());
        setResult(MainActivity.GET_AMOUNT, intent);
        this.finish();
    }
}
