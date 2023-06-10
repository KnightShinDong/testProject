package com.sdh.boardProject.dao;


import com.sdh.boardProject.dto.MemberDto;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {

    DataSource dataSource;

    public void MemberDao() throws NamingException {

        try {
            Context context = new InitialContext();
            dataSource = (DataSource)context.lookup("java:comp/env/test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int memberJoin(MemberDto memberDto) {

        int resultNum = 0;

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = dataSource.getConnection();
            String query = "INSERT INTO members (memberId, memberPw, memberName, memberPhone, memberEmail) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, memberDto.getMemberId());
            pstmt.setString(2, memberDto.getMemberPw());
            pstmt.setString(3, memberDto.getMemberName());
            pstmt.setString(4, memberDto.getMemberPhone());
            pstmt.setString(5, memberDto.getMemberEmail());

            resultNum = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(pstmt != null) pstmt.close();
                if(conn!= null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultNum;
    }
}