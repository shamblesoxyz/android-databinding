package com.assignment.databinding;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.io.Serializable;


public class UserModel extends BaseObservable implements Serializable {
    private String firstname;
    private String lastname;

    public UserModel() {
    }

    public UserModel(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Bindable
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
        notifyPropertyChanged(BR.firstname);
    }

    @Bindable
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
        notifyPropertyChanged(BR.lastname);
    }
}
