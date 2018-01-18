package pumpkin.noa;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.share.ShareApi;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
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


public class MainActivity extends AppCompatActivity {

    private ShareDialog shareDialog;
    private Button button;
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
        shareDialog = new ShareDialog(this);
        button = (Button) findViewById(R.id.buttonShare);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Posts/SonOfNoa");
        Bundle bundle = getIntent().getExtras();
        String key = bundle.getString("key");
        if(key.equals("son_of_noa"))
        {
            logo.setImageResource(R.drawable.sonofnoa2);
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

        }
    public void onClickShare(View v) {
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ConstraintLayout row =(ConstraintLayout)v.getParent();

            TextView url = (TextView)row.getChildAt(4);
            TextView content = (TextView)row.getChildAt(1);
            ImageView image = (ImageView)row.getChildAt(2);
            Toast.makeText(this,url.getText(),Toast.LENGTH_LONG).show();



            ShareLinkContent contentLink = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse(url.getText().toString()))
                    .setQuote(content.getText().toString())
                    .setImageUrl(Uri.parse(url.getText().toString()))


                    .build();



            ShareDialog.show(this, contentLink);

        }
    }
    /*public void onClickShare(View v)
    {
        if(ShareDialog.canShow(SharePhotoContent.class)) {
            Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.brand);

            ConstraintLayout row =(ConstraintLayout)v.getParent();

            TextView url = (TextView)row.getChildAt(4);
            TextView contentText = (TextView)row.getChildAt(1);
            ImageView image2 = (ImageView)row.getChildAt(2);
            SharePhoto photo = new SharePhoto.Builder()
                    .setBitmap(image).setCaption(contentText.toString())
                    .build();

            SharePhotoContent content = new SharePhotoContent.Builder()
                    .addPhoto(photo)

                    .build();


            ShareApi.share(content,null);
        }
        else
        {
            Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show();
        }


    }*/

    public void onClickBack(View v)
    {
        Intent goBack = new Intent(MainActivity.this,BrandPage.class);
        startActivity(goBack);
    }







    }

