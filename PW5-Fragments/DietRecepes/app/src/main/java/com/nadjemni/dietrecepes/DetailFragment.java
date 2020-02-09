package com.nadjemni.dietrecepes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    int id;
    public DetailFragment(int id) {
        this.id=id;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_details,container,false);
        ImageView meal_img=v.findViewById(R.id.meal_img);
        TextView meal_des=v.findViewById(R.id.meal_des);
        TextView meal_content=v.findViewById(R.id.meal_content);
        switch (id){
            case 0: {
                meal_img.setImageResource(R.drawable.abreakfast);
                meal_des.setText("You have to eat 353 calories at 08:00 am");
                meal_content.setText(
                        "- 1 Banana \n" +
                        "- 1 cup cow milk\n"+
                        "- 1 boiled egg \n"+
                                "- 2 cups of water \n"+
                                "- 1 piece of brown bread");
            }break;
            case 1: {
                meal_img.setImageResource(R.drawable.alunch);
                meal_des.setText("You have to eat 353 calories at 02:00 pm");
                meal_content.setText("- 10g meat \n" +
                        "- 1 cup lemon juice\n"+"- 200g boiled vegetbles \n"+"- 3 cups of water \n"+"- 3 piece of brown bread");

            }break;
            case 2: {

                meal_img.setImageResource(R.drawable.afruits);
                meal_des.setText("You can eat 131 calories at 07:00 pm");
                meal_content.setText("- 1/2 Banana \n" +
                        "- 1/2 avocado\n"+"- 1 apple \n"+"- 2 cups of water \n");

            }break;
            case 3: {

                meal_img.setImageResource(R.drawable.asalad);
                meal_des.setText("You have to eat 353 calories at 07:00 pm");
                meal_content.setText("- 300g Salade \n"
                        +"- 2 cups of water \n");

            }break;
        }
        return  v;
    }
}
