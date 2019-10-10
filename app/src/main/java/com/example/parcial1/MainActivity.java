package com.example.parcial1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.parcial1.MVC.EditActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Producto> productos;
    RecyclerView rv;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productos = new ArrayList<Producto>();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.title);

       // actionBar.setDisplayHomeAsUpEnabled(true);

        for(int i=0; i<12; i++){
            productos.add(new Producto("Producto "+(i +1), 34,13.00));
        }
      rv = (RecyclerView) this.findViewById(R.id.rvListado);
        adapter = new MyAdapter(productos,this);
        rv.setAdapter(adapter);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        //lm.setOrientation(LinearLayoutManager.HORIZONTAL);

        //GridLayoutManager lm = new GridLayoutManager(this, 2);

        rv.setLayoutManager(lm);


    }

    public void editarProducto(int posicion){
        Producto p = this.productos.get(posicion);

        Intent i = new Intent(this, EditActivity.class);
        i.putExtra("posicion", posicion + "");
        i.putExtra("nombre", p.getNombre());
        i.putExtra("cantidad", p.getCantidad() + "");
        i.putExtra("precio", p.getPrecio() + "");

        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();

            String nombre = extras.getString("nombre");
            int cantidad = Integer.parseInt(extras.getString("cantidad"));
            Double precio = Double.parseDouble(extras.getString("precio"));
            int posicion = Integer.parseInt(extras.getString("posicion"));

            Producto p = new Producto(nombre, cantidad, precio);

            this.productos.set(posicion, p);

            this.adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.adapter.notifyDataSetChanged();

    }
}
