package com.ibrahimyousre.resumebuilder.fragments;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.ibrahimyousre.resumebuilder.EditActivity;
import com.ibrahimyousre.resumebuilder.adapters.ReferencesAdapter;
import com.ibrahimyousre.resumebuilder.adapters.ResumeEventAdapter;
import com.ibrahimyousre.resumebuilder.adapters.SchoolsAdapter;
import com.ibrahimyousre.resumebuilder.datamodel.References;
import com.ibrahimyousre.resumebuilder.datamodel.Resume;
import com.ibrahimyousre.resumebuilder.datamodel.School;
import com.ibrahimyousre.resumebuilder.helper.ResumeEventFragment;
import com.ibrahimyousre.resumebuilder.helper.ResumeFragment;

public class ReferencesFragment extends ResumeEventFragment<References> {
    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new ReferencesFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    protected void delete(int pos) {
        getResume().references.remove(pos);
    }

    @Override
    public void onClick(int position) {
        Intent intent = EditActivity.getReferencesIntent(getContext());
        EditActivity.setData(intent, position, getResume().references.get(position));
        startActivityForResult(intent, REQUEST_EDIT);
    }

    @Override
    protected void addClicked() {
        Intent intent = EditActivity.getReferencesIntent(getContext());
        startActivityForResult(intent, REQUEST_ADD);
    }

    @Override
    protected ResumeEventAdapter<References> getAdapter(View emptyView) {
        return new ReferencesAdapter(getResume().references, this)
                .setEmptyView(emptyView);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ADD && resultCode == Activity.RESULT_OK) {
            getResume().references.add(new References(EditActivity.getEvent(data)));
            notifyDataChanged();
        }
        if (requestCode == REQUEST_EDIT && resultCode == Activity.RESULT_OK) {
            int id = data.getIntExtra(EditActivity.FIELD_ID, -1);
            getResume().references.get(id).cloneThis(EditActivity.getEvent(data));
            notifyDataChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
