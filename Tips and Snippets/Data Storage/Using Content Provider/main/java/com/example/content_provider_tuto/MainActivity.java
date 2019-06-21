package com.example.content_provider_tuto;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.content_provider_tuto.data.PokemonContract.PokemonEntry;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayPokemon();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.item1){
                Toast.makeText(getApplicationContext(),"POKEMON !",Toast.LENGTH_SHORT).show();
                insertPokemon();
        }

        return super.onOptionsItemSelected(item);
    }

    private void insertPokemon(){

        ContentValues values = new ContentValues();

        values.put(PokemonEntry.COLUMN_POKE_NAME,"Zubat");
        values.put(PokemonEntry.COLUMN_POKE_TYPE,"Fly");
        values.put(PokemonEntry.COLUMN_POKE_ATK,15);
        values.put(PokemonEntry.COLUMN_POKE_DEF,8);

        Uri newUri = getContentResolver().insert(PokemonEntry.CONTENT_URI,values);
    }

    private void displayPokemon(){

        String[] projection = {
                PokemonEntry._ID,
                PokemonEntry.COLUMN_POKE_NAME,
                PokemonEntry.COLUMN_POKE_ATK
        };

        Cursor cursor = getContentResolver().query(
                PokemonEntry.CONTENT_URI,
                projection,
                null,
                null,
                null);

        TextView displayView = (TextView) findViewById(R.id.poke_list);

        int idIndex = cursor.getColumnIndex(PokemonEntry._ID);
        int nameIndex = cursor.getColumnIndex(PokemonEntry.COLUMN_POKE_NAME);
        int atkIndex = cursor.getColumnIndex(PokemonEntry.COLUMN_POKE_ATK);

        while (cursor.moveToNext()){

            int id = cursor.getInt(idIndex);
            String name = cursor.getString(nameIndex);
            int atk = cursor.getInt(atkIndex);

            displayView.append("\n"+id+" - "+
                    name+" - "+
                    atk+" - ");
        }

        cursor.close();

    }
}
