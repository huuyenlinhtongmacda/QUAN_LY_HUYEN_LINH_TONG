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

public class Quen_Mat_Khau extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_taikhoan;
	private JTextField txt_thiendao;
	private JPasswordField txt_matkhaumoi;
	private JPasswordField txt_xacnhanmatkhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quen_Mat_Khau frame = new Quen_Mat_Khau();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Quen_Mat_Khau() throws SQLException {
		String thien_dao_y_chi = "2010";
		Connection ket_noi = file_ket_noi.ham_ket_noi();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 367);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(0, 0, 436, 38);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("HUYỄN LINH TÔNG");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Quên Mật Khẩu");
		lblNewLabel_3.setForeground(new Color(255, 128, 64));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(142, 48, 140, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 101, 134, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu Mới : ");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 142, 148, 22);
		contentPane.add(lblNewLabel_1_1);
		
		txt_taikhoan = new JTextField();
		txt_taikhoan.setColumns(10);
		txt_taikhoan.setBounds(152, 93, 263, 30);
		contentPane.add(txt_taikhoan);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Xác Nhận :");
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(10, 184, 148, 22);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Thiên Đạo :");
		lblNewLabel_1_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(10, 231, 148, 22);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txt_thiendao = new JTextField();
		txt_thiendao.setColumns(10);
		txt_thiendao.setBounds(154, 230, 261, 30);
		contentPane.add(txt_thiendao);
		
		JButton btnGiaNhp = new JButton("Gia Nhập");
		btnGiaNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dang_Nhap frame = null;
				try {
					frame = new Dang_Nhap();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				Quen_Mat_Khau.this.dispose();
			}
		});
		btnGiaNhp.setForeground(Color.MAGENTA);
		btnGiaNhp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGiaNhp.setBounds(148, 298, 110, 22);
		contentPane.add(btnGiaNhp);
		
		JButton btnXcNhn = new JButton("Xác Nhận :");
		btnXcNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tai_khoan = txt_taikhoan.getText().trim();
				String mat_khau_moi = new String(txt_matkhaumoi.getPassword());
				String thien_dao = txt_thiendao.getText().trim();
				if(thien_dao.equals(thien_dao_y_chi)) {
					try {
						String sql = "UPDATE Tai_Khoan SET Mat_Khau = ? WHERE Ten_Tai_Khoan = ?; ";
						PreparedStatement ps = ket_noi.prepareStatement(sql);
		                ps.setString(1, mat_khau_moi);
		                ps.setString(2, tai_khoan);
		                int ket_qua = ps.executeUpdate();

	                    if (ket_qua > 0) {
	                        JOptionPane.showMessageDialog(Quen_Mat_Khau.this, "Thay đổi mật khẩu thành công !");
	                    }
		                
					}catch (SQLException ex) {
	                	JOptionPane.showMessageDialog(Quen_Mat_Khau.this, "Đã sảy ra lỗi !");
	                }
				}else {
					JOptionPane.showMessageDialog(Quen_Mat_Khau.this, "Hãy tìm Phong Chủ của ngươi !");
				}
				
				
			}
		});
		btnXcNhn.setForeground(new Color(0, 255, 64));
		btnXcNhn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnXcNhn.setBounds(286, 300, 110, 22);
		contentPane.add(btnXcNhn);
		
		txt_matkhaumoi = new JPasswordField();
		txt_matkhaumoi.setBounds(152, 146, 263, 30);
		contentPane.add(txt_matkhaumoi);
		
		txt_xacnhanmatkhau = new JPasswordField();
		txt_xacnhanmatkhau.setBounds(152, 188, 263, 30);
		contentPane.add(txt_xacnhanmatkhau);

	}

}
