package fcu.iecs.listitemexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sammy on 2016/11/18.
 */
public class MenuListAdaptor extends ArrayAdapter<FoodItem> {

    private Context mContext;

    private int mResourceId;

    private List<FoodItem> mMenuItemList;

    public MenuListAdaptor(Context context, int resource, List<FoodItem> objects) {
        super(context, resource, objects);
        mContext = context;
        mResourceId = resource;
        mMenuItemList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.menu_list_layout, parent, false);
        }

        FoodItem item = mMenuItemList.get(position);

        TextView tvItemName = (TextView) convertView.findViewById(R.id.tv_item);
        tvItemName.setText(item.getItemName());

        TextView tvPrice = (TextView) convertView.findViewById(R.id.tv_price);
        tvPrice.setText(String.valueOf(item.getPrice()));

        TextView tvAmount = (TextView) convertView.findViewById(R.id.tv_amount);
        tvAmount.setText(String.valueOf(item.getAmount()));

        return convertView;


    }
}
