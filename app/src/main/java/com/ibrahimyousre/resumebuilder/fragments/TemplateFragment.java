package com.ibrahimyousre.resumebuilder.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ibrahimyousre.resumebuilder.MainActivity;
import com.ibrahimyousre.resumebuilder.R;
import com.ibrahimyousre.resumebuilder.datamodel.Resume;
import com.ibrahimyousre.resumebuilder.helper.ResumeFragment;

public class TemplateFragment extends ResumeFragment {

    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new TemplateFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_template, container, false);
        ImageView image1 = (ImageView) root.findViewById(R.id.img1);
        ImageView image2 = (ImageView) root.findViewById(R.id.img2);
        ImageView image3 = (ImageView) root.findViewById(R.id.img3);
        ImageView image4 = (ImageView) root.findViewById(R.id.img4);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).openFragment(
                        PreviewFragment.newInstance(getResume()));
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).openFragment(
                        PreviewFragment2.newInstance(getResume()));
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).openFragment(
                        PreviewFragment3.newInstance(getResume()));
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).openFragment(
                        PreviewFragment4.newInstance(getResume()));
            }
        });
        return root;
    }
}