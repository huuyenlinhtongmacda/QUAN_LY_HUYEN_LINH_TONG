
package Do_An;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Chi_Tiet_Thanh_Vien extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txt_taikhoan;
    private JTextField txt_quyen;
    private JTextField txt_mathanhvien;
    private JTextField txt_tenthanhvien;
    private JTextField txt_phong;
    private JTextField txt_chucvu;
    private JTextField txt_tuvi;
    private JTextField txt_linhcan;
    private JTextField txt_phapkhi;

    private JButton btn_sua;

    private boolean trang_thai = false;

    private final String ten_tai_khoan;

    // Lưu mã thành viên ban đầu
    private String ma_thanh_vien_cu;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    Chi_Tiet_Thanh_Vien frame =
                            new Chi_Tiet_Thanh_Vien("admin");

                    frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }
            }
        });
    }

    public Chi_Tiet_Thanh_Vien(String ten_tai_khoan) {

        this.ten_tai_khoan = ten_tai_khoan;

        setTitle("Chi Tiết Thành Viên - HUYỄN LINH TÔNG");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(720, 470);

        setLocationRelativeTo(null);

        tao_giao_dien();

        hoat_dong(ten_tai_khoan);

        khoa_cac_o_nhap();
    }

    // =========================================
    // GIAO DIỆN
    // =========================================

    private void tao_giao_dien() {

        JPanel content_pane = new JPanel(new BorderLayout(10, 10));

        content_pane.setBorder(
                BorderFactory.createEmptyBorder(12, 18, 15, 18));

        content_pane.setBackground(Color.WHITE);

        setContentPane(content_pane);

        JLabel lbl_tieu_de = new JLabel(
                "HUYỄN LINH TÔNG",
                SwingConstants.CENTER);

        lbl_tieu_de.setForeground(Color.RED);

        lbl_tieu_de.setFont(
                new Font("Times New Roman", Font.BOLD, 26));

        lbl_tieu_de.setOpaque(true);

        lbl_tieu_de.setBackground(new Color(255, 255, 128));

        lbl_tieu_de.setBorder(
                BorderFactory.createEmptyBorder(8, 5, 8, 5));

        content_pane.add(lbl_tieu_de, BorderLayout.NORTH);

        JPanel panel_thong_tin = new JPanel(new GridBagLayout());

        panel_thong_tin.setBackground(Color.WHITE);

        panel_thong_tin.setBorder(
                BorderFactory.createTitledBorder("Thông Tin Thành Viên"));

        content_pane.add(panel_thong_tin, BorderLayout.CENTER);

        txt_taikhoan = new JTextField(15);
        txt_quyen = new JTextField(15);
        txt_mathanhvien = new JTextField(15);
        txt_tenthanhvien = new JTextField(15);
        txt_phong = new JTextField(15);
        txt_chucvu = new JTextField(15);
        txt_tuvi = new JTextField(15);
        txt_linhcan = new JTextField(15);
        txt_phapkhi = new JTextField(15);

        them_o(panel_thong_tin, "Tài Khoản:", txt_taikhoan, 0, 0);
        them_o(panel_thong_tin, "Quyền:", txt_quyen, 1, 0);

        them_o(panel_thong_tin, "Tên Thành Viên:", txt_tenthanhvien, 0, 1);
        them_o(panel_thong_tin, "Mã Thành Viên:", txt_mathanhvien, 1, 1);

        them_o(panel_thong_tin, "Mã Phòng:", txt_phong, 0, 2);
        them_o(panel_thong_tin, "Chức Vụ:", txt_chucvu, 1, 2);

        them_o(panel_thong_tin, "Tu Vi:", txt_tuvi, 0, 3);
        them_o(panel_thong_tin, "Linh Căn:", txt_linhcan, 1, 3);

        them_o(panel_thong_tin, "Pháp Khí:", txt_phapkhi, 0, 4);

        JPanel panel_nut = new JPanel();

        panel_nut.setBackground(Color.WHITE);

        btn_sua = new JButton("Sửa");

        btn_sua.setFont(
                new Font("Times New Roman", Font.BOLD, 16));

        btn_sua.setForeground(Color.MAGENTA);

        btn_sua.addActionListener(_ -> xu_ly_nut_sua());

        panel_nut.add(btn_sua);

        JButton btn_xoa = new JButton("Xóa thành viên");

        btn_xoa.addActionListener(_ -> xu_ly_xoa());

        panel_nut.add(btn_xoa);

        JButton btn_dong = new JButton("Đóng");

        btn_dong.setFont(
                new Font("Times New Roman", Font.BOLD, 16));

        btn_dong.addActionListener(_ -> {

            Quan_Tri frame = new Quan_Tri();

            frame.setVisible(true);

            dispose();

        });

        panel_nut.add(btn_dong);

        content_pane.add(panel_nut, BorderLayout.SOUTH);
    }

    private void them_o(
            JPanel panel,
            String ten_nhan,
            JTextField o_nhap,
            int cot,
            int hang) {

        GridBagConstraints gbc_nhan = new GridBagConstraints();

        gbc_nhan.insets = new Insets(9, 8, 9, 8);

        gbc_nhan.anchor = GridBagConstraints.WEST;

        gbc_nhan.gridx = cot * 2;

        gbc_nhan.gridy = hang;

        JLabel lbl = new JLabel(ten_nhan);

        lbl.setForeground(Color.BLUE);

        lbl.setFont(
                new Font("Times New Roman", Font.BOLD, 16));

        panel.add(lbl, gbc_nhan);

        GridBagConstraints gbc_o_nhap = new GridBagConstraints();

        gbc_o_nhap.insets = new Insets(9, 8, 9, 8);

        gbc_o_nhap.gridx = cot * 2 + 1;

        gbc_o_nhap.gridy = hang;

        gbc_o_nhap.fill = GridBagConstraints.HORIZONTAL;

        gbc_o_nhap.weightx = 1;

        o_nhap.setFont(
                new Font("Tahoma", Font.PLAIN, 12));

        panel.add(o_nhap, gbc_o_nhap);
    }

    // =========================================
    // KHÓA VÀ MỞ KHÓA Ô NHẬP
    // =========================================

    private void khoa_cac_o_nhap() {

        txt_taikhoan.setEditable(false);

        txt_quyen.setEditable(false);

        txt_mathanhvien.setEditable(false);

        txt_tenthanhvien.setEditable(false);

        txt_phong.setEditable(false);

        txt_chucvu.setEditable(false);

        txt_tuvi.setEditable(false);

        txt_linhcan.setEditable(false);

        txt_phapkhi.setEditable(false);
    }

    private void mo_khoa_cac_o_nhap() {

        txt_tenthanhvien.setEditable(true);

        txt_mathanhvien.setEditable(true);

        txt_phong.setEditable(true);

        txt_chucvu.setEditable(true);

        txt_tuvi.setEditable(true);

        txt_linhcan.setEditable(true);

        txt_phapkhi.setEditable(true);
    }

    // =========================================
    // TẢI THÔNG TIN THÀNH VIÊN
    // =========================================

    public void hoat_dong(String ten_tai_khoan) {

        String sql =
                "SELECT "
                + "tk.Quyen, "
                + "tv.Ma_Thanh_Vien, "
                + "tv.Ten_Thanh_Vien, "
                + "ph.Ma_Phong, "
                + "tv.Chuc_Vu, "
                + "tt.Tu_Vi, "
                + "tt.Linh_Can, "
                + "tt.Phap_Khi "
                + "FROM Tai_Khoan tk "
                + "LEFT JOIN Thanh_Vien tv "
                + "ON tk.Ten_Tai_Khoan = tv.Ten_Tai_Khoan "
                + "LEFT JOIN Thong_Tin_Thanh_Vien tt "
                + "ON tv.Ma_Thanh_Vien = tt.Ma_Thanh_Vien "
                + "LEFT JOIN Cac_Phong ph "
                + "ON tv.Phong = ph.Ma_Phong "
                + "WHERE tk.Ten_Tai_Khoan = ?";

        try (
                Connection connection = file_ket_noi.ham_ket_noi();

                PreparedStatement ps = connection.prepareStatement(sql)
        ) {

            ps.setString(1, ten_tai_khoan);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    txt_taikhoan.setText(ten_tai_khoan);

                    txt_quyen.setText(rs.getString("Quyen"));

                    // LƯU MÃ THÀNH VIÊN BAN ĐẦU
                    ma_thanh_vien_cu =
                            rs.getString("Ma_Thanh_Vien");

                    txt_mathanhvien.setText(ma_thanh_vien_cu);

                    txt_tenthanhvien.setText(
                            rs.getString("Ten_Thanh_Vien"));

                    txt_phong.setText(
                            rs.getString("Ma_Phong"));

                    txt_chucvu.setText(
                            rs.getString("Chuc_Vu"));

                    txt_tuvi.setText(
                            rs.getString("Tu_Vi"));

                    txt_linhcan.setText(
                            rs.getString("Linh_Can"));

                    txt_phapkhi.setText(
                            rs.getString("Phap_Khi"));

                    if (ma_thanh_vien_cu == null) {

                        JOptionPane.showMessageDialog(
                                this,
                                "Tài khoản này chưa có thông tin thành viên!");
                    }

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Không tìm thấy tài khoản: " + ten_tai_khoan);
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Không thể tải thông tin thành viên!\n"
                    + e.getMessage());

        }
        
    }

    // =========================================
    // NÚT SỬA VÀ LƯU
    // =========================================

    private void xu_ly_nut_sua() {

        if (!trang_thai) {

            if (ma_thanh_vien_cu == null
                    || ma_thanh_vien_cu.trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Không có mã thành viên ban đầu!");

                return;
            }

            mo_khoa_cac_o_nhap();

            btn_sua.setText("Lưu");

            trang_thai = true;

            return;
        }

        cap_nhat_thong_tin();
    }

    // =========================================
    // CẬP NHẬT THÔNG TIN
    // =========================================

    private void cap_nhat_thong_tin() {

        String ma_cu = ma_thanh_vien_cu;

        String ma_moi = txt_mathanhvien.getText().trim();

        String ten_thanh_vien =
                txt_tenthanhvien.getText().trim();

        String ten_phong =
                txt_phong.getText().trim();

        String chuc_vu =
                txt_chucvu.getText().trim();

        String tu_vi =
                txt_tuvi.getText().trim();

        String linh_can =
                txt_linhcan.getText().trim();

        String phap_khi =
                txt_phapkhi.getText().trim();

        // KIỂM TRA MÃ BAN ĐẦU

        if (ma_cu == null || ma_cu.trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Không tìm thấy mã thành viên ban đầu!");

            return;
        }

        // KIỂM TRA DỮ LIỆU

        if (ma_moi.isEmpty()
                || ten_thanh_vien.isEmpty()
                || ten_phong.isEmpty()
                || chuc_vu.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Mã thành viên, tên thành viên, phòng và chức vụ không được để trống!");

            return;
        }

        Connection connection = null;

        try {

            connection = file_ket_noi.ham_ket_noi();

            if (connection == null) {

                throw new SQLException(
                        "Kết nối cơ sở dữ liệu thất bại!");
            }

            connection.setAutoCommit(false);

            // =================================
            // KIỂM TRA MÃ THÀNH VIÊN TRÙNG
            // =================================

            String sql_kiem_tra =
                    "SELECT COUNT(*) "
                    + "FROM Thanh_Vien "
                    + "WHERE Ma_Thanh_Vien = ? "
                    + "AND Ma_Thanh_Vien <> ?";

            try (PreparedStatement ps =
                    connection.prepareStatement(sql_kiem_tra)) {

                ps.setString(1, ma_moi);

                ps.setString(2, ma_cu);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next() && rs.getInt(1) > 0) {

                        throw new SQLException(
                                "Mã thành viên đã tồn tại!");
                    }
                }
            }

            // =================================
            // KIỂM TRA PHÒNG
            // =================================

            String sql_phong =
                    "SELECT COUNT(*) "
                    + "FROM Cac_Phong "
                    + "WHERE Ma_Phong = ?";

            try (PreparedStatement ps =
                    connection.prepareStatement(sql_phong)) {

                ps.setString(1, ten_phong);

                try (ResultSet rs = ps.executeQuery()) {

                    if (!rs.next() || rs.getInt(1) == 0) {

                        throw new SQLException(
                                "Mã phòng không tồn tại!");
                    }
                }
            }

            // =================================
            // THAY ĐỔI MÃ THÀNH VIÊN
            // =================================

            if (!ma_cu.equals(ma_moi)) {

                // TẠM NGỪNG KIỂM TRA KHÓA NGOẠI

                String sql_tat_khoa =
                        "ALTER TABLE dbo.Thong_Tin_Thanh_Vien "
                        + "NOCHECK CONSTRAINT FK_Thong_Tin_Thanh_Vien";

                try (PreparedStatement ps =
                        connection.prepareStatement(sql_tat_khoa)) {

                    ps.executeUpdate();
                }

                // CẬP NHẬT BẢNG THANH_VIEN

                String sql_doi_ma =
                        "UPDATE Thanh_Vien "
                        + "SET Ma_Thanh_Vien = ? "
                        + "WHERE Ma_Thanh_Vien = ?";

                try (PreparedStatement ps =
                        connection.prepareStatement(sql_doi_ma)) {

                    ps.setString(1, ma_moi);

                    ps.setString(2, ma_cu);

                    int ket_qua = ps.executeUpdate();

                    if (ket_qua == 0) {

                        throw new SQLException(
                                "Không tìm thấy mã thành viên cũ!");
                    }
                }

                // CẬP NHẬT BẢNG THONG_TIN_THANH_VIEN

                String sql_doi_ma_chi_tiet =
                        "UPDATE Thong_Tin_Thanh_Vien "
                        + "SET Ma_Thanh_Vien = ? "
                        + "WHERE Ma_Thanh_Vien = ?";

                try (PreparedStatement ps =
                        connection.prepareStatement(sql_doi_ma_chi_tiet)) {

                    ps.setString(1, ma_moi);

                    ps.setString(2, ma_cu);

                    int ket_qua = ps.executeUpdate();

                    if (ket_qua == 0) {

                        throw new SQLException(
                                "Không tìm thấy thông tin chi tiết thành viên!");
                    }
                }

                // BẬT LẠI VÀ KIỂM TRA KHÓA NGOẠI

                String sql_bat_khoa =
                        "ALTER TABLE dbo.Thong_Tin_Thanh_Vien "
                        + "WITH CHECK CHECK CONSTRAINT FK_Thong_Tin_Thanh_Vien";

                try (PreparedStatement ps =
                        connection.prepareStatement(sql_bat_khoa)) {

                    ps.executeUpdate();
                }
            }

            // =================================
            // CẬP NHẬT THÔNG TIN THÀNH VIÊN
            // =================================

            String sql_thanh_vien =
                    "UPDATE Thanh_Vien "
                    + "SET Ten_Thanh_Vien = ?, "
                    + "Chuc_Vu = ?, "
                    + "Phong = ? "
                    + "WHERE Ten_Tai_Khoan = ?";

            try (PreparedStatement ps =
                    connection.prepareStatement(sql_thanh_vien)) {

                ps.setString(1, ten_thanh_vien);

                ps.setString(2, chuc_vu);

                ps.setString(3, ten_phong);

                ps.setString(4, ten_tai_khoan);

                int ket_qua = ps.executeUpdate();

                if (ket_qua == 0) {

                    throw new SQLException(
                            "Không tìm thấy thành viên cần cập nhật!");
                }
            }

            // =================================
            // CẬP NHẬT THÔNG TIN CHI TIẾT
            // =================================

            String sql_thong_tin =
                    "UPDATE Thong_Tin_Thanh_Vien "
                    + "SET Tu_Vi = ?, "
                    + "Linh_Can = ?, "
                    + "Phap_Khi = ? "
                    + "WHERE Ma_Thanh_Vien = ?";

            try (PreparedStatement ps =
                    connection.prepareStatement(sql_thong_tin)) {

                ps.setString(1, tu_vi);

                ps.setString(2, linh_can);

                ps.setString(3, phap_khi);

                ps.setString(4, ma_moi);

                int ket_qua = ps.executeUpdate();

                if (ket_qua == 0) {

                    throw new SQLException(
                            "Không tìm thấy thông tin chi tiết thành viên!");
                }
            }

            // =================================
            // HOÀN TẤT GIAO DỊCH
            // =================================

            connection.commit();

            // CẬP NHẬT LẠI MÃ BAN ĐẦU

            ma_thanh_vien_cu = ma_moi;

            khoa_cac_o_nhap();

            btn_sua.setText("Sửa");

            trang_thai = false;

            JOptionPane.showMessageDialog(
                    this,
                    "Cập nhật thông tin thành viên thành công!");

        } catch (Exception e) {

            if (connection != null) {

                try {

                    connection.rollback();

                } catch (SQLException ex) {

                    ex.printStackTrace();
                }
            }

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Cập nhật thất bại!\n" + e.getMessage());

        } finally {

            if (connection != null) {

                try {

                    connection.setAutoCommit(true);

                    connection.close();

                } catch (SQLException e) {

                    e.printStackTrace();
                }
            }
        }
    }

    // =========================================
    // XÓA THÀNH VIÊN
    // =========================================

    private void xu_ly_xoa() {

        int xac_nhan = JOptionPane.showConfirmDialog(
                this,
                "Ngươi có chắc chắn muốn xóa thành viên này không?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);

        if (xac_nhan != JOptionPane.YES_OPTION) {

            return;
        }

        Connection connection = null;

        try {

            connection = file_ket_noi.ham_ket_noi();

            if (connection == null) {

                throw new SQLException(
                        "Kết nối cơ sở dữ liệu thất bại!");
            }

            connection.setAutoCommit(false);

            String ma_thanh_vien =
                    txt_mathanhvien.getText().trim();

            // XÓA THÔNG TIN CHI TIẾT

            String sql_1 =
                    "DELETE FROM Thong_Tin_Thanh_Vien "
                    + "WHERE Ma_Thanh_Vien = ?";

            try (PreparedStatement ps =
                    connection.prepareStatement(sql_1)) {

                ps.setString(1, ma_thanh_vien);

                ps.executeUpdate();
            }

            // XÓA THÀNH VIÊN

            String sql_2 =
                    "DELETE FROM Thanh_Vien "
                    + "WHERE Ma_Thanh_Vien = ?";

            try (PreparedStatement ps =
                    connection.prepareStatement(sql_2)) {

                ps.setString(1, ma_thanh_vien);

                int ket_qua = ps.executeUpdate();

                if (ket_qua == 0) {

                    throw new SQLException(
                            "Không tìm thấy thành viên cần xóa!");
                }
            }

            // XÓA TÀI KHOẢN

            String sql_3 =
                    "DELETE FROM Tai_Khoan "
                    + "WHERE Ten_Tai_Khoan = ?";

            try (PreparedStatement ps =
                    connection.prepareStatement(sql_3)) {

                ps.setString(1, ten_tai_khoan);

                ps.executeUpdate();
            }

            connection.commit();

            JOptionPane.showMessageDialog(
                    this,
                    "Xóa thành viên thành công!");

            Quan_Tri frame = new Quan_Tri();

            frame.setVisible(true);

            dispose();

        } catch (Exception e) {

            if (connection != null) {

                try {

                    connection.rollback();

                } catch (SQLException ex) {

                    ex.printStackTrace();
                }
            }

            e.printStackTrace();

            JOptionPane.showMessageDialog(
                    this,
                    "Xóa thất bại!\n" + e.getMessage());

        } finally {

            if (connection != null) {

                try {

                    connection.setAutoCommit(true);

                    connection.close();

                } catch (SQLException e) {

                    e.printStackTrace();
                }
            }
        }
    }
}
