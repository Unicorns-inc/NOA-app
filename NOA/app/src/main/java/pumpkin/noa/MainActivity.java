package pumpkin.noa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final ArrayList<PostTemplates> postList = new ArrayList<PostTemplates>();

        postList.add(new PostTemplates("Valentine's Day", "bla bla bla LOVE", R.drawable.brand));
        postList.add(new PostTemplates("8 March", "bla bla bla Women", R.drawable.brand));
        postList.add(new PostTemplates("Birthday specials", "bla bla bla BD", R.drawable.brand));
        postList.add(new PostTemplates("You fucked up and your gf is mad? ", "bla bla bla Perfect Gift", R.drawable.brand));

        PostAdapter postAdapter = new PostAdapter(this, postList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(postAdapter);


    }
}
