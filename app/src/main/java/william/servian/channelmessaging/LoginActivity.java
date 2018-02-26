package william.servian.channelmessaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,OnDownloadListener{

    private Button btnValider ;
    private EditText eddittextlogin;
    private EditText eddittextmdp;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnValider = (Button) findViewById(R.id.button_valider);
        btnValider.setOnClickListener(this) ;

        eddittextlogin = (EditText) findViewById(R.id.EditText_login);
        eddittextmdp = (EditText) findViewById(R.id.EditText_mdp);

        sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE);

    }

    @Override
    public void onClick(View v) {

        HttpPostHandler http = new HttpPostHandler();
        http.addOnDownloadListener(this);
        String url = "http://www.raphaelbischof.fr/messaging/?function=connect";
        HashMap<String,String> hasMap= new HashMap<>();
        hasMap.put("username",eddittextlogin.getText().toString());
        hasMap.put("password",eddittextmdp.getText().toString());
        http.execute(new PostRequest(url,hasMap));

        startActivity(new Intent(LoginActivity.this,ChannelListActivity.class));

    }


    @Override
    public void onDownloadComplete(String downloadedContent) {
        System.out.println(downloadedContent);
        Gson gson = new Gson();
        Reponse obj = gson.fromJson(downloadedContent, Reponse.class);
        sharedPreferences
                .edit()
                .putString("accessToken",obj.getAccesstoken())
                .apply();
    }

    @Override
    public void onDownloadError(String error) {

        Toast.makeText(getApplicationContext(),"Error = "+error,Toast.LENGTH_SHORT).show();

    }
}
