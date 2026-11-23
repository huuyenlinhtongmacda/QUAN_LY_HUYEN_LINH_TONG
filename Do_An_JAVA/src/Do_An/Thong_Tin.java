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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Thong_Tin extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField txt_danhtinh;
    private JTextField txt_taikhoan;
    private JComboBox<String> cbo_phong;

    private JTextField txt_phapkhi;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Thong_Tin frame = new Thong_Tin("admin");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Thong_Tin(String nhan_tai_khoan) throws SQLException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 489);
        this.setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 128));
        panel.setBounds(0, 0, 436, 50);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("HUYỄN LINH TÔNG");
        lblNewLabel.setBounds(91, 10, 232, 29);
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        panel.add(lblNewLabel);

        JLabel lblNewLabel_3 = new JLabel("Thông Tin");
        lblNewLabel_3.setForeground(new Color(255, 128, 64));
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel_3.setBounds(159, 60, 121, 30);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_1_2 = new JLabel("Tài Khoản : ");
        lblNewLabel_1_2.setForeground(Color.BLUE);
        lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_1_2.setBounds(10, 98, 134, 22);
        contentPane.add(lblNewLabel_1_2);

        txt_taikhoan = new JTextField();
        txt_taikhoan.setForeground(new Color(128, 0, 0));
        txt_taikhoan.setFont(new Font("Times New Roman", Font.BOLD, 18));
        txt_taikhoan.setBounds(127, 100, 180, 25);
        txt_taikhoan.setEditable(false);
        txt_taikhoan.setText(nhan_tai_khoan);
        contentPane.add(txt_taikhoan);

        JLabel lblNewLabel_1 = new JLabel("Danh Tính : ");
        lblNewLabel_1.setForeground(Color.BLUE);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_1.setBounds(10, 144, 134, 22);
        contentPane.add(lblNewLabel_1);

        txt_danhtinh = new JTextField();
        txt_danhtinh.setColumns(10);
        txt_danhtinh.setBounds(127, 143, 281, 30);
        contentPane.add(txt_danhtinh);

        JLabel lblNewLabel_1_1 = new JLabel("Phong : ");
        lblNewLabel_1_1.setForeground(Color.BLUE);
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_1_1.setBounds(10, 191, 134, 22);
        contentPane.add(lblNewLabel_1_1);

        cbo_phong = new JComboBox<String>();
        cbo_phong.setModel(new DefaultComboBoxModel<String>(new String[] {
            "TNP : Thiên Nguyên Phong",
            "VNP : Vọng Nguyệt Phong",
            "THP : Tử Hà Phong",
            "PMP : Phiêu Miểu Phong",
            "UMP : U Minh Phong",
            "VDP : Vấn Đạo Phong",
            "LHP : Lạc Hà Phong",
            "LTP : Lưu Thần Phong",
            "VTP : Vân Tiêu Phong"
        }));
        cbo_phong.setBounds(127, 183, 281, 30);
        contentPane.add(cbo_phong);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Tu Vi : ");
        lblNewLabel_1_1_1.setForeground(Color.BLUE);
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_1_1_1.setBounds(10, 241, 134, 22);
        contentPane.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("Linh Căn : ");
        lblNewLabel_1_1_2.setForeground(Color.BLUE);
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_1_1_2.setBounds(10, 298, 134, 22);
        contentPane.add(lblNewLabel_1_1_2);
        
        JLabel lblNewLabel_1_1_3 = new JLabel("Pháp Khí : ");
        lblNewLabel_1_1_3.setForeground(Color.BLUE);
        lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_1_1_3.setBounds(10, 362, 134, 22);
        contentPane.add(lblNewLabel_1_1_3);
        
        JComboBox<String> cbo_tuvi = new JComboBox<String>();
        cbo_tuvi.setModel(new DefaultComboBoxModel<>(new String[] {"Luyện Khí", "Trúc Cơ", "Kim Đan", "Nguyên Anh", "Hóa Thần", "Hợp Thể", "Đại Thừa", "Độ Kiếp", "Đại Đế"}));
        cbo_tuvi.setBounds(127, 244, 281, 30);
        contentPane.add(cbo_tuvi);
        
        JComboBox<String> cbo_linhcan = new JComboBox<String>();
        cbo_linhcan.setModel(new DefaultComboBoxModel<>(new String[] {"Kim Linh Căn", "Thủy Linh Căn", "Hỏa Linh Căn", "Thổ Linh Căn", "Mộc Linh Căn", "Phong Linh Căn", "Lôi Linh Căn", "Băng Linh Căn"}));
        cbo_linhcan.setBounds(127, 301, 281, 30);
        contentPane.add(cbo_linhcan);
        
        txt_phapkhi = new JTextField();
        txt_phapkhi.setColumns(10);
        txt_phapkhi.setBounds(127, 351, 281, 30);
        contentPane.add(txt_phapkhi);

        JButton btn_gianhap = new JButton("Gia Nhập");

        btn_gianhap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String tai_khoan = nhan_tai_khoan;
                String danh_tinh = txt_danhtinh.getText().trim();
                String phong = cbo_phong.getSelectedItem().toString();
                String tu_vi = cbo_tuvi.getSelectedItem().toString();
                String linh_can = cbo_linhcan.getSelectedItem().toString();
                String phap_khi = txt_phapkhi.getText().trim();
                
                String ma_phong = "";
                
                
                if (danh_tinh.isEmpty()) {
                    JOptionPane.showMessageDialog(Thong_Tin.this, "Vui lòng nhập danh tính!");
                    return;
                }
                
                switch (phong) {
                case "TNP : Thiên Nguyên Phong":
                    ma_phong = "TNP";
                    break;

                case "VNP : Vọng Nguyệt Phong":
                    ma_phong = "VNP";
                    break;

                case "THP : Tử Hà Phong":
                    ma_phong = "THP";

                    break;

                case "PMP : Phiêu Miểu Phong":
                    ma_phong = "PMP";
                    break;

                case "UMP : U Minh Phong":
                    ma_phong = "UMP";
                    break;

                case "VDP : Vấn Đạo Phong":
                    ma_phong = "VDP";
                    break;

                case "LHP : Lạc Hà Phong":
                    ma_phong = "LHP";
                    break;

                case "LTP : Lưu Thần Phong":
                    ma_phong = "LTP";
                    break;

                case "VTP : Vân Tiêu Phong":
                    ma_phong = "VTP";
                    break;
            }
                

                try {
                    Connection ket_noi = file_ket_noi.ham_ket_noi();
                    
                    String sql = "SELECT COUNT(*) FROM Thanh_Vien WHERE Phong = ?";

                    PreparedStatement ps = ket_noi.prepareStatement(sql);
                    ps.setString(1, ma_phong);

                    ResultSet rs = ps.executeQuery();

                    int so_thanh_vien = 0;

                    if (rs.next()) {
                        so_thanh_vien = rs.getInt(1);
                    }

                    String ma_thanh_vien = ma_phong + String.format("%02d", so_thanh_vien + 1);

                     sql = "INSERT INTO Thanh_Vien (Ten_Tai_Khoan, Ma_Thanh_Vien, Ten_Thanh_vien, Phong, Chuc_Vu) VALUES (?, ?, ?, ?, ?)";

                    ps = ket_noi.prepareStatement(sql);

                    ps.setString(1, tai_khoan);
                    ps.setString(2, ma_thanh_vien);
                    ps.setString(3, danh_tinh);
                    ps.setString(4, ma_phong);
                    ps.setString(5, "Thành Viên");

                    int ket_qua = ps.executeUpdate();

                    if (ket_qua > 0) {
                        JOptionPane.showMessageDialog(Thong_Tin.this, "Gia nhập thành công!");
                        
                        sql = "INSERT INTO Thong_Tin_Thanh_Vien(Ma_Thanh_Vien, Tu_Vi, Linh_Can, Phap_Khi) VALUES (? ,? ,? ,? )";
                        ps = ket_noi.prepareStatement(sql);

                        ps.setString(1, ma_thanh_vien);
                        ps.setString(2, tu_vi);
                        ps.setString(3, linh_can);
                        ps.setString(4, phap_khi);
                        
                        ps.executeUpdate();
                        
                        
                        Dang_Nhap frame = null;
        				try {
        					frame = new Dang_Nhap();
        				} catch (SQLException e1) {
        					// TODO Auto-generated catch block
        					e1.printStackTrace();
        				}
        				frame.setVisible(true);
        				Thong_Tin.this.dispose();
                    }

                    ps.close();
                    ket_noi.close();

                } catch (SQLException ex) {
                	JOptionPane.showMessageDialog(Thong_Tin.this, "Thành viên đã tồn tại !");
                }
            }
        });

        btn_gianhap.setForeground(Color.MAGENTA);
        btn_gianhap.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btn_gianhap.setBounds(142, 419, 110, 22);
        contentPane.add(btn_gianhap);
        
        
    }
}