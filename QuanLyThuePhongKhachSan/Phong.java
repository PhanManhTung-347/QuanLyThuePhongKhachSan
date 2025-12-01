import java.util.Scanner;

public class Phong
{
    private String maPhong;
    private String loaiPhong;
    private double giaPhong;   
    private String trangThai;
    private Scanner sc=new Scanner(System.in);
    public Phong(String maPhong,String loaiPhong,double giaPhong,String trangThai)
    {
        this.maPhong=maPhong;
        this.loaiPhong=loaiPhong;
        this.giaPhong=giaPhong;
        this.trangThai="Trong";
    }
    public Phong(){}
    public String getMaPhong() {
        return maPhong;
    }
    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }
    public String getLoaiPhong() {
        return loaiPhong;
    }
    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }
    public double getGiaPhong() {
        return giaPhong;
    }
    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }
    public String getTrangThai() {
        return trangThai;
    }
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public void nhap()
    {
        System.out.println("Nhap ma phong:");
        this.maPhong=sc.nextLine();
        System.out.println("Nhap loai phong:");
        this.loaiPhong=sc.nextLine();
        boolean hople=false;
        do
        {
            try
            {
                System.out.println("Nhap gia phong:");
                this.giaPhong=sc.nextDouble();
                sc.nextLine();
                if (giaPhong<=0)
                {
                    System.out.println("Gia phong phai lon hon 0! Vui long nhap lai");
                    hople=false;
                }
                else
                    hople=true;
            }
            catch (Exception ex)
            {
                System.out.println("Vui long nhap dung dinh dang cua gia tien!");
                sc.nextLine();
                hople=false;
            }
        }
        while (hople==false);
        this.trangThai="Trong";
    }
    public void xuat()
    {
        System.out.println("\n----Thong tin phong----");
        System.out.println("Ma phong: "+this.maPhong);
        System.out.println("Loai phong: "+this.loaiPhong);
        System.out.println("Gia phong: "+this.giaPhong);
        System.out.println("Trang thai: "+this.trangThai);
    }
    public void capNhatTrangThai(String trangThaiMoi)
    {
        this.trangThai=trangThaiMoi;
    }
}
