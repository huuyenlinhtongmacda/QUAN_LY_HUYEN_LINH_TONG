package Do_An;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import java.sql.PreparedStatement;


public class Dang_Ky extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_taikhoan;
	private JPasswordField txt_matkhau;
	private JPasswordField txt_xacnhanmatkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dang_Ky frame = new Dang_Ky();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Dang_Ky() throws SQLException {
		Connection ket_noi = file_ket_noi.ham_ket_noi();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setForeground(new Color(255, 255, 128));
		panel.setBounds(0, 0, 436, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HUYỄN LINH TÔNG");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(99, 10, 232, 29);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Đăng Ký");
		lblNewLabel_3.setForeground(new Color(255, 128, 64));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(164, 56, 121, 30);
		contentPane.add(lblNewLabel_3);
		
		txt_taikhoan = new JTextField();
		txt_taikhoan.setBounds(122, 96, 287, 30);
		contentPane.add(txt_taikhoan);
		txt_taikhoan.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản : ");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 97, 134, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu : ");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 143, 134, 22);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Xác Nhân MK : ");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(10, 190, 134, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btn_gianhap = new JButton("Gia Nhập");
		btn_gianhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dang_Nhap frame = null;
				try {
					frame = new Dang_Nhap();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				Dang_Ky.this.dispose();
			}
		});
		btn_gianhap.setForeground(Color.MAGENTA);
		btn_gianhap.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_gianhap.setBounds(122, 229, 110, 22);
		contentPane.add(btn_gianhap);
		
		JButton btn_dangky = new JButton("Đăng Ký");
		btn_dangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tai_khoan = txt_taikhoan.getText().trim();
				String mat_khau = new String(txt_matkhau.getPassword());
				String xac_nhan_mat_khau = new String(txt_xacnhanmatkhau.getPassword());
				if(mat_khau.equals(xac_nhan_mat_khau)) {
					try {
						String sql = "insert into Tai_Khoan(Ten_Tai_Khoan, Mat_Khau , Quyen)\r\n"
								+ "values ( ? , ? , N'thanhvien');";
						PreparedStatement ps = ket_noi.prepareStatement(sql);
						ps.setString(1, tai_khoan);
						ps.setString(2, mat_khau);
						int ket_qua = ps.executeUpdate();
						if(ket_qua > 0) {
							JOptionPane.showMessageDialog(Dang_Ky.this, "Tạo tài khoản thành công");
							Thong_Tin frame = null;
							try {
								frame = new Thong_Tin(tai_khoan);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							frame.setVisible(true);
							Dang_Ky.this.dispose();
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(Dang_Ky.this, "Tài khoản đã tồn tại");
						
					}
				}else {
					JOptionPane.showMessageDialog(Dang_Ky.this, "Xác nhận mật khẩu không đúng");
					
				}
			}
		});
		btn_dangky.setForeground(Color.MAGENTA);
		btn_dangky.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_dangky.setBounds(299, 231, 110, 22);
		contentPane.add(btn_dangky);
		
		txt_matkhau = new JPasswordField();
		txt_matkhau.setBounds(122, 136, 287, 30);
		contentPane.add(txt_matkhau);
		
		txt_xacnhanmatkhau = new JPasswordField();
		txt_xacnhanmatkhau.setBounds(122, 189, 287, 30);
		contentPane.add(txt_xacnhanmatkhau);

	}

}
