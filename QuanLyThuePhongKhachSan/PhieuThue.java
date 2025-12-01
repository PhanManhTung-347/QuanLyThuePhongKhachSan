import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class PhieuThue
{
    private String maPhieuThue;
    private LocalDateTime ngayThue;
    private LocalDateTime ngayTraDuKien;
    private KhachHang khachHang;
    private Phong phong;
    private Scanner sc=new Scanner(System.in);
    public PhieuThue(String maPhieuThue,LocalDateTime ngayThue,LocalDateTime ngayTraDuKien,KhachHang khachHang,Phong phong)
    {
        this.maPhieuThue=maPhieuThue;
        this.ngayThue=ngayThue;
        this.ngayTraDuKien=ngayTraDuKien;
        this.khachHang=khachHang;
        this.phong=phong;
    }
    public PhieuThue(){}
    public String getMaPhieuThue() {
        return maPhieuThue;
    }
    public void setMaPhieuThue(String maPhieuThue) {
        this.maPhieuThue = maPhieuThue;
    }
    public LocalDateTime getNgayThue() {
        return ngayThue;
    }
    public void setNgayThue(LocalDateTime ngayThue) {
        this.ngayThue = ngayThue;
    }
    public LocalDateTime getNgayTraDuKien() {
        return ngayTraDuKien;
    }
    public void setNgayTraDuKien(LocalDateTime ngayTraDuKien) {
        this.ngayTraDuKien = ngayTraDuKien;
    }
    public KhachHang getKhachHang() {
        return khachHang;
    }
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
    public Phong getPhong() {
        return phong;
    }
    public void setPhong(Phong phong) {
        this.phong = phong;
    }
    public void nhap(KhachHang khachHang, Phong phong) 
    { 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime thoiGianHienTai = LocalDateTime.now();
        boolean hopLe1 = false;
        do {
            try {
                System.out.println("Nhap ngay thue (dd/MM/yyyy HH:mm):"); 
                this.ngayThue = LocalDateTime.parse(sc.nextLine(), formatter);
                if (this.ngayThue.isBefore(thoiGianHienTai)) 
                {
                    System.out.println("Ngay thue phai lon hon hoac bang ngay gio hien tai: "+thoiGianHienTai.format(formatter));
                } 
                else 
                {
                    hopLe1 = true;
                }
            } catch (DateTimeParseException ex) {
                System.out.println("Dinh dang ngay khong hop le, vui long nhap theo format (dd/MM/yyyy HH:mm)!");
            }
        } while (hopLe1==false);
        boolean hopLe2 = false;
        do {
            try {
                System.out.println("Nhap ngay du kien tra (dd/MM/yyyy HH:mm):");
                this.ngayTraDuKien = LocalDateTime.parse(sc.nextLine(), formatter);
                if (this.ngayTraDuKien.isBefore(this.ngayThue)) 
                {
                    System.out.println("Ngay tra du kien phai lon hon hoac bang ngay thue: "+this.ngayThue.format(formatter));
                } 
                else 
                {
                    hopLe2 = true;
                }
            } catch (DateTimeParseException ex) {
                System.out.println("Dinh dang ngay khong hop le, vui long nhap theo format (dd/MM/yyyy HH:mm)!");
            }
        } while (hopLe2==false);
        this.khachHang = khachHang;
        this.phong = phong;
    }
    public void xuat() 
    {
        System.out.println("\n----Thong tin phieu thue---");
        System.out.println("Ma phieu thue: " +this.maPhieuThue);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Ngay thue: " + formatter.format(this.ngayThue));
        System.out.println("Ngay tra du kien: " + formatter.format(this.ngayTraDuKien));
        khachHang.xuat();
        phong.xuat();
    }
    public double tinhNgayThue() 
    {
        LocalDateTime ngayThueLocal = this.ngayThue;
        LocalDateTime ngayTraDuKienLocal = this.ngayTraDuKien;
        long soNgayThue = ChronoUnit.DAYS.between(ngayThueLocal, ngayTraDuKienLocal);
        return Math.abs(soNgayThue);
    }
    public double tinhTien()
    {
        return phong.getGiaPhong()*tinhNgayThue();
    }
}
