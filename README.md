# 🏯 HUYỄN LINH TÔNG

**Hệ thống quản lý tông môn – HUYỄN LINH TÔNG**

> Một ứng dụng quản lý tông môn được xây dựng bằng Java, kết hợp cơ sở dữ liệu Microsoft SQL Server, hướng đến việc quản lý thành viên, tài khoản, chức vụ và các hoạt động trong tông môn.

---

## 📖 1. Giới thiệu

HUYỄN LINH TÔNG là dự án phần mềm quản lý được phát triển với mục tiêu xây dựng một hệ thống quản lý tông môn có tổ chức, phân quyền rõ ràng và dữ liệu được lưu trữ tập trung.

Ứng dụng cung cấp giao diện đồ họa, hỗ trợ người dùng thao tác với các chức năng quản lý thông qua hệ thống cửa sổ Java Swing.

### 🎯 Mục tiêu dự án

- Xây dựng hệ thống quản lý thành viên.
- Quản lý tài khoản và quyền truy cập.
- Quản lý các Phong trong tông môn.
- Lưu trữ và truy xuất dữ liệu bằng SQL Server.
- Xây dựng giao diện thân thiện, dễ sử dụng.
- Đóng gói ứng dụng thành file `.exe` để thuận tiện triển khai trên Windows.

---

## 🛠️ 2. Công nghệ sử dụng

| Công nghệ            | Mục đích                        |
| -------------------- | ------------------------------- |
| Java                 | Ngôn ngữ lập trình chính        |
| Java Swing           | Xây dựng giao diện đồ họa       |
| Microsoft SQL Server | Quản lý cơ sở dữ liệu           |
| JDBC                 | Kết nối Java với SQL Server     |
| jpackage             | Đóng gói ứng dụng thành EXE     |
| JRE Runtime          | Môi trường thực thi Java đi kèm |

---

## 📂 3. Cấu trúc thư mục

```text
HUYEN_LINH_TONG/
│
├── HUYEN_LINH_TONG.exe
│
├── app/
│   ├── HUYEN_LINH_TONG.jar
│   └── HUYEN_LINH_TONG.cfg
│
└── runtime/
    ├── bin/
    ├── conf/
    ├── legal/
    └── lib/
```

### Chức năng các thành phần

- `HUYEN_LINH_TONG.exe`: Tệp khởi chạy ứng dụng.
- `app/`: Chứa chương trình Java đã biên dịch và tệp cấu hình.
- `runtime/`: Chứa môi trường Java được đóng gói cùng ứng dụng.

---

## 🚀 4. Hướng dẫn sử dụng

### Nếu muốn sử dụng dược thì hãy sửa lại code trong file Ket_Noi để thiết lập kết nối với sql

### Yêu cầu hệ thống

- Hệ điều hành Windows.
- Microsoft SQL Server nếu sử dụng các chức năng cần kết nối cơ sở dữ liệu.
- Cơ sở dữ liệu được cấu hình phù hợp với ứng dụng.

**Lưu ý:** Ứng dụng đã được đóng gói kèm Java Runtime nên không cần cài đặt Java riêng trên máy tính.

### Khởi chạy chương trình

1. Giải nén thư mục `HUYEN_LINH_TONG`.
2. Giữ nguyên cấu trúc thư mục.
3. Nhấn đúp vào tệp `HUYEN_LINH_TONG.exe`.
4. Chờ ứng dụng khởi động.

Không di chuyển riêng tệp EXE ra khỏi thư mục chứa `app` và `runtime`.

---


## 🗄️ 5. Cơ sở dữ liệu

Dự án sử dụng Microsoft SQL Server để lưu trữ dữ liệu.

Cơ sở dữ liệu đảm nhiệm việc quản lý các thông tin liên quan đến:

- Tài khoản.
- Thành viên.
- Thông tin thành viên.
- Các Phong.
- Chức vụ.
- Tu vi.
- Các dữ liệu quản lý khác.

Tên cơ sở dữ liệu và thông tin kết nối cần được cấu hình tương ứng với môi trường triển khai.

---

## 🏯 6. Hệ thống Cửu Phong

HUYỄN LINH TÔNG được tổ chức thành chín Phong:

| Mã Phong | Tên Phong          |
| -------- | ------------------ |
| TNP      | Thiên Nguyên Phong |
| VNP      | Vọng Nguyệt Phong  |
| THP      | Tử Hà Phong        |
| PMP      | Phiêu Miểu Phong   |
| UMP      | U Minh Phong       |
| VDP      | Vấn Đạo Phong      |
| LHP      | Lạc Hà Phong       |
| LTP      | Lưu Thần Phong     |
| VTP      | Vân Tiêu Phong     |

Mỗi Phong là một đơn vị trực thuộc tông môn, có hệ thống thành viên và thông tin quản lý riêng.

---

## 🔐 7. Bảo mật

Hệ thống hướng đến việc phân quyền và quản lý tài khoản người dùng.

Các thông tin đăng nhập và dữ liệu thành viên được quản lý thông qua cơ sở dữ liệu.

Người quản trị chịu trách nhiệm quản lý tài khoản và các hoạt động quản lý được cấp quyền.

---

## 👨‍💻 8. Tác giả

**Xuyên Bạch**

Dự án: HUYỄN LINH TÔNG

---

## 📜 9. Bản quyền

© 2026 Xuyên Bạch – HUYỄN LINH TÔNG.

Mọi quyền được bảo lưu.

---

\<p align="center">   \<b>HUYỄN LINH TÔNG\</b>   \<br>   \<i>Nhất niệm khai thiên địa – Vạn đạo quy tông môn.\</i> \</p>
