package com.lzm.blog.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzm.blog.R;
import com.lzm.blog.model.Blog;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import static java.text.DateFormat.*;

public class BlogRecyclerAdapter extends RecyclerView.Adapter<BlogRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Blog> blogList;

    public BlogRecyclerAdapter(Context context, List<Blog> blogList) {
        this.context = context;
        this.blogList = blogList;
    }

    @Override
    public BlogRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_row, parent, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(BlogRecyclerAdapter.ViewHolder holder, int position) {
        Blog blog = blogList.get(position);

        String imageUrl = null;

        DateFormat dateFormat = getDateInstance();
        Long date = Long.valueOf(blog.getTimestamp());
        String formattedDate = dateFormat.format(new Date(date).getTime());
        imageUrl = blog.getImage();

        holder.title.setText(blog.getTitle());
        holder.description.setText(blog.getDescription());
        holder.timestamp.setText(formattedDate);
        Picasso.with(context)
                .load(imageUrl)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        public TextView timestamp;
        public ImageView image;
        String userId;

        public ViewHolder(View view, Context ctx) {
            super(view);

            context = ctx;

            title = view.findViewById(R.id.postTitleList);
            description = view.findViewById(R.id.postTextList);
            image = view.findViewById(R.id.postImageList);
            timestamp = view.findViewById(R.id.postTimestampList);

            userId = null;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //next activity
                }
            });
        }
    }
}
