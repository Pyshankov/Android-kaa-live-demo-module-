package android.livedemo.kaa.kaaproject.org.android.demoapplications.gyroscopeapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.livedemo.kaa.kaaproject.org.android.R;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GyroscopeFragment.OnGyroscopeFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GyroscopeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GyroscopeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String TAG = GyroscopeFragment.class.getSimpleName();

    public static final String FRAGMENT_ID = "FRAGMENT_GYROSCOPE";

    // TODO: Rename and change types of parameters
    private String mParam1;


    private OnGyroscopeFragmentInteractionListener mListener;

    private TextView axisTextX;
    private TextView axisTextY;
    private TextView axisTextZ;

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private SensorEventListener eventListener;

    public GyroscopeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment GyroscopeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GyroscopeFragment newInstance(String param1) {
        GyroscopeFragment fragment = new GyroscopeFragment();
        Bundle args = new Bundle();
        args.putString(FRAGMENT_ID, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(FRAGMENT_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mSensorManager = (SensorManager) getActivity().getApplicationContext().getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        View view = inflater.inflate(R.layout.fragment_gyroscope, container, false);
        axisTextX = (TextView) view.findViewById(R.id.axis_x_text);
        axisTextY = (TextView) view.findViewById(R.id.axis_y_text);
        axisTextZ = (TextView) view.findViewById(R.id.axis_z_text);
        eventListener = new CustomSensorEventListener();

        mSensorManager.registerListener(eventListener,mSensor,SensorManager.SENSOR_DELAY_NORMAL);

        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onGyroscopeFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnGyroscopeFragmentInteractionListener) {
            mListener = (OnGyroscopeFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        mSensorManager.unregisterListener(eventListener);
        Log.d(TAG, "eventListener have been stopped");

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnGyroscopeFragmentInteractionListener {
        // TODO: Update argument type and name
        void onGyroscopeFragmentInteraction(Uri uri);
    }

    private class CustomSensorEventListener implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent event) {
            axisTextX.setText(String.valueOf(event.values[0]));
            axisTextY.setText(String.valueOf(event.values[1]));
            axisTextZ.setText(String.valueOf(event.values[2]));
            Log.d(TAG,"gyroscope values have been updated");
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            //stub
        }
    }
}
