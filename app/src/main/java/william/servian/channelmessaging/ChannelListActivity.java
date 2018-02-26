package william.servian.channelmessaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sacquind on 29/01/2018.
 */
public class ChannelListActivity extends AppCompatActivity implements View.OnClickListener,OnDownloadListener{
    SharedPreferences sharedPreferences;
    private ListView liste;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channellist);
        sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        HttpPostHandler http = new HttpPostHandler();
        http.addOnDownloadListener(this);
        HashMap<String, String> paramsPost = new HashMap<>();
        String myToken = sharedPreferences.getString("accessToken",null);
        paramsPost.put("accesstoken",myToken);
        http.execute(new PostRequest("http://www.raphaelbischof.fr/messaging/?function=getchannels",paramsPost));
        liste = (ListView) findViewById(R.id.listView);
    }

    @Override
    public void onClick(View v)
    {

    }

    @Override
    public void onDownloadComplete(String downloadedContent) {

        Gson gson = new Gson();
        ChannelReponse obj = gson.fromJson(downloadedContent, ChannelReponse.class);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        for (Channel chan:obj.getChannels()) {
            arrayAdapter.add(chan.getName().toString());

        }

        liste.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDownloadError(String error) {

    }
}