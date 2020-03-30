package com.droidbyme.recyclerviewselection.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.droidbyme.recyclerviewselection.R;
import com.droidbyme.recyclerviewselection.model.Planet;

import java.util.ArrayList;
import java.util.Locale;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {

    private Context context;
    private ArrayList<Planet> planets;

    public DataAdapter(Context context, ArrayList<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_planet, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        Planet planet = planets.get(position);
        holder.setDetails(planet);
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    class DataHolder extends RecyclerView.ViewHolder {

        private TextView txtName, txtConfirmed, txtHospitalized, txtDeceased;

        DataHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtConfirmed = itemView.findViewById(R.id.txtDistance);
            txtHospitalized = itemView.findViewById(R.id.txtGravity);
            txtDeceased = itemView.findViewById(R.id.txtDiameter);
        }

        void setDetails(Planet planet) {
            txtName.setText(planet.getPlanetName());
            txtConfirmed.setText(String.format(Locale.US, "Confirmed : %d", planet.getDistanceFromSun()));
            txtHospitalized.setText(String.format(Locale.US, "Hospitalized : %d", planet.getGravity()));
            txtDeceased.setText(String.format(Locale.US, "Deceased : %d", planet.getDiameter()));
        }
    }
}