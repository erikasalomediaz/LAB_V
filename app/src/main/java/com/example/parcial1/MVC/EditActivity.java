package com.example.parcial1.MVC;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.parcial1.Producto;
import com.example.parcial1.R;
public class EditActivity extends AppCompatActivity {

    String posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.edit_title);

        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        Bundle extras = i.getExtras();

        this.posicion = extras.getString("posicion");
        String nombre = extras.getString("nombre");
        int cantidad = Integer.parseInt(extras.getString("cantidad"));
        Double precio = Double.parseDouble(extras.getString("precio"));

        EdModel p = new EdModel(nombre, cantidad, precio);//mi modelo
        EdController c = new EdController(p); //mi controller
        EdListener ml = new EdListener(c);//mi listener
        EdView v = new EdView(p, this, ml,c);//mi view
        c.setView(v);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (android.R.id.home == item.getItemId()) {
            super.finish();
        }
        return super.onOptionsItemSelected(item);


    }

    public void editarProducto(String name, int cantidad, Double precio) {
        Intent i = new Intent();
        i.putExtra("nombre", name + "");
        i.putExtra("cantidad", cantidad + "");
        i.putExtra("precio", precio + "");
        i.putExtra("posicion", this.posicion + "");

        setResult(RESULT_OK, i);
        super.finish();
    }
}