package com.example.coronavirus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyImageAdapter extends ArrayAdapter<ImagePreventionMethods> {

    List<ImagePreventionMethods> imagePreventionMethods;
    Context context;


    public MyImageAdapter(@NonNull Context context, List<ImagePreventionMethods> imagePreventionMethods) {
        super(context,R.layout.row ,imagePreventionMethods);

        this.context = context;
        this.imagePreventionMethods = imagePreventionMethods;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null,true);

        TextView number = view.findViewById(R.id.prevention_methodsTv);
        ImageView image = view.findViewById(R.id.prevention_methods_Image);

        number.setText(imagePreventionMethods.get(position).getNumber());
        Picasso.get().load(imagePreventionMethods.get(position).getUriImage()).into(image);

        return view;
    }

    @Override
    public int getCount() {
        return imagePreventionMethods.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public ImagePreventionMethods getItem(int position) {
        return imagePreventionMethods.get(position);
    }
}
