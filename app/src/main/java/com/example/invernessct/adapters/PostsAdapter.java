package com.example.invernessct.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.invernessct.R;
import com.example.invernessct.models.PostsObject;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    // Context object
    private Context mContext;
    // List of news feed objects (posts)
    private List<PostsObject> postsTable;

    public PostsAdapter(Context mContext, List<PostsObject> postsTable) {
        this.mContext = mContext;
        this.postsTable = postsTable;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_posts, viewGroup, false);
            return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder,int position) {
        PostsObject postsObject = postsTable.get(position);

        holder.textViewPostTitle.setText(postsObject.getPost_title());
        holder.textViewPostAuthor.setText(postsObject.getPost_author());
        holder.textViewPostContent.setText(postsObject.getPost_content());
        holder.textViewPostDate.setText(postsObject.getPost_date());
        holder.textViewPostCategory.setText(postsObject.getPost_category());

        String imageURL = "http://www.kamilwierzbicki.com/main/images/posts/" + postsObject.getPost_image();

            Picasso.get().load(imageURL).into(holder.imageViewPost);

    }

    @Override
    public int getItemCount() {
        return postsTable.size();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewPostTitle, textViewPostAuthor, textViewPostContent, textViewPostDate, textViewPostCategory;
        ImageView imageViewPost;

        public PostsViewHolder(View itemView){
            super(itemView);

            textViewPostTitle = itemView.findViewById(R.id.textViewPostTitle);
            textViewPostCategory = itemView.findViewById(R.id.textViewPostCategory);
            textViewPostAuthor = itemView.findViewById(R.id.textViewPostAuthor);
            textViewPostContent = itemView.findViewById(R.id.textViewPostContent);
            textViewPostDate = itemView.findViewById(R.id.textViewPostDate);
            imageViewPost = itemView.findViewById(R.id.imageViewPost);
        }
    }
}
