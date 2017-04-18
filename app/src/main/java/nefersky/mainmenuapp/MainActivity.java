package nefersky.mainmenuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonMenu = (Button)findViewById(R.id.buttonMenu);
        TextView textView = (TextView)findViewById(R.id.textView);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        buttonMenu.setOnClickListener(viewOnClickListener);
        textView.setOnClickListener(viewOnClickListener);
        imageView.setOnClickListener(viewOnClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TextView infoTextView = (TextView)findViewById(R.id.textView);

        switch(id) {
            case R.id.action_cat_male:
                infoTextView.setText("Вы выбрали кота!");
                return true;
            case R.id.action_cat_female:
                infoTextView.setText("Вы выбрали кошку!");
                return true;
            case R.id.action_kitten:
                infoTextView.setText("Вы выбрали котенка!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onSettingsClick(MenuItem item) {
        TextView infoTextView = (TextView)findViewById(R.id.textView);
        infoTextView.setText("Вы выбрали пункт Settings, лучше бы выбрали кота");
    }

    View.OnClickListener viewOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            showPopupMenu(v);
        }
    };

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.inflate(R.menu.popupmenu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.menu1:
                        Toast.makeText(getApplicationContext(), "Вы выбрали PopupMenu 1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu2:
                        Toast.makeText(getApplicationContext(), "Вы выбрали PopupMenu 2", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu3:
                        Toast.makeText(getApplicationContext(), "Вы выбрали PopupMenu 3", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(getApplicationContext(), "onDismiss", Toast.LENGTH_SHORT).show();
            }
        });

        popupMenu.show();
    }
}
