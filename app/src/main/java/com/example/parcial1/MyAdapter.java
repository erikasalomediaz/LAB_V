package com.example.parcial1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private List<Producto> productos;
    MainActivity mact;
public MyAdapter(List<Producto> productos, MainActivity ma){
this.productos = productos;
this.mact = ma;
}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);

        MyViewHolder myViewHolder = new MyViewHolder(v,this.mact);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.posicion = position;
        Producto p = this.productos.get(position);
        String can = String.valueOf(p.getCantidad());
        holder.tvNombre.setText(p.getNombre());
        holder.tvCantidad.setText(can);
       holder.tvPrecio.setText((p.getPrecio()).toString());

    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
