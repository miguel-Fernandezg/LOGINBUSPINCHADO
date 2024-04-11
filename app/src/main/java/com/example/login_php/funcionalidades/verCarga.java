package com.example.login_php.funcionalidades;

import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login_php.Database;
import com.example.login_php.objetos.Vehiculo;

import java.util.List;

public class verCarga extends AppCompatActivity {

    private List<Vehiculo> listaCargas;
    private ArrayAdapter<Vehiculo> adapter;
    private ListView listViewCarga;
    private Database database;

}
