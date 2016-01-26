package com.deepakm.algo.greedy.activityselection;

/**
 * Created by dmarathe on 1/23/16.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * You are given n activities with their start and finish times. Select the maximum number of activities that can be
 * performed by a single person, assuming that a person can only work on a single activity at a time.
 */
public class ActivitySelection {
    private final Activity[] activitis;

    public ActivitySelection(Activity[] activities) {
        this.activitis = activities;
    }

    public Activity[] select() {
        Collections.sort(Arrays.asList(activitis), new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                if( o1.getEndTime() > o2.getEndTime() ) return 1;
                if( o1.getEndTime() < o2.getEndTime() ) return -1;
                return 0;
            }
        });
        int j=0;
        System.out.println(activitis[j]);
        for(int i=1;i<activitis.length;i++){
            if( activitis[i].getStartTime() > activitis[j].getEndTime()){
                j = i;
                System.out.println(activitis[j]);
            }
        }
        return activitis;
    }


    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int finish[] = {2, 4, 6, 7, 9, 9};
        Activity[] activities = Activity.from(start, finish);
        ActivitySelection selection = new ActivitySelection(activities);
        Activity.print(activities);
        System.out.println();
        activities = selection.select();
       // Activity.print(selection.select());
    }
}

class Activity {
    private int startTime;
    private int endTime;

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String toString() {
        return "start : " + startTime + ", finish : " + endTime;
    }

    public static Activity[] from(int startTime[], int endTime[]) {
        if (startTime == null || endTime == null || startTime.length != endTime.length) {
            throw new IllegalArgumentException("array null or size mismatch");
        }
        Activity activities[] = new Activity[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            Activity activity = new Activity(startTime[i], endTime[i]);
            activities[i] = activity;
        }
        return activities;
    }

    public static void print(Activity[] activities) {
        for (Activity activity : activities) {
            System.out.println(activity);
        }
    }
}

