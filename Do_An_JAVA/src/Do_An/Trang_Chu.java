package Do_An;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextPane;
import javax.swing.RowFilter;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Trang_Chu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_mathanhvien;
	private JTextField txt_tenthanhvien;
	private JTextField txt_phong;
	private JTextField txt_chucvu;
	private JTextField txt_tuvi;
	private JTextField txt_danhvong;
	private JTextField txt_linhcan;
	private JTextField txt_phapkhi;
	private JTable tbl_thanhvien;
	private JTextField txt_timkiem;
	private JTextField txt_mathanhvien_thanhvien;
	private JTextField txt_tenthanhvien_thanhvien;
	private JTextField txt_phong_thanhvien;
	private JTextField txt_chucvu_thanh_vien;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trang_Chu frame = new Trang_Chu("admin");
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
	public Trang_Chu(String tai_khoan) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 652);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(0, 0, 986, 42);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("HUYỄN LINH TÔNG");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblNewLabel);
		

		
		JPanel pnl_noidung = new JPanel();
		pnl_noidung.setBounds(180, 44, 806, 571);
		contentPane.add(pnl_noidung);
		pnl_noidung.setLayout(new CardLayout(0, 0));
		
		CardLayout card = (CardLayout) pnl_noidung.getLayout();
		
		JPanel pnl_trangchu = new JPanel();
		pnl_trangchu.setForeground(new Color(0, 0, 128));
		pnl_trangchu.setBackground(new Color(255, 198, 255));
		pnl_noidung.add(pnl_trangchu, "name_30388568402900");
		pnl_trangchu.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Chào Mừng Đạo Hữu Trở Về");
		lblNewLabel_1.setBounds(10, 25, 304, 29);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		pnl_trangchu.add(lblNewLabel_1);
		
		JLabel lbl_tenthanhvien = new JLabel("TRỐNG ( vui lòng Đăng Nhập )");
		lbl_tenthanhvien.setFont(new Font("Tahoma", Font.BOLD, 23));
		lbl_tenthanhvien.setBounds(74, 61, 357, 51);
		pnl_trangchu.add(lbl_tenthanhvien);
		
		JLabel lblNewLabel_3 = new JLabel("Huyễn Linh Tông");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(516, 10, 135, 20);
		pnl_trangchu.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nơi hội tụ đồng đạo");
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(549, 40, 187, 20);
		pnl_trangchu.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cùng chấn hưng Tiên lộ");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(577, 61, 159, 29);
		pnl_trangchu.add(lblNewLabel_5);
		
		JPanel pnl_thongtinchinh = new JPanel();
		pnl_thongtinchinh.setBackground(new Color(187, 221, 255));
		pnl_thongtinchinh.setBounds(25, 230, 341, 177);
		pnl_trangchu.add(pnl_thongtinchinh);
		pnl_thongtinchinh.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Thông Tin Tông Môn");
		lblNewLabel_6.setBounds(66, 5, 158, 19);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnl_thongtinchinh.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Tên : ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(10, 42, 45, 13);
		pnl_thongtinchinh.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Số Phong :");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1.setBounds(10, 113, 92, 13);
		pnl_thongtinchinh.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("Số Thành Viên : ");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_2.setBounds(10, 143, 109, 13);
		pnl_thongtinchinh.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("Tông Chủ : ");
		lblNewLabel_7_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_3.setBounds(10, 80, 75, 13);
		pnl_thongtinchinh.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel_7_2_1 = new JLabel("Huyễn Linh Tông");
		lblNewLabel_7_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_2_1.setBounds(157, 43, 109, 13);
		pnl_thongtinchinh.add(lblNewLabel_7_2_1);
		
		JLabel lblNewLabel_7_2_2 = new JLabel("Ẩn Danh");
		lblNewLabel_7_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_2_2.setBounds(157, 81, 109, 13);
		pnl_thongtinchinh.add(lblNewLabel_7_2_2);
		
		JLabel lblNewLabel_7_2_3 = new JLabel("9");
		lblNewLabel_7_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_2_3.setBounds(157, 114, 109, 13);
		pnl_thongtinchinh.add(lblNewLabel_7_2_3);
		
		JLabel lbl_sothanhvien = new JLabel("2");
		lbl_sothanhvien.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_sothanhvien.setBounds(157, 144, 109, 13);
		pnl_thongtinchinh.add(lbl_sothanhvien);
		
		JPanel pnl_thongtinmoi = new JPanel();
		pnl_thongtinmoi.setBackground(new Color(183, 255, 183));
		pnl_thongtinmoi.setBounds(407, 230, 372, 177);
		pnl_trangchu.add(pnl_thongtinmoi);
		pnl_thongtinmoi.setLayout(null);
		
		JLabel lbl_thongbao1 = new JLabel("Chào mừng dạo hữu - Xuyên Bạch - gia nhập tông môn");
		lbl_thongbao1.setBounds(10, 49, 352, 19);
		lbl_thongbao1.setFont(new Font("Tahoma", Font.BOLD, 10));
		pnl_thongtinmoi.add(lbl_thongbao1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Thông Tin Mới");
		lblNewLabel_6_1.setBounds(121, 10, 110, 19);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnl_thongtinmoi.add(lblNewLabel_6_1);
		
		JLabel lbl_thongbao2 = new JLabel("Chào mừng dạo hữu - Mặc Dạ - gia nhập tông môn");
		lbl_thongbao2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_thongbao2.setBounds(10, 88, 352, 19);
		pnl_thongtinmoi.add(lbl_thongbao2);
		
		JLabel lbl_thongbao3 = new JLabel("Chào mừng dạo hữu - Bạch Thỏ - gia nhập tông môn");
		lbl_thongbao3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_thongbao3.setBounds(10, 135, 352, 19);
		pnl_thongtinmoi.add(lbl_thongbao3);
		
		JPanel pnl_khauhieu = new JPanel();
		pnl_khauhieu.setBackground(new Color(255, 255, 204));
		pnl_khauhieu.setBounds(25, 449, 754, 112);
		pnl_trangchu.add(pnl_khauhieu);
		pnl_khauhieu.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Đạo bất Đồng, Khả Luận Đạo. Tâm Bất Đồng, Vẫn Khả Tương Dao. ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(116, 41, 491, 25);
		pnl_khauhieu.add(lblNewLabel_8);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Khẩu Hiệu Tông Môn");
		lblNewLabel_6_1_1.setBounds(268, 10, 159, 19);
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnl_khauhieu.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("Duyên Khởi Tại Đây, Đồng Hành Về Sau.");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_1.setBounds(189, 77, 305, 25);
		pnl_khauhieu.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_11.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/Mystic Temple GUI Dashboard(1)(1).png")));
		lblNewLabel_11.setBounds(-27, -46, 847, 631);
		pnl_trangchu.add(lblNewLabel_11);
		
		JPanel pnl_cuuphong = new JPanel();
		pnl_cuuphong.setBackground(new Color(255, 225, 210));
		pnl_noidung.add(pnl_cuuphong, "name_30388533287200");
		pnl_cuuphong.setLayout(null);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Cửu Phong Hội Tụ - Cùng Hướng Đạo Tâm");
		lblNewLabel_1_2_2.setBounds(197, 10, 369, 24);
		lblNewLabel_1_2_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnl_cuuphong.add(lblNewLabel_1_2_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(22, 68, 249, 155);
		pnl_cuuphong.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lbl_thiennguyenphong = new JLabel("");
		lbl_thiennguyenphong.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/thien_nguyen_phong_249x155.png")));
		lbl_thiennguyenphong.setBounds(0, 0, 249, 155);
		panel_3.add(lbl_thiennguyenphong);
		
		lbl_thiennguyenphong.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    	int xac_nhan = JOptionPane.showConfirmDialog(
					    Trang_Chu.this,
					    "Bạn có chắc chắn muốn vào Thiên Nguyên Phong?",
					    "Xác nhận vào",
					    JOptionPane.YES_NO_OPTION
					);
				if(xac_nhan == JOptionPane.YES_OPTION) {
						
						Thien_Nguyen_Phong frame = null;
						try {
							frame = new Thien_Nguyen_Phong(tai_khoan);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.setVisible(true);
						Trang_Chu.this.setVisible(false);
					}
		        

		    }

		});
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(281, 68, 249, 155);
		pnl_cuuphong.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lbl_vongnguyetphong = new JLabel("");
		lbl_vongnguyetphong.setBounds(0, 0, 249, 155);
		lbl_vongnguyetphong.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/vong_nguyet_phong_249x155.png")));
		panel_3_1.add(lbl_vongnguyetphong);
		
		lbl_vongnguyetphong.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    	int xac_nhan = JOptionPane.showConfirmDialog(
					    Trang_Chu.this,
					    "Bạn có chắc chắn muốn vào Vọng Nguyệt Phong ?",
					    "Xác nhận vào",
					    JOptionPane.YES_NO_OPTION
					);
				if(xac_nhan == JOptionPane.YES_OPTION) {
						
						Vong_Nguyet_Phong frame = null;
						try {
							frame = new Vong_Nguyet_Phong(tai_khoan);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.setVisible(true);
						Trang_Chu.this.setVisible(false);
					}
		        

		    }

		});
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBounds(540, 68, 249, 155);
		pnl_cuuphong.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JLabel lbl_phieumieuphong = new JLabel("");
		lbl_phieumieuphong.setBounds(0, 0, 298, 155);
		lbl_phieumieuphong.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/phieu_mieu_phong_249x155.png")));
		panel_3_2.add(lbl_phieumieuphong);
		
		lbl_phieumieuphong.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    	int xac_nhan = JOptionPane.showConfirmDialog(
					    Trang_Chu.this,
					    "Bạn có chắc chắn muốn vào Phiêu Miểu Phong ?",
					    "Xác nhận vào",
					    JOptionPane.YES_NO_OPTION
					);
				if(xac_nhan == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(Trang_Chu.this, "Bí cảnh hiện đang Đóng : ");
					}
		    }
		});
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBounds(22, 230, 249, 155);
		pnl_cuuphong.add(panel_3_3);
		panel_3_3.setLayout(null);
		
		JLabel lbl_vandaophong = new JLabel("");
		lbl_vandaophong.setBounds(0, 0, 249, 155);
		lbl_vandaophong.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/van_dao_phong_249x155.png")));
		panel_3_3.add(lbl_vandaophong);
		
		lbl_vandaophong.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    	int xac_nhan = JOptionPane.showConfirmDialog(
					    Trang_Chu.this,
					    "Bạn có chắc chắn muốn vào Vấn Đạo Phong ?",
					    "Xác nhận vào",
					    JOptionPane.YES_NO_OPTION
					);
				if(xac_nhan == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(Trang_Chu.this, "Bí cảnh hiện đang Đóng : ");
					}
		    }
		});
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setBounds(22, 395, 249, 155);
		pnl_cuuphong.add(panel_3_4);
		panel_3_4.setLayout(null);
		
		JLabel lbl_lachaphong = new JLabel("");
		lbl_lachaphong.setBounds(0, 0, 249, 155);
		lbl_lachaphong.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/lac_ha_phong_249x155.png")));
		panel_3_4.add(lbl_lachaphong);
		
		lbl_lachaphong.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    	int xac_nhan = JOptionPane.showConfirmDialog(
					    Trang_Chu.this,
					    "Bạn có chắc chắn muốn vào Lạc Hà Phong ?",
					    "Xác nhận vào",
					    JOptionPane.YES_NO_OPTION
					);
				if(xac_nhan == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(Trang_Chu.this, "Bí cảnh hiện đang Đóng : ");
					}
		    }
		});
		
		JPanel panel_3_5 = new JPanel();
		panel_3_5.setBounds(281, 230, 249, 155);
		pnl_cuuphong.add(panel_3_5);
		panel_3_5.setLayout(null);
		
		JLabel lbl_uminhphong = new JLabel("");
		lbl_uminhphong.setBounds(0, 0, 249, 155);
		lbl_uminhphong.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/u_minh_phong_249x155.png")));
		panel_3_5.add(lbl_uminhphong);
		
		lbl_uminhphong.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    	int xac_nhan = JOptionPane.showConfirmDialog(
					    Trang_Chu.this,
					    "Bạn có chắc chắn muốn vào U Minh Phong ?",
					    "Xác nhận vào",
					    JOptionPane.YES_NO_OPTION
					);
				if(xac_nhan == JOptionPane.YES_OPTION) {
						
						U_Minh_Phong frame = null;
						try {
							frame = new U_Minh_Phong(tai_khoan);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.setVisible(true);
						Trang_Chu.this.setVisible(false);
					}
		        

		    }

		});
		
		JPanel panel_3_6 = new JPanel();
		panel_3_6.setBounds(281, 395, 249, 155);
		pnl_cuuphong.add(panel_3_6);
		panel_3_6.setLayout(null);
		
		JLabel lbl_luuthanphong = new JLabel("");
		lbl_luuthanphong.setBounds(0, 0, 249, 155);
		lbl_luuthanphong.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/luu_than_phong_249x155.png")));
		panel_3_6.add(lbl_luuthanphong);
		
		lbl_luuthanphong.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    	int xac_nhan = JOptionPane.showConfirmDialog(
					    Trang_Chu.this,
					    "Bạn có chắc chắn muốn vào Lưu Thần Phong ?",
					    "Xác nhận vào",
					    JOptionPane.YES_NO_OPTION
					);
				if(xac_nhan == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(Trang_Chu.this, "Bí cảnh hiện đang Đóng : ");
					}
		    }
		});
		
		JPanel panel_3_7 = new JPanel();
		panel_3_7.setBounds(540, 230, 249, 155);
		pnl_cuuphong.add(panel_3_7);
		panel_3_7.setLayout(null);
		
		JLabel lbl_tuhaphong = new JLabel("");
		lbl_tuhaphong.setBounds(0, 0, 249, 155);
		lbl_tuhaphong.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/tu_ha_phong_249x155.png")));
		panel_3_7.add(lbl_tuhaphong);
		
		lbl_tuhaphong.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    	int xac_nhan = JOptionPane.showConfirmDialog(
					    Trang_Chu.this,
					    "Bạn có chắc chắn muốn vào Tử Hà Phong ?",
					    "Xác nhận vào",
					    JOptionPane.YES_NO_OPTION
					);
				if(xac_nhan == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(Trang_Chu.this, "Bí cảnh hiện đang Đóng : ");
					}
		    }
		});
		
		JPanel panel_3_8 = new JPanel();
		panel_3_8.setBounds(540, 395, 249, 155);
		pnl_cuuphong.add(panel_3_8);
		panel_3_8.setLayout(null);
		
		JLabel lbl_vantieuphong = new JLabel("");
		lbl_vantieuphong.setBounds(0, 0, 249, 155);
		lbl_vantieuphong.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/van_tieu_phong_249x155.png")));
		panel_3_8.add(lbl_vantieuphong);
		
		lbl_vantieuphong.addMouseListener(new MouseAdapter() {

		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    	int xac_nhan = JOptionPane.showConfirmDialog(
					    Trang_Chu.this,
					    "Bạn có chắc chắn muốn vào Vân Tiêu Phong ?",
					    "Xác nhận vào",
					    JOptionPane.YES_NO_OPTION
					);
				if(xac_nhan == JOptionPane.YES_OPTION) {
						
					Van_Tieu_Phong frame = null;
						try {
							frame = new Van_Tieu_Phong(tai_khoan);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frame.setVisible(true);
						Trang_Chu.this.setVisible(false);
					}
		        

		    }

		});
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/Mystic Temple GUI Dashboard(1)(1).png")));
		lblNewLabel_21.setBounds(-97, -48, 922, 639);
		pnl_cuuphong.add(lblNewLabel_21);
		
		JPanel pnl_hoso = new JPanel();
		pnl_hoso.setBackground(new Color(215, 255, 255));
		pnl_noidung.add(pnl_hoso, "name_30388553932400");
		pnl_hoso.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 226, 213));
		panel_1.setBounds(31, 100, 195, 294);
		pnl_hoso.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/gau_dep.jpg")));
		lblNewLabel_2.setBounds(-40, -15, 256, 257);
		panel_1.add(lblNewLabel_2);
		
		JLabel lbl_tenthanhvien_hoso = new JLabel("Thành Viên Chính Thức");
		lbl_tenthanhvien_hoso.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_tenthanhvien_hoso.setBounds(10, 252, 175, 32);
		panel_1.add(lbl_tenthanhvien_hoso);
		
		JLabel lblNewLabel_1_2 = new JLabel("Thông Tin Thành Viên");
		lblNewLabel_1_2.setBounds(232, 10, 229, 24);
		lblNewLabel_1_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		pnl_hoso.add(lblNewLabel_1_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 240));
		panel_2.setBounds(281, 100, 441, 352);
		pnl_hoso.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Thành Viên :");
		lblNewLabel_1_1.setBounds(10, 30, 151, 21);
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Tên Thành Viên :");
		lblNewLabel_1_3.setForeground(Color.BLUE);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(10, 70, 141, 22);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Phong :");
		lblNewLabel_1_4.setForeground(Color.BLUE);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(10, 110, 107, 22);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Chức Vụ :");
		lblNewLabel_1_5.setForeground(Color.BLUE);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(10, 150, 107, 22);
		panel_2.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Tu Vi :");
		lblNewLabel_1_6.setForeground(Color.BLUE);
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(10, 190, 107, 22);
		panel_2.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Danh Vọng :");
		lblNewLabel_1_7.setForeground(Color.BLUE);
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_7.setBounds(10, 309, 107, 22);
		panel_2.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Linh căn :");
		lblNewLabel_1_8.setForeground(Color.BLUE);
		lblNewLabel_1_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_8.setBounds(10, 222, 107, 22);
		panel_2.add(lblNewLabel_1_8);
		
		JLabel lblNewLabel_1_9 = new JLabel("Pháp Khí : ");
		lblNewLabel_1_9.setForeground(Color.BLUE);
		lblNewLabel_1_9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_9.setBounds(10, 266, 107, 22);
		panel_2.add(lblNewLabel_1_9);
		
		txt_mathanhvien = new JTextField();
		txt_mathanhvien.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_mathanhvien.setText("TNP01");
		txt_mathanhvien.setBackground(new Color(255, 255, 174));
		txt_mathanhvien.setBounds(186, 22, 245, 29);
		panel_2.add(txt_mathanhvien);
		txt_mathanhvien.setColumns(10);
		
		txt_tenthanhvien = new JTextField();
		txt_tenthanhvien.setText("Xuyên Bạch");
		txt_tenthanhvien.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_tenthanhvien.setColumns(10);
		txt_tenthanhvien.setBackground(new Color(255, 255, 174));
		txt_tenthanhvien.setBounds(186, 61, 245, 29);
		panel_2.add(txt_tenthanhvien);
		
		txt_phong = new JTextField();
		txt_phong.setText("Thiên Nguyên Phong");
		txt_phong.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_phong.setColumns(10);
		txt_phong.setBackground(new Color(255, 255, 174));
		txt_phong.setBounds(186, 103, 245, 29);
		panel_2.add(txt_phong);
		
		txt_chucvu = new JTextField();
		txt_chucvu.setText("Phong Chủ");
		txt_chucvu.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_chucvu.setColumns(10);
		txt_chucvu.setBackground(new Color(255, 255, 174));
		txt_chucvu.setBounds(186, 143, 245, 29);
		panel_2.add(txt_chucvu);
		
		txt_tuvi = new JTextField();
		txt_tuvi.setText("Hóa Thần");
		txt_tuvi.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_tuvi.setColumns(10);
		txt_tuvi.setBackground(new Color(255, 255, 174));
		txt_tuvi.setBounds(186, 183, 245, 29);
		panel_2.add(txt_tuvi);
		
		txt_danhvong = new JTextField();
		txt_danhvong.setText("1000 Vạn");
		txt_danhvong.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_danhvong.setColumns(10);
		txt_danhvong.setBackground(new Color(255, 255, 174));
		txt_danhvong.setBounds(186, 306, 245, 29);
		panel_2.add(txt_danhvong);
		
		txt_linhcan = new JTextField();
		txt_linhcan.setText("Lôi Linh Căn");
		txt_linhcan.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_linhcan.setColumns(10);
		txt_linhcan.setBackground(new Color(255, 255, 174));
		txt_linhcan.setBounds(186, 222, 245, 29);
		panel_2.add(txt_linhcan);
		
		txt_phapkhi = new JTextField();
		txt_phapkhi.setText("Thiên Nguyên Kiếm");
		txt_phapkhi.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_phapkhi.setColumns(10);
		txt_phapkhi.setBackground(new Color(255, 255, 174));
		txt_phapkhi.setBounds(186, 263, 245, 29);
		panel_2.add(txt_phapkhi);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/Mystic Temple GUI Dashboard(1)(1).png")));
		lblNewLabel_23.setBounds(-47, -28, 853, 616);
		pnl_hoso.add(lblNewLabel_23);
		
		
		
		JPanel pnl_thanhvien = new JPanel();
		pnl_thanhvien.setBackground(new Color(230, 255, 230));
		pnl_noidung.add(pnl_thanhvien, "name_30388583875600");
		pnl_thanhvien.setLayout(null);
		
		JLabel lbl_sothanhvien_thanhvien = new JLabel("0");
		lbl_sothanhvien_thanhvien.setForeground(Color.BLUE);
		lbl_sothanhvien_thanhvien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_sothanhvien_thanhvien.setBounds(262, 141, 65, 22);
		pnl_thanhvien.add(lbl_sothanhvien_thanhvien);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số Thành Viên :");
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(145, 141, 107, 22);
		pnl_thanhvien.add(lblNewLabel_1_1_1);
		
		JComboBox<String> cbo_phong = new JComboBox<String>();
		cbo_phong.setModel(new DefaultComboBoxModel<>(new String[] {"Tất Cả", "Thiên Nguyên Phong", "Vọng Nguyệt Phong", "Tử Hà Phong", "Phiêu Miểu Phong", "U Minh Phong", "Vấn Đạo Phong", "Lạc Hà Phong", "Lưu Thần Phong", "Vân Tiêu Phong"}));
		cbo_phong.setBounds(23, 90, 144, 35);
		pnl_thanhvien.add(cbo_phong);
		
		JTextPane txtpnDuynKhiKhi = new JTextPane();
		txtpnDuynKhiKhi.setBounds(528, 303, 268, 175);
		pnl_thanhvien.add(txtpnDuynKhiKhi);
		txtpnDuynKhiKhi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnDuynKhiKhi.setText("             Duyên Khởi\r\n\r\n Nhân chi sở tại hựu năng cầu\r\n Vân phong khởi xướng độ thiên tiên\r\n Duyên khởi vạn niên nhân chi mộng\r\n Vạn lộ tranh phong Diễm phá quân.\r\n\r\n     \t     --- Xuyên Bạch ---");
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Các Thành Viên");
		lblNewLabel_1_2_1.setBounds(296, 10, 138, 24);
		lblNewLabel_1_2_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		pnl_thanhvien.add(lblNewLabel_1_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 184, 469, 347);
		pnl_thanhvien.add(scrollPane);
		
		tbl_thanhvien = new JTable();
		tbl_thanhvien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 TV", "T\u00EAn Th\u00E0nh Vi\u00EAn", "Phong", "Ch\u1EE9c V\u1EE5", "Danh V\u1ECDng"
			}
		));
		tbl_thanhvien.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbl_thanhvien.getColumnModel().getColumn(3).setPreferredWidth(40);
		tbl_thanhvien.getColumnModel().getColumn(4).setPreferredWidth(30);
		scrollPane.setViewportView(tbl_thanhvien);
		
		txt_timkiem = new JTextField();
		txt_timkiem.setToolTipText("");
		txt_timkiem.setBounds(173, 90, 225, 35);
		pnl_thanhvien.add(txt_timkiem);
		txt_timkiem.setColumns(10);
		
		JButton btn_timkiem = new JButton("Tìm Kiếm");
		btn_timkiem.setBackground(new Color(0, 0, 255));
		btn_timkiem.setForeground(new Color(255, 255, 255));
		btn_timkiem.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_timkiem.setBounds(408, 90, 84, 35);
		pnl_thanhvien.add(btn_timkiem);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 234));
		panel_4.setBounds(528, 90, 268, 175);
		pnl_thanhvien.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_10 = new JLabel("Mã TV :");
		lblNewLabel_1_10.setForeground(Color.BLUE);
		lblNewLabel_1_10.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_10.setBounds(10, 23, 83, 22);
		panel_4.add(lblNewLabel_1_10);
		
		JLabel lblNewLabel_1_11 = new JLabel("Tên :");
		lblNewLabel_1_11.setForeground(Color.BLUE);
		lblNewLabel_1_11.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_11.setBounds(10, 62, 83, 22);
		panel_4.add(lblNewLabel_1_11);
		
		JLabel lblNewLabel_1_12 = new JLabel("Phong :");
		lblNewLabel_1_12.setForeground(Color.BLUE);
		lblNewLabel_1_12.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_12.setBounds(10, 105, 83, 22);
		panel_4.add(lblNewLabel_1_12);
		
		JLabel lblNewLabel_1_13 = new JLabel("Chức Vụ :");
		lblNewLabel_1_13.setForeground(Color.BLUE);
		lblNewLabel_1_13.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_13.setBounds(10, 143, 83, 22);
		panel_4.add(lblNewLabel_1_13);
		
		txt_mathanhvien_thanhvien = new JTextField();
		txt_mathanhvien_thanhvien.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_mathanhvien_thanhvien.setText("TNP01");
		txt_mathanhvien_thanhvien.setBounds(103, 10, 155, 35);
		panel_4.add(txt_mathanhvien_thanhvien);
		txt_mathanhvien_thanhvien.setColumns(10);
		
		txt_tenthanhvien_thanhvien = new JTextField();
		txt_tenthanhvien_thanhvien.setText("Xuyên Bạch");
		txt_tenthanhvien_thanhvien.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_tenthanhvien_thanhvien.setColumns(10);
		txt_tenthanhvien_thanhvien.setBounds(103, 49, 155, 35);
		panel_4.add(txt_tenthanhvien_thanhvien);
		
		txt_phong_thanhvien = new JTextField();
		txt_phong_thanhvien.setText("Thiên Nguyên Phong");
		txt_phong_thanhvien.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_phong_thanhvien.setColumns(10);
		txt_phong_thanhvien.setBounds(103, 89, 155, 35);
		panel_4.add(txt_phong_thanhvien);
		
		txt_chucvu_thanh_vien = new JTextField();
		txt_chucvu_thanh_vien.setText("Phong Chủ");
		txt_chucvu_thanh_vien.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_chucvu_thanh_vien.setColumns(10);
		txt_chucvu_thanh_vien.setBounds(103, 130, 155, 35);
		panel_4.add(txt_chucvu_thanh_vien);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(528, 303, 268, 175);
		pnl_thanhvien.add(panel_4_1);
		
		JLabel lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/Mystic Temple GUI Dashboard(1)(1).png")));
		lblNewLabel_24.setBounds(-43, -25, 902, 630);
		pnl_thanhvien.add(lblNewLabel_24);
		
		JPanel pnl_thongbao = new JPanel();
		pnl_thongbao.setBackground(new Color(255, 210, 210));
		pnl_noidung.add(pnl_thongbao, "name_33237011842300");
		pnl_thongbao.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(215, 255, 215));
		panel_5.setBounds(10, 52, 384, 254);
		pnl_thongbao.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("Cơ Duyên Nhập Tông");
		lblNewLabel_12.setBounds(89, 5, 185, 20);
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_5.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("1 . Chấp bút sáng tác.");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(10, 35, 349, 32);
		panel_5.add(lblNewLabel_13);
		
		JLabel lblNewLabel_13_1 = new JLabel("2 . Đàm đạo trong game.");
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_1.setBounds(10, 77, 349, 32);
		panel_5.add(lblNewLabel_13_1);
		
		JLabel lblNewLabel_13_2 = new JLabel("3 . Ca vang đạo tâm.");
		lblNewLabel_13_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_2.setBounds(10, 119, 349, 32);
		panel_5.add(lblNewLabel_13_2);
		
		JLabel lblNewLabel_13_3 = new JLabel("4 . Đàm luận thiên đia.");
		lblNewLabel_13_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_3.setBounds(10, 161, 349, 32);
		panel_5.add(lblNewLabel_13_3);
		
		JLabel lblNewLabel_13_4 = new JLabel("5 . Kết giao đồng đạo");
		lblNewLabel_13_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_4.setBounds(10, 197, 349, 32);
		panel_5.add(lblNewLabel_13_4);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Thông Báo");
		lblNewLabel_1_2_3.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_2_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_2_3.setBounds(297, 10, 157, 22);
		pnl_thongbao.add(lblNewLabel_1_2_3);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(255, 217, 198));
		panel_5_1.setBounds(10, 322, 384, 239);
		pnl_thongbao.add(panel_5_1);
		panel_5_1.setLayout(null);
		
		JLabel lblNewLabel_12_1 = new JLabel("Điều Kiện Gia Nhập");
		lblNewLabel_12_1.setBounds(111, 5, 161, 21);
		lblNewLabel_12_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_5_1.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_13_5 = new JLabel("1 . Không phân biệt mạnh yếu, cao thấp hay xuất thân.\r\n");
		lblNewLabel_13_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_13_5.setBounds(10, 36, 349, 32);
		panel_5_1.add(lblNewLabel_13_5);
		
		JLabel lblNewLabel_13_6 = new JLabel("2 . Không yêu cầu người phải giỏi viết văn , chơi game hay ca hát.\r\n");
		lblNewLabel_13_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_13_6.setBounds(10, 72, 349, 32);
		panel_5_1.add(lblNewLabel_13_6);
		
		JLabel lblNewLabel_13_7 = new JLabel("3 . Tôn trọng đồng môn, giữ gìn hòa khí, tuân thủ Tông quy.");
		lblNewLabel_13_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_13_7.setBounds(10, 113, 349, 32);
		panel_5_1.add(lblNewLabel_13_7);
		
		JLabel lblNewLabel_13_8 = new JLabel("4 . Ngiêm cấm gây chiến vô cớ, xúc phạm người khác.");
		lblNewLabel_13_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_13_8.setBounds(10, 155, 349, 32);
		panel_5_1.add(lblNewLabel_13_8);
		
		JLabel lblNewLabel_13_8_1 = new JLabel("5 . Ngiêm cấm phá hoại sự đoàn kết của Tông Môn.");
		lblNewLabel_13_8_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_13_8_1.setBounds(10, 197, 349, 32);
		panel_5_1.add(lblNewLabel_13_8_1);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBackground(new Color(255, 255, 221));
		panel_5_2.setBounds(423, 52, 361, 509);
		pnl_thongbao.add(panel_5_2);
		panel_5_2.setLayout(null);
		
		JLabel lblNewLabel_12_1_1 = new JLabel("Tông Quy");
		lblNewLabel_12_1_1.setBounds(140, 5, 80, 21);
		lblNewLabel_12_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		panel_5_2.add(lblNewLabel_12_1_1);
		
		JLabel lblNewLabel_13_9 = new JLabel("1 . Tôn sư trọng đạo\r\n");
		lblNewLabel_13_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_9.setBounds(10, 47, 349, 32);
		panel_5_2.add(lblNewLabel_13_9);
		
		JLabel lblNewLabel_13_10 = new JLabel("2 . Đồng môn tương trọng.");
		lblNewLabel_13_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_10.setBounds(10, 85, 349, 32);
		panel_5_2.add(lblNewLabel_13_10);
		
		JLabel lblNewLabel_13_11 = new JLabel("3 . ngôn từ có chuẩn mực.\r\n");
		lblNewLabel_13_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_11.setBounds(10, 127, 349, 32);
		panel_5_2.add(lblNewLabel_13_11);
		
		JLabel lblNewLabel_13_12 = new JLabel("4 . Xưng hô đúng lễ.");
		lblNewLabel_13_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_12.setBounds(10, 169, 349, 32);
		panel_5_2.add(lblNewLabel_13_12);
		
		JLabel lblNewLabel_13_13 = new JLabel("5 . Giữ gin Tông Môn");
		lblNewLabel_13_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_13.setBounds(10, 211, 349, 32);
		panel_5_2.add(lblNewLabel_13_13);
		
		JLabel lblNewLabel_13_14 = new JLabel("6 . Tôn trọng Tông quy.");
		lblNewLabel_13_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_14.setBounds(10, 253, 349, 32);
		panel_5_2.add(lblNewLabel_13_14);
		
		JLabel lblNewLabel_13_15 = new JLabel("7 . Tranh luận đúng mực.");
		lblNewLabel_13_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_15.setBounds(10, 297, 349, 32);
		panel_5_2.add(lblNewLabel_13_15);
		
		JLabel lblNewLabel_13_16 = new JLabel("8 . Bảo vệ riêng tư.");
		lblNewLabel_13_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_16.setBounds(10, 339, 349, 32);
		panel_5_2.add(lblNewLabel_13_16);
		
		JLabel lblNewLabel_13_17 = new JLabel("9 . Có việc báo cáo.");
		lblNewLabel_13_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_17.setBounds(10, 381, 349, 32);
		panel_5_2.add(lblNewLabel_13_17);
		
		JLabel lblNewLabel_13_18 = new JLabel("10 . Kỷ luật công minh.");
		lblNewLabel_13_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_18.setBounds(10, 423, 349, 32);
		panel_5_2.add(lblNewLabel_13_18);
		
		JLabel lblNewLabel_13_19 = new JLabel("11 . Hòa khí cùng tu.");
		lblNewLabel_13_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13_19.setBounds(10, 465, 349, 32);
		panel_5_2.add(lblNewLabel_13_19);
		
		JLabel lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/Mystic Temple GUI Dashboard(1)(1).png")));
		lblNewLabel_25.setBounds(-47, -31, 888, 632);
		pnl_thongbao.add(lblNewLabel_25);
		
		JPanel pnl_menu = new JPanel();
		pnl_menu.setBackground(new Color(0, 128, 255));
		pnl_menu.setBounds(0, 44, 178, 571);
		contentPane.add(pnl_menu);
		pnl_menu.setLayout(null);
		
		JButton btn_trangchu = new JButton("Trang Chủ");
		btn_trangchu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnl_noidung, "name_30388568402900");
			}
		});
		btn_trangchu.setForeground(new Color(255, 255, 255));
		btn_trangchu.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_trangchu.setBackground(new Color(255, 128, 255));
		btn_trangchu.setBounds(10, 27, 158, 47);
		pnl_menu.add(btn_trangchu);
		
		JButton btn_hoso = new JButton("Hồ Sơ");
		btn_hoso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnl_noidung, "name_30388553932400");
			}
		});
		btn_hoso.setForeground(Color.WHITE);
		btn_hoso.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_hoso.setBackground(new Color(255, 128, 255));
		btn_hoso.setBounds(10, 105, 158, 47);
		pnl_menu.add(btn_hoso);
		
		JButton btn_thanhvien = new JButton("Thành Viên");
		btn_thanhvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnl_noidung, "name_30388583875600");
			}
		});
		btn_thanhvien.setForeground(Color.WHITE);
		btn_thanhvien.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_thanhvien.setBackground(new Color(255, 128, 255));
		btn_thanhvien.setBounds(10, 187, 158, 47);
		pnl_menu.add(btn_thanhvien);
		
		JButton btn_cuuphong = new JButton("Cửu Phong");
		btn_cuuphong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnl_noidung, "name_30388533287200");
			}
		});
		btn_cuuphong.setForeground(Color.WHITE);
		btn_cuuphong.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_cuuphong.setBackground(new Color(255, 128, 255));
		btn_cuuphong.setBounds(10, 268, 158, 47);
		pnl_menu.add(btn_cuuphong);
		
		JButton btn_thongbao = new JButton("Thông Báo ");
		btn_thongbao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(pnl_noidung, "name_33237011842300");
			}
		});
		btn_thongbao.setForeground(Color.WHITE);
		btn_thongbao.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_thongbao.setBackground(new Color(255, 128, 255));
		btn_thongbao.setBounds(10, 344, 158, 47);
		pnl_menu.add(btn_thongbao);
		
		JButton btn_dangxuat = new JButton("Đăng Nhập");
		btn_dangxuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int xac_nhan = JOptionPane.showConfirmDialog(
					    Trang_Chu.this,
					    "Bạn có chắc chắn muốn Đăng Nhập?",
					    "Xác nhận đăng xuất",
					    JOptionPane.YES_NO_OPTION
					);
				if(xac_nhan == JOptionPane.YES_OPTION) {
					Dang_Nhap frame = null;
					try {
						frame = new Dang_Nhap();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.setVisible(true);
					Trang_Chu.this.dispose();
					}
				}
				
		});
		btn_dangxuat.setForeground(Color.WHITE);
		btn_dangxuat.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_dangxuat.setBackground(new Color(255, 128, 255));
		btn_dangxuat.setBounds(10, 502, 158, 47);
		pnl_menu.add(btn_dangxuat);
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setIcon(new ImageIcon(Trang_Chu.class.getResource("/Do_An/anh/resized-810x580.png")));
		lblNewLabel_22.setBounds(0, 0, 178, 571);
		pnl_menu.add(lblNewLabel_22);
		
		
		// Gọi hàm
		
		cap_nhat_canh_gioi(tai_khoan);
		
		trang_chu_ho_so(tai_khoan, txt_mathanhvien, txt_tenthanhvien, txt_phong, txt_chucvu, txt_tuvi, txt_danhvong, txt_linhcan, txt_phapkhi, cbo_phong, lbl_sothanhvien_thanhvien );
		
		trang_chu_trang_chu(tai_khoan, lbl_tenthanhvien, lbl_thongbao1, lbl_thongbao2, lbl_thongbao3, lbl_sothanhvien);
		
		to_mau_o();
		to_mau_ma_phong();
		tim_kiem();
		
		cbo_phong.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            trang_chu_thanh_vien(
		                tai_khoan,
		                txt_mathanhvien_thanhvien,
		                txt_tenthanhvien_thanhvien,
		                txt_phong_thanhvien,
		                txt_chucvu_thanh_vien,
		                cbo_phong,
		                lbl_sothanhvien_thanhvien
		            );
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		});
	}
	
	public void trang_chu_trang_chu(String ten_tai_khoan, JLabel lbl_tenthanhvien, JLabel lbl_thongbao1, JLabel lbl_thongbao2, JLabel lbl_thongbao3, JLabel lbl_sothanhvien) {
		try {
			Connection ket_noi = file_ket_noi.ham_ket_noi();
			
			String sql = "select Ten_Thanh_Vien from Thanh_Vien\r\n"
					+ "where Ten_Tai_Khoan = ?;";
			
			PreparedStatement ps = ket_noi.prepareStatement(sql);
			ps.setString(1, ten_tai_khoan);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				lbl_tenthanhvien.setText(rs.getNString("Ten_Thanh_Vien"));
			} else {

                txt_mathanhvien.setText("");
                txt_tenthanhvien.setText("");
                txt_phong.setText("");
                txt_chucvu.setText("");
                txt_tuvi.setText("");
                txt_danhvong.setText("");
                txt_linhcan.setText("");
                txt_phapkhi.setText("");

                
            }
			
			ps.close();
			rs.close();
			
			sql = "SELECT TOP 3 *\r\n"
					+ "FROM Thanh_Vien\r\n"
					+ "ORDER BY ID DESC;";
			
			Statement statement = ket_noi.createStatement();
            rs = statement.executeQuery(sql);
            int lan = 1;
            while(rs.next()) {
            	
            	if(lan == 1) {
            		lbl_thongbao1.setText("Chào mừng dạo hữu - " + rs.getNString("Ten_Thanh_Vien") + " - gia nhập tông môn");
            	}else if(lan == 2) {
            		lbl_thongbao2.setText("Chào mừng dạo hữu - " + rs.getNString("Ten_Thanh_Vien") + " - gia nhập tông môn");
            	}else if(lan == 3) {
            		lbl_thongbao3.setText("Chào mừng dạo hữu - " + rs.getNString("Ten_Thanh_Vien") + " - gia nhập tông môn");
            	}
            	lan ++;
			}
            
            int so_thanh_vien = tbl_thanhvien.getRowCount();
            lbl_sothanhvien.setText(String.valueOf(so_thanh_vien));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void trang_chu_ho_so (String ten_tai_khoan,JTextField  txt_mathanhvien, JTextField  txt_tenthanhvien, JTextField  txt_phong, JTextField  txt_chucvu, JTextField  txt_tuvi, JTextField  txt_danhvong, JTextField  txt_linhcan, JTextField  txt_phapkhi,JComboBox<String> cbo_phong,JLabel lbl_sothanhvien_thanhvien) throws SQLException {
		Connection ket_noi = file_ket_noi.ham_ket_noi();
		
		String sql = "SELECT \r\n"
				+ "    tv.Ten_Thanh_Vien,\r\n"
				+ "    tv.Chuc_Vu,\r\n"
				+ "    ph.Ten_Phong,\r\n"
				+ "    ttt.*\r\n"
				+ "FROM Tai_Khoan tk\r\n"
				+ "INNER JOIN Thanh_Vien tv\r\n"
				+ "    ON tk.Ten_Tai_Khoan = tv.Ten_Tai_Khoan\r\n"
				+ "LEFT JOIN Cac_Phong ph\r\n"
				+ "    ON tv.Phong = ph.Ma_Phong\r\n"
				+ "LEFT JOIN Thong_Tin_Thanh_Vien ttt\r\n"
				+ "    ON tv.Ma_Thanh_Vien = ttt.Ma_Thanh_Vien\r\n"
				+ "WHERE tk.Ten_Tai_Khoan = ?;";
		
		PreparedStatement ps = ket_noi.prepareStatement(sql);
		ps.setString(1, ten_tai_khoan);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			txt_mathanhvien.setText(rs.getNString("Ma_Thanh_Vien"));
			txt_tenthanhvien.setText(rs.getNString("Ten_Thanh_Vien"));
			txt_phong.setText(rs.getNString("Ten_Phong"));
			txt_chucvu.setText(rs.getNString("Chuc_Vu"));
			txt_tuvi.setText(rs.getNString("Tu_Vi"));
			txt_danhvong.setText(new String(rs.getString("Danh_Vong")));
			txt_linhcan.setText(rs.getNString("Linh_Can"));
			txt_phapkhi.setText(rs.getNString("Phap_Khi"));
		}
		
		
		trang_chu_thanh_vien(ten_tai_khoan, txt_mathanhvien_thanhvien, txt_tenthanhvien_thanhvien, txt_phong_thanhvien, txt_chucvu_thanh_vien,cbo_phong,lbl_sothanhvien_thanhvien);
	}
	
	public void trang_chu_thanh_vien(String ten_tai_khoan, JTextField  txt_mathanhvien_thanhvien, JTextField  txt_tenthanhvien_thanhvien, JTextField  txt_phong_thanhvien, JTextField  txt_chucvu_thanh_vien, JComboBox<String> cbo_phong,JLabel lbl_sothanhvien_thanhvien) throws SQLException {
		Connection ket_noi = file_ket_noi.ham_ket_noi();
		String phong = cbo_phong.getSelectedItem().toString();

		String sql = "SELECT "
		        + "tv.Ma_Thanh_Vien, "
		        + "tv.Ten_Thanh_Vien, "
		        + "ph.Ten_Phong, "
		        + "tv.Chuc_Vu, "
		        + "tt.Danh_Vong "
		        + "FROM Thanh_Vien tv "
		        + "LEFT JOIN Cac_Phong ph ON tv.Phong = ph.Ma_Phong "
		        + "LEFT JOIN Thong_Tin_Thanh_Vien tt ON tv.Ma_Thanh_Vien = tt.Ma_Thanh_Vien ";

		if (!phong.equals("Tất Cả")) {
		    sql += "WHERE ph.Ten_Phong = ? ";
		}

		sql += "ORDER BY tt.Danh_Vong DESC";

		PreparedStatement ps = ket_noi.prepareStatement(sql);

		if (!phong.equals("Tất Cả")) {
		    ps.setString(1, phong);
		}

		ResultSet rs = ps.executeQuery();

		DefaultTableModel model = (DefaultTableModel) tbl_thanhvien.getModel();

		// Xóa dữ liệu cũ
		model.setRowCount(0);

		// Tải dữ liệu mới
		while (rs.next()) {
		    String[] thanh_vien = new String[5];

		    for (int i = 1; i <= 5; i++) {
		        thanh_vien[i - 1] = rs.getString(i);
		    }

		    model.addRow(thanh_vien);
		}
		
		int so_dong = tbl_thanhvien.getRowCount();

		lbl_sothanhvien_thanhvien.setText(String.valueOf(so_dong));
		
		
        txt_mathanhvien_thanhvien.setText(txt_mathanhvien.getText());
        txt_tenthanhvien_thanhvien.setText(txt_tenthanhvien.getText());
        txt_phong_thanhvien.setText(txt_phong.getText());
        txt_chucvu_thanh_vien.setText(txt_chucvu.getText());
        
        rs.close();
		ps.close();
		ket_noi.close();
	}
	
	
	public void cap_nhat_canh_gioi(String ten_tai_khoan) throws SQLException {
		Connection ket_noi = file_ket_noi.ham_ket_noi();
		
		String ma_thanh_vien = "";
		int danh_vong = 0 ;
		String canh_gioi_moi = "";
		
		String sql = "SELECT \r\n"
				+ "tt.Danh_Vong, \r\n"
				+ "tv.Ma_Thanh_Vien\r\n"
				+ "FROM Thong_Tin_Thanh_Vien tt\r\n"
				+ "JOIN Thanh_Vien tv\r\n"
				+ "ON tv.Ma_Thanh_Vien = tt.Ma_Thanh_Vien\r\n"
				+ "WHERE tv.Ten_Tai_Khoan = ? ;";
		
		PreparedStatement ps = ket_noi.prepareStatement(sql);
		ps.setString(1, ten_tai_khoan);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			ma_thanh_vien = rs.getNString("Ma_Thanh_Vien");
			danh_vong = rs.getInt("Danh_Vong");
		}
		
		ps.close();
		
		
		/*
		 * Danh vọng của các cảnh giới :

			Luyện Khí : 20
			Trúc Cơ : 50
			Kim Đan : 70
			Nguyên Anh : 100
			Hóa Thần : 150
			hợp Thể : 200
			Đại Thừa : 270
			Độ kiếp : 350
			Đại Đế : 500
		 */
		
		if (danh_vong < 0) {
			canh_gioi_moi = "Phàm Nhân";
		}else if (danh_vong < 50) {
			canh_gioi_moi = "Luyên Khí";
		}else if (danh_vong < 70) {
			canh_gioi_moi = "Trúc Cơ";
		}else if (danh_vong < 100) {
			canh_gioi_moi = "Kim Đan";
		}else if (danh_vong < 150) {
			canh_gioi_moi = "Nguyên Anh";
		}else if (danh_vong < 200) {
			canh_gioi_moi = "Hóa Thần";
		}else if (danh_vong < 270) {
			canh_gioi_moi = "Hợp Thể";
		}else if (danh_vong < 350) {
			canh_gioi_moi = "Đại Thừa";
		}else if (danh_vong < 500) {
			canh_gioi_moi = "Độ Kiếp";
		}else {
			canh_gioi_moi = "ĐẠI ĐẾ";
		}
		
		
		sql = "UPDATE Thong_Tin_Thanh_Vien\r\n"
				+ "SET Tu_Vi = ?\r\n"
				+ "WHERE Ma_Thanh_Vien = ?;";
		
		ps = ket_noi.prepareStatement(sql);
		ps.setString(1, canh_gioi_moi);
		ps.setString(2, ma_thanh_vien);
		ps.executeUpdate();
		
	}
	
	
	
	
	public void tim_kiem() {

	    DefaultTableModel model = (DefaultTableModel) tbl_thanhvien.getModel();

	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

	    tbl_thanhvien.setRowSorter(sorter);

	    txt_timkiem.getDocument().addDocumentListener(new DocumentListener() {

	        public void insertUpdate(DocumentEvent e) {
	            loc_du_lieu();
	        }

	        public void removeUpdate(DocumentEvent e) {
	            loc_du_lieu();
	        }

	        public void changedUpdate(DocumentEvent e) {
	            loc_du_lieu();
	        }

	        public void loc_du_lieu() {

	            String tu_khoa = txt_timkiem.getText().trim();

	            if (tu_khoa.isEmpty()) {
	                sorter.setRowFilter(null);
	            } else {
	                sorter.setRowFilter(
	                    RowFilter.regexFilter(
	                        "(?i)" + Pattern.quote(tu_khoa)
	                    )
	                );
	            }
	        }
	    });
	}
	
	public void to_mau_o() {
	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
	        @Override
	        public Component getTableCellRendererComponent(
	                JTable table, Object value,
	                boolean isSelected, boolean hasFocus,
	                int row, int column) {

	            Component c = super.getTableCellRendererComponent(
	                    table, value, isSelected, hasFocus, row, column);

	            if (!isSelected) {
	                if (value != null && value.toString().equals("Phong Chủ")) {
	                    c.setBackground(Color.YELLOW);
	                    c.setForeground(Color.BLACK);
	                } else {
	                    c.setBackground(Color.WHITE);
	                    c.setForeground(Color.BLACK);
	                }
	            }

	            return c;
	        }
	    };

	    tbl_thanhvien.getColumnModel().getColumn(3).setCellRenderer(renderer);
	}
	public void to_mau_ma_phong() {

	    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {

	        @Override
	        public Component getTableCellRendererComponent(
	                JTable table, Object value,
	                boolean isSelected, boolean hasFocus,
	                int row, int column) {

	            Component c = super.getTableCellRendererComponent(
	                    table, value, isSelected, hasFocus,
	                    row, column);

	            if (!isSelected) {

	                Object ten_phong = table.getValueAt(row, 2);

	                if (ten_phong != null) {

	                    switch (ten_phong.toString()) {

	                        case "Thiên Nguyên Phong":
	                            c.setBackground(new Color(255, 215, 0));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        case "Vọng Nguyệt Phong":
	                            c.setBackground(new Color(255, 182, 193));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        case "Tử Hà Phong":
	                            c.setBackground(new Color(221, 160, 221));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        case "Phiêu Miểu Phong":
	                            c.setBackground(new Color(224, 255, 255));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        case "U Minh Phong":
	                            c.setBackground(new Color(105, 105, 105));
	                            c.setForeground(Color.WHITE);
	                            break;

	                        case "Vấn Đạo Phong":
	                            c.setBackground(new Color(144, 238, 144));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        case "Lạc Hà Phong":
	                            c.setBackground(new Color(173, 216, 230));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        case "Lưu Thần Phong":
	                            c.setBackground(new Color(255, 228, 181));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        case "Vân Tiêu Phong":
	                            c.setBackground(new Color(176, 196, 70));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        default:
	                            c.setBackground(Color.WHITE);
	                            c.setForeground(Color.BLACK);
	                            break;
	                    }

	                } else {
	                    c.setBackground(Color.WHITE);
	                    c.setForeground(Color.BLACK);
	                }
	            }

	            return c;
	        }
	    };

	    tbl_thanhvien.getColumnModel().getColumn(0).setCellRenderer(renderer);
	}
}
