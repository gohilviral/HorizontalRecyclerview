package com.example.horizontalrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class horizontalAdapter extends RecyclerView.Adapter<horizontalAdapter.holder> {

    Context context;
   // ArrayList<Integer>  arrayList;
    ArrayList<Model>  arrayList;

    public horizontalAdapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.horizontal_layout,null);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

    /*    holder.description.setText(arrayList.get(position));
        holder.imageView.setImageResource(arrayList.get(position));*/

    Model model=arrayList.get(position);

    holder.description.setText(model.getDescription());
    holder.imageView.setImageResource(model.getImage());
   // Picasso.with(context).load(model.image).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class holder extends RecyclerView.ViewHolder{

        TextView description;
        ImageView imageView;

        public holder(@NonNull View itemView) {
            super(itemView);

            description=itemView.findViewById(R.id.description);
            imageView=itemView.findViewById(R.id.imageview);
        }
    }
}
