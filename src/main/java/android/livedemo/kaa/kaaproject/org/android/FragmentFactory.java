package android.livedemo.kaa.kaaproject.org.android;



import android.livedemo.kaa.kaaproject.org.android.demoapplications.demo.DemoFragment;
import android.livedemo.kaa.kaaproject.org.android.demoapplications.gyroscopeapp.GyroscopeFragment;
import android.support.v4.app.Fragment;

import java.util.NoSuchElementException;


public class FragmentFactory {

    private static GyroscopeFragment gyroscopeFragment;

    private static DemoFragment demoFragment;

    public static GyroscopeFragment getGyroscopeFragment(){
        if(gyroscopeFragment==null) gyroscopeFragment = new GyroscopeFragment();
        return gyroscopeFragment;
    }

    public static DemoFragment getDemoFragment(){
        if(demoFragment==null) demoFragment = new DemoFragment();
        return demoFragment;
    }

    public static Fragment getFragment(String fragmentId){

        if(fragmentId.equals(DemoFragment.FRAGMENT_ID))
            return getDemoFragment();

        else if(fragmentId.equals(GyroscopeFragment.FRAGMENT_ID))
            return getGyroscopeFragment();

        throw new NoSuchElementException("could not find a this type of fragment: "+ fragmentId);
    }

}
