package com.example.recipeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.Listeners.RecipeClickListenar;
import com.example.recipeapp.Models.SimiliarRecipeResponse;
import com.example.recipeapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SimiliarRecipeAdapter extends RecyclerView.Adapter<SimiliarRecipeViewHolder>{

    Context context;
    List<SimiliarRecipeResponse> list;
    RecipeClickListenar listener;


    public SimiliarRecipeAdapter(Context context, List<SimiliarRecipeResponse> list, RecipeClickListenar listenar) {
        this.context = context;
        this.list = list;
        this.listener = listenar;
    }

    @NonNull
    @Override
    public SimiliarRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SimiliarRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_similiar_recipe, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull SimiliarRecipeViewHolder holder, int position) {
        holder.textView_similiar_title.setText(list.get(position).title);
        holder.textView_similiar_title.setSelected(true);
        holder.textView_similiar_serving.setText(list.get(position).servings+" Persons");
        Picasso.get().load("https://img.spoonacular.com/recipeImages/"+list.get(position).id+"-556x370."+list.get(position).imageType).into(holder.imageView_similiar);

        holder.similiar_recipe_holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecipeClicked(String.valueOf(list.get(holder.getAbsoluteAdapterPosition()).id));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class SimiliarRecipeViewHolder extends RecyclerView.ViewHolder {
    CardView similiar_recipe_holder;
    TextView textView_similiar_title, textView_similiar_serving;
    ImageView imageView_similiar;

    public SimiliarRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        similiar_recipe_holder = itemView.findViewById(R.id.similiar_recipe_holder);
        textView_similiar_title = itemView.findViewById(R.id.textView_similiar_title);
        textView_similiar_serving = itemView.findViewById(R.id.textView_similiar_serving);
        imageView_similiar = itemView.findViewById(R.id.imageView_similiar);
    }
}
