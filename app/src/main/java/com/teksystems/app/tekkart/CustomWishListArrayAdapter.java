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
import com.teksystems.app.model.Transaction;
import com.teksystems.app.model.WishList;
import com.teksystems.app.service.WishListService;

import java.util.List;
import java.util.Random;

/**
 * Created by sopani on 2/19/2018.
 */

public class CustomWishListArrayAdapter  extends ArrayAdapter{

        List<WishList> wishLists;
    final Controller aController = (Controller) getContext().getApplicationContext();
        public CustomWishListArrayAdapter(Context context, List<WishList> list)
        {
            super(context,0,list);
            wishLists = list;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            LayoutInflater inflater = LayoutInflater.from(getContext());
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.wish_list_layout,parent,false);
                holder = new ViewHolder();
                holder.tv =(TextView) convertView.findViewById(R.id.firstLine);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)convertView.getTag();
            }
            WishList in = (WishList) aController.getWishList(position);
            String productName = "Product";
           /* for(Product product :aController.getProducts()) {
                *//*if(product.getProductId().equals(in.getProductId())) {
                    productName = product.getProductName();
                }*//*
            }*/
            holder.tv.setText(in==null?"P1":in.getProductId().toString()/*productName*/);
            return convertView;

        }

        static class ViewHolder
        {
            TextView tv;

        }
    }

