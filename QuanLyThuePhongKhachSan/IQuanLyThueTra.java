import java.time.LocalDateTime;

public interface IQuanLyThueTra 
{
    PhieuThue thuePhong(KhachHang kh, Phong p, LocalDateTime ngayThue, LocalDateTime ngayTraDuKien);
    HoaDon traPhong(String maPhieuThue, NhanVien nv);
}
