import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group
{
    public static Map<String, Long> groupsMap = new HashMap<>();
    private Long id;
    private String name;
    private List<Students> studentsList = new ArrayList<>();

    public Group(Long id, String name)
    {
        this.id = id;
        this.name = name;
        setStudentsList();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Students> getStudentsList()
    {
        return studentsList;
    }

    private void setStudentsList()
    {
        String selectTableSQL = "SELECT * FROM students WHERE groupnum=" + this.id;
        try
        {
            Connection dbConnect = JDBC.getDBConnection();
            Statement statement = dbConnect.createStatement();
            
            ResultSet rs = statement.executeQuery(selectTableSQL);

            Students student;

            while(rs.next())
            {
                student = new Students();
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("firstname"));
                student.setLastName(rs.getString("lastname"));
                student.setAge(rs.getInt("age"));
                student.setPoints(rs.getInt("points"));
                student.setGroupNum(rs.getInt("groupnum"));

                this.studentsList.add(student);
            }
        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void readGroups()
    {
        String selectTableSQL = "SELECT * FROM groups";
        try
        {
            Connection dbConnect = JDBC.getDBConnection();
            Statement statement = dbConnect.createStatement();

            ResultSet rs = statement.executeQuery(selectTableSQL);

            while(rs.next())
            {
                Long groupID = rs.getLong("id");
                String groupName = rs.getString("name");
                groupsMap.put(groupName, groupID);
            }

        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString()
    {
        return "Группа №" + id +
                ", Имя: '" + name + '\'' +
                ", Студенты:" + studentsList.toString() + "\n";
    }
}
