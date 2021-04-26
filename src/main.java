import com.StudentScoresRank.OperationMenu;

/*-
 * @program: courseRank
 *
 * @description: main program
 *
 * @author: 1910120228_LOUIS
 *
 * @creat: 2021-04-23-20:42
 * */
public class main {
    public static void main(String[] args) {
        OperationMenu STU_TEACHER = null;
        try {
            STU_TEACHER = new OperationMenu();
            STU_TEACHER.Menu();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
