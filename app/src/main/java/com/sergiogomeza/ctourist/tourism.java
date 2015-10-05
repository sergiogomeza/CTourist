package com.sergiogomeza.ctourist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class tourism extends AppCompatActivity {
    private ListView lOption;
    private ArrayAdapter<String> listAdapter;
    int sel;
    ListView lstdatos;
    private Lista_op[] datos =
            new Lista_op[] {
                    new Lista_op(R.drawable.smartbov, "hotel","select"),
                    new Lista_op(R.drawable.smartstdom, "bar","select"),
                    new Lista_op(R.drawable.smartislands,"tourism","select"),
                    new Lista_op(R.drawable.smartstfel, "demography","select"),
                    new Lista_op(R.drawable.smartwcity, "about","select"),
                    new Lista_op(R.drawable.smartcar, "about","select")
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);

        Adapter adaptll = new Adapter(this, datos);
        lOption=(ListView)findViewById(R.id.lOption);
        lOption.setAdapter(adaptll);
        final Intent vaults= new Intent(this, vaults.class);
        final Intent domingo= new Intent(this, domingo.class);
        final Intent rosario= new Intent(this, rosario.class);
        final Intent stfelipe= new Intent(this, stfelipe.class);
        final Intent walledcity= new Intent(this, walledcity.class);

        String[] var = getResources().getStringArray(R.array.tourist_fields);
        datos[0].setName(var[0]);
        datos[1].setName(var[1]);
        datos[2].setName(var[2]);
        datos[3].setName(var[3]);
        datos[4].setName(var[4]);
        datos[5].setName(var[5]);
        lOption.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sel = (int) parent.getItemIdAtPosition(position);
                switch (sel) {
                    case 0:
                        startActivity(vaults);
                        //finish();
                        break;
                    case 1:
                        startActivity(domingo);
                        //finish();
                        break;
                    case 2:
                        startActivity(rosario);
                        //finish();
                        break;
                    case 3:
                        startActivity(stfelipe);
                        //finish();
                        break;
                    case 4:
                        startActivity(walledcity);
                        //finish();
                        break;
                    case 5:
                        finish();
                        break;
                    default:
                        Toast.makeText(tourism.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public class Adapter extends ArrayAdapter{
        public Adapter(Context context,Lista_op[] datos){
            super (context,R.layout.layout_item,datos);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater= LayoutInflater.from(getContext());
            View Item = inflater.inflate(R.layout.layout_item, null);

            ImageView ImagenMenu =(ImageView) Item.findViewById(R.id.imagen);
            ImagenMenu.setImageResource(datos[position].getIdent());

            TextView ItemMenu = (TextView) Item.findViewById(R.id.tNombre);
            ItemMenu.setText(datos[position].getName());

            TextView SubItemMenu= (TextView) Item.findViewById(R.id.other);
            SubItemMenu.setText(datos[position].getOther());

            return Item;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tourism, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
