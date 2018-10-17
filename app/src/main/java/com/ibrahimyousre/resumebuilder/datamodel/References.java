package com.ibrahimyousre.resumebuilder.datamodel;

import android.os.Parcel;

/**
 * Created by ibrahim on 1/18/18.
 */

public class References extends ResumeEvent {
    public References() {
    }

    public static final Creator<References> CREATOR = new Creator<References>() {
        @Override
        public References createFromParcel(Parcel in) {
            return new References(new ResumeEvent(in));
        }

        @Override
        public References[] newArray(int size) {
            return new References[size];
        }
    };

    public References(ResumeEvent event) {
        super(event);
    }

    public String getPersonName() {
        return getTitle();
    }

    public void setPersonName(String personName) {
        setTitle(personName);
    }

    public String getPersonEmail() {
        return getDetail();
    }

    public void setPersonEmail(String personEmail) {
        setDetail(personEmail);
    }

    public String getPersonPhone() {
        return getSubtitle();
    }

    public void setPersonPhone(String personPhone) {
        setSubtitle(personPhone);
    }

    public String getPersonInstitution() {
        return getShortDescription(); }

    public void setPersonInstitution(String personInstitution) {
        setShortDescription(personInstitution);
    }

}

