package pumpkin.noa;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo =(ImageView)findViewById(R.id.logo);
        final ArrayList<PostTemplates> postList = new ArrayList<PostTemplates>();
        final PostAdapter postAdapter = new PostAdapter(this, postList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(postAdapter);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Posts/SonOfNoa");
        Bundle bundle = getIntent().getExtras();
        String key = bundle.getString("key");
        if(key.equals("son_of_noa"))
        {
            logo.setImageResource(R.drawable.sonofnoa);
            myRef = database.getReference("Posts/SonOfNoa");
        }
        if(key.equals("joanli_nor_jewellery"))
        {
            logo.setImageResource(R.drawable.joanli);
            myRef = database.getReference("Posts/JoanliNorJewellery");
        }
        if(key.equals("nordahl_jewellery"))
        {
            logo.setImageResource(R.drawable.nordahl_jewellery);
            myRef = database.getReference("Posts/NordahlJewellery");
        }
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                PostTemplates newPost = dataSnapshot.getValue(PostTemplates.class);
                postAdapter.add(newPost);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_SHORT).show();

            }
        });



        /*postList.add(new PostTemplates("Valentine's Day", "bla bla bla LOVE"));
        postList.add(new PostTemplates("8 March", "bla bla bla Women"));
        postList.add(new PostTemplates("Birthday specials", "bla bla bla BD"));
        postList.add(new PostTemplates("You fucked up and your gf is mad? ", "bla bla bla Perfect Gift"));*/






    }
}
