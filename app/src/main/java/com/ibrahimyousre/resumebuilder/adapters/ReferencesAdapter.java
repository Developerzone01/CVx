package com.ibrahimyousre.resumebuilder.adapters;

import android.support.annotation.NonNull;
import android.view.View;

import com.ibrahimyousre.resumebuilder.datamodel.References;
import com.ibrahimyousre.resumebuilder.datamodel.School;

import java.util.List;

/**
 * Created by ibrahim on 1/19/18.
 */

public class ReferencesAdapter extends ResumeEventAdapter<References> {

    public ReferencesAdapter (@NonNull List<References> list,
                          ResumeEventOnClickListener resumeEventOnClickListener) {
        super(list, resumeEventOnClickListener);
    }
}