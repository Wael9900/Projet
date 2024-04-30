package com.example.projet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class library extends Fragment {
    private ArrayList<String> photosLibraries = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_library, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view1);

        PictureDAO pictureDAO = new PictureDAO(getContext());
        pictureDAO.open();
        photosLibraries = (ArrayList<String>) pictureDAO.getAllURLs();
        pictureDAO.close();
        Collections.reverse(photosLibraries);

        library_adaptor adapter = new library_adaptor(photosLibraries, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}
