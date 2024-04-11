package com.example.login_php.funcionalidades;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
public class verPerfil extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cuenta);

        // Referencias a los TextViews en el layout
        TextView textViewCorreo = findViewById(R.id.textViewCorreo);
        TextView textViewContraseña = findViewById(R.id.textViewContraseña);
        TextView textViewNombre = findViewById(R.id.textViewNombre);
        TextView textViewRol = findViewById(R.id.textViewRol);

        // Abrir la base de datos en modo lectura
        SQLiteDatabase db = null;
        try {
            MyDBHelper dbHelper = new MyDBHelper(this);
            db = dbHelper.getReadableDatabase();

            // Consulta para obtener los detalles de la cuenta
            Cursor cursor = db.rawQuery("SELECT correo, contraseña, nombre, rol FROM cuentas", null);

            // Verificar si hay al menos un resultado
            if (cursor.moveToFirst()) {
                // Obtener los datos de la consulta
                String correo = cursor.getString(0);
                String contraseña = cursor.getString(1);
                String nombre = cursor.getString(2);
                String rol = cursor.getString(3);

                // Mostrar los detalles en los TextViews
                textViewCorreo.setText("Correo: " + correo);
                textViewContraseña.setText("Contraseña: " + contraseña);
                textViewNombre.setText("Nombre: " + nombre);
                textViewRol.setText("Rol: " + rol);
            } else {
                // No se encontraron resultados
                Toast.makeText(this, "No se encontraron detalles de la cuenta", Toast.LENGTH_SHORT).show();
            }

            // Cerrar el cursor
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar la base de datos
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
    }
}