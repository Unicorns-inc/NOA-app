package nordahl.andersen;

//https://github.com/firebase/FirebaseUI-Android/tree/master/auth#configuration

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.ui.auth.AuthUI;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "facebook";
    private CallbackManager callbackManager;
    private AccessToken facebookToken;
    private LoginButton facebookSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
     //   startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(Arrays.asList(AuthUI.FACEBOOK_PROVIDER)).build(),1);
        FacebookSdk.sdkInitialize(getApplicationContext());


        setContentView(R.layout.activity_main);

        facebookSignIn = (LoginButton)findViewById(R.id.facebookSignIn);
        ImageButton loginbutton = (ImageButton)findViewById(R.id.loginButton);
        initializeFacebookLogin();
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){

        }
    }

    private void initializeFacebookLogin() {
        callbackManager = CallbackManager.Factory.create();
        facebookSignIn.setReadPermissions("email", "public_profile", "user_friends");
        facebookSignIn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onCancel");
                facebookToken = loginResult.getAccessToken();
                nextActivity();

            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError");
            }


        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        callbackManager.onActivityResult(requestCode,resultCode,data);

    }

    public void handleFacebookAccessToken(AccessToken token){
        Log.d(TAG,"handleFacebookAccessToken:" + token);
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){//???
                    Log.d(TAG,"SgnInWthCredential:success(");
                    FirebaseUser user = mAuth.getCurrentUser();
                    nextActivity();
                    //https://www.youtube.com/watch?v=wbaPmFP83d0 1:29
                } else {
                    Log.w(TAG, "signInWithCredential:failure",task.getException());
                    Toast.makeText(MainActivity.this, "Autchentication failed.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    public void nextActivity(){
    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
    startActivity(intent);
    };


    /*
    public void facebookOnClick(View view) {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(
                                Arrays.asList(
                                        new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build()
                                ))
                        .build(), 1);

        callbacks:
            signInSuccess:  {
                Intent intent = new Intent(this, Main2Activity.class);
                // Do something.
                // Return type determines whether we continue the redirect automatically
                // or whether we leave that to developer to handle.

            }

*/
    // Initialize Facebook Login button
        //https://www.numetriclabz.com/android-facebook-integration-and-login/#Register_Callback_With_LoginButton - step 3 to make callback method
        //https://www.youtube.com/watch?v=vXxdHYs9SkQ login video with

/*

       if (mAuth.getCurrentUser() != null) {

            //if user, go to next activity

            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);

            Toast mytoast2 = new Toast(this);
            mytoast2.makeText(getApplicationContext(), "Check man, youre logged in",
                    mytoast2.LENGTH_LONG).show();

        } else {

            //if no user, stay on page, clear fields and display error message

            Toast mytoast = new Toast(this);
            mytoast.makeText(getApplicationContext(), "Error - not logged in!",
                    mytoast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUi(currentUser);
    }

   public void updateUI (FirebaseUser user) {

       if (user != null) {

           //if user, go to next activity

           Intent intent = new Intent(this, Main2Activity.class);
           startActivity(intent);

           Toast mytoast2 = new Toast(this);
           mytoast2.makeText(getApplicationContext(), "Check man, youre logged in",
                   mytoast2.LENGTH_LONG).show();

       } else {

           //if no user, stay on page, clear fields and display error message

           Toast mytoast = new Toast(this);
           mytoast.makeText(getApplicationContext(), "Error - not logged in!",
                   mytoast.LENGTH_LONG).show();

       }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException(exception));
                            Toast.makeText(FacebookLoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

       mAuth.signInWithCustomToken(mCustomToken)
            .

    addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete (@NonNull Task < AuthResult > task) {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithCustomToken:success");
                FirebaseUser user = mAuth.getCurrentUser();
                updateUI(user);
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithCustomToken:failure", task.getException());
                Toast.makeText(CustomAuthActivity.this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
                updateUI(null);
            }
        }
    });*/


}

