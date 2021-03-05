import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase
{
    private static String selectTableSQLFind = "SELECT * FROM students WHERE";

    private static void findStudentsBy(String selectTableSQL)
    {
        try
        {
            Connection dbConnect = JDBC.getDBConnection();
            Statement statement = dbConnect.createStatement();

            ResultSet rs = statement.executeQuery(selectTableSQL);

            if(!rs.next()){
                System.out.println("Ничего по поиску не найдено!");
            }
            else{
                while(rs.next())
                {
                    System.out.println("Студент №" + rs.getLong("id"));
                    System.out.println("Имя: " + rs.getString("firstname"));
                    System.out.println("Фамилия: " + rs.getString("lastname"));
                    System.out.println("Возраст: " + rs.getInt("age"));
                    System.out.println("ID группы: " + rs.getInt("groupnum") + "\n");
                }
            }
        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    //Поиск студентов можно проводить как через запросы к БД,
    //так и через перебор списка, встроенного в класс Group
    //Запросы к БД

    public static void findStudentsById(Long id)
    {
        findStudentsBy(selectTableSQLFind + "id=" + id);
    }

    public static void findStudentsByFirstName(String firstName)
    {
        findStudentsBy(selectTableSQLFind + "firstname=" + firstName);
    }

    public static void findStudentsByLastName(String lastName)
    {
        findStudentsBy(selectTableSQLFind + "lastname=" + lastName);
    }


    public static void findStudentsByPoints(int points)
    {
        findStudentsBy(selectTableSQLFind + "points=" + points);
    }

    public static void findStudentsByAgeMore(int age)
    {
        findStudentsBy(selectTableSQLFind + "age>" + age);
    }

    public static void findStudentsByAgeEqual(int age)
    {
        findStudentsBy(selectTableSQLFind + "age=" + age);
    }

    public static void findStudentsByAgeLess(int age)
    {
        findStudentsBy(selectTableSQLFind + "age<" + age);
    }
}
