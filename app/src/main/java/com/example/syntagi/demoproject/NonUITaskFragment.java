package com.example.syntagi.demoproject;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NonUITaskFragment extends Fragment {

   public NonUITaskFragment()

   {

   }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        L.m("Fragment onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.m("Fragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        L.m("Fragment onCreateView");
       // return super.onCreateView(inflater, container, savedInstanceState);
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        L.m("Fragment onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        L.m("Fragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        L.m("Fragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        L.m("Fragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        L.m("Fragment onStop");
   }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        L.m("Fragment onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        L.m("Fragment onViewStateRestored");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        L.m("Fragment onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.m("Fragment onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        L.m("Fragment onDetach");
    }
}
