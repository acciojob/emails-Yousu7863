package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar = new ArrayList<>(); // Stores all the meetings

    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);
    }

    public void addMeeting(Meeting meeting){
        this.calendar.add(meeting);
    }

    public ArrayList<Meeting> getCalendar() {
        return calendar;
    }

    public int findMaxMeetings(){

        if(calendar.isEmpty()) return 0;

        Collections.sort(calendar, new Sortbyendtime());

        LocalTime curEndTime= calendar.get(0).getEndTime();
        int maxMeetings= 1;

        for(Meeting meeting : calendar){

            if(meeting.getStartTime().compareTo(curEndTime) > 0){
                maxMeetings+=1;
                curEndTime= meeting.getEndTime();
            }
        }
        return maxMeetings;
    }
}
}