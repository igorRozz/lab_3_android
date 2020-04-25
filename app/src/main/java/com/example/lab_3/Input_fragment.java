package com.example.lab_3;

import android.content.Context;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.TextView;


import androidx.fragment.app.Fragment;



public class Input_fragment extends Fragment {

    private Output_interface callback;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button okButton = (Button) getView().findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try
        {
            callback = (Output_interface)context;
        }
        catch(ClassCastException ex)
        {
            Log.d("Error", ex.getMessage());
        }
    }

    public void sendMessage() {
        EditText editDeparture = getView().findViewById(R.id.editDepature);
        EditText editArrival = getView().findViewById(R.id.editArrival);

        RadioGroup radGrp = getView().findViewById(R.id.radios);
        int id = radGrp.getCheckedRadioButtonId();
        String buffer = "";

        if(id!=-1 & editArrival.length()>0 & editDeparture.length()>0) {
            if(editArrival.length()>0) {
                switch (id) {
                    case R.id.firsttime:
                        buffer=("Вибрано потяг з " + editDeparture.getText() + " в " + editArrival.getText() + " в 19:15"+"\n");
                        break;
                    case R.id.secondtime:
                        buffer=("Вибрано потяг з " + editDeparture.getText() + " в " + editArrival.getText() + " в 20:45"+"\n");
                        break;
                    default:
                        break;
                }

            }
            callback.output(buffer);
        }
        else {
            Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Заповніть всі вікна, будь ласка", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


}
