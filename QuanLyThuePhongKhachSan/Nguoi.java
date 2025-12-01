import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class Nguoi
{
    protected String ma;
    protected String hoTen;
    protected String soDienThoai;
    protected String diaChi;
    protected Date ngaySinh;
    protected Scanner sc=new Scanner(System.in);
    public Nguoi(String ma,String hoTen,String soDienThoai,String diaChi,Date ngaySinh)
    {
        this.ma=ma;
        this.hoTen=hoTen;
        this.soDienThoai=soDienThoai;
        this.diaChi=diaChi;
        this.ngaySinh=ngaySinh;
    }
    public Nguoi(){}
    public void setma(String ma)
    {
        this.ma=ma;
    }
    public String getma()
    {
        return ma;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public long tinhTuoi(Date ngaySinh)
    {
        Calendar c=new GregorianCalendar();
        c.setTime(ngaySinh);
        LocalDate ngaySinhLoCal=LocalDate.of(c.get(Calendar.YEAR),c.get(Calendar.MONTH)+1,c.get(Calendar.DAY_OF_MONTH));
        LocalDate ngayHienTai=LocalDate.now();
        long tuoi=ChronoUnit.YEARS.between(ngaySinhLoCal,ngayHienTai);
        return Math.abs(tuoi);
    }
    public void nhap()
    {
        System.out.println("Nhap ma:");
        this.ma=sc.nextLine();
        System.out.println("Nhap ten:");
        this.hoTen=sc.nextLine();
        System.out.println("Nhap so dien thoai:");
        this.soDienThoai=sc.nextLine();
        System.out.println("Nhap dia chi:");
        this.diaChi=sc.nextLine();
        boolean hopLe = false;
        Date ngayHienTai = new Date();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        d.setLenient(false); 
        do 
        {
            System.out.println("Nhap ngay sinh (dd/MM/yyyy):");
            String ngaySinhStr = sc.nextLine();
            try 
            {
                Date ngayNhap = d.parse(ngaySinhStr);
                if (ngayNhap.after(ngayHienTai)) 
                {
                    System.out.println("Ngay sinh khong duoc lon hon ngay hien tai vui long nhap lai!");
                    hopLe = false;
                } 
                else 
                    if (tinhTuoi(ngayNhap)>=18)
                    {   
                        this.ngaySinh = ngayNhap;
                        hopLe = true; 
                    }
                    else
                    {
                        System.out.println("Chua du 18 tuoi.Vui long kiem tra hoac nhap lai!");
                        hopLe=false;
                    }

            } catch (ParseException ex) 
            {
                System.out.println("Ngay sinh khong dung dinh dang (dd/MM/yyyy). Vui long nhap lai!");
                hopLe = false;
            }

        } while (hopLe==false);
    }
    public void xuat()
    {
        System.out.println("Ma:" +this.ma);
        System.out.println("Ten: "+this.hoTen);
        System.out.println("So dien thoai: "+this.soDienThoai);
        System.out.println("Dia chi: "+this.diaChi);
        SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Ngay sinh: "+d.format(this.ngaySinh));
    }
}