package com.example.syntagi.demoproject;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyAlertCustDial extends DialogFragment {
    @NonNull
  // @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
//        LayoutInflater inflater=getActivity().getLayoutInflater();
//        View view=inflater.inflate(R.layout.myalertcust_dial,null);
//        builder.setView(view);
//
//       builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
//           @Override
//           public void onClick(DialogInterface dialog, int which) {
//               Toast.makeText(getActivity(), "positive buttton click"+which, Toast.LENGTH_SHORT).show();
//           }
//       });
//
//       builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
//           @Override
//           public void onClick(DialogInterface dialog, int which) {
//               Toast.makeText(getActivity(), "negative buttton click"+which, Toast.LENGTH_SHORT).show();
//           }
//       });
//        Dialog dialog=builder.create();
//        return dialog;
//
//
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.myalertcust_dial,null);
    }
}
