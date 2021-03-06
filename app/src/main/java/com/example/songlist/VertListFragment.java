package com.example.songlist;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class VertListFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vert_list, container, false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Playlist playlist = Playlist.getInstance();

        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        SongListAdapter songListAdapter = new SongListAdapter(this.getContext(),playlist, R.layout.vertical_row_item);
        recyclerView.setAdapter(songListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        FloatingActionButton floatingActionButton = view.findViewById(R.id.change_list);
        floatingActionButton.setOnClickListener(view1 -> Navigation.findNavController(view1).navigate(R.id.action_vertListFragment_to_horListFragment));
        return view;
    }
}