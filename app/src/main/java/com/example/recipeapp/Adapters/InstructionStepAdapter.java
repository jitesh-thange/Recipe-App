package com.example.recipeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.Models.Step;
import com.example.recipeapp.R;

import java.util.List;

public class InstructionStepAdapter extends RecyclerView.Adapter<InstructionStepViewHolder>{
    Context context;
    List<Step> list;

    public InstructionStepAdapter(Context context, List<Step> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public InstructionStepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionStepViewHolder(LayoutInflater.from(context).inflate(R.layout.list_instructions_steps,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull InstructionStepViewHolder holder, int position) {
        holder.textView_instruction_step_number.setText(String.valueOf(list.get(position).number));
        holder.textView_instruction_step_titel.setText(list.get(position).step);
        holder.recycler_instruction_ingredients.setHasFixedSize(true);
        holder.recycler_instruction_ingredients.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        InstructionsIngredientsAdapter instructionsIngredientsAdapter = new InstructionsIngredientsAdapter(context,list.get(position).ingredients);
        holder.recycler_instruction_ingredients.setAdapter(instructionsIngredientsAdapter);

        holder.recycler_instruction_equipments.setHasFixedSize(true);
        holder.recycler_instruction_equipments.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        InstructionsEquipmentAdapter instructionsEquipmentAdapter = new InstructionsEquipmentAdapter(context,list.get(position).equipment);
        holder.recycler_instruction_equipments.setAdapter(instructionsEquipmentAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class InstructionStepViewHolder extends RecyclerView.ViewHolder {
    TextView textView_instruction_step_number,textView_instruction_step_titel;
    RecyclerView recycler_instruction_equipments,recycler_instruction_ingredients;


    public InstructionStepViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_instruction_step_number = itemView.findViewById(R.id.textView_instruction_step_number);
        textView_instruction_step_titel = itemView.findViewById(R.id.textView_instruction_step_titel);
        recycler_instruction_equipments = itemView.findViewById(R.id.recycler_instruction_equipments);
        recycler_instruction_ingredients = itemView.findViewById(R.id.recycler_instruction_ingredients);
    }
}
