package greedy;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


class Meeting {
    public int start;
    public int end;
    public int pos;

    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting m1, Meeting m2) {
        if(m1.end > m2.end)
            return 1;
        else if(m1.end < m2.end)
            return -1;
        else if(m1.pos < m2.pos)
            return -1;
        return 1;
    }

}

public class nMeetingsOneRoom {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start[] = new int[n];
        int end[] = new int[n];
        for(int i = 0; i < n; ++i) {
            start[i] = sc.nextInt();
        }
        for(int i = 0; i < n; ++i) {
            end[i] = sc.nextInt();
        }
        ArrayList<Integer> result = getMaxMeetings(start, end);
        Iterator<Integer> resultIterator = result.iterator();
        while(resultIterator.hasNext()) {
            System.out.print(resultIterator.next() + " ");
        }
        sc.close();
    }

    private static ArrayList<Integer> getMaxMeetings(int[] start, int[] end) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        for(int i = 0; i < start.length; ++i) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }
        MeetingComparator mc = new MeetingComparator();
        Collections.sort(meetings, mc);
        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(meetings.getFirst().pos);
        int limit = meetings.getFirst().end;
        for(int i = 1; i < meetings.size(); ++i) {
            if(meetings.get(i).start > limit) {
                answers.add(meetings.get(i).pos);
                limit = meetings.get(i).end;
            }
        }
        return answers;
    }
}
