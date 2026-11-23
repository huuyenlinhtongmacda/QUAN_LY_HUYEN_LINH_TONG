package Do_An;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;


public class Van_Tieu_Phong extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer timer;
	
	private int luot = 0;
	private int danh_vong = 0;
	private String ma_thanh_vien = "";
	
	private int [] dap_an = {0,0,0,0,0};
	private int [] chon = {0,0,0,0,0};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Van_Tieu_Phong frame = new Van_Tieu_Phong("admin");
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
	public Van_Tieu_Phong(String ten_tai_khoan) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Đạp bộ truy phong:");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(81, 139, 199, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lbl_danhvong = new JLabel("0");
		lbl_danhvong.setForeground(new Color(128, 0, 0));
		lbl_danhvong.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_danhvong.setBounds(599, 60, 156, 29);
		contentPane.add(lbl_danhvong);
		
		JLabel lblDanhVng = new JLabel("Danh Vọng :");
		lblDanhVng.setForeground(new Color(128, 0, 0));
		lblDanhVng.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblDanhVng.setBounds(461, 60, 146, 29);
		contentPane.add(lblDanhVng);
		
		JLabel lbl_thongtin = new JLabel("- ");
		lbl_thongtin.setForeground(new Color(128, 0, 0));
		lbl_thongtin.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lbl_thongtin.setBounds(10, 60, 227, 29);
		contentPane.add(lbl_thongtin);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBackground(new Color(255, 255, 128));
		panel_1_3.setBounds(0, 0, 780, 50);
		contentPane.add(panel_1_3);
		
		JLabel lblHuynLinhTng_4 = new JLabel("HUYỄN LINH TÔNG - Vân Tiêu Phong");
		lblHuynLinhTng_4.setForeground(Color.RED);
		lblHuynLinhTng_4.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblHuynLinhTng_4.setBounds(117, 10, 502, 29);
		panel_1_3.add(lblHuynLinhTng_4);
		
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
		
		JPanel panel = new JPanel();
		panel.setBounds(81, 190, 542, 380);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[100px][100px][100px][100px][100px]", "[86px][87px][86px][86px]"));
		
		JButton btn_0 = new JButton("()");
		
		btn_0.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_0, "cell 0 0,grow");
		
		JButton btn_1 = new JButton("()");
		btn_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_1, "cell 1 0,grow");
		
		JButton btn_2 = new JButton("()");
		btn_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_2, "cell 2 0,grow");
		
		JButton btn_3 = new JButton("()");
		btn_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_3, "cell 3 0,grow");
		
		JButton btn_5 = new JButton("()");
		btn_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_5, "cell 0 1,grow");
		
		JButton btn_6 = new JButton("()");
		btn_6.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_6, "cell 1 1,grow");
		
		JButton btn_7 = new JButton("()");
		btn_7.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_7, "cell 2 1,grow");
		
		JButton btn_8 = new JButton("()");
		btn_8.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_8, "cell 3 1,grow");
		
		JButton btn_10 = new JButton("()");
		btn_10.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_10, "cell 0 2,grow");
		
		JButton btn_11 = new JButton("()");
		btn_11.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_11, "cell 1 2,grow");
		
		JButton btn_12 = new JButton("()");
		btn_12.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_12, "cell 2 2,grow");
		
		JButton btn_13 = new JButton("()");
		btn_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_13.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_13, "cell 3 2,grow");
		
		JButton btn_15 = new JButton("()");
		btn_15.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_15, "cell 0 3,grow");
		
		JButton btn_16 = new JButton("()");
		btn_16.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_16, "cell 1 3,grow");
		
		JButton btn_17 = new JButton("()");
		btn_17.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_17, "cell 2 3,grow");
		
		JButton btn_18 = new JButton("()");
		btn_18.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_18, "cell 3 3,grow");
		
		JButton btn_4 = new JButton("()");
		btn_4.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_4, "cell 4 0,grow");
		
		JButton btn_9 = new JButton("()");
		btn_9.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_9, "cell 4 1,grow");
		
		JButton btn_14 = new JButton("()");
		btn_14.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_14, "cell 4 2,grow");
		
		JButton btn_19 = new JButton("()");
		btn_19.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(btn_19, "cell 4 3,grow");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Van_Tieu_Phong.class.getResource("/Do_An/anh/van tieu phong.png")));
		lblNewLabel.setBounds(0, 46, 721, 622);
		contentPane.add(lblNewLabel);
		this.setLocationRelativeTo(null);
		
		
		btn_0.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_0.setBackground(new Color(51, 153, 255));
		        chon[luot] = 0;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		          
		            try {
		            

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_1.setBackground(new Color(51, 153, 255));
		        chon[luot] = 1;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		            
		            try {
		               

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_2.setBackground(new Color(51, 153, 255));
		        chon[luot] = 2;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		           
		            try {
		            
		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_3.setBackground(new Color(51, 153, 255));
		        chon[luot] = 3;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		          
		            try {
		             

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_4.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_4.setBackground(new Color(51, 153, 255));
		        chon[luot] = 4;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		           
		            try {
		                

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_5.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_5.setBackground(new Color(51, 153, 255));
		        chon[luot] = 5;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		         
		            try {
		           

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_6.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_6.setBackground(new Color(51, 153, 255));
		        chon[luot] = 6;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		            
		            try {
		            

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_7.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_7.setBackground(new Color(51, 153, 255));
		        chon[luot] = 7;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		         
		            try {
		              

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_8.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_8.setBackground(new Color(51, 153, 255));
		        chon[luot] = 8;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		           
		            try {
		             

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_9.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_9.setBackground(new Color(51, 153, 255));
		        chon[luot] = 9;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
	
		            try {
		             

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_10.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_10.setBackground(new Color(51, 153, 255));
		        chon[luot] = 10;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		           
		            try {
		               

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_11.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_11.setBackground(new Color(51, 153, 255));
		        chon[luot] = 11;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		
		            try {
		            

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_12.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_12.setBackground(new Color(51, 153, 255));
		        chon[luot] = 12;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		       
		            try {
		        
		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_13.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_13.setBackground(new Color(51, 153, 255));
		        chon[luot] = 13;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		          
		            try {
		                

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_14.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_14.setBackground(new Color(51, 153, 255));
		        chon[luot] = 14;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		          
		            try {
		              

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_15.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_15.setBackground(new Color(51, 153, 255));
		        chon[luot] = 15;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		          
		            try {
		               
		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_16.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_16.setBackground(new Color(51, 153, 255));
		        chon[luot] = 16;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		            
		            try {
		                

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_17.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_17.setBackground(new Color(51, 153, 255));
		        chon[luot] = 17;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		           
		            try {
		            	
		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong, btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_18.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_18.setBackground(new Color(51, 153, 255));
		        chon[luot] = 18;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		           
		            try {
		                
		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});

		btn_19.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        btn_19.setBackground(new Color(51, 153, 255));
		        chon[luot] = 19;
		        luot += 1;
		        if (luot == 5) {
		            tinh_diem(btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
	                        btn_6, btn_7, btn_8, btn_9, btn_10,
	                        btn_11, btn_12, btn_13, btn_14, btn_15,
	                        btn_16, btn_17, btn_18, btn_19);
		            
		            try {
		               

		                hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
		                        btn_6, btn_7, btn_8, btn_9, btn_10,
		                        btn_11, btn_12, btn_13, btn_14, btn_15,
		                        btn_16, btn_17, btn_18, btn_19);
		                luot = 0;
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            }
		        }
		    }
		});
		
		
		hoat_dong(ten_tai_khoan,lbl_thongtin,lbl_danhvong,btn_0,btn_1, btn_2, btn_3, btn_4, btn_5,
		        btn_6, btn_7, btn_8, btn_9, btn_10,
		        btn_11, btn_12, btn_13, btn_14, btn_15,
		        btn_16, btn_17, btn_18, btn_19);
	}
	public void hoat_dong(	String ten_tai_khoan, JLabel lbl_thongtin,JLabel lbl_danhvong,
							JButton btn_0,JButton btn_1, JButton btn_2, JButton btn_3,
				            JButton btn_4, JButton btn_5, JButton btn_6,
				            JButton btn_7, JButton btn_8, JButton btn_9,
				            JButton btn_10, JButton btn_11, JButton btn_12,
				            JButton btn_13, JButton btn_14, JButton btn_15,
				            JButton btn_16, JButton btn_17, JButton btn_18,
				            JButton btn_19) throws SQLException {
		
		
		
		Connection ket_noi = file_ket_noi.ham_ket_noi();
		Random rd = new Random();
		
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

		String thong_tin = ma_thanh_vien + " - " + ten_thanh_vien;
		
		lbl_thongtin.setText(thong_tin);
		lbl_danhvong.setText(String.valueOf(danh_vong));
		
		// tạo dáp án đúng
		for (int i = 0 ; i < 5 ; i ++) {
			int so = rd.nextInt(20);
			dap_an [i] = so ;
		}
		cau_hoi(btn_0,btn_1, btn_2, btn_3, btn_4, btn_5,
		        btn_6, btn_7, btn_8, btn_9, btn_10,
		        btn_11, btn_12, btn_13, btn_14, btn_15,
		        btn_16, btn_17, btn_18, btn_19);
		
		
		
	}
	
	public void cau_hoi(JButton btn_0,JButton btn_1, JButton btn_2, JButton btn_3,
            JButton btn_4, JButton btn_5, JButton btn_6,
            JButton btn_7, JButton btn_8, JButton btn_9,
            JButton btn_10, JButton btn_11, JButton btn_12,
            JButton btn_13, JButton btn_14, JButton btn_15,
            JButton btn_16, JButton btn_17, JButton btn_18,
            JButton btn_19) {

			JButton[] cac_o = {
			btn_0, btn_1, btn_2, btn_3, btn_4,
			btn_5, btn_6, btn_7, btn_8, btn_9,
			btn_10, btn_11, btn_12, btn_13, btn_14,
			btn_15, btn_16, btn_17, btn_18, btn_19
			};
			
			Timer cho = new Timer(1500, e -> {
			    ((Timer)e.getSource()).stop();

			    int[] i = {0};

			    timer = new Timer(700, _ -> {

			        if (i[0] > 0) {
			            cac_o[dap_an[i[0] - 1]].setBackground(null);
			        }

			        if (i[0] < 5) {
			            cac_o[dap_an[i[0]]].setBackground(new Color(51, 153, 255));
			            i[0]++;
			        } else {
			            timer.stop();
			        }
			    });

			    cac_o[dap_an[0]].setBackground(new Color(51, 153, 255));
			    i[0]++;

			    timer.start();
			});

			cho.setRepeats(false);
			cho.start();
			
			}
	
	public void tinh_diem(JButton btn_0, JButton btn_1, JButton btn_2, JButton btn_3,
	        JButton btn_4, JButton btn_5, JButton btn_6,
	        JButton btn_7, JButton btn_8, JButton btn_9,
	        JButton btn_10, JButton btn_11, JButton btn_12,
	        JButton btn_13, JButton btn_14, JButton btn_15,
	        JButton btn_16, JButton btn_17, JButton btn_18,
	        JButton btn_19) {

	    System.out.println(Arrays.toString(dap_an));
	    System.out.println(Arrays.toString(chon));

	    JButton[] cac_o = {
	        btn_0, btn_1, btn_2, btn_3, btn_4,
	        btn_5, btn_6, btn_7, btn_8, btn_9,
	        btn_10, btn_11, btn_12, btn_13, btn_14,
	        btn_15, btn_16, btn_17, btn_18, btn_19
	    };

	    // Tô xanh các ô đáp án
	    
	    
	    // Tô đỏ các ô đã chọn sai
	    for (int i = 0; i < 5; i++) {
	        boolean dung = false;
	        cac_o[dap_an[i]].setBackground(new Color(51, 153, 255));
	        for (int j = 0; j < 5; j++) {
	        	
	            if (chon[i] == dap_an[j]) {
	                dung = true;
	                break;
	            }
	        }

	        if (dung) {
	            cac_o[chon[i]].setBackground(new Color(190, 255, 190));
	        } else {
	            cac_o[chon[i]].setBackground(new Color(255, 215, 215));
	        }
	    }

	    // So sánh kết quả
	    if (Arrays.equals(dap_an, chon)) {
	        System.out.println("Chinh xac!");
	        danh_vong += 5;
	        
	    } else {
	        System.out.println("Sai!");
	        danh_vong -= 5;
	    }
	    
	    try (
                Connection ket_noi = file_ket_noi.ham_ket_noi();
                PreparedStatement ps = ket_noi.prepareStatement(
                    "UPDATE Thong_Tin_Thanh_Vien "
                    + "SET Danh_Vong = ? "
                    + "WHERE Ma_Thanh_Vien = ?"
                )
            ) {

                ps.setInt(1, danh_vong);
                ps.setString(2, ma_thanh_vien);

                ps.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        

	    JOptionPane.showMessageDialog(Van_Tieu_Phong.this, "Tiếp Tục");

	    // Đặt lại màu
	    for (int i = 0; i < 20; i++) {
	        cac_o[i].setBackground(null);
	    }
	}
}
		

