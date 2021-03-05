import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainClass
{
    public static void main(String[] args)
    {
        List<Group> groupList = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        Group.readGroups();

        groupList = readAllGroups();

        System.out.println("Список всех групп: ");

        for(Map.Entry<String, Long> group : Group.groupsMap.entrySet())
        {
            System.out.printf("ID: %d NAME: %s \n", group.getValue(),group.getKey());
        }

        System.out.println("Студентов какой группы вывести? ");

        String nameGroup = in.nextLine();
        if(Group.groupsMap.get(nameGroup) != null){
            System.out.println(groupList.get(Math.toIntExact(Group.groupsMap.get(nameGroup)) - 1).getStudentsList().toString());
        }
        else System.out.println("Группы с таким именем нет!");

        DataBase.findStudentsByAgeMore(22);
    }

    static List<Group> readAllGroups() //Прочитать все группы из БД
    {
        String selectTableSQL = "SELECT * FROM groups";
        List<Group> groupList = new ArrayList<>();
        try
        {
            Connection dbConnect = JDBC.getDBConnection();
            Statement statement = dbConnect.createStatement();

            ResultSet rs = statement.executeQuery(selectTableSQL);

            Group group;

            while(rs.next())
            {
                group = new Group(rs.getLong("id"), rs.getString("name"));
                groupList.add(group);
            }

        } catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return groupList;
    }
}
