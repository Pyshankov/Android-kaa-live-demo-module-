package android.livedemo.kaa.kaaproject.org.android.activity;

import android.livedemo.kaa.kaaproject.org.android.FragmentFactory;
import android.livedemo.kaa.kaaproject.org.android.R;
import android.livedemo.kaa.kaaproject.org.android.demoapplications.demo.DemoFragment;
import android.livedemo.kaa.kaaproject.org.android.demoapplications.gyroscopeapp.GyroscopeFragment;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DemoActivity extends AppCompatActivity implements GyroscopeFragment.OnGyroscopeFragmentInteractionListener,DemoFragment.OnDemoFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout

        String fragmentName = getIntent().getExtras().getString("fragmentName");



        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            Fragment firstFragment = FragmentFactory.getFragment(fragmentName);

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }


    @Override
    public void onGyroscopeFragmentInteraction(Uri uri) {
    }

    @Override
    public void onDemoFragmentInteraction(Uri uri) {
    }

}

