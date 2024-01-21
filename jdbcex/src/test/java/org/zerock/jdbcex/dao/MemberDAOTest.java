package org.zerock.jdbcex.dao;

import lombok.Cleanup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.domain.MemberVO;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberDAOTest {

    private MemberDAO memberDAO;

    @BeforeEach
    public void ready(){
        memberDAO = new MemberDAO();
    }

    @Test
    public void 회원가입() throws Exception {
        MemberVO memberVO = MemberVO.builder()
                .memberId("sin1167")
                .memberPw("ssy917")
                .memberName("신석용")
                .memberPhone("010-2736-1111")
                .build();

        memberDAO.joinMember(memberVO);

    }

    @Test
    void 회원목록조회() throws Exception {

        List<MemberVO> memberList = memberDAO.selectAll();
        memberList.forEach(member -> System.out.println(member));
    }

    @Test
    public void 번호로회원조회() throws Exception {

        int memberNo = 3;

        MemberVO memberVO = memberDAO.selectOne(memberNo);

        System.out.println(memberVO);

    }

    @Test
    public void 회원탈퇴() throws Exception {

        int memberNo = 6;

        memberDAO.deleteMember(memberNo);

    }

    @Test
    void 회원정보수정() throws Exception{

        MemberVO memberVO = MemberVO.builder()
                .memberNo(1)
                .memberPw("123123123")
                .memberPhone("010-2222-3333")
                .build();

        memberDAO.updateMember(memberVO);
    }
}