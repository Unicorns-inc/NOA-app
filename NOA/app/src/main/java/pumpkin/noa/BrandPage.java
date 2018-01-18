package pumpkin.noa;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.login.widget.LoginButton;


public class BrandPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_page);

    }

    public void onClickGoToListOfPosts(View v) {
        Intent listIntent = new Intent(BrandPage.this, MainActivity.class);
        if (v.getId() == R.id.son_of_noa_logo) {
            listIntent.putExtra("key", "son_of_noa");
        }
        if (v.getId() == R.id.joanli_nor_jewellery_logo) {
            listIntent.putExtra("key", "joanli_nor_jewellery");
        }
        if (v.getId() == R.id.nordahl_jewellery_logo) {
            listIntent.putExtra("key", "nordahl_jewellery");

        }

        startActivity(listIntent);
    }



}
