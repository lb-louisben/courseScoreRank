package com.Test;

import com.StudentScoresRank.RankOperation;
import com.StudentScoresRank.StuInfo;

import java.util.List;

/*-
 * @program: courseRank/src/com/Test/courseRank
 * @description: Test the method of getting data from the database
 * @author: 1910120228_LOUIS
 * @creat: 2021-04-21-22:28
 */
/**
* @description:
* @Param: 
* @return: 
* @author: 1910120228_louis
* @Date: 2021/4/22
* @Time: 12:37
*
**/
public class SelectMainTest {
    public static void main(String[] args){
        List<StuInfo> stuInfoList = RankOperation.getInstance().totalStuInfo();
        System.out.println("StuId\t\tStuName\t\tChineseScore\tMathScore\tEngScore\tSciScore\tTotalScore");
        for (StuInfo stu : stuInfoList) {
            System.out.print(
                    stu.getID()+"\t"+stu.getNAME()+"\t\t\t"+ stu.getScoreCN()+"\t\t\t\t"+stu.getScoreMATH()+"\t\t\t"+
                    stu.getScoreENG()+"\t\t\t"+ stu.getScoreSCI()+"\t\t\t"+stu.getTotalSCORES()
            );
            System.out.println();
        }
    }
}