package com.spring.mvc.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbEmployeeRepository implements EmployeeRepository{


    //DB 접속정보 설정
    private String uid = "java01";
    private String upw = "1234";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe"; //데이터베이스가 어디있는지 주소
    private String driverName = "oracle.jdbc.driver.OracleDriver";

    @Override
    public void save(Employee employee) {
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, uid, upw);

            String sql = "INSERT INTO employee " +
                    "VALUES (seq_employee.?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, employee.getEmpName());
            pstmt.setInt(2, employee.getEmpNum());
            pstmt.setString(3, employee.getPosition());

            int result = pstmt.executeUpdate(); // 성공한 쿼리의 수 리턴
            if (result == 1) System.out.println("입력 성공!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> findAll() {

        List<Employee> employeeList = new ArrayList<>();

        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url,uid,upw);

            String sql = "SELECT * FROM employee";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                employeeList.add(new Employee());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void remove(int empNum) {
        try {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, uid, upw);

            String sql = "DELETE FROM employee WHERE empNum = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, empNum);

            int result = pstmt.executeUpdate(); // 성공한 쿼리의 수 리턴
            if (result == 1) System.out.println("삭제 성공!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
