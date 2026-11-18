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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JButton;


public class Quan_Tri extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_soluongtaikhoan;
	private JTextField txt_soluongthanhvien;
	private JTextField txt_phong;
	private JTable tbl_thanhvien;
	private JTextField txt_timkiem;
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quan_Tri frame = new Quan_Tri();
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
	public Quan_Tri() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 548);
		this.setLocationRelativeTo(null);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(0, 0, 794, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHuynLinhTng = new JLabel("HUYỄN LINH TÔNG - QUẢN TRỊ");
		lblHuynLinhTng.setBounds(202, 12, 373, 29);
		lblHuynLinhTng.setForeground(Color.RED);
		lblHuynLinhTng.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel.add(lblHuynLinhTng);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản :");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(42, 84, 107, 22);
		contentPane.add(lblNewLabel_1);
		
		txt_soluongtaikhoan = new JTextField();
		txt_soluongtaikhoan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txt_soluongtaikhoan.setText("0");
		txt_soluongtaikhoan.setBounds(172, 76, 78, 42);
		contentPane.add(txt_soluongtaikhoan);
		txt_soluongtaikhoan.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thành Viên :");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(272, 85, 107, 22);
		contentPane.add(lblNewLabel_1_1);
		
		txt_soluongthanhvien = new JTextField();
		txt_soluongthanhvien.setText("0");
		txt_soluongthanhvien.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txt_soluongthanhvien.setColumns(10);
		txt_soluongthanhvien.setBounds(429, 76, 78, 42);
		contentPane.add(txt_soluongthanhvien);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Phong :");
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(554, 84, 107, 22);
		contentPane.add(lblNewLabel_1_1_1);
		
		txt_phong = new JTextField();
		txt_phong.setText("9");
		txt_phong.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txt_phong.setColumns(10);
		txt_phong.setBounds(671, 76, 78, 42);
		contentPane.add(txt_phong);
		
		JLabel lblNewLabel_1_2 = new JLabel("Các Thành Viên");
		lblNewLabel_1_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(111, 175, 148, 22);
		contentPane.add(lblNewLabel_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 218, 696, 247);
		contentPane.add(scrollPane);
		
		tbl_thanhvien = new JTable();
		tbl_thanhvien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tbl_thanhvien.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"STT", "T\u00EAn T\u00E0i Kho\u1EA3n", "Quy\u1EC1n", "M\u00E3 Th\u00E0nh Vi\u00EAn", "T\u00EAn Th\u00E0nh Vi\u00EAn", "Phong", "Ch\u1EE9c V\u1EE5"
			}
		));
		tbl_thanhvien.getColumnModel().getColumn(0).setPreferredWidth(15);
		tbl_thanhvien.getColumnModel().getColumn(2).setPreferredWidth(40);
		tbl_thanhvien.getColumnModel().getColumn(3).setPreferredWidth(50);
		tbl_thanhvien.getColumnModel().getColumn(4).setPreferredWidth(90);
		tbl_thanhvien.getColumnModel().getColumn(5).setPreferredWidth(90);
		scrollPane.setViewportView(tbl_thanhvien);
		
		txt_timkiem = new JTextField();
		txt_timkiem.setToolTipText("");
		txt_timkiem.setColumns(10);
		txt_timkiem.setBounds(380, 171, 268, 35);
		contentPane.add(txt_timkiem);
		
		JButton btn_timkiem = new JButton("Tìm Kiếm");
		btn_timkiem.setForeground(Color.WHITE);
		btn_timkiem.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_timkiem.setBackground(Color.BLUE);
		btn_timkiem.setBounds(665, 171, 84, 35);
		contentPane.add(btn_timkiem);
		
		// Gọi hàm
		hoat_dong();
		tim_kiem();
		to_mau_ma_phong();
		to_mau_chuc_vu();
		
		tbl_thanhvien.getSelectionModel().addListSelectionListener(e -> {
			
		    if (!e.getValueIsAdjusting()) {

		        int hang = tbl_thanhvien.getSelectedRow();

		        if (hang != -1) {

		            String ma_thanh_vien = tbl_thanhvien.getValueAt(hang, 1).toString();

		            System.out.println(ma_thanh_vien);
		            
		            Chi_Tiet_Thanh_Vien frame = null;
					frame = new Chi_Tiet_Thanh_Vien(ma_thanh_vien);
					frame.setVisible(true);
					Quan_Tri.this.dispose();
		        }
		    }
		});
		
		
	}
	
	public void hoat_dong() {

		
		try {
            Connection connection = file_ket_noi.ham_ket_noi();

            if (connection == null) {
                System.out.println("Kết nối thất bại");
                return;
            }

            System.out.println("Kết nối thành công");
            System.out.println("================================================");

            Scanner sc = new Scanner(System.in);

            String sql = "SELECT \r\n"
            		+ "tk.Ten_Tai_Khoan,\r\n"
            		+ "tk.Quyen,\r\n"
            		+ "tv.Ma_Thanh_Vien,\r\n"
            		+ "tv.Ten_Thanh_Vien,\r\n"
            		+ "ph.Ten_Phong,\r\n"
            		+ "tv.Chuc_Vu\r\n"
            		+ "\r\n"
            		+ "FROM Tai_Khoan tk\r\n"
            		+ "JOIN Thanh_Vien tv\r\n"
            		+ "ON tk.Ten_Tai_Khoan = tv.Ten_Tai_Khoan\r\n"
            		+ "JOIN Cac_Phong ph\r\n"
            		+ "ON tv.Phong = ph.Ma_Phong; " ;
            
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            int so_cot = rs.getMetaData().getColumnCount();
            DefaultTableModel model = (DefaultTableModel) tbl_thanhvien.getModel();
            
            while(rs.next()) {
            	
            	String [] thanh_vien = new String[so_cot + 1];
            	
            	int so_luong =tbl_thanhvien.getRowCount();
            	thanh_vien[0] = String.valueOf(so_luong + 1);
            	
            	for(int i = 0 ; i < so_cot ; i ++ ) {
            		thanh_vien[ i +1 ] = rs.getString( i +1 );
            	}
            	model.addRow(thanh_vien);
            	
            }

            sc.close();
            connection.close();
            
    		int so_luong_ban_ghi =tbl_thanhvien.getRowCount();

    		
    		txt_soluongtaikhoan.setText(String.valueOf(so_luong_ban_ghi));
    		txt_soluongthanhvien.setText(String.valueOf(so_luong_ban_ghi  ));

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
	public void to_mau_chuc_vu() {
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

	    tbl_thanhvien.getColumnModel().getColumn(6).setCellRenderer(renderer);
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

	                Object ten_phong = table.getValueAt(row, 5);

	                if (ten_phong != null) {

	                    switch (ten_phong.toString()) {

	                        case "Thiên Nguyên Phong":
	                            c.setBackground(new Color(255, 215, 0));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        case "Vọng Nguyệt Phong":
	                            c.setBackground(new Color(173, 216, 230));
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
	                            c.setBackground(new Color(255, 182, 193));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        case "Lưu Thần Phong":
	                            c.setBackground(new Color(255, 228, 181));
	                            c.setForeground(Color.BLACK);
	                            break;

	                        case "Vân Tiêu Phong":
	                            c.setBackground(new Color(176, 196, 222));
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

	    tbl_thanhvien.getColumnModel().getColumn(3).setCellRenderer(renderer);
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
}
