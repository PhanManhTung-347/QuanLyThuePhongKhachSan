import java.util.Date;

public class NhanVien extends Nguoi
{
    private String chucVu;
    private double Luong;
    private double phuCap;
    public NhanVien(String maNhanVien,String hoTen,String soDienThoai,String diaChi,Date ngaySinh,String chucVu,double Luong,double phuCap)
    {
        super(maNhanVien,hoTen,soDienThoai,diaChi,ngaySinh);
        this.chucVu=chucVu;
        this.Luong=Luong;
        this.phuCap=phuCap;
    }
    public NhanVien(){}
    public String getChucVu() {
        return chucVu;
    }
    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    public double getLuong() {
        return Luong;
    }
    public void setLuong(double luong) {
        Luong = luong;
    }
    public double getPhuCap() {
        return phuCap;
    }
    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }
    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap vao chuc vu:");
        this.chucVu=sc.nextLine();
        boolean hople1=false;
        do
        {
            try
            {
                System.out.println("Nhap luong:");
                this.Luong=sc.nextDouble();
                sc.nextLine();
                if (Luong<=0)
                {
                    System.out.println("Luong phai lon hon 0! Vui long nhap lai");
                    hople1=false;
                }
                else
                    hople1=true;
            }
            catch (Exception ex)
            {
                System.out.println("Vui long nhap dung dinh dang cua gia tien!");
                sc.nextLine();
                hople1=false;
            }
        }
        while (hople1==false);
        boolean hople2=false;
        do
        {
            try
            {
                System.out.println("Nhap phu cap:");
                this.phuCap=sc.nextDouble();
                sc.nextLine();
                if (phuCap<0)
                {
                    System.out.println("Phu cap phai lon hon hoac bang 0! Vui long nhap lai");
                    hople2=false;
                }
                else
                    hople2=true;
            }
            catch (Exception ex)
            {
                System.out.println("Vui long nhap dung dinh dang cua gia tien!");
                sc.nextLine();
                hople2=false;
            }
        }
        while (hople2==false);
    }
    @Override
    public void xuat()
    {
        System.out.println("\n----Thong tin nhan vien----");
        super.xuat();
        System.out.println("Chuc vu: "+this.chucVu);
        System.out.println("Luong: "+this.Luong);
        System.out.println("Phu cap: "+this.phuCap);
    }
}
