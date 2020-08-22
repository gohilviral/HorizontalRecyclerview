package com.example.horizontalrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.holder>{

    Context context;
    ArrayList<String> arrayList;
    ArrayList<Model> getArrayList=new ArrayList<>();

    public Adapter(Context context, ArrayList<String> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view=layoutInflater.inflate(R.layout.vertical_layout,null);
       return new holder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        holder.title.setText(arrayList.get(position));
        int array []={R.drawable.game1,R.drawable.game1,R.drawable.game2,R.drawable.game6,R.drawable.game6,R.drawable.game1};

        String des[]={"Guard of Dungeon","Guard of Dungeon","Pool Hall","Vice City","Vice City","Game"};
        getArrayList.clear();
        for (int i=0;i<6;i++){

           /* Model model=new Model();

            getArrayList.add(model[i]);*/

            Model p=new Model();
            p.setDescription(des[i]);
            p.setImage(array[i]);
            getArrayList.add(p);
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setHasFixedSize(true);
        horizontalAdapter horizontalAdapter=new horizontalAdapter(context,getArrayList);
        holder.recyclerView.setAdapter(horizontalAdapter);

        horizontalAdapter.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {

        return arrayList.size();

    }

    public class holder extends RecyclerView.ViewHolder{

        TextView title;
        RecyclerView recyclerView;

        public holder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            recyclerView=itemView.findViewById(R.id.horizontal);
        }
    }
}
