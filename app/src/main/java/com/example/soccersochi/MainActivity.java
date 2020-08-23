package com.example.soccersochi;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.accountFragment, R.id.meetFragment, R.id.merchFragment, R.id.socialFragment, R.id.newsFragment)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("OK",null);
        AlertDialog dialog=builder.create();
        String[] arr= new String[10];
        arr[0]="Мы пришли и верим в ребят,\n" +
                "Бело-синие победят! ";
        arr[1]="ФК Сочи - не робей,\n" +
                "Хэй, хэй!\n" +
                "По чужим воротам бей.\n" +
                "Хэй, хэй!";
        arr[2]="Нам ни водка ни чужие жены,\n" +
                "Не заменят сектор стадиона.\n";
        arr[3]="Каждый с детства точно знает,\n" +
                "Кто, когда и где играет.\n" +
                "Нас фанатов миллион,\n" +
                "Выше руки стадион.\n";
        arr[4]="Пусть судья сегодня глуп,\n" +
                "Победит любимый клуб!";
        arr[5]="Вперёд мой клуб! Вперёд родной!\n" +
                "Мы за тебя стоим горой!\n" +
                "Вперед мой клуб, вперёд мой клуб!\n" +
                "Тебя всегда победы ждут!";
        arr[6]="Будь победа иль беда —\n" +
                "Сочи, мы с тобой всегда!\n" +
                "Сочи, рвись смелее в бой —\n" +
                "Знай, что мы всегда с тобой!";
        arr[7]="Пусть даже судей, соперник подкупит,\n" +
                "Спорткомитет будет пусть за него,\n" +
                "Победу Сочи никому не уступит,\n" +
                "Соперник не сдержит атаки его.";
        arr[8]="Лучше флага нет во всем мире,\n" +
                "Лучше Сочи нет никого.\n" +
                "Не красно-белый,\n" +
                "А только бело синий";
        arr[9]="Пройдут недели и года !\n" +
                "Но будем мы верны всегда !\n" +
                "Футбол, подруги и друзья!\n" +
                "И бело-синие цвета!";
        dialog.setTitle("Кричалка дня!");
        dialog.setMessage(arr[new Random(System.currentTimeMillis()).nextInt(10)]);
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}