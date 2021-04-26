package com.StudentScoresRank;


/*-
 * @project: CourseRank/src/com.StudentScoresRank/SyuInfo
 * @description: operation
 * @author: 1910120228_louis
 * @Date: 2021/4/21 18:45
 **/


public class StuInfo {

    private int ID;
    private String NAME;
    private int scoreCN;
    private int scoreMATH;
    private int scoreENG;
    private int scoreSCI;
    private int totalSCORES;


    public StuInfo(int ID, String NAME, int scoreCN, int scoreMATH, int scoreENG,int scoreSCI, int totalSCORES ){
        super();
        this.ID = ID;
        this.NAME = NAME;
        this.scoreCN = scoreCN;
        this.scoreMATH = scoreMATH;
        this.scoreENG = scoreENG;
        this.scoreSCI = scoreSCI;
        this.totalSCORES = totalSCORES;
    }



    public StuInfo(){
        super();
    }


    //id
    public void setID( int id) {
        this.ID = id;
    }

    public int getID() {
        return this.ID;
    }

    //name
    public void setNAME( String name){
        this.NAME = name;
    }

    public String getNAME() {
        return this.NAME;
    }

    //chinese
    public void setScoreCN(int scoreCN) {
        this.scoreCN = scoreCN;
    }

    public int getScoreCN() {
        return this.scoreCN;
    }

    //math
    public void setScoreMATH(int scoreMATH) {
        this.scoreMATH = scoreMATH;
    }

    public int getScoreMATH() {
        return this.scoreMATH;
    }

    //english
    public void setScoreENG(int scoreENG) {
        this.scoreENG =scoreENG;
    }

    public int getScoreENG() {
        return this.scoreENG;
    }

    //science
    public void setScoreSIC(int scoreSCI) {
        this.scoreSCI = scoreSCI;
    }

    public int getScoreSCI() {
        return this.scoreSCI;
    }

    //total_scores
    public void setTotalSCORES( int totalSCORE) {
        this.totalSCORES = totalSCORE;
    }

    public int getTotalSCORES() {
        return this.totalSCORES;
    }


}
