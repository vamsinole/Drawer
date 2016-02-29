package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.Arrays;

import static android.widget.SearchView.OnCloseListener;
import static android.widget.SearchView.OnQueryTextListener;
//AIzaSyBzydSVaaCjjdA9ImbsHrrhSll3nfLsCsI
public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnQueryTextListener {
    public static final int NOTIFICATION_ID = 1;
    private DrawerLayout drawerLayout;
    private SearchView searchView;
    private ListView listView;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    private String[] Items = {"Edm Night","Proshow","Alamode","Incendary","Celebrity Night",
            "La Frenze","Carpe Diem","Footloose","Dance Charades","Showoff",
            "Director's Cut","Double Trouble","Innovation","Bindaas Bol","Tongues on Fire","Kahani",
            "Graffiti","The Sketcher","Toon Con","Story Pic",
            "Treasure Hunt","Gully Cricket","Roadies","China Town","Gamer's Asylum","Blind Date",
            "Street Soccer","Anime Quiz","PaaniPuri Junction","Pillow Fight","Photo Booth","Tv Quiz","BasketBall","B Quiz",
            "Lights! Camera! Action!","Intuizione","Balloon Fight","Bollywood Tambola","Cricket Quiz","Silver Screen",
            "Book Cricket","Ad-Mania","Tug of War","Ranneeti","Arm Wrestling","MUN","Cognoscencia","Feathers","Dum Charades",
            "Melodiux", "Unplugged", "Antakshiri", "Psychadelia","Perplexus","Platzen","Stegolica","Konqueror","photography","Tasveer"};

    private String[] Values = {"Edm Night","Proshow","Alamode","Incendary","Celebrity Night",
            "La Frenze","Carpe Diem","Footloose","Dance Charades","Showoff",
            "Director's Cut","Double Trouble","Innovation","Bindaas Bol","Tongues on Fire","Kahani",
            "Graffiti","The Sketcher","Toon Con","Story Pic",
            "Treasure Hunt","Gully Cricket","Roadies","China Town","Gamer's Asylum","Blind Date",
            "Street Soccer","Anime Quiz","PaaniPuri Junction","Pillow Fight","Photo Booth","Tv Quiz","BasketBall","B Quiz",
            "Lights! Camera! Action!","Intuizione","Balloon Fight","Bollywood Tambola","Cricket Quiz","Silver Screen",
            "Book Cricket","Ad-Mania","Tug of War","Ranneeti","Arm Wrestling","MUN","Cognoscencia","Feathers","Dum Charades",
            "Melodiux", "Unplugged", "Antakshiri", "Psychadelia","Perplexus","Platzen","Stegolica","Konqueror","photography","Tasveer"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);


        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final Button button = (Button)findViewById(R.id.button4);
        final ImageView imageView = (ImageView)findViewById(R.id.image2);
        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) findViewById(R.id.search);


        searchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
        listView = (ListView)findViewById(R.id.list1);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(DrawerActivity.this,android.R.layout.simple_list_item_1,Items);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);
        setupSearchView();
        String previouslyStoredValue = sharedPreferences.getString("our_value", "No value found");


        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
            }
        });


        searchView.setOnCloseListener(new OnCloseListener() {
            @Override
            public boolean onClose() {
                listView.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                fab.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                searchView.onActionViewCollapsed();
                return true;
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = (String) listView.getAdapter().getItem(position);
                position = Arrays.asList(Values).indexOf(text);
                switch(position){
                    case 0:case 1:case 2:case 3:case 4:
                        Intentfunction(ProshowsActivity.class);
                        break;
                    case 5:case 6:case 7:case 8:case 9:
                        Intentfunction(DanceActivity.class);
                        break;
                    case 10:case 11:case 12:case 13:case 14:case 15:
                        Intentfunction(DramaActivity.class);
                        break;
                    case 16:case 17:case 18:case 19:
                        Intentfunction(FineArtsActivity.class);
                        break;
                    case 20:case 21:case 22:case 23:case 24:case 25:case 26:case 27:case 28:case 29:
                    case 30:case 31:case 32:case 33:case 34:case 35:case 36:case 37:case 38:case 39:
                    case 40:case 41:case 42:case 43:case 44:
                        Intentfunction(InformalActivity.class);
                        break;
                    case 45:case 46:case 47:case 48:
                        Intentfunction(LiteraryActivity.class);
                        break;
                    case 49:case 50:case 51:case 52:
                        Intentfunction(MusicActivity.class);
                        break;
                    case 53:case 54:case 55:case 56:
                        Intentfunction(OnlineActivity.class);
                        break;
                    case 57:case 58:
                        Intentfunction(PhotoActivity.class);
                }
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(NetworkInfo.State.CONNECTED != null) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setType("text/plain");
                    intent.setData(Uri.parse("mailto:"));
                    String string = "Hello This is Vamshikrishna";
                    String[] string1 = {"effervescence@iiita.ac.in"};
                    intent.putExtra(Intent.EXTRA_SUBJECT, string);
                    intent.putExtra(Intent.EXTRA_EMAIL, string1);
                    startActivity(intent);
                }
                else if(NetworkInfo.State.DISCONNECTED != null)
                {
                    Snackbar snackbar = Snackbar.make(drawerLayout, "Internet Connection Required", Snackbar.LENGTH_LONG).
                            setAction("RETRY",new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });
                    snackbar.setActionTextColor(Color.RED);
                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    snackbar.show();
                }
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://effervescence.iiita.ac.in"));
                startActivity(intent);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_Effervescence_open, R.string.navigation_Effervescence_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    public void Intentfunction(Class Activity){
        Intent intent;
        intent = new Intent(DrawerActivity.this, Activity);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go2, R.anim.enter_right2).toBundle();
        startActivity(intent, bndlanimation);
    }


    private void setupSearchView() {
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener((OnQueryTextListener) DrawerActivity.this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            listView.clearTextFilter();
        } else {
            listView.setFilterText(newText.toString());
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        moveTaskToBack(true);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.drawer, menu);
//        return true;
//    }

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intentfun(DrawerActivity.class);
        }
        else if (id == R.id.nav_proshows) {
            Intentfun(ProshowsActivity.class);
        }
        else if (id == R.id.nav_events) {
            Intentfun(EventActivity.class);
        }
        else if (id == R.id.nav_sponsors) {
            Intentfun(NextActivity.class);
        }
        else if (id == R.id.nav_reg) {
            Intentfun(RegActivity.class);
        }
        else if (id == R.id.nav_contact){
            Intentfun(ContactActivity.class);
        }
        else if (id == R.id.nav_gallery)
        {
            Uri uri = Uri.parse("https://effervescence.iiita.ac.in/gallery.html");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            Bundle bndlanimation =
                    ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go, R.anim.enter_right).toBundle();
            startActivity(intent,bndlanimation);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void Intentfun (Class Activity){
        Intent intent = new Intent(DrawerActivity.this,Activity);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go, R.anim.enter_right).toBundle();
        startActivity(intent, bndlanimation);
    }
}