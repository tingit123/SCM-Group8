package cmu246; // Đổi tên package thành chữ thường theo quy tắc đặt tên trong Java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SinhVien {
    private String mssv;
    private String hoTen;
    private String ngaySinh; // Sửa tên biến theo quy tắc camelCase
    private String gioiTinh;
    private String email;
    private String phone;

    public SinhVien(String mssv, String hoTen, String ngaySinh, String gioiTinh, String email, String phone) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh; // Đổi từ Ngaysinh -> ngaySinh
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.phone = phone;
    }

    public String getMssv() {
        return mssv;
    }

    @Override
    public String toString() {
        return "MSSV: " + mssv + ", Họ tên: " + hoTen + ", Ngày sinh: " + ngaySinh + ", Giới tính: " + gioiTinh + ", Email: " + email + ", Phone: " + phone;
    }
}

public class Necu { // Đổi tên class thành PascalCase
    private static List<SinhVien> danhSachSinhVien = new ArrayList<>();

    public static void themSinhVien(Scanner scanner) { // Tránh tạo Scanner mới
        System.out.print("Nhập MSSV: ");
        String mssv = scanner.nextLine();
        System.out.print("Nhập Họ và Tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhập Ngày sinh: ");
        String ngaySinh = scanner.nextLine();
        System.out.print("Nhập Giới tính: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Nhập Email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập Số điện thoại: ");
        String phone = scanner.nextLine();

        danhSachSinhVien.add(new SinhVien(mssv, hoTen, ngaySinh, gioiTinh, email, phone));
        System.out.println("Thêm sinh viên thành công!");
    }

    public static void xoaSinhVien(Scanner scanner) { // Tránh tạo Scanner mới
        System.out.print("Nhập MSSV cần xóa: ");
        String mssv = scanner.nextLine();

        boolean daXoa = danhSachSinhVien.removeIf(sv -> sv.getMssv().equals(mssv));
        if (daXoa) {
            System.out.println("Xóa sinh viên thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên có MSSV: " + mssv);
        }
    }

    public static void hienThiDanhSach() {
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            for (SinhVien sv : danhSachSinhVien) {
                System.out.println(sv);
            }
        }
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Thêm sinh viên");
System.out.println("2. Xóa sinh viên");
                System.out.println("3. Hiển thị danh sách");
                System.out.println("4. Thoát");
                System.out.print("Chọn chức năng: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập số.");
                    scanner.next(); // Xử lý lỗi nhập ký tự không hợp lệ
                    continue;
                }

                int chon = scanner.nextInt();
                scanner.nextLine(); // Xử lý lỗi trôi lệnh

                switch (chon) {
                    case 1:
                        themSinhVien(scanner);
                        break;
                    case 2:
                        xoaSinhVien(scanner);
                        break;
                    case 3:
                        hienThiDanhSach();
                        break;
                    case 4:
                        System.out.println("Kết thúc chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        } finally {
            scanner.close(); // Đảm bảo đóng Scanner
        }
    }

    public static void main(String[] args) {
        Necu a= new Necu();a.Menu();
    }
}