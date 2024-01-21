package org.zerock.jdbcex.dao;

import lombok.Cleanup;
import org.zerock.jdbcex.domain.MemberVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    /** 회원가입 */
    public void joinMember(MemberVO vo) throws Exception {
        String sql = "INSERT INTO tbl_member (memberId, memberPw, memberName, memberPhone) VALUES (?, ?, ?, ? ) ";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, vo.getMemberId());
        preparedStatement.setString(2, vo.getMemberPw());
        preparedStatement.setString(3, vo.getMemberName());
        preparedStatement.setString(4, vo.getMemberPhone());

        //날짜가 오려면 LocalDate 타입은 지원하지 않으므로 java.sql.Date 타입을 이용해 변환해서 추가
        //예시) preparedStatement.setDate(5, Date.valueOf(vo.getJoinDate()));

        preparedStatement.executeUpdate();
        //DML(insert, update, delete) 실행 -> executeUpdate();

    }

    /**
     *  모든 회원 조회
     * */
    public List<MemberVO> selectAll() throws Exception {

        String sql = "SELECT * FROM tbl_member ";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<MemberVO> memberList = new ArrayList<>();

        while (resultSet.next()){
            MemberVO memberVO = MemberVO.builder()
                    .memberNo(resultSet.getInt("memberNo"))
                    .memberId(resultSet.getString("memberID"))
                    .memberPw(resultSet.getString("memberPw"))
                    .memberPhone(resultSet.getString("memberPhone"))
                    .memberShip(resultSet.getBoolean("memberShip"))
                    .build();

            memberList.add(memberVO);
        }
        return memberList;
    }

    /**
     *  특정 회원 조회
     * */
    public MemberVO selectOne(int memberNo) throws Exception {

        String sql = "SELECT * FROM tbl_member WHERE memberNo = ? ";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, memberNo);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        MemberVO vo = MemberVO.builder()
                .memberNo(resultSet.getInt("memberNo"))
                .memberId(resultSet.getString("memberID"))
                .memberPw(resultSet.getString("memberPw"))
                .memberPhone(resultSet.getString("memberPhone"))
                .memberShip(resultSet.getBoolean("memberShip"))
                .build();

        return vo;
    }

    /**
     *  회원 탈퇴
     * */
    public void deleteMember(int memberNo) throws Exception {

        String sql = "DELETE FROM tbl_member WHERE memberNo = ? ";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, memberNo);

        preparedStatement.executeUpdate();
    }

    /**
     *  회원정보 수정
     * */
    public void updateMember(MemberVO memberVO) throws Exception {

        String sql = "UPDATE tbl_member SET memberPw = ?, memberPhone = ? WHERE memberNo = ? ";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, memberVO.getMemberPw());
        preparedStatement.setString(2, memberVO.getMemberPhone());
        preparedStatement.setInt(3, memberVO.getMemberNo());

        preparedStatement.executeUpdate();
    }

}