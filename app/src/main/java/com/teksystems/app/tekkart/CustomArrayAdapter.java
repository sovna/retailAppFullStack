package com.teksystems.app.tekkart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.teksystems.app.model.Product;

import java.util.List;

/**
 * Created by sopani on 2/19/2018.
 */

public class CustomArrayAdapter  extends ArrayAdapter{

        List<Product> products;
        public CustomArrayAdapter(Context context, List<Product> list)
        {
            super(context,0,list);
            products = list;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            LayoutInflater inflater = LayoutInflater.from(getContext());
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.product_list_layout,parent,false);
// inflate custom layout called row
                holder = new ViewHolder();
                holder.tv =(TextView) convertView.findViewById(R.id.firstLine);
               // holder.tv =(TextView) convertView.findViewById(R.id.secondLine);
// initialize textview
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder)convertView.getTag();
            }
            Product in = (Product) products.get(position);
            holder.tv.setText(in==null?"P1":in.getProductName());

            // set the name to the text;

            return convertView;

        }

        static class ViewHolder
        {

            TextView tv;
        }
    }

