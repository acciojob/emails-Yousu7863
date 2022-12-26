package com.driver;

import java.time.LocalTime;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

class mycomparator implements Comparator<Meeting> {
    @Override public int compare(Meeting o1, Meeting o2)
    {
        return o1.getEndTime().compareTo(o2.getEndTime());
    }
}

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        LocalTime time_limit = LocalTime.ofSecondOfDay(0);
        int count = 1;
        mycomparator mc = new mycomparator();
        Collections.sort(calendar, mc);
        for(int i =1;i<calendar.size();i++){
            if(calendar.get(i).getStartTime().compareTo(time_limit) >0){
                count++;
                time_limit = calendar.get(i).getEndTime();
            }
        }
        return count;
    }
}
