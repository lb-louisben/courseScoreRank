package com.StudentScoresRank;


import java.sql.*;
import java.util.*;


/*-
 * @program: courseRank
 *
 * @description: menu
 *
 * @author: 1910120228_LOUIS
 *
 * @creat: 2021-04-23-15:48
 * */

/**
 * @description: operationMenu
 * @Param: null
 * @return: null
 * @author: 1910120228_louis
 * @Date: 2021/4/23
 * @Time: 21:47
 **/
public class OperationMenu {
    private final Connection conn = null;
    Scanner scan = new Scanner(System.in);

    int stuID;

    /**
     * @description: MENU
     * @Param: null
     * @return: null
     * @author: 1910120228_louis
     * @Date: 2021/4/23
     * @Time: 21:47
     **/
    public void Menu() throws SQLException {
        Scanner scan = new Scanner(System.in);

        int choose;
        List<Integer> chos = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            chos.add(i);
        }
        Set<Integer> chooseSet = new HashSet<>(chos);

        do {
            System.out.println("======= Student test score-info management =======");
            System.out.println("\t1.Query personal information");
            System.out.println("\t2.Query all student score information");
            System.out.println("\t3.Modify information by ID");
            System.out.println("\t4.Delete student information by ID");
            System.out.println("\t5.Add information");
            System.out.println("\t6.Sort by score");
            System.out.println("\t7.EXIT");
            System.out.println("============== Please select (1-7) ===============");


            choose = scan.nextInt();
            while (!chooseSet.contains(choose)) {
                System.out.print("Please select (1-7):    ");
                choose = scan.nextInt();
            }

            System.out.println("************************************************************");
            switch (choose) {
                case 1 -> sbListById();
                case 2 -> showAllInfo();
                case 3 -> modifyInfoById();
                case 4 -> deleteInfoById();
                case 5 -> addInfoThroughId();
                case 6 -> sortScore();
                case 7 -> {
                    System.out.println("You've chosen to log out. Are you sure you want to log out?(y/n)");
                    String scanExit = scan.next();
                    if (scanExit.equals("y")) {
                        System.exit(-1);
                        System.out.println("You've successfully logged out of the system. Welcome to use it again!");
                    }
                }
            }
        } while (choose != 7);

        System.out.println(" Bye~ ");
        scan.close();

        try {
            assert false;
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @description: Query stuInfo by ID
     * @Param: null
     * @return: null
     * @author: 1910120228_louis
     * @Date: 2021/4/23
     * @Time: 21:44
     **/
    public void sbListById() {

        System.out.print("\t1、Please input the id u wanna query: ");
        stuID = scan.nextInt();
        System.out.println("The score information of the student with id " + stuID + " is as follows: ");
        System.out.println("StuId\t\tStuName\t\tChineseScore\tMathScore\tEngScore\tSciScore\tTotalScore");
        RankOperation stuOp = null;
        try {
            stuOp = new RankOperation();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert stuOp != null;
        System.out.print(
                stuOp.queryInfoById(stuID).getID() + "\t" + stuOp.queryInfoById(stuID).getNAME() + "\t\t\t" +
                        stuOp.queryInfoById(stuID).getScoreCN() + "\t\t\t\t" + stuOp.queryInfoById(stuID).getScoreMATH() + "\t\t\t" +
                        stuOp.queryInfoById(stuID).getScoreENG() + "\t\t\t" + stuOp.queryInfoById(stuID).getScoreSCI() + "\t\t\t" +
                        stuOp.queryInfoById(stuID).getTotalSCORES());
        System.out.println();
        System.out.println();
    }


    /**
     * @description: all of students scores
     * @Param: null
     * @return: null
     * @author: 1910120228_louis
     * @Date: 2021/4/23
     * @Time: 22:37
     **/
    public void showAllInfo() {
        System.out.println("The score information of all of student is as follows: ");
        System.out.println();
        List<StuInfo> stuInfoList = RankOperation.getInstance().totalStuInfo();
        System.out.println("StuId\t\tStuName\t\tChineseScore\tMathScore\tEngScore\tSciScore\tTotalScore");
        for (StuInfo stu : stuInfoList) {
            System.out.print(
                    stu.getID() + "\t" + stu.getNAME() + "\t\t\t" + stu.getScoreCN() + "\t\t\t\t" + stu.getScoreMATH() + "\t\t\t" +
                            stu.getScoreENG() + "\t\t\t" + stu.getScoreSCI() + "\t\t\t" + stu.getTotalSCORES()
            );
            System.out.println();
            System.out.println();
        }
    }


    /**
     * @description: Modify information by ID
     * @Param: null
     * @return: null
     * @author: 1910120228_louis
     * @Date: 2021/4/23
     * @Time: 21:45
     **/
    public void modifyInfoById() throws SQLException {
        System.out.println("Please input the ID u wanna modify");
        stuID = scan.nextInt();
        System.out.println("The score information of the student with id " + stuID + " is as follows: ");
        System.out.println("StuId\t\tStuName\t\tChineseScore\tMathScore\tEngScore\tSciScore\tTotalScore");
        RankOperation stuOp = null;
        try {
            stuOp = new RankOperation();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert stuOp != null;
        System.out.print(
                stuOp.queryInfoById(stuID).getID() + "\t" + stuOp.queryInfoById(stuID).getNAME() + "\t\t\t" +
                        stuOp.queryInfoById(stuID).getScoreCN() + "\t\t\t\t" + stuOp.queryInfoById(stuID).getScoreMATH() + "\t\t\t" +
                        stuOp.queryInfoById(stuID).getScoreENG() + "\t\t\t" + stuOp.queryInfoById(stuID).getScoreSCI() + "\t\t\t" +
                        stuOp.queryInfoById(stuID).getTotalSCORES());
        System.out.println();
        System.out.println("Please enter the student's new grade score as followed：");

        int CN, Math, Eng, Sci, TotalScore;
        String Name;

        System.out.print("New name：\t");
        Name = scan.next();

        System.out.print("New Chinese score: \t");
        CN = scan.nextInt();

        System.out.print("New math score: \t");
        Math = scan.nextInt();

        System.out.print("New English score: \t");
        Eng = scan.nextInt();

        System.out.print("New science score: \t");
        Sci = scan.nextInt();

        TotalScore = CN + Math + Eng + Sci;
        System.out.print("New total score: \t" + TotalScore);
        System.out.println();


        StuInfo stu = new StuInfo(stuID, Name, CN, Math, Eng, Sci, TotalScore);
        RankOperation insert = new RankOperation();
        boolean ok = insert.updateStu(stu);
        if (ok) {
            System.out.println("Save Successfully!");
        } else {
            System.out.println("Failed to save!");
        }
        System.out.println();
    }


    /**
     * @description:
     * @Param:
     * @return:
     * @author: 1910120228_louis
     * @Date: 2021/4/23
     * @Time: 23:59
     **/
    public void deleteInfoById() {
        StuInfo stu = new StuInfo();
        System.out.println("Please input the ID u wanna delete");
        stuID = scan.nextInt();
        System.out.println("The score information of the student with id " + stuID + " is as follows: ");
        stu.setID(stuID);

        System.out.println("StuId\t\tStuName\t\tChineseScore\tMathScore\tEngScore\tSciScore\tTotalScore");
        RankOperation stuOp = null;
        try {
            stuOp = new RankOperation();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert stuOp != null;
        System.out.print(
                stuOp.queryInfoById(stuID).getID() + "\t" + stuOp.queryInfoById(stuID).getNAME() + "\t\t\t" +
                        stuOp.queryInfoById(stuID).getScoreCN() + "\t\t\t\t" + stuOp.queryInfoById(stuID).getScoreMATH() + "\t\t\t" +
                        stuOp.queryInfoById(stuID).getScoreENG() + "\t\t\t" + stuOp.queryInfoById(stuID).getScoreSCI() + "\t\t\t");
        System.out.println(stuOp.queryInfoById(stuID).getTotalSCORES());
        System.out.println("是否真的删除(y/n)：");
        String confirm = scan.next();
        if (confirm.equals("y")) {
            boolean res = RankOperation.getInstance().deleteInfoById(stu);
            if (res) {
                System.out.println("Successfully delete student information with id !");
            } else {
                System.out.println("ERROR!! Failed to delete student information with id !");

            }
        }
        System.out.println();
        System.out.println();
    }

    /**
     * @description:
     * @Param:
     * @return:
     * @author: 1910120228_louis
     * @Date: 2021/4/24
     * @Time: 00:17
     **/
    public void addInfoThroughId() throws SQLException {

        String continuance;
        do {
            int ID, CN, Math, Eng, Sci, TotalScore;
            String Name;
            System.out.println("Add students and their test scores：");
            System.out.print("id \t");
            ID = scan.nextInt();
            System.out.print("Name: \t");
            Name = scan.next();
            System.out.print("CN: \t");
            CN = scan.nextInt();
            System.out.print("Math: \t");
            Math = scan.nextInt();
            System.out.print("Eng: \t");
            Eng = scan.nextInt();
            System.out.print("Sci: \t");
            Sci = scan.nextInt();
            TotalScore = CN + Math + Eng + Sci;
            System.out.println("Name: \t" + TotalScore);

            StuInfo stu = new StuInfo(ID, Name, CN, Math, Eng, Sci, TotalScore);
            boolean res = RankOperation.getInstance().saveScores(stu);
            if (res) {
                System.out.println("Insert data into the table assignment.score successfully!!");
            } else {
                System.out.println("Failed to insert data into table assignment.score!!");
            }
            System.out.println();

            System.out.print("Do you want to continue adding? (y/n)：");
            continuance = scan.next();
        } while (continuance.equals("y"));
    }


    /**
     * @description:
     * @Param:
     * @return:
     * @author: 1910120228_louis
     * @Date: 2021/4/23
     * @Time: 22:36
     **/
    public void sortScore() throws SQLException {
        System.out.println("The ranking in descending order of score is as follows:");
        System.out.println("StuId\t\tStuName\t\tChineseScore\tMathScore\tEngScore\tSciScore\tTotalScore");
        List<StuInfo> ranking = RankOperation.getInstance().Descending();
        for (StuInfo s : ranking) {
            System.out.print(
                    s.getID() + "\t" + s.getNAME() + "\t\t\t" + s.getScoreCN() + "\t\t\t\t" + s.getScoreMATH() + "\t\t\t" +
                            s.getScoreENG() + "\t\t\t" + s.getScoreSCI() + "\t\t\t");
            System.out.println(s.getTotalSCORES());
        }

    }
}
