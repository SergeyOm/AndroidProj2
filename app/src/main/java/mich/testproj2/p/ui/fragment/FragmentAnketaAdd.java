package mich.testproj2.p.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mich.testproj2.R;
import mich.testproj2.p.ui.activity.MainActivity;

/**
 * Created by michigan on 10/01/2016.
 */

public class FragmentAnketaAdd extends Fragment {
    Button addData;
    TextView name;
    TextView soname;
    TextView age;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_anketa_add, container, false);
        name = (TextView) v.findViewById(R.id.input_name);
        soname = (TextView) v.findViewById(R.id.input_soname);
        age = (TextView) v.findViewById(R.id.input_age);

        addData = (Button) v.findViewById(R.id.button_add);
        addData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        FragmentListPersons listFragment = new FragmentListPersons();
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name.toString());
                        bundle.putString("name", name.toString());
                        bundle.putString("name", name.toString());

                        listFragment.setArguments(bundle);

                        (MainActivity)v.getActivity().pers
                                .new

                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container_content_main, listFragment);
                        fragmentTransaction.commit();
                    }
                }

        );

        return v;
    }


}