package com.emarkova.session18.recycler;

import android.support.annotation.LongDef;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.emarkova.session18.ImageItemType;
import com.emarkova.session18.data.model.Image;
import com.emarkova.session18.recycler.binders.FrescoHolderBinder;
import com.emarkova.session18.recycler.binders.GlideHolderBinder;
import com.emarkova.session18.recycler.binders.HttpHolderBinder;
import com.emarkova.session18.recycler.binders.ImageHolderBinder;
import com.emarkova.session18.recycler.binders.PicassoHolderBinder;
import com.emarkova.session18.recycler.factories.FrescoFactory;
import com.emarkova.session18.recycler.factories.GlideFactory;
import com.emarkova.session18.recycler.factories.HttpFactory;
import com.emarkova.session18.recycler.factories.PicassoFactory;
import com.emarkova.session18.recycler.factories.ViewHolderFactory;
import com.emarkova.session18.recycler.viewholders.PicassoViewHolder;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {
    List<Image> mDataImage;
    List<ImageItemType> mDataType;
    SparseArray<ViewHolderFactory> mFactoryMap;

    public CustomAdapter(List<Image> listImage, List<ImageItemType> listType){
        mDataImage = listImage;
        mDataType = listType;
        mFactoryMap = new SparseArray<>();
        mFactoryMap.put(ItemType.HTTP.getType(), new HttpFactory());
        mFactoryMap.put(ItemType.PICASSO.getType(), new PicassoFactory());
        mFactoryMap.put(ItemType.GLIDE.getType(), new GlideFactory());
        mFactoryMap.put(ItemType.FRESCO.getType(), new FrescoFactory());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolderFactory factory = mFactoryMap.get(i);
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return factory.createViewHolder(viewGroup, layoutInflater);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ImageHolderBinder binder = getBinder(mDataType.get(i), mDataImage.get(i));
        binder.bindViewHolder(viewHolder);
    }

    private ImageHolderBinder getBinder(ImageItemType itemType, Image image) {
        switch (itemType.getItemType()) {
            case HTTP:
                return new HttpHolderBinder(ItemType.HTTP.getType(), image);
            case PICASSO:
                return new PicassoHolderBinder(ItemType.PICASSO.getType(), image);
            case GLIDE:
                return  new GlideHolderBinder(ItemType.GLIDE.getType(), image);
            case FRESCO:
                return new FrescoHolderBinder(ItemType.FRESCO.getType(), image);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return mDataType.get(position).getItemType().getType();
    }

    @Override
    public int getItemCount() {
        return mDataType.size();
    }
}
