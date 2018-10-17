package com.ibrahimyousre.resumebuilder.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ibrahimyousre.resumebuilder.R;
import com.ibrahimyousre.resumebuilder.datamodel.Resume;
import com.ibrahimyousre.resumebuilder.helper.ResumeFragment;
import com.ibrahimyousre.resumebuilder.helper.TextChangeListener;

public class HobbiesFragment extends ResumeFragment {

    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new HobbiesFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =
                inflater.inflate(R.layout.fragment_hobbies, container, false);

        final Resume resume = getResume();

        EditText hobbiesFavourite = root.findViewById(R.id.edit_hobbies1);
        hobbiesFavourite.setText(resume.hobbiesFavourite);
        hobbiesFavourite.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resume.hobbiesFavourite = s.toString();
            }
        });
        return root;
    }
}
