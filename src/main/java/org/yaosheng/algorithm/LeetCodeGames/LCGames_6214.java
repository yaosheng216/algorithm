package org.yaosheng.algorithm.LeetCodeGames;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yaosheng on 2022/10/23.
 */
public class LCGames_6214 {

    public static boolean hasOverlap(Date leftStartDate,Date leftEndDate,Date rightStartDate,Date rightEndDate){
        return ((leftStartDate.getTime () >= rightStartDate.getTime ())
                && leftStartDate.getTime () < rightEndDate.getTime ())
            || ((leftStartDate.getTime () > rightStartDate.getTime ())
                && leftStartDate.getTime () <= rightEndDate.getTime ())
            || ((rightStartDate.getTime () >= leftStartDate.getTime ())
                &&rightStartDate.getTime () < leftEndDate.getTime ())
            || ((rightStartDate.getTime () > leftStartDate.getTime ())
                && rightStartDate.getTime () <= leftEndDate.getTime ());
    }

    public static boolean haveConflict(String[] event1, String[] event2) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        boolean b = false;
        try{
            Date leftStartDate = simpleDateFormat.parse (event1[0]);
            Date leftEndDate = simpleDateFormat.parse (event1[1]);
            Date rightStartDate = simpleDateFormat.parse (event2[0]);
            Date rightEndDate = simpleDateFormat.parse (event2[1]);

            b = hasOverlap (leftStartDate,leftEndDate,rightStartDate,rightEndDate);
        }catch (ParseException e){
            throw new RuntimeException ("时间类型转换失败");
        }
        return b;
    }

    public static void main(String[] args) {
        String[] s1 = {"01:00","02:00"};
        String[] s2 = {"01:20","03:00"};
        System.out.println (haveConflict (s1,s2));
    }
}
