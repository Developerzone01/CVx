package com.ibrahimyousre.resumebuilder.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by ibrahim on 1/18/18.
 */

public class PersonalInfo implements Parcelable {
    private String name;
    private String jobTitle;
    private String addressLine1;
    private String addressLine2;
    private String phone;
    private String email;
    private String personalstatement;
    private String dateofbirth;
    private String currentresidence;


    public PersonalInfo() {
        this("", "", "", "", "", "","","","");
    }

    public PersonalInfo(String name, String jobTitle, String addressLine1, String addressLine2, String phone, String email, String personalstatement, String dateofbirth, String currentresidence) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.phone = phone;
        this.email = email;
        this.personalstatement = personalstatement;
        this.dateofbirth = dateofbirth;
        this.currentresidence = currentresidence;
    }

    protected PersonalInfo(Parcel in) {
        name = in.readString();
        jobTitle = in.readString();
        addressLine1 = in.readString();
        addressLine2 = in.readString();
        phone = in.readString();
        email = in.readString();
        personalstatement = in.readString();
        dateofbirth = in.readString();
        currentresidence = in.readString();
    }

    public static final Creator<PersonalInfo> CREATOR = new Creator<PersonalInfo>() {
        @Override
        public PersonalInfo createFromParcel(Parcel in) {
            return new PersonalInfo(in);
        }

        @Override
        public PersonalInfo[] newArray(int size) {
            return new PersonalInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(jobTitle);
        dest.writeString(addressLine1);
        dest.writeString(addressLine2);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(personalstatement);
        dest.writeString(dateofbirth);
        dest.writeString(currentresidence);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpersonalstatement(){return personalstatement;}

    public void setPersonalstatement(String personalstatement){this.personalstatement = personalstatement;}

    public String getDateofbirth(){return dateofbirth;}

    public void setDateofbirth(String dateofbirth){this.dateofbirth = dateofbirth;}

    public String getCurrentresidence(){return currentresidence;}

    public void setCurrentresidence(String currentresidence){this.currentresidence = currentresidence;}

}
