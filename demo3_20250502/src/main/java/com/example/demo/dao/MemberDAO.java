package com.example.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.MemberDTO;

@Repository // 인스턴스 자동 연결 
public class MemberDAO {
	
	@Autowired // jdbc api 쿼리를 실행시키면 자동으로 리스트에 넣어준다.
	private JdbcTemplate jt;
	
	//UPDATE
	public int update (MemberDTO member) {
		String query = "UPDATE TBL_MEMBER SET pw = ?, name = ?,phone =?, grade = ? WHERE id =? ";
		int result = jt.update(query,
					member.getPw(),
					member.getName(),
					member.getPhone(),
					member.getGrade(),
					member.getId());
		return result ; 
	}
	
	
	//INSERT
	public int insert(MemberDTO member) {
		String query = "INSERT INTO TBL_MEMBER VALUES(?,?,?,?,?)";
		int result = jt.update(query,
				member.getId(),
				member.getPw(),
				member.getName(),
				member.getPhone(),
				member.getGrade());
		return result;
							
	}
	
	//SELECT 
	//1개 조회
	public MemberDTO viewMember(String id) {
		String query = "SELECT * FROM TBL_MEMBER WHERE ID = ? ";
		MemberDTO member =jt.queryForObject(query, //하나의 데이터만 뽑을 때 
					new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class),id);
		return member ;
	}
	
	//전체 조회
	public List<MemberDTO> list() {
		String query = "SELECT * FROM TBL_MEMBER";
		List<MemberDTO> list = jt.query(query, //목록 데이터 얻을 때
						new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));

		return list;
	}

	//구식
	public List<MemberDTO> getList() {
		String query = "SELECT * FROM TBL_MEMBER";
		List<MemberDTO> mList = new ArrayList<>();
		try (Connection conn = DBcon.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {

			while (rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setGrade(rs.getString("grade"));

				mList.add(member);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mList;
	}
}
