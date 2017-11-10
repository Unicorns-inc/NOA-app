package pumpkin.noa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginMenuActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login_menu);
        button = (Button)findViewById(R.id.buttonToBrandPage);
    }
    public void onClickGoToBrandPage(View v)
    {
        Intent intent= new Intent(LoginMenuActivity.this,BrandPage.class);
        startActivity(intent);

    }

}
