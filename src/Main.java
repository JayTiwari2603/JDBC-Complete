import java.sql.*;

public class Main{

    private static final String url="jdbc:mysql://localhost:3306/mydb";           //Database ka url
    private static final String username="root";      //Database ka username
    private static final String password="Jay#26@1234";      //Databse ka password

    public static void main(String[] args) {
        //Driver load process
        try {
            //Here Class is the Class only and .forName is one the method and then we pass the String value
            Class.forName("com.mysql.cj.jdbc.Driver");// The Line is used for load Drivers
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        //Now connnection banana hai database ke sath:
        //Connection ka object isliye banaaya taaki vo connection ko hold rakh sake!
        try{
            Connection connection = DriverManager.getConnection(url, username, password);

            //The next step after creating connection is creating statement
            //This Statement interface is used to execute queries and database se data retrive karne me
            // and operation perform karne me!!
            Statement statement = connection.createStatement();
            String query ="select * from students";
            //ResultSet is used to hold the table which comes from database
            ResultSet resultSet=statement.executeQuery(query);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks=resultSet.getDouble("marks");
                System.out.println("ID: "+id);
                System.out.println("NAME: "+name);
                System.out.println("AGE: "+age);
                System.out.println("MARKS: "+marks);

            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }



    }
}