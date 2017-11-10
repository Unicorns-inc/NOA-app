package pumpkin.noa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

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
        Bundle bundle = getIntent().getExtras();
        String key = bundle.getString("key");
        if(key.equals("son_of_noa"))
        {
            logo.setImageResource(R.drawable.sonofnoa);
        }
        if(key.equals("joanli_nor_jewellery"))
        {
            logo.setImageResource(R.drawable.joanli);
        }
        if(key.equals("nordahl_jewellery"))
        {
            logo.setImageResource(R.drawable.nordahl_jewellery);
        }
        postList.add(new PostTemplates("Valentine's Day", "bla bla bla LOVE", R.drawable.brand));
        postList.add(new PostTemplates("8 March", "bla bla bla Women", R.drawable.brand));
        postList.add(new PostTemplates("Birthday specials", "bla bla bla BD", R.drawable.brand));
        postList.add(new PostTemplates("You fucked up and your gf is mad? ", "bla bla bla Perfect Gift", R.drawable.brand));

        PostAdapter postAdapter = new PostAdapter(this, postList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(postAdapter);




    }
}
