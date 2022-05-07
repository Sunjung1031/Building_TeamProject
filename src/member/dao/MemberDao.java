package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
   public Member selectById(Connection conn, String id) throws SQLException{
      PreparedStatement pstmt = null; //쿼리문에 ? 를 사용하고, 객체를 캐시에 담아 재사용
      ResultSet rs = null;    //select의 결과를 저장하는 객체.
      try {
         pstmt = conn.prepareStatement("select * from main where memberId=?");
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         Member member = null;
      if(rs.next()) {
         member = new Member(
               rs.getString("memberid"),
               rs.getString("name"),
               rs.getString("password"),
               rs.getInt("total_size"),
               rs.getInt("com_heat"),
               rs.getInt("com_clean"),
               rs.getInt("com_ev"),
               rs.getInt("com_es"),
               rs.getInt("com_maintain"),
               rs.getInt("com_insur"),
               rs.getInt("com_labor"),
               rs.getInt("com_water"),
               rs.getInt("com_ele")
               );
      }
      //member테이블에서 memberid 컬럼값이 id 파라미터와 동일한 데이터를 조회한다.
      //데이터가 존재하면 22~28행의 코드를 이용해 Member 객체를 생성한다.
      //데이터가 존재하지 않으면 객체를 생성하지 않으므로 null을 리턴한다.
      return member;
      }finally {
         JdbcUtil.close(rs);
         JdbcUtil.close(pstmt);
      }
   }
   
   public void insert(Connection conn, Member mem)throws SQLException{
      try(PreparedStatement pstmt = conn.prepareStatement("insert into member values(?,?,?,?)")){
         pstmt.setString(1,mem.getId());
         pstmt.setString(2,mem.getName());
         pstmt.setString(3,mem.getPassword());
         pstmt.executeUpdate();
      }
   }
   public void update(Connection conn, Member mem)throws SQLException{
      try(PreparedStatement pstmt = conn.prepareStatement("update member set name =?, password=? where memberid=?")){
         pstmt.setString(1,mem.getName());
         pstmt.setString(2,mem.getPassword());
         pstmt.setString(3,mem.getId());
         pstmt.executeUpdate();
      }
   }
}