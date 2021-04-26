package com.Test;

import com.StudentScoresRank.RankOperation;
import com.StudentScoresRank.StuInfo;

/*-
 * @program: courseRank
 *
 * @description: Test the method of deleting the student information corresponding to the id
 *
 * @author: 1910120228_LOUIS
 *
 * @creat: 2021-04-22-13:58
 * */

public class deleteMainTest {
    public static void main(String[] args) {
        StuInfo stu = new StuInfo();
        stu.setID(20210003);;
        boolean res = RankOperation.getInstance().deleteInfoById(stu);
        if (res) {
            System.out.println("Successfully delete student information with id !");
        }else {
            System.out.println("ERROR!! Failed to delete student information with id !");
        }
    }
}
