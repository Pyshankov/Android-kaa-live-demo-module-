package android.livedemo.kaa.kaaproject.org.android;

import android.app.Application;
import android.content.Context;
import android.util.Log;


public class LiveDemoApp extends Application {

    public static final String TAG = LiveDemoApp.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
    }

//    private static KaaClient mClient;
//
//    private static Context mContext;
//
////    private UiLifecycleHelper uiHelper;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        mContext = getApplicationContext();
//
//        mClient= Kaa.newClient(new AndroidKaaPlatformContext(mContext),new SimpleKaaClientStateListener());
//        mClient.start();
//    }
//
//    public void pause() {
//        /*
//         * Suspend the Kaa client. Release all network connections and application
//         * resources. Suspend all the Kaa client tasks.
//         */
//        mClient.pause();
//    }
//
//    public void resume() {
//        /*
//         * Resume the Kaa client. Restore the Kaa client workflow. Resume all the Kaa client
//         * tasks.
//         */
//        mClient.resume();
//    }
//
//    @Override
//    public void onTerminate() {
//        super.onTerminate();
//           /*
//         * Stop the Kaa client. Release all network connections and application
//         * resources. Shut down all the Kaa client tasks.
//         */
//        mClient.stop();
//    }
//
//    public KaaClient getKaaClient() {
//        return  mClient;
//    }
//
//    public void detachEndpoint() {
//        EndpointKeyHash endpointKey = new EndpointKeyHash(mClient.getEndpointKeyHash());
//        mClient.detachEndpoint(endpointKey, new OnDetachEndpointOperationCallback() {
//            @Override
//            public void onDetach(SyncResponseResultType syncResponseResultType) {
//                Log.i(TAG, "User was detached");
//            }
//        });
//    }

}
