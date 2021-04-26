package com.Test;

import com.StudentScoresRank.RankOperation;
import com.StudentScoresRank.StuInfo;

/**
 * @program: CourseRank/src/com.Test/MainTest
 * @description: Test the method of inserting elements into the database table
 * @author: 1910120228_LOUIS
 * @creat: 2021-04-21-21:52
 */
public class MainTest {
    public static void main(String[] args) {

        //variable
        int id = 20210003;
        String name = "ABC_YL";
        int chinese = 120;
        int math = 130;
        int english = 90;
        int science = 237;
        int totalScore = chinese + math + english + science;


        StuInfo stu = new StuInfo();
        stu.setID(id);
        stu.setNAME(name);
        stu.setScoreCN(chinese);
        stu.setScoreMATH(math);
        stu.setScoreENG(english);
        stu.setScoreSIC(science);
        stu.setTotalSCORES(totalScore);

        boolean res = RankOperation.getInstance().saveScores(stu);

        if (res) {
            System.out.println("Insert data into the table assignment.score successfully!!");
        } else {
            System.out.println("Failed to insert data into table assignment.score!!");
        }
    }
}
