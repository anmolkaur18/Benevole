package com.example.benevole;
import com.google.firebase.database.PropertyName;
public class Model {
    String name, eventDetails, link;


    @PropertyName("name")
    public String getName() {
        return name;
    }

    @PropertyName("eventDetails")
    public String getEventdetails() {
        return eventDetails;
    }

    @PropertyName("link")
    public String getLink() {return link; }
}
