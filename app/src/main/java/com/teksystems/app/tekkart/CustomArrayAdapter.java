package com.teksystems.app.tekkart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.teksystems.app.model.Product;
import com.teksystems.app.model.ProductCart;
import com.teksystems.app.model.WishList;
import com.teksystems.app.service.WishListService;

import java.util.List;
import java.util.Random;

/**
 * Created by sopani on 2/19/2018.
 */

public class CustomArrayAdapter  extends ArrayAdapter{
List<ProductCart> productCartList;
        List<Product> products;
    final Controller aController = (Controller) getContext().getApplicationContext();

    public CustomArrayAdapter(Context context, List<Product> list)
        {
            super(context,0,list);
            products = list;
            for(Product productAddList : products) {
                aController.getProducts().add(productAddList);
            }
        }

    @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            LayoutInflater inflater = LayoutInflater.from(getContext());
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.product_list_layout,parent,false);
// inflate custom layout called row
                holder = new ViewHolder();
                holder.tv =(TextView) convertView.findViewById(R.id.firstLine);
               holder.tvSec =(TextView) convertView.findViewById(R.id.secondLine);
                holder.add = (ImageButton) convertView.findViewById(R.id.add);
                holder.wish = (ImageButton) convertView.findViewById(R.id.wish);
// initialize textview
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)convertView.getTag();
            }
            Product in = (Product) products.get(position);
            holder.tv.setText(in==null?"P1":in.getProductName());
            holder.tvSec.setText(in==null?"1":String.valueOf(in.getUnitPrice()));
            //holder.add.setId(position);
           holder.add.setOnClickListener(new View.OnClickListener() {
               public void onClick(View v) {
                Product product = aController.getProducts(position);
                   ProductCart productCart = new ProductCart();
                   productCart.setOrderLine(new Random().nextInt());
                   productCart.setQuantity(productCart.getQuantity()+1);
                   productCart.setProductId(product.getProductId());
                   productCart.setOrderAmount(product.getUnitPrice());
                   productCart.setProductCategoryId(product.getProductCategoryId());
                   productCart.setLocationId(product.getLocationId());
                   productCart.setManufacturerId(product.getManufacturerId());
                   productCart.setProductUom(product.getUom());
                   productCart.setTransactionType("OO");
                  aController.getCart().add(productCart);
               }

               });

        holder.wish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProductCart productCart = aController.getCart(position);
                WishList wishList = new WishList();
                wishList.setWishListId(new Random().nextInt());
                wishList.setUserId(Integer.valueOf(aController.getUserId()));
                wishList.setProductId(productCart.getProductId());
                wishList.setProductCategoryId(productCart.getProductCategoryId());
                wishList.setManufacturerId(productCart.getManufacturerId());
                wishList.setLocationId(productCart.getLocationId());
                new WishListService().addToWishList(wishList);
            }
            });

            return convertView;

        }

        static class ViewHolder
        {

            TextView tv;
            TextView tvSec;
            ImageButton add;
            ImageButton wish;
        }
    }

