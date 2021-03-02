public class Students
{
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private int points;
    private int groupNum;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public int getGroupNum()
    {
        return groupNum;
    }

    public void setGroupNum(int groupNum)
    {
        this.groupNum = groupNum;
    }

    @Override
    public String toString()
    {
        return "\nСтудент №" + id +
                ">> Имя: '" + firstName + '\'' +
                " Фамилия: '" + lastName + '\'' +
                " Возраст: " + age +
                " Баллы: " + points + "\n";
    }
}
