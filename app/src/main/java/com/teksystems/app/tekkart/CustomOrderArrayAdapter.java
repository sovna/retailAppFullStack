package com.teksystems.app.tekkart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.teksystems.app.model.CartDisplay;
import com.teksystems.app.model.Order;
import com.teksystems.app.model.Product;
import com.teksystems.app.model.ProductCart;
import com.teksystems.app.model.ProductName;
import com.teksystems.app.model.Transaction;
import com.teksystems.app.model.WishList;
import com.teksystems.app.service.ProductService;
import com.teksystems.app.service.WishListService;

import java.util.List;
import java.util.Random;

/**
 * Created by sopani on 2/19/2018.
 */

public class CustomOrderArrayAdapter  extends ArrayAdapter{

        List<Order> orderList;
    final Controller aController = (Controller) getContext().getApplicationContext();
        public CustomOrderArrayAdapter(Context context, List<Order> list)
        {
            super(context,0,list);
            orderList = list;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            LayoutInflater inflater = LayoutInflater.from(getContext());
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.order_list_layout,parent,false);
                holder = new ViewHolder();
                holder.tv =(TextView) convertView.findViewById(R.id.firstLine);
                holder.tvSec = (TextView) convertView.findViewById(R.id.secondLine);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)convertView.getTag();
            }
            Order in = (Order) aController.getOrder(position);
            String productNamestr = "Product";
            for(ProductName productName : ProductName.values()){
                if(productName.getKey()==in.getProductId().intValue()){
                    productNamestr = productName.getValue();
                }
            }
            holder.tv.setText(in==null?"P1":productNamestr);
            holder.tvSec.setText(in==null?"1":String.valueOf(in.getQuantity()));
            return convertView;

        }

        static class ViewHolder
        {
            TextView tv;
            TextView tvSec;
        }
    }

