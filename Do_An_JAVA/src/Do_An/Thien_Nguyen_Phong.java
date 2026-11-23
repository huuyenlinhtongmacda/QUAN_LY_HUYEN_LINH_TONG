package Do_An;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Thien_Nguyen_Phong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int dap_an = 0;
	private String ma_thanh_vien = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thien_Nguyen_Phong frame = new Thien_Nguyen_Phong("admin");
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
	public Thien_Nguyen_Phong(String ten_tai_khoan) throws SQLException {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(0, 0, 780, 50);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("HUYỄN LINH TÔNG - Thiên Nguyên Phong");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(117, 10, 502, 29);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trang_Chu frame = null;
				try {
					frame = new Trang_Chu(ten_tai_khoan);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				Thien_Nguyen_Phong.this.dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(10, 12, 41, 32);
		panel.add(btnNewButton);
		
		JLabel lbl_thongtin = new JLabel("TNP01 - Xuyên Bạch");
		lbl_thongtin.setForeground(new Color(0, 0, 255));
		lbl_thongtin.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_thongtin.setBounds(10, 60, 227, 29);
		contentPane.add(lbl_thongtin);
		
		JLabel lblNewLabel_2 = new JLabel("Tính Toán Thiên Cơ :");
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(132, 151, 199, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDanhVng = new JLabel("Danh Vọng :");
		lblDanhVng.setForeground(Color.BLUE);
		lblDanhVng.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblDanhVng.setBounds(408, 60, 146, 29);
		contentPane.add(lblDanhVng);
		
		JLabel lbl_danhvong = new JLabel("100000 Vạn");
		lbl_danhvong.setForeground(Color.BLUE);
		lbl_danhvong.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_danhvong.setBounds(545, 60, 156, 29);
		contentPane.add(lbl_danhvong);
		
		JButton btn_cauhoi = new JButton("35 + 12 = ?");
		btn_cauhoi.setBackground(new Color(255, 255, 255));
		btn_cauhoi.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn_cauhoi.setBounds(132, 186, 447, 66);
		contentPane.add(btn_cauhoi);
		this.setLocationRelativeTo(null);
		
		JButton btn_A = new JButton("50");
		JButton btn_B = new JButton("65");
		JButton btn_C = new JButton("72");		
		JButton btn_D = new JButton("100");	
		
		hoat_dong(ten_tai_khoan, dap_an, lbl_thongtin, lbl_danhvong, btn_cauhoi, btn_A, btn_B, btn_C, btn_D );
		
		
		btn_A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dap_an_A = btn_A.getText().trim();
				
				if(dap_an_A.equals(String.valueOf(dap_an))) {
					try {
						dung("A", btn_A, btn_B, btn_C, btn_D, ten_tai_khoan, lbl_thongtin, lbl_danhvong, btn_cauhoi);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					try {
						sai("A", btn_A, btn_B, btn_C, btn_D, ten_tai_khoan, lbl_thongtin, lbl_danhvong, btn_cauhoi);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_A.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn_A.setBounds(115, 315, 146, 66);
		contentPane.add(btn_A);

		
		btn_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dap_an_B = btn_B.getText().trim();
				if(dap_an_B.equals(String.valueOf(dap_an))) {
					try {
						dung("B", btn_A, btn_B, btn_C, btn_D, ten_tai_khoan, lbl_thongtin, lbl_danhvong, btn_cauhoi);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					try {
						sai("B", btn_A, btn_B, btn_C, btn_D, ten_tai_khoan, lbl_thongtin, lbl_danhvong, btn_cauhoi);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_B.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn_B.setBounds(444, 315, 146, 66);
		contentPane.add(btn_B);
		
		
		btn_C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dap_an_C = btn_C.getText().trim();
				if(dap_an_C.equals(String.valueOf(dap_an))) {
					try {
						dung("C", btn_A, btn_B, btn_C, btn_D, ten_tai_khoan, lbl_thongtin, lbl_danhvong, btn_cauhoi);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					try {
						sai("C", btn_A, btn_B, btn_C, btn_D, ten_tai_khoan, lbl_thongtin, lbl_danhvong, btn_cauhoi);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_C.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn_C.setBounds(115, 418, 146, 66);
		contentPane.add(btn_C);
		
		
		btn_D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dap_an_D = btn_D.getText().trim();
				if(dap_an_D.equals(String.valueOf(dap_an))) {
					try {
						dung("D", btn_A, btn_B, btn_C, btn_D, ten_tai_khoan, lbl_thongtin, lbl_danhvong, btn_cauhoi);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					try {
						sai("D", btn_A, btn_B, btn_C, btn_D, ten_tai_khoan, lbl_thongtin, lbl_danhvong, btn_cauhoi);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_D.setFont(new Font("Tahoma", Font.BOLD, 25));
		btn_D.setBounds(444, 418, 146, 66);
		contentPane.add(btn_D);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Mobile Devices\\Không Có Tiêu Đề4_20251117213833(1).png"));
		lblNewLabel_1.setBounds(0, 47, 720, 566);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Thien_Nguyen_Phong.class.getResource("/Do_An/anh/Mystic Temple GUI Dashboard(1)(1).png")));
		lblNewLabel_3.setBounds(-29, -20, 790, 706);
		contentPane.add(lblNewLabel_3);
	}
	
	public void hoat_dong(String ten_tai_khoan, int dap_an, JLabel lbl_thongtin, JLabel lbl_danhvong, JButton btn_cauhoi, JButton btn_A, JButton btn_B, JButton btn_C, JButton btn_D ) throws SQLException {
		
		
		
		Connection ket_noi = file_ket_noi.ham_ket_noi();
		
		String ten_thanh_vien = "" ;
		int danh_vong = 0;
		
		String sql = "SELECT \r\n"
				+ "tv.Ma_Thanh_vien,\r\n"
				+ "tv.Ten_Thanh_Vien,\r\n"
				+ "tt.Danh_Vong\r\n"
				+ "FROM Thanh_Vien tv\r\n"
				+ "JOIN Thong_Tin_Thanh_Vien tt\r\n"
				+ "ON tv.Ma_Thanh_Vien = tt.Ma_Thanh_Vien\r\n"
				+ "WHERE tv.Ten_Tai_khoan = ?;";
		PreparedStatement ps = ket_noi.prepareStatement(sql);
		ps.setString(1, ten_tai_khoan);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			ma_thanh_vien = rs.getNString("Ma_Thanh_Vien");
			ten_thanh_vien = rs.getNString("Ten_Thanh_Vien");
			danh_vong = rs.getInt("Danh_Vong");
		}
		String thong_tin = ma_thanh_vien + " - " + ten_thanh_vien ;
		String cau_hoi = cau_hoi(btn_A, btn_B, btn_C, btn_D);
		lbl_thongtin.setText(thong_tin);
		lbl_danhvong.setText(String.valueOf(danh_vong ));
		btn_cauhoi.setText(cau_hoi);
		
	}
	
	public String cau_hoi(JButton btn_A, JButton btn_B, JButton btn_C, JButton btn_D) {
		
		Random rd = new Random();

		int so_dau = 0;
		int so_cuoi = 0;
		int vi_tri = 0;
		// int dap_an = 0 ; ở dòng 46

		String[] phep_tinh = {" + ", " - ", " x ", " / "," / "};
		String cau_hoi = "";

		while (true) {

		    so_dau = rd.nextInt(100) + 1;
		    so_cuoi = rd.nextInt(100) + 1;

		    vi_tri = rd.nextInt(phep_tinh.length);

		    if (vi_tri == 3 && so_dau % so_cuoi != 0) {
		        continue;
		    }

		    if (vi_tri == 0) {
		        dap_an = so_dau + so_cuoi;
		    }
		    else if (vi_tri == 1) {
		        dap_an = so_dau - so_cuoi;
		    }
		    else if (vi_tri == 2) {
		        dap_an = so_dau * so_cuoi;
		    }
		    else if (vi_tri == 3 || vi_tri == 4) {
		        dap_an = so_dau / so_cuoi;
		    }

		    cau_hoi = so_dau + phep_tinh[vi_tri] + so_cuoi + " = ?";
		    
		    break;
		}

		//dap an
		
		int [] dap_an1 = { 0 , 0 , 0 , 0 };
		
		
		for(int i = 0 ; i <= 3 ; i ++) {
			int vi_tri1 = rd.nextInt(2);
			
			if(vi_tri1 == 0) {
				dap_an1[i] = dap_an + rd.nextInt(20) + 1;
			}else {
				dap_an1[i] = dap_an - rd.nextInt(20) - 1;
			}
		}
		int vi_tri_dung = rd.nextInt(4);
		dap_an1[vi_tri_dung] = dap_an;
		
		btn_A.setText(String.valueOf(dap_an1[0]));
		btn_B.setText(String.valueOf(dap_an1[1]));
		btn_C.setText(String.valueOf(dap_an1[2]));
		btn_D.setText(String.valueOf(dap_an1[3]));
	

		return cau_hoi;
	}
	
	public void dung(String dap_an_chon, JButton btn_A, JButton btn_B, JButton btn_C, JButton btn_D, String ten_tai_khoan, JLabel lbl_thongtin, JLabel lbl_danhvong, JButton btn_cauhoi) throws SQLException {
		
		Connection ket_noi = file_ket_noi.ham_ket_noi();
		
		Color mau_A = btn_A.getBackground();
		Color mau_B = btn_B.getBackground();
		Color mau_C = btn_C.getBackground();
		Color mau_D = btn_D.getBackground();

		Color chu_A = btn_A.getForeground();
		Color chu_B = btn_B.getForeground();
		Color chu_C = btn_C.getForeground();
		Color chu_D = btn_D.getForeground();
		
		if(dap_an_chon.equals("A")) {
			btn_A.setBackground(Color.GREEN);
			btn_A.setForeground(Color.WHITE);
		}else if(dap_an_chon.equals("B")) {
			btn_B.setBackground(Color.GREEN);
			btn_B.setForeground(Color.WHITE);
		}else if(dap_an_chon.equals("C")) {
			btn_C.setBackground(Color.GREEN);
			btn_C.setForeground(Color.WHITE);
		}else if(dap_an_chon.equals("D")) {
			btn_D.setBackground(Color.GREEN);
			btn_D.setForeground(Color.WHITE);
		}
		
		int danh_vong_hien_tai = Integer.parseInt(lbl_danhvong.getText());
		int danh_vong_moi = danh_vong_hien_tai + 10 ;
		
		String sql = "UPDATE Thong_Tin_Thanh_Vien\r\n"
				+ "SET Danh_Vong = ?\r\n"
				+ "WHERE Ma_Thanh_Vien = ?;";
		
		PreparedStatement ps = ket_noi.prepareStatement(sql);
		ps.setInt(1, danh_vong_moi);
		ps.setString(2, ma_thanh_vien);
		int rs = ps.executeUpdate();
		System.out.println(rs);
		
		JOptionPane.showMessageDialog(Thien_Nguyen_Phong.this, "Trả lời ĐÚNG");
		
		hoat_dong(ten_tai_khoan, dap_an, lbl_thongtin, lbl_danhvong, btn_cauhoi, btn_A, btn_B, btn_C, btn_D);
		
		btn_A.setBackground(mau_A);
		btn_A.setForeground(chu_A);

		btn_B.setBackground(mau_B);
		btn_B.setForeground(chu_B);

		btn_C.setBackground(mau_C);
		btn_C.setForeground(chu_C);

		btn_D.setBackground(mau_D);
		btn_D.setForeground(chu_D);
	}
	
	public void sai(String dap_an_chon, JButton btn_A, JButton btn_B, JButton btn_C, JButton btn_D, String ten_tai_khoan, JLabel lbl_thongtin, JLabel lbl_danhvong, JButton btn_cauhoi) throws SQLException {
		
		Connection ket_noi = file_ket_noi.ham_ket_noi();
		
		Color mau_A = btn_A.getBackground();
		Color mau_B = btn_B.getBackground();
		Color mau_C = btn_C.getBackground();
		Color mau_D = btn_D.getBackground();

		Color chu_A = btn_A.getForeground();
		Color chu_B = btn_B.getForeground();
		Color chu_C = btn_C.getForeground();
		Color chu_D = btn_D.getForeground();
		
		if(dap_an_chon.equals("A")) {
			btn_A.setBackground(Color.RED);
			btn_A.setForeground(Color.WHITE);
		}else if(dap_an_chon.equals("B")) {
			btn_B.setBackground(Color.RED);
			btn_B.setForeground(Color.WHITE);
		}else if(dap_an_chon.equals("C")) {
			btn_C.setBackground(Color.RED);
			btn_C.setForeground(Color.WHITE);
		}else if(dap_an_chon.equals("D")) {
			btn_D.setBackground(Color.RED);
			btn_D.setForeground(Color.WHITE);
		}
		
		int danh_vong_hien_tai = Integer.parseInt(lbl_danhvong.getText());
		int danh_vong_moi = danh_vong_hien_tai - 5 ;
		
		String sql = "UPDATE Thong_Tin_Thanh_Vien\r\n"
				+ "SET Danh_Vong = ?\r\n"
				+ "WHERE Ma_Thanh_Vien = ?;";
		
		PreparedStatement ps = ket_noi.prepareStatement(sql);
		ps.setInt(1, danh_vong_moi);
		ps.setString(2, ma_thanh_vien);
		int rs = ps.executeUpdate();
		System.out.println(rs);
		JOptionPane.showMessageDialog(Thien_Nguyen_Phong.this, "Trả lời SAI");
		
		hoat_dong(ten_tai_khoan, dap_an, lbl_thongtin, lbl_danhvong, btn_cauhoi, btn_A, btn_B, btn_C, btn_D );
		
		btn_A.setBackground(mau_A);
		btn_A.setForeground(chu_A);

		btn_B.setBackground(mau_B);
		btn_B.setForeground(chu_B);

		btn_C.setBackground(mau_C);
		btn_C.setForeground(chu_C);

		btn_D.setBackground(mau_D);
		btn_D.setForeground(chu_D);
	}
}
	

