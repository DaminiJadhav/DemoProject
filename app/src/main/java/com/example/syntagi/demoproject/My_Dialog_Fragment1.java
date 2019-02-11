package com.example.syntagi.demoproject;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class My_Dialog_Fragment1 extends DialogFragment implements View.OnClickListener {
Button yes,no;
Communicator communicator;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator= (Communicator) context;
    }

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.my_dialog_fragmnet1,null);
       no=view.findViewById(R.id.button_1);
        yes=view.findViewById(R.id.button_2);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
       setCancelable(false);
       return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button_1)
        {
            communicator.onDialogMessage("No button click");
            dismiss();
//            Toast.makeText(getActivity(), "No button click", Toast.LENGTH_SHORT).show();
        }
        else
        {
            communicator.onDialogMessage("yes button click");
            dismiss();
//            Toast.makeText(getActivity(), "Yes button click", Toast.LENGTH_SHORT).show();
        }

            }
            interface Communicator
            {
                public void onDialogMessage(String message);
            }
}
