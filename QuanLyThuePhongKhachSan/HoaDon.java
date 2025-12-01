import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class HoaDon
{
    private String maHoaDon;
    private LocalDateTime ngayLap;
    private double tongTien;
    private PhieuThue phieuThue;
    private NhanVien nhanVienLap;
    private String trangThai;
    private Scanner sc=new Scanner(System.in);
    public HoaDon(String maHoaDon, PhieuThue phieuThue, NhanVien nhanVienLap,LocalDateTime ngayLap,String trangThai,double tongTien) {
        this.maHoaDon = maHoaDon;
        this.phieuThue = phieuThue;
        this.nhanVienLap = nhanVienLap;
        this.ngayLap =ngayLap;
        this.tongTien = phieuThue.tinhTien();
        this.trangThai = trangThai;
    }
   
    public HoaDon() {}
    public String getMaHoaDon() {
        return maHoaDon;
    }
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }
    public LocalDateTime getNgayLap() {
        return ngayLap;
    }
    public void setNgayLap(LocalDateTime ngayLap) {
        this.ngayLap = ngayLap;
    }
    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
    public PhieuThue getPhieuThue() {
        return phieuThue;
    }
    public void setPhieuThue(PhieuThue phieuThue) {
        this.phieuThue = phieuThue;
    }
    public NhanVien getNhanVienLap() {
        return nhanVienLap;
    }
    public void setNhanVienLap(NhanVien nhanVienLap) {
        this.nhanVienLap = nhanVienLap;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Scanner getSc() {
        return sc;
    }
    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    public void xacNhanThanhToan() 
    {
        this.trangThai = "Da thanh toan";
    }
    public void xuat() 
    {
        System.out.println("\n----Hoa don thanh toan----");
        System.out.println("Ma hoa don:" +this.maHoaDon);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Ngay lap:" + formatter.format(ngayLap));
        System.out.println("Nhan vien lap:" + nhanVienLap.getHoTen());
        System.out.println("Trang thai:" +this.trangThai);
        System.out.println("Tong tien:" +this.tongTien);
        phieuThue.xuat();
        System.out.println("=========================");
    }
}