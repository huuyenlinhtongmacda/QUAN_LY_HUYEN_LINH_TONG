package Do_An;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Vong_Nguyet_Phong extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel pnl_vongnguyetphong;

    private JLabel lbl_thongtin;
    private JLabel lbl_danhvong;

    private String ma_thanh_vien;
    private int danh_vong = 0;

    private Timer timer;

    private boolean hoat_dong = true;
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vong_Nguyet_Phong frame = new Vong_Nguyet_Phong("admin");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public Vong_Nguyet_Phong(String ten_tai_khoan) throws SQLException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 725, 634);

        pnl_vongnguyetphong = new JPanel();
        pnl_vongnguyetphong.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(pnl_vongnguyetphong);
        pnl_vongnguyetphong.setLayout(null);

        // Thông tin thành viên
        lbl_thongtin = new JLabel(" - ");
        lbl_thongtin.setForeground(new Color(255, 255, 0));
        lbl_thongtin.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lbl_thongtin.setBounds(10, 60, 227, 29);
        pnl_vongnguyetphong.add(lbl_thongtin);

        // Chữ danh vọng
        JLabel lblDanhVng = new JLabel("Danh Vọng :");
        lblDanhVng.setForeground(new Color(255, 255, 0));
        lblDanhVng.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lblDanhVng.setBounds(457, 60, 146, 29);
        pnl_vongnguyetphong.add(lblDanhVng);

        // Thanh tiêu đề
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 780, 50);
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(255, 255, 128));
        pnl_vongnguyetphong.add(panel_1);

        JLabel lbl_tieu_de = new JLabel("HUYỄN LINH TÔNG - Vọng Nguyệt Phong");
        lbl_tieu_de.setForeground(Color.RED);
        lbl_tieu_de.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lbl_tieu_de.setBounds(117, 10, 502, 29);
        panel_1.add(lbl_tieu_de);

        // Nút quay lại
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
        panel_1.add(btn_thoat);

        // Giá trị danh vọng
        lbl_danhvong = new JLabel("0");
        lbl_danhvong.setForeground(new Color(255, 255, 0));
        lbl_danhvong.setFont(new Font("Times New Roman", Font.BOLD, 24));
        lbl_danhvong.setBounds(592, 60, 156, 29);
        pnl_vongnguyetphong.add(lbl_danhvong);

        // Hình nền
        JLabel lbl_hinh_nen = new JLabel("");
        lbl_hinh_nen.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\vong_nguyet_treo_may (1).png"));
        lbl_hinh_nen.setBounds(0, 48, 701, 539);
        pnl_vongnguyetphong.add(lbl_hinh_nen);

        setLocationRelativeTo(null);

        // Khởi chạy Vọng Nguyệt Phong
        vong_nguyet_phong(ten_tai_khoan);
    }

    // Lấy thông tin thành viên và bắt đầu tu luyện
    public void vong_nguyet_phong(String ten_tai_khoan) throws SQLException {

        String sql = "SELECT "
                + "tv.Ma_Thanh_vien, "
                + "tv.Ten_Thanh_Vien, "
                + "tt.Danh_Vong "
                + "FROM Thanh_Vien tv "
                + "JOIN Thong_Tin_Thanh_Vien tt "
                + "ON tv.Ma_Thanh_Vien = tt.Ma_Thanh_Vien "
                + "WHERE tv.Ten_Tai_khoan = ?";

        try (
            Connection ket_noi = file_ket_noi.ham_ket_noi();
            PreparedStatement ps = ket_noi.prepareStatement(sql)
        ) {

            ps.setString(1, ten_tai_khoan);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    ma_thanh_vien = rs.getNString("Ma_Thanh_Vien");

                    String ten_thanh_vien = rs.getNString("Ten_Thanh_Vien");

                    danh_vong = rs.getInt("Danh_Vong");

                    lbl_thongtin.setText(ma_thanh_vien + " - " + ten_thanh_vien);

                    lbl_danhvong.setText(String.valueOf(danh_vong));
                }
            }
        }

        // Mỗi 10 giây cộng 1 danh vọng
        timer = new Timer(10000, _ -> {

            if (hoat_dong) {

                danh_vong++;

                lbl_danhvong.setText(String.valueOf(danh_vong));

                hien_thi_cong_diem(pnl_vongnguyetphong);
            }

            // Cập nhật danh vọng vào SQL Server
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
        });

        timer.start();
    }

    // Hiệu ứng +1 bay lên
    public void hien_thi_cong_diem(JPanel panel) {

        JLabel lbl_cong_diem = new JLabel("+1");

        lbl_cong_diem.setFont(new Font("Times New Roman", Font.BOLD, 25));
        lbl_cong_diem.setForeground(Color.YELLOW);
        lbl_cong_diem.setBounds(350, 370, 80, 30);

        panel.add(lbl_cong_diem);
        panel.setComponentZOrder(lbl_cong_diem, 0);
        panel.repaint();

        final int[] vi_tri_y = {370};
        final int[] do_mo = {255};

        Timer animation = new Timer(30, null);

        animation.addActionListener(_ -> {

            vi_tri_y[0] -= 5;
            do_mo[0] -= 10;

            lbl_cong_diem.setLocation(350, vi_tri_y[0]);

            if (do_mo[0] <= 0) {

                animation.stop();

                panel.remove(lbl_cong_diem);
                panel.repaint();

            } else {

                lbl_cong_diem.setForeground(
                    new Color(255, 255, 0, do_mo[0])
                );
            }
        });

        animation.start();
    }
}