package com.dev.jsonfetch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter <ExampleAdapter.ExampleViewHolder> implements View.OnClickListener {

    private Context mContext;
    private ArrayList <ExampleItem> mExampleList;
    private OnItemClickListener mListener;

    @Override
    public void onClick(View v) {
    }

    public void setOnItemClickListener(OnItemClickListener listener){

       mListener=listener;

    }

    public interface OnItemClickListener{
        void OnItemClick(int position) ;

    }


    public ExampleAdapter(Context context, ArrayList <ExampleItem> exampleList) {
        mContext = context;
        mExampleList = exampleList;


    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( mContext ).inflate( R.layout.example_item, parent, false );
        return new ExampleViewHolder( v );
    }

    @Override
    public void onBindViewHolder( ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get( position );

        String imageUrl = currentItem.getmImageUrl();
        String creatorName = currentItem.getmCreator();
        int likeCount = currentItem.getLikeCount();

         holder.mTextViewCreator.setText(creatorName) ;
         holder.mTextViewLikes.setText( "Likes: " +likeCount );
        Picasso.with( mContext ).load( imageUrl ).fit().centerInside().into( holder.mImageView );

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes);
        }
    }
}


