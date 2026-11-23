package Do_An;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class file_ket_noi {
	// Tạo hàm kết nối
	public static Connection ham_ket_noi() throws SQLException {
		// Tạo biến lưu giá trị kết nối
		Connection ket_noi = null ;
		
		String url ="jdbc:sqlserver://localhost:1433;databaseName=HUYEN_LINH_TONG_COPY;encrypt=true;trustServerCertificate=true;" ;                         
		String userName = "huyenlinhtong" ;
		String password = "Hlt@2026Secure!";
		
		ket_noi = DriverManager.getConnection(url, userName, password);
		
		return ket_noi;
	}
	
}