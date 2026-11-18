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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPasswordField; 

public class Dang_Nhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_tai_khoan;
	private JPasswordField txt_mat_khau;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dang_Nhap frame = new Dang_Nhap();
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
	public Dang_Nhap() throws SQLException {
		Connection ket_noi = file_ket_noi.ham_ket_noi();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(0, 0, 436, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HUYỄN LINH TÔNG");
		lblNewLabel.setBounds(89, 10, 232, 29);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản : ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setBounds(10, 116, 134, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật Khẩu : ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setBounds(10, 148, 121, 30);
		contentPane.add(lblNewLabel_2);
		
		txt_tai_khoan = new JTextField();
		txt_tai_khoan.setBounds(154, 108, 252, 30);
		contentPane.add(txt_tai_khoan);
		txt_tai_khoan.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Đăng Nhập");
		lblNewLabel_3.setForeground(new Color(255, 128, 64));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(154, 60, 121, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btn_gia_nhap = new JButton("Gia Nhập");
		btn_gia_nhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tai_khoan = txt_tai_khoan.getText().trim();
				String mat_khau = new String(txt_mat_khau.getPassword());
				
				try {
					String sql = "SELECT * FROM Tai_Khoan \r\n"
							+ "WHERE Ten_Tai_Khoan = ? and Mat_Khau = ?; ";
					PreparedStatement ps = ket_noi.prepareStatement(sql);
					ps.setString(1, tai_khoan);
					ps.setString(2, mat_khau);
					
					ResultSet rs = ps.executeQuery();
					if( tai_khoan.isEmpty() || mat_khau.isEmpty() ) {
						JOptionPane.showMessageDialog(Dang_Nhap.this, "Nhập đầy đủ tên tài khoản và mật khẩu");
					}
					else if(rs.next() && rs.getString("Quyen").equals("thanhvien")) {
						JOptionPane.showMessageDialog(Dang_Nhap.this, "Đăng nhập thành công");
						Trang_Chu frame = new Trang_Chu(tai_khoan);
						frame.setVisible(true);
						Dang_Nhap.this.dispose();
					}
					else if(rs.getString("Quyen").equals("quantri")) {
						JOptionPane.showMessageDialog(Dang_Nhap.this, "Đăng nhập quản trị thành công");
						Quan_Tri frame = new Quan_Tri();
						frame.setVisible(true);
						Dang_Nhap.this.dispose();
					}else {
						JOptionPane.showMessageDialog(Dang_Nhap.this, "Sai tên tài khoản hoặc mật khẩu");
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(Dang_Nhap.this, "Sai tên tài khoản hoặc mật khẩu");
				}
			}
		});
		btn_gia_nhap.setForeground(new Color(255, 0, 255));
		btn_gia_nhap.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_gia_nhap.setBounds(296, 214, 110, 22);
		contentPane.add(btn_gia_nhap);
		
		JButton btn_quen_mat_khau = new JButton("Quên Mật Khẩu");
		btn_quen_mat_khau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quen_Mat_Khau frame = null;
				try {
					frame = new Quen_Mat_Khau();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				Dang_Nhap.this.dispose();
			}
		});
		btn_quen_mat_khau.setForeground(new Color(0, 128, 255));
		btn_quen_mat_khau.setBounds(10, 216, 121, 20);
		contentPane.add(btn_quen_mat_khau);
		
		JButton btn_dang_ky = new JButton("Đăng Ký");
		btn_dang_ky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dang_Ky frame = null;
				try {
					frame = new Dang_Ky();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				Dang_Nhap.this.dispose();
			}
		});
		btn_dang_ky.setForeground(Color.MAGENTA);
		btn_dang_ky.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btn_dang_ky.setBounds(154, 216, 110, 22);
		contentPane.add(btn_dang_ky);
		
		txt_mat_khau = new JPasswordField();
		txt_mat_khau.setBounds(154, 151, 252, 30);
		contentPane.add(txt_mat_khau);

	}
}
