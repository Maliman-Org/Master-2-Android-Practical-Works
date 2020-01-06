package com.nadjemni.dietrecepes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        RecyclerAdapter adapter;
        if(recyclerView!=null){
            //recyclerView=findViewById(R.id.recyclerView);
                    adapter =
                    new RecyclerAdapter(DietActivity.this,true,getSupportFragmentManager());
        }else {
            recyclerView=findViewById(R.id.recyclerView2);
            Log.e("null","nulle");
            adapter =new RecyclerAdapter(DietActivity.this,!true,getSupportFragmentManager());
        }
        recyclerView.setAdapter(adapter);
}
    public static class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.mViewHolder> {
    ArrayList<RecyclerAdapter.Meal> list;
    Context context;
    boolean goToAnother;
    FragmentManager fragmentManager;
    public RecyclerAdapter( final Context context, boolean goToAnotherActivity,FragmentManager manager) {
        list=new ArrayList<>();
        this.context=context;
        this.goToAnother=goToAnotherActivity;
        fragmentManager=manager;
        list.add(new RecyclerAdapter.Meal(0,"Breakfast","353 calories",
                "08:00 am",R.drawable.abreakfastv,true));
        list.add(new RecyclerAdapter.Meal(1,"Lunch","353 calories",
                "02:00 pm",R.drawable.alunchv,true));
        list.add(new RecyclerAdapter.Meal(2,"Snack","132 calories",
                "05:00 pm",R.drawable.afruitsv,false));
        list.add(new RecyclerAdapter.Meal(3,"Dinner","353 calories",
                "07:00 pm",R.drawable.asaladv,true));
    }

    @Override
    public RecyclerAdapter.mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_item,parent,false);
        RecyclerAdapter.mViewHolder mViewHolder =new RecyclerAdapter.mViewHolder(view,context,list,goToAnother,fragmentManager);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.mViewHolder holder, int position) {
        holder.title.setText(list.get(position).name);
        holder.date.setText(list.get(position).time);
        holder.des.setText(list.get(position).numberOfCalories);
        holder.avatar.setImageResource(list.get(position).avatar);
        holder.id=list.get(position).id;
        if(list.get(position).required){

        }else{

        }

    }

    @Override
    public int getItemCount() {
        if(list!=null)
            return list.size();
        else return 0;
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView title,des,date;
        ArrayList<RecyclerAdapter.Meal> list;
        final Context context;
        int id;
        public mViewHolder(View itemView, final Context context, ArrayList<RecyclerAdapter.Meal> list, boolean goToAnotherActivity, final FragmentManager manager)
        {
            super(itemView);
            this.list=list;
            this.context=context;
            if(goToAnotherActivity){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(context,DetailsActivity.class);
                        intent.putExtra("id",id);
                        context.startActivity(intent);
                    }
                });}
            else{
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DetailFragment fragment = new DetailFragment(id);
                                manager.beginTransaction()
                                .replace(R.id.detail_container, fragment)
                                .commit();

                    }
                });}
            avatar=itemView.findViewById(R.id.meal_img);
            title=itemView.findViewById(R.id.meal_name);
            des=itemView.findViewById(R.id.meal_calories);
            date=itemView.findViewById(R.id.meal_time);
        }
    }
    public static class Meal {
        String name,numberOfCalories,time;
        int avatar, id;
        boolean required;

        public Meal(int id,String name, String numberOfCalories, String time, int avatar, boolean required) {
            this.id=id;
            this.name = name;
            this.numberOfCalories = numberOfCalories;
            this.time = time;
            this.avatar = avatar;
            this.required = required;

        }
    }

}
}
