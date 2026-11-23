package Do_An;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
 
public class U_Minh_Phong extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel pnl_uminhphong;

	private JLabel lbl_thongtin_uminh;
	private JLabel lbl_danhvong_uminh;

	private JButton btn_1;
	private JButton btn_2;
	private JButton btn_3;
	private JButton btn_4;
	private JButton btn_5;
	private JButton btn_6;
	private JButton btn_7;
	private JButton btn_8;
	private JButton btn_9;

	private String ma_thanh_vien;
	private int danh_vong = 0;
	private int chon = -1;
	private Timer timer;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					U_Minh_Phong frame = new U_Minh_Phong("admin");

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}
			}
		});
	}

	public U_Minh_Phong(String ten_tai_khoan) throws SQLException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 634);

		pnl_uminhphong = new JPanel();

		pnl_uminhphong.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pnl_uminhphong);

		pnl_uminhphong.setLayout(null);

		// Thanh tiêu đề

		JPanel panel_1_3 = new JPanel();

		panel_1_3.setLayout(null);

		panel_1_3.setBackground(new Color(255, 255, 128));

		panel_1_3.setBounds(0, 0, 780, 50);

		pnl_uminhphong.add(panel_1_3);

		JLabel lblHuynLinhTng_4 = new JLabel("HUYỄN LINH TÔNG - U Minh Phong");

		lblHuynLinhTng_4.setForeground(Color.RED);

		lblHuynLinhTng_4.setFont(new Font("Times New Roman", Font.BOLD, 24));

		lblHuynLinhTng_4.setBounds(117, 10, 502, 29);

		panel_1_3.add(lblHuynLinhTng_4);

		// Nút thoát

		JButton btn_thoat = new JButton("X");
		btn_thoat.addActionListener(_ -> {
            try {
                Trang_Chu frame = new Trang_Chu(ten_tai_khoan);
                frame.setVisible(true);

                if (timer != null) {
                    timer.stop();
                }

                dispose();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

		btn_thoat.setForeground(Color.BLACK);

		btn_thoat.setFont(new Font("Tahoma", Font.BOLD, 10));

		btn_thoat.setBackground(new Color(255, 128, 64));

		btn_thoat.setBounds(10, 12, 41, 32);

		panel_1_3.add(btn_thoat);

		// Tiêu đề Cửu U Bí Cảnh

		JLabel lblNewLabel_3 = new JLabel("Cửu U Bí Cảnh:");

		lblNewLabel_3.setForeground(new Color(255, 128, 64));

		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));

		lblNewLabel_3.setBounds(122, 137, 144, 30);

		pnl_uminhphong.add(lblNewLabel_3);

		// Thông tin thành viên

		lbl_thongtin_uminh = new JLabel(" - ");

		lbl_thongtin_uminh.setForeground(new Color(255, 255, 0));

		lbl_thongtin_uminh.setFont(new Font("Times New Roman", Font.BOLD, 24));

		lbl_thongtin_uminh.setBounds(10, 60, 227, 29);

		pnl_uminhphong.add(lbl_thongtin_uminh);

		// Chữ danh vọng

		JLabel lblDanhVng_1 = new JLabel("Danh Vọng :");

		lblDanhVng_1.setForeground(new Color(255, 255, 0));

		lblDanhVng_1.setFont(new Font("Times New Roman", Font.BOLD, 24));

		lblDanhVng_1.setBounds(438, 60, 146, 29);

		pnl_uminhphong.add(lblDanhVng_1);

		// Giá trị danh vọng

		lbl_danhvong_uminh = new JLabel("0");

		lbl_danhvong_uminh.setForeground(new Color(255, 255, 0));

		lbl_danhvong_uminh.setFont(new Font("Times New Roman", Font.BOLD, 24));

		lbl_danhvong_uminh.setBounds(589, 60, 156, 29);

		pnl_uminhphong.add(lbl_danhvong_uminh);

		// Bảng 9 ô

		JPanel panel = new JPanel();

		panel.setBounds(73, 177, 548, 371);

		pnl_uminhphong.add(panel);

		panel.setLayout(new GridLayout(0, 3, 0, 0));

		// Ô 1

		btn_1 = new JButton("?");

		btn_1.setFont(new Font("Tahoma", Font.BOLD, 30));

		btn_1.setForeground(new Color(0, 0, 255));

		panel.add(btn_1);

		// Ô 2

		btn_2 = new JButton("?");

		btn_2.setFont(new Font("Tahoma", Font.BOLD, 30));

		btn_2.setForeground(Color.BLUE);

		panel.add(btn_2);

		// Ô 3

		btn_3 = new JButton("?");

		btn_3.setForeground(Color.BLUE);

		btn_3.setFont(new Font("Tahoma", Font.BOLD, 30));

		panel.add(btn_3);

		// Ô 4

		btn_4 = new JButton("?");

		btn_4.setForeground(Color.BLUE);

		btn_4.setFont(new Font("Tahoma", Font.BOLD, 30));

		panel.add(btn_4);

		// Ô 5

		btn_5 = new JButton("?");

		btn_5.setForeground(Color.BLUE);

		btn_5.setFont(new Font("Tahoma", Font.BOLD, 30));

		panel.add(btn_5);

		// Ô 6

		btn_6 = new JButton("?");

		btn_6.setForeground(Color.BLUE);

		btn_6.setFont(new Font("Tahoma", Font.BOLD, 30));

		panel.add(btn_6);

		// Ô 7

		btn_7 = new JButton("?");

		btn_7.setForeground(Color.BLUE);

		btn_7.setFont(new Font("Tahoma", Font.BOLD, 30));

		panel.add(btn_7);

		// Ô 8

		btn_8 = new JButton("?");

		btn_8.setForeground(Color.BLUE);

		btn_8.setFont(new Font("Tahoma", Font.BOLD, 30));

		panel.add(btn_8);

		// Ô 9

		btn_9 = new JButton("?");

		btn_9.setForeground(Color.BLUE);

		btn_9.setFont(new Font("Tahoma", Font.BOLD, 30));

		panel.add(btn_9);

		setLocationRelativeTo(null);

		// Sự kiện ô 1

		btn_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				chon = 0;
				
				try {

					u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
							btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});

		// Sự kiện ô 2

		btn_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				chon = 1;

				try {

					u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
							btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});

		// Sự kiện ô 3

		btn_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				chon = 2;

				try {

					u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
							btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});

		// Sự kiện ô 4

		btn_4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				chon = 3;

				try {

					u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
							btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});

		// Sự kiện ô 5

		btn_5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				chon = 4;

				try {

					u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
							btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});

		// Sự kiện ô 6

		btn_6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				chon = 5;

				try {

					u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
							btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});

		// Sự kiện ô 7

		btn_7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				chon = 6;

				try {

					u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
							btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});

		// Sự kiện ô 8

		btn_8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				chon = 7;

				try {

					u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
							btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});

		// Sự kiện ô 9

		btn_9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				chon = 8;

				try {

					u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
							btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);

				} catch (SQLException e1) {

					e1.printStackTrace();

				}
			}
		});

		// Khởi chạy U Minh Phong

		u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
				btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(U_Minh_Phong.class.getResource("/Do_An/anh/Moonlit Temple of U Minh Phong (1).png")));
		lblNewLabel.setBounds(0, 42, 721, 580);
		pnl_uminhphong.add(lblNewLabel);

	}

	// Hàm U Minh Phong

	public void u_minh_phong(String ten_tai_khoan, JLabel lbl_thongtin_uminh,
			JLabel lbl_danhvong_uminh, JButton btn_1, JButton btn_2,
			JButton btn_3, JButton btn_4, JButton btn_5, JButton btn_6,
			JButton btn_7, JButton btn_8, JButton btn_9) throws SQLException {
	
		Connection ket_noi = file_ket_noi.ham_ket_noi();

		String ten_thanh_vien = "";

		String sql = "SELECT "
				+ "tv.Ma_Thanh_vien, "
				+ "tv.Ten_Thanh_Vien, "
				+ "tt.Danh_Vong "
				+ "FROM Thanh_Vien tv "
				+ "JOIN Thong_Tin_Thanh_Vien tt "
				+ "ON tv.Ma_Thanh_Vien = tt.Ma_Thanh_Vien "
				+ "WHERE tv.Ten_Tai_khoan = ?;";

		PreparedStatement ps = ket_noi.prepareStatement(sql);

		ps.setString(1, ten_tai_khoan);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			ma_thanh_vien = rs.getNString("Ma_Thanh_Vien");

			ten_thanh_vien = rs.getNString("Ten_Thanh_Vien");

			danh_vong = rs.getInt("Danh_Vong");

		}

		String thong_tin_uminh = ma_thanh_vien + " - " + ten_thanh_vien;
		
		lbl_thongtin_uminh.setText(thong_tin_uminh);
		lbl_danhvong_uminh.setText(String.valueOf(danh_vong));

		int[] gia_tri = {50, 20, 10, 1, -50, -30, -20, -10, -1};

		List<Integer> gia_tri1 = new ArrayList<>();

		for (int so : gia_tri) {

			gia_tri1.add(so);

		}

		Collections.shuffle(gia_tri1);

		if (chon != -1) {

			System.out.printf("đã chọn ô " + chon + " = ");

			System.out.println(gia_tri1.get(chon));
			
			danh_vong += gia_tri1.get(chon);
			
			try (
	                
	                PreparedStatement ps1 = ket_noi.prepareStatement(
	                    "UPDATE Thong_Tin_Thanh_Vien "
	                    + "SET Danh_Vong = ? "
	                    + "WHERE Ma_Thanh_Vien = ?"
	                )
	            ) {

	                ps1.setInt(1, danh_vong);
	                ps1.setString(2, ma_thanh_vien);

	                ps1.executeUpdate();

	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
			
			btn_1.setText(String.valueOf(gia_tri1.get(0)));
			btn_2.setText(String.valueOf(gia_tri1.get(1)));
			btn_3.setText(String.valueOf(gia_tri1.get(2)));
			btn_4.setText(String.valueOf(gia_tri1.get(3)));
			btn_5.setText(String.valueOf(gia_tri1.get(4)));
			btn_6.setText(String.valueOf(gia_tri1.get(5)));
			btn_7.setText(String.valueOf(gia_tri1.get(6)));
			btn_8.setText(String.valueOf(gia_tri1.get(7)));
			btn_9.setText(String.valueOf(gia_tri1.get(8)));
			
			JButton[] cac_o = {
				    btn_1, btn_2, btn_3,
				    btn_4, btn_5, btn_6,
				    btn_7, btn_8, btn_9
				};
				
				
				for (int i = 0; i < 9; i++) {
				    int gia_tri_o = gia_tri1.get(i);

				    if (gia_tri_o > 0) {
				        cac_o[i].setBackground(new Color(190, 255, 190));
				    } else {
				        cac_o[i].setBackground(new Color(255, 215, 215));
				    }
				    
				    	cac_o[chon].setBackground(Color.YELLOW);
				    

				    	cac_o[i].setForeground(Color.BLACK);
				}
				
			btn_1.setEnabled(false);
			btn_2.setEnabled(false);
			btn_3.setEnabled(false);
			btn_4.setEnabled(false);
			btn_5.setEnabled(false);
			btn_6.setEnabled(false);
			btn_7.setEnabled(false);
			btn_8.setEnabled(false);
			btn_9.setEnabled(false);
			
			timer = new Timer(2000, _ -> {
				
			    // Chuyển 9 ô về ?
			    btn_1.setText("?");
			    btn_2.setText("?");
			    btn_3.setText("?");
			    btn_4.setText("?");
			    btn_5.setText("?");
			    btn_6.setText("?");
			    btn_7.setText("?");
			    btn_8.setText("?");
			    btn_9.setText("?");

			    // Reset lựa chọn
			    chon = -1;

			    // Làm mới vòng chơi
			    try {
			        u_minh_phong(ten_tai_khoan, lbl_thongtin_uminh, lbl_danhvong_uminh,
			                btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9);
			    } catch (SQLException ex) {
			        ex.printStackTrace();
			    }
			    
			    for (JButton nut : cac_o) {
			        nut.setText("?");
			        nut.setBackground(null);
			        nut.setForeground(Color.BLACK);
			    }
			    
			    btn_1.setEnabled(true);
			    btn_2.setEnabled(true);
			    btn_3.setEnabled(true);
			    btn_4.setEnabled(true);
			    btn_5.setEnabled(true);
			    btn_6.setEnabled(true);
			    btn_7.setEnabled(true);
			    btn_8.setEnabled(true);
			    btn_9.setEnabled(true);
			    
			    timer.stop();
			});

			timer.setRepeats(false);
			timer.start();
		}

	}
}