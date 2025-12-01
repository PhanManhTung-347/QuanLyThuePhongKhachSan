public interface IQuanLyDuLieu 
{
    void themPhong(Phong p);
    void themNguoi(Nguoi n);
    Phong timPhong(String maPhong);
    KhachHang timKhachHang(String maKhachHang);
    NhanVien timNhanVien(String maNhanVien);
    PhieuThue timPhieuThue(String maPhieuThue);
    HoaDon timHoaDon(String maHoaDon);
    boolean xoaPhong(String maPhong);
    boolean xoaKhachHang(String maKhachHang);
    boolean xoaNhanVien(String maNhanVien);
    boolean xoaPhieuThue(String maPhieuThue);
    boolean suaKhachHang(String maKhachHang);
    boolean suaNhanVien(String maNhanVien);
    boolean suaPhong(String maPhong);
    double tinhTongDoanhThu();
}
