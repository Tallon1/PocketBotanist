package com.java.pocketbotanist.view.adapter;

import static com.java.pocketbotanist.utils.Constants.PLANT_INTENT_EXTRAS_KEY;
import static com.java.pocketbotanist.utils.FirebaseConstants.FIREBASE_IMAGE_REFERENCE;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.java.pocketbotanist.databinding.FragmentAddPlantBinding;
import com.java.pocketbotanist.databinding.FragmentDiscoverBinding;
import com.java.pocketbotanist.databinding.ItemDiscoverPlantBinding;
import com.java.pocketbotanist.model.Plant;
import com.java.pocketbotanist.view.CheckPlantActivity;

import java.util.List;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.ViewHolder> {

    private Context context;
    private List<Plant> plantList;

    FragmentDiscoverBinding binding;

    public DiscoverAdapter(Context context, List<Plant> plantList) {
        this.context = context;
        this.plantList = plantList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemDiscoverPlantBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plant plant = plantList.get(position);

        Glide
                .with(context)
                .load(FIREBASE_IMAGE_REFERENCE.child(plant.getImage()))
                .into(holder.binding.ivPlantPhoto);

        holder.binding.tvCommonName.setText(plant.getCommonName());
        holder.binding.tvLatinName.setText(plant.getLatinName());
        if (!plant.isVerified()) holder.binding.ivVerified.setVisibility(View.GONE);

        holder.binding.ivMore.setOnClickListener(v -> goToCheckPlant(plant));
    }

    private void goToCheckPlant(Plant plant) {
        Intent intent = new Intent(context, CheckPlantActivity.class);
        intent.putExtra(PLANT_INTENT_EXTRAS_KEY, plant);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (plantList == null) {
            return 0;
        } else {
            return plantList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemDiscoverPlantBinding binding;

        public ViewHolder(ItemDiscoverPlantBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}