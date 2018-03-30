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

public class CustomCartArrayAdapter  extends ArrayAdapter{

        List<ProductCart> cartDisplayList;
    final Controller aController = (Controller) getContext().getApplicationContext();
        public CustomCartArrayAdapter(Context context, List<ProductCart> list)
        {
            super(context,0,list);
            aController.setProductCarts(list);
            cartDisplayList = list;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            LayoutInflater inflater = LayoutInflater.from(getContext());
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.cart_list_layout,parent,false);
                holder = new ViewHolder();
                holder.tv =(TextView) convertView.findViewById(R.id.firstLine);
                holder.tvSec = (TextView) convertView.findViewById(R.id.secondLine);
                holder.wish = (ImageButton) convertView.findViewById(R.id.wish);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)convertView.getTag();
            }
            ProductCart in = (ProductCart) cartDisplayList.get(position);
            String productName = "Product";
            for(Product product :aController.getProducts()) {
                if(product.getProductId().equals(in.getProductId())) {
                    productName = product.getProductName();
                }
            }
            holder.tv.setText(in==null?"P1":productName);
            holder.tvSec.setText(in==null?"1":String.valueOf(in.getQuantity()));

            holder.wish.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    ProductCart productCart = aController.getCart(position);
                    aController.getCart().remove(productCart);
                    WishList wishList = new WishList();
                    wishList.setWishListId(new Random().nextInt());
                    wishList.setUserId(Integer.valueOf(aController.getUserId()));
                    wishList.setProductId(productCart.getProductId());
                    wishList.setProductCategoryId(productCart.getProductCategoryId());
                    wishList.setManufacturerId(productCart.getManufacturerId());
                    wishList.setLocationId(productCart.getLocationId());
                    aController.getWishLists().add(wishList);
                    }
            });

            // set the name to the text;

            return convertView;

        }

        static class ViewHolder
        {
            TextView tv;
            TextView tvSec;
            ImageButton wish;
        }
    }

