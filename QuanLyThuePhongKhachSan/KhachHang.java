import java.util.Date;
public class KhachHang extends Nguoi
{
    private String soCMND;
    public KhachHang(String maKhachHang,String hoTen,String soDienThoai,String diaChi,Date ngaySinh,String soCMND)
    {
        super(maKhachHang,hoTen,soDienThoai,diaChi,ngaySinh);
        this.soCMND=soCMND;
    }
    public KhachHang(){}
    public String getSoCMND() {
        return soCMND;
    }
    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }
    @Override
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap so chung minh nhan dan:");
        this.soCMND=sc.nextLine();
    }
    @Override
    public void xuat()
    {
        System.out.println("\n----Thong tin khach hang----");
        super.xuat();
        System.out.println("So chung minh: "+this.soCMND);
    }

}
