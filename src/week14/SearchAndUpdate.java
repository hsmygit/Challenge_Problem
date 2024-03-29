package week14;
import java.io.*;
import java.sql.*;

public class SearchAndUpdate {
    public static void main(String[] args){
        Connection conn;
        Statement stmt = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root", "4014");//JDBC 연결
            System.out.println("DB 연결 완료");
            stmt = conn.createStatement(); // SQL을 처리용 Statement 객체 생성

            stmt.executeUpdate("UPDATE book SET author = '제인 오스틴', title = 'Pride & Prejudice' WHERE title = 'Pride and Prejudice'");
            printTable(stmt);
        }catch (ClassNotFoundException e){
            System.out.println("JDBC 드라이버 로드 에러");
        }catch (SQLException e){
            System.out.println("SQL 실행 에러");
        }
    }

    //레코드의 각 열의 값 화면에 출력
    private static void printTable(Statement stmt)
    {
        ResultSet srs;
        System.out.printf("%4s |%-30s|%-30s|%-10s\n", "id", "title", "publisher", "author");
        try
        {
            srs = stmt.executeQuery("select * from book");
            while(srs.next())
            {
                System.out.printf("%4s|%-30s|%-30s|%-10s\n", new String(srs.getString("id")), srs.getString("title"), srs.getString("publisher"), srs.getString("author"));
            }
        } catch (SQLException e) { System.out.println("SQL 실행 에러"); }
    }
}