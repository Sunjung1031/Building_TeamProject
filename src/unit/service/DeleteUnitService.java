package unit.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import unit.dao.UnitDAO;
import unit.model.Unit;

public class DeleteUnitService {
	private UnitDAO unitDAO = new UnitDAO();

	public void deletion(Unit unit) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Unit unitA = unitDAO.SelectByNo(conn, unit.getNo());
			System.out.println(unitA);
			if (unitA == null) {
				throw new UnitNotFoundException();
			}
			if (!canDelete(unit.getNo(), unitA)) {
				throw new PermissionDeniedException();
			}
			unitDAO.delete(conn, unit.getNo());
			
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canDelete(Unit no , Unit unitA) {
		return unitA.getNo().equals(no);
	}
}
