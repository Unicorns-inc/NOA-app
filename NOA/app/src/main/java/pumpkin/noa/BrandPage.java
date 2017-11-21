package pumpkin.noa;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

public class BrandPage extends AppCompatActivity {
    private ShareDialog shareDialog;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_page);
        shareDialog = new ShareDialog(this);
        button = (Button) findViewById(R.id.buttonShare);
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
        //startActivity(listIntent);
    }

    public void onClickShare(View v) {
        if (ShareDialog.canShow(SharePhotoContent.class)) {
            SharePhoto photo =
            SharePhotoContent linkContent = new SharePhotoContent.Builder().
                    addPhoto()








            shareDialog.show(linkContent);
        }
    }
}
