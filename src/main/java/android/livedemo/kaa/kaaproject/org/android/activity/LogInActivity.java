package android.livedemo.kaa.kaaproject.org.android.activity;

import android.content.Intent;
import android.livedemo.kaa.kaaproject.org.android.FragmentFactory;
import android.livedemo.kaa.kaaproject.org.android.R;
import android.livedemo.kaa.kaaproject.org.android.demoapplications.demo.DemoFragment;
import android.livedemo.kaa.kaaproject.org.android.demoapplications.gyroscopeapp.GyroscopeFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogInActivity extends AppCompatActivity  {

    private static final String TAG = LogInActivity.class.getSimpleName();

    private static List<String> fragmentList = new ArrayList<>(Arrays.asList(DemoFragment.FRAGMENT_ID,GyroscopeFragment.FRAGMENT_ID));

    ArrayAdapter<String> adapter;

    private Button buttonDemoActivity;
    private ListView fragmentsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        buttonDemoActivity = (Button) findViewById(R.id.button);
        fragmentsListView = (ListView) findViewById(R.id.listFragments);

        adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                fragmentList);

        fragmentsListView.setAdapter(adapter);

        fragmentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {

                String fragmentName = (String) (fragmentsListView.getItemAtPosition(myItemInt));
                Log.d(TAG,fragmentName);

                Intent intent = new Intent(getApplicationContext(), DemoActivity.class);
                intent.putExtra("fragmentName",fragmentName);
                startActivity(intent);

            }
        });
    }

    public void gotoDemoActivity(View view) {
        Intent intent = new Intent(this, DemoActivity.class);
        startActivity(intent);
    }


}
