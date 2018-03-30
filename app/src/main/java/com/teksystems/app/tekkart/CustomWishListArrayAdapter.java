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
                holder.add = (ImageButton) convertView.findViewById(R.id.add);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)convertView.getTag();
            }
            WishList in = (WishList) aController.getWishList(position);
            String productNamestr = "Product";
for(ProductName productName : ProductName.values()){
    if(productName.getKey()==in.getProductId().intValue()){
        productNamestr = productName.getValue();
    }
}

            holder.tv.setText(in==null?"P1":productNamestr);
            holder.add.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    WishList productWish = aController.getWishList(position);
                    Product product = null;
                    for (Product productInList :aController.getProducts()){
                        if(productWish.getProductId().equals(productInList.getProductId())){
                            product = productInList;
                        }
                    }
                    if(product != null) {
                        ProductCart productCart = new ProductCart();
                        productCart.setOrderLine(new Random().nextInt());
                        productCart.setQuantity(productCart.getQuantity() + 1);
                        productCart.setProductId(product.getProductId());
                        productCart.setOrderAmount(product.getUnitPrice());
                        productCart.setProductCategoryId(product.getProductCategoryId());
                        productCart.setLocationId(product.getLocationId());
                        productCart.setManufacturerId(product.getManufacturerId());
                        productCart.setProductUom(product.getUom());
                        productCart.setTransactionType("OO");
                        aController.getCart().add(productCart);
                    }


                }

            });

            return convertView;

        }

        static class ViewHolder
        {
            TextView tv;
            ImageButton add;

        }
    }

