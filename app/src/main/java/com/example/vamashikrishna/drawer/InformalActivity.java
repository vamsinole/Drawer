package com.example.vamashikrishna.drawer;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InformalActivity extends AppCompatActivity {
    private String[] informal_events = {"Treasure Hunt","Gully Cricket","Roadies","China Town","Gamer's Asylum","Blind Date",
            "Street Soccer","Anime Quiz","PaaniPuri Junction","Pillow Fight","Photo Booth","Tv Quiz","BasketBall","B Quiz",
            "Lights! Camera! Action!","Intuizione","Balloon Fight","Bollywood Tambola","Cricket Quiz","Silver Screen",
            "Book Cricket","Ad-Mania","Tug of War","Ranneeti","Arm Wrestling"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informal);


        ListView listView = (ListView)findViewById(R.id.listView6);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,informal_events);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String formal = "";
                String string = "";
                String Name = "";
                String phone = "";
                String date = "";
                String time = "";
                switch (position) {
                    case 0:
                        formal = "TREASURE HUNT" ;
                        string = "You’ll see some rhyme and you will see some reason. Treasure Hunt is the game to play." ;
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 1:
                        formal = "GULLY CRICKET" ;
                        string = "It sure has been some time since we have broken some neighbourhood windows trying the helicopter shot.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 2:
                        formal = "ROADIES" ;
                        string = "A remake of the popular T.V. show,Roadies is not where you’ll score brownie points if you just sing or dance.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 3:
                        formal = "CHINA TOWN" ;
                        string = "Raise the stakes, put on your pokerface and set the scene for an unforgettable casino experience. So be ready and gamble to galore.All are invited!";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 4:
                        formal = "GAMER'S ASYLUM" ;
                        string = "Experience the world of computer games. Gear up for the ultimate gaming battle.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 5:
                        formal = "BLIND DATE" ;
                        string = "Ever dared of thinking that you can challenge the much clichéd love story of Romeo and Juliet or Adam and Eve? If you have, register it ";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 6:
                        formal = "STREET SOCCER" ;
                        string = "Inspired by the unbelievable tricks of the skilful footballers, this is one heck of an event for all the soccer maniacs! Let the ball do the talking.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 7:
                        formal = "ANIME QUIZ" ;
                        string = "All Naruto, One Piece and DBZ fans, get going and be ready to live up to your fantasy and prove that you are the biggest anime freak!! Dattebayo!!";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 8:
                        formal = "PAANIPURI JUNCTION" ;
                        string = "Get ready to smack the most delicious and famous Indian dish “PAANIPURI”!! Show your zest and mania for golgappe by drubbing other fanatics and turn into ZEALOT of paanipuri.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 9:
                        formal = "PILLOW FIGHT" ;
                        string = "The oh-so-common sport that is usually played on bed comes with a 'twist'.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 10:
                        formal = "PHOTO BOOTH" ;
                        string = "Do props excite you? Do frames amaze you?Then “Photobooth” is the event for you. Brace yourselves for you are going to have one hell of a time at Effe'15.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 11:
                        formal = "TV QUIZ" ;
                        string = "To all TV series freaks out there !! We provide you a great platform to prove yourself as the biggest TV series maniac.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 12:
                        formal = "BASKETBALL" ;
                        string = "Considered to be the number one team sport in the world, 3x3 basketball is increasingly playing an influential part for the development of basketball worldwide.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 13:
                        formal = "B QUIZ" ;
                        string = "Business is a game, played for fantastic stakes and you’re in competition with experts . If you want to win, you have to be the master of the game.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 14:
                        formal = "LIGHTS! CAMERA! ACTION!" ;
                        string = "All you need to do is, show your talent in the ever loved BOLLYWOOD.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 15:
                        formal = "INTUIZIONE" ;
                        string = "When a management team with a reputation for brilliance tackles a business with a reputation of bad economics, it is the reputation of the business that remains intact.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 16:
                        formal = "BALLOON FIGHT" ;
                        string = "Burst the balloon tied to your opponent’s leg while saving the one tied to your leg. Participate in a group of 5.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 17:
                        formal = "BOLLYWOOD TAMBOLA" ;
                        string = "Adding flavor to one of the most popular party game is the masala and the grandeur of one of the biggest Indian Industry – Bollywood.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 18:
                        formal = "CRICKET QUIZ" ;
                        string = "India is a country of cricket fanatics. So take a shot at our quiz and check where you stand.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 19:
                        formal = "SILVER SCREEN" ;
                        string = "For all the movie maniacs out there, we present you Silver Screen, the ultimate movie mela! Watch all your favourite movies 24x7 in surround sound with your friends and partners.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 20:
                        formal = "BOOK CRICKET" ;
                        string = "Remember your favourite past-time in school, this event takes you back in the time.";
                        break;
                    case 21:
                        formal = "AD-MANIA" ;
                        string = "Are you an Ad-Maniac? Are you confident you know each and every ad on the TV? Here is your chance to test and prove yourself!";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 22:
                        formal = "TUG OF WAR" ;
                        string = "Come in a group of 6 and test your ultimate strength .";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 23:
                        formal = "RANNEETI" ;
                        string = "It takes a touch of genius-and lot of courage-to move in the opposite direction and strive to win. Management is doing things right, leadership is doing the right things.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                        break;
                    case 24:
                        formal = "ARM WRESTLING" ;
                        string = "This event aims to find the best in this art. Grab your popeye spinach and get ready.";
                        Name = "";
                        phone = "";
                        date = "17-10-2016";
                        time = "04:30 PM";
                }
                startFormalService(formal,string,Name,phone,date,time);
            }
        });
    }


    private void startFormalService(String formal,String string,String Name,String phone,String date,String time) {
        Intent intent = new Intent(InformalActivity.this, FormalActivity.class);
        intent.putExtra("info", formal);
        intent.putExtra("info2",string);
        intent.putExtra("info3", Name);
        intent.putExtra("info4", phone);
        intent.putExtra("info5", date);
        intent.putExtra("info6", time);
        Bundle bndlanimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.left_go, R.anim.enter_right).toBundle();
        startActivity(intent, bndlanimation);
    }


    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_left, R.anim.exit_right);
    }
}
