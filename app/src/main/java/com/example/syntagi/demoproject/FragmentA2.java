package com.example.syntagi.demoproject;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentA2 extends Fragment implements AdapterView.OnItemClickListener {

    ListView list1;
    Communicator com;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a2, container, false);
        list1 = view.findViewById(R.id.listview4);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.title2, android.R.layout.simple_list_item_1);
        list1.setAdapter(adapter);
        list1.setOnItemClickListener(this);
        return view;
    }

    public void setCommunicator(Communicator communicator) {
        this.com = communicator;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        com.respond(position);
    }

    public interface Communicator {
        public void respond(int index);
    }
}
