import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class KhachSan_QuanLyThuePhong implements IQuanLyDuLieu,IQuanLyThueTra,IReadWrite
{
    protected  final ArrayList<Nguoi> dsNguoi;
    private final ArrayList<Phong> dsPhong;
    private final ArrayList<PhieuThue> dsPhieuThue;
    private final ArrayList<HoaDon> dsHoaDon;
    private final Scanner sc = new Scanner(System.in);
    public KhachSan_QuanLyThuePhong()
    {
        this.dsNguoi=new ArrayList<>();
        this.dsPhong=new ArrayList<>();
        this.dsPhieuThue=new ArrayList<>();
        this.dsHoaDon=new ArrayList<>();
    }

    @Override
    public void themNguoi(Nguoi n) 
    {
        for (Nguoi nguoi:dsNguoi)
        {
            if (nguoi.getma().equalsIgnoreCase(n.getma()))
            {
                if (n instanceof KhachHang)
                    System.out.println("Da ton tai khach hang voi ma nay. Khong the them!");
                else
                    System.out.println("Da ton tai nhan vien voi ma nay. Khong the them!");
            return;
            }
        }
        dsNguoi.add(n);
        if (n instanceof KhachHang)
            System.out.println("Da them khach hang thanh cong!");
        else
            System.out.println("Da them nhan vien thanh cong!");
    }

    @Override
    public void themPhong(Phong p) 
    {
        for (Phong phong:dsPhong)
        {
            if (p.getMaPhong().equalsIgnoreCase(phong.getMaPhong()))
            {
                System.out.println("Da ton tai phong voi ma nay, khong the them!");
                return;
            }
        }
        dsPhong.add(p);
        System.out.println("\nThem phong voi ma "+p.getMaPhong()+" thanh cong");
    }

    @Override
    public Phong timPhong(String maPhong) 
    {
        if (maPhong==null) 
            return null;
        for (Phong p : dsPhong) 
        {
            if (p.getMaPhong()!=null&&p.getMaPhong().equalsIgnoreCase(maPhong)) 
            {
                return p;
            }
        }
        return null;
    }

    @Override
    public KhachHang timKhachHang(String maKhachHang) 
    {
        if (maKhachHang==null) return null;
        for (Nguoi n:dsNguoi) 
        {
            if (n instanceof KhachHang) 
            {
                if (n.getma()!=null&& n.getma().equalsIgnoreCase(maKhachHang)) 
                {
                    return (KhachHang) n;
                }
            }    
        }
        return null;
    }
    @Override
    public NhanVien timNhanVien(String maNhanVien) 
    {
        if (maNhanVien==null) return null;
        for (Nguoi n:dsNguoi) 
        {
            if (n instanceof NhanVien) 
            {
                if (n.getma()!=null&& n.getma().equalsIgnoreCase(maNhanVien)) 
                {
                    return (NhanVien) n;
                }
            }    
        }
        return null;
    }
    @Override
    public PhieuThue timPhieuThue(String maPhieu) 
    {
        if (maPhieu==null) 
            return null;
        for (PhieuThue pt:dsPhieuThue) 
        {
            if (pt.getMaPhieuThue()!=null && pt.getMaPhieuThue().equalsIgnoreCase(maPhieu)) 
            {
                return pt;
            }
        }
        return null;
    }
    @Override
    public HoaDon timHoaDon(String maHoaDon) 
    {
        if (maHoaDon == null) 
            return null;
        for (HoaDon hd : dsHoaDon) 
        {
            if (hd.getMaHoaDon()!=null && hd.getMaHoaDon().equalsIgnoreCase(maHoaDon)) 
            {
                return hd;
            }
        }
        return null;
    }
    @Override
    public boolean xoaPhong(String maPhong) 
    {
        Phong phongCanXoa = timPhong(maPhong);
        if (phongCanXoa != null) 
        {
            if (!phongCanXoa.getTrangThai().equalsIgnoreCase("Trong")) 
           
            {
                System.out.println("Phong dang co khach thue khong the xoa!");
                return false;
            }
            for (PhieuThue pt : dsPhieuThue) 
            {
                if (pt.getPhong().getMaPhong().equalsIgnoreCase(maPhong)) 
                {
                    System.out.println("Khong the xoa phong nay do dang co lich su thue!");
                    return false;
                }
            }
            dsPhong.remove(phongCanXoa);
            System.out.println("Xoa phong thanh cong!");
            return true;
        }
        System.out.println("Khong tim thay phong voi ma " + maPhong+" de xoa");
        return false;
    }
    @Override
    public boolean xoaKhachHang(String maKhachHang) 
    {
        KhachHang khachHangCanXoa= timKhachHang(maKhachHang);
        if (khachHangCanXoa != null) 
        {
            for (PhieuThue pt : dsPhieuThue) 
            {
                if (pt.getKhachHang().getma().equalsIgnoreCase(maKhachHang)) 
                {
                    System.out.println("Khong the xoa khach hang nay do dang co lich su thue!");
                    return false;
                }
            }
            dsNguoi.remove(khachHangCanXoa);
            System.out.println("Xoa khach hang thanh cong!");
            return true;
        }
        System.out.println("Khong tim thay khach hang voi ma " +maKhachHang+" de xoa");
        return false;
    }
    @Override
    public boolean xoaNhanVien(String maNhanVien) 
    {
        NhanVien nhanVienCanXoa= timNhanVien(maNhanVien);
        if (nhanVienCanXoa != null) 
        {
            for (HoaDon hd : dsHoaDon) 
            {
                if (hd.getNhanVienLap().getma().equalsIgnoreCase(maNhanVien)) 
                {
                    System.out.println("Khong the xoa nhan vien nay vi co hoa don lien quan!");
                    return false;
                }
            }
            dsNguoi.remove(nhanVienCanXoa);
            System.out.println("Xoa nhan vien thanh cong!");
            return true;
        }
        System.out.println("Khong tim thay nhan vien voi ma " +maNhanVien+" de xoa");
        return false;
    }
    @Override
    public boolean xoaPhieuThue(String maPhieu) 
    {
        PhieuThue pt = timPhieuThue(maPhieu);
        if (pt == null) 
        {
            System.out.println("Khong tim thay phieu thue voi ma " + maPhieu + " de xoa");
            return false;
        }
        for (HoaDon hd : dsHoaDon) 
        {
            if (hd.getPhieuThue().getMaPhieuThue().equalsIgnoreCase(maPhieu)) 
            {
                System.out.println("Phieu thue da lap hoa don, khong the xoa!");
                return false;
            }
        }
        String c1;
        System.out.println("Ban co chac chan muon xoa phieu thue(Y/N)?");
        c1=sc.nextLine();
        Phong p = timPhong(pt.getPhong().getMaPhong());
        if (c1.equalsIgnoreCase("Y"))
        {
            if (p != null) 
            {
                p.capNhatTrangThai("Trong");
            }
            dsPhieuThue.remove(pt);
            System.out.println("Xoa phieu thue thanh cong!");
            return true;
        }
        else
        {
            System.out.println("Huy xoa phieu thue!");
            return false;
        }
    }
    @Override 
    public boolean suaKhachHang(String maKhachHang)
    {
        for (int i = 0; i < dsNguoi.size(); i++) 
        {
        if (dsNguoi.get(i).getma().equals(maKhachHang)) 
        {
            KhachHang khmoi = new KhachHang();
            khmoi.nhap();
            khmoi.setma(maKhachHang);
            dsNguoi.set(i, khmoi);
            return true;
        }
    }
    return false;
    }
    @Override
    public boolean suaNhanVien(String maNhanVien) 
    {
        for (int i = 0; i < dsNguoi.size(); i++) 
        {
            if (dsNguoi.get(i).getma().equals(maNhanVien)) 
            {
                System.out.println("Tim thay nhan vien, bat dau cap nhat:");
                NhanVien nvMoi = new NhanVien();
                nvMoi.nhap();
                nvMoi.setma(maNhanVien); 
                dsNguoi.set(i, nvMoi);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean suaPhong(String maPhong) 
    {
        for (int i = 0; i < dsPhong.size(); i++) 
        {
            if (dsPhong.get(i).getMaPhong().equals(maPhong)) 
            {
                System.out.println("Tim thay phong, bat dau cap nhat:");
                Phong pMoi = new Phong();
                pMoi.nhap();
                pMoi.setMaPhong(maPhong);
                dsPhong.set(i, pMoi);
                return true;
            }
        }
        return false;
    }
    @Override
    public double tinhTongDoanhThu() 
    {
        double tong = 0;
        for (HoaDon hd : dsHoaDon) 
        {
            if (hd.getTrangThai().equalsIgnoreCase("Da thanh toan")) 
            {
                tong += hd.getTongTien();
            }
        }
        return tong;
    }
    @Override
    public PhieuThue thuePhong(KhachHang kh, Phong p, LocalDateTime ngayThue, LocalDateTime ngayTraDuKien) 
    {
        if (p.getTrangThai().equalsIgnoreCase("Trong")) 
        {
            String maPhieu = "PT" + (dsPhieuThue.size() + 1);
            PhieuThue pt = new PhieuThue(maPhieu, ngayThue, ngayTraDuKien, kh, p);
            dsPhieuThue.add(pt);
            p.setTrangThai("Da thue");
            System.out.println("\nThue phong thanh cong.");
            return pt;
        } 
        return null;
    }

    @Override
    public HoaDon traPhong(String maPhieuThue, NhanVien nv) 
    {
        PhieuThue phieuThueCanTra = null;
        for (PhieuThue pt : dsPhieuThue) 
        {
            if (pt.getMaPhieuThue().equalsIgnoreCase(maPhieuThue)) 
            {
                phieuThueCanTra = pt;
                break;
            }
        }
        if (phieuThueCanTra != null) 
        {
            String maHD = "HD" + (dsHoaDon.size() + 1);
            LocalDateTime ngayLap = LocalDateTime.now();
            HoaDon hd = new HoaDon(maHD, phieuThueCanTra, nv, ngayLap, "Chua thanh toan", phieuThueCanTra.tinhTien());
            String type;
            System.out.println("Lua chon thanh toan: Y.Xac nhan thanh toan || N. Chua thanh toan");
            type=sc.nextLine();
            if (type.equalsIgnoreCase("Y"))
            {
                hd.xacNhanThanhToan(); 
                dsHoaDon.add(hd);
                phieuThueCanTra.getPhong().setTrangThai("Trong");
                System.out.println("Tra phong thanh cong, hoa don da lap va thanh toan!");
                hd.xuat();
                return hd;
            }
            else
            {
                System.out.println("Thanh toan that bai huy thanh toan!");
                return null;
            }
        } 
        else 
        {
            System.out.println("Khong tim thay phieu thue voi ma:" + maPhieuThue);
            return null;
        }
    }
    @Override
    public void WriteData() 
    {
        System.out.println("...Dang ghi du lieu xuong file " + IReadWrite.filename + "...");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        try (PrintWriter pw = new PrintWriter(new FileWriter(IReadWrite.filename))) 
        {
            pw.println("---NGUOI---");
            for (Nguoi n : dsNguoi) 
            {
                String type = (n instanceof KhachHang) ? "KH" : "NV";
                pw.println(type + "|" + n.getma() + "|" + n.getHoTen() + "|" + n.getSoDienThoai() + "|" + n.getDiaChi() + "|" + dateFormatter.format(n.getNgaySinh())+"|");
                if (n instanceof KhachHang kh) 
                {
                    pw.println(kh.getSoCMND());
                } 
                else if (n instanceof NhanVien nv) 
                {
                    pw.println(nv.getChucVu() + "|" + nv.getLuong() + "|" + nv.getPhuCap());
                }
            }
            pw.println("---PHONG---");
            for (Phong p : dsPhong) 
            {
                pw.println(p.getMaPhong() + "|" + p.getLoaiPhong() + "|" + p.getGiaPhong() + "|" + p.getTrangThai());
            }
            pw.println("---PHIEUTHUE---");
            for (PhieuThue pt : dsPhieuThue) 
            {
                pw.println(pt.getMaPhieuThue() + "|" + pt.getNgayThue().format(dateTimeFormatter) + "|" + pt.getNgayTraDuKien().format(dateTimeFormatter) + "|" + pt.getKhachHang().getma() + "|" + pt.getPhong().getMaPhong());
            }
            pw.println("---HOADON---");
            for (HoaDon hd : dsHoaDon) 
            {
                pw.println(hd.getMaHoaDon() + "|" + hd.getPhieuThue().getMaPhieuThue() + "|" + hd.getNhanVienLap().getma() + "|" + hd.getNgayLap().format(dateTimeFormatter) + "|" + hd.getTongTien() + "|" + "Da thanh toan");
            }
            pw.println("---END---");
            System.out.println("Ghi du lieu thanh cong vao file " + IReadWrite.filename + "!");
        } catch (IOException e) {
            System.out.println("Loi ghi du lieu: " + e.getMessage());
        }
    }

    @Override
    public void ReadData()
    {
        File f = new File(IReadWrite.filename);
        if (!f.exists()) 
        {
            System.out.println("File "+IReadWrite.filename+" khong ton tai!");
            return;
        }
        System.out.println("Dang doc du lieu tu file: "+IReadWrite.filename + "...");
        dsNguoi.clear();
        dsPhong.clear();
        dsPhieuThue.clear();
        dsHoaDon.clear();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String phanHienTai = "";
        try (BufferedReader br = new BufferedReader(new FileReader(f))) 
        {
            String dong;
            while ((dong=br.readLine())!=null) 
            {
                if (dong.startsWith("---") &&dong.endsWith("---")) 
                {
                    phanHienTai=dong;
                    continue;
                }
                switch (phanHienTai) 
                {
                    case "---NGUOI---":
                        String[] partsNguoi = dong.split("\\|");
                        if (partsNguoi.length >= 6) 
                        {
                            String type = partsNguoi[0];
                            java.util.Date ngaySinh = dateFormatter.parse(partsNguoi[5]);
                            if (type.equals("KH")) 
                            {
                                String cmndLine = br.readLine();
                                if (cmndLine!=null) 
                                {
                                    KhachHang kh = new KhachHang(partsNguoi[1], partsNguoi[2], partsNguoi[3], partsNguoi[4], ngaySinh, cmndLine);
                                    dsNguoi.add(kh);
                                }
                            } 
                            else if (type.equals("NV")) 
                            {
                                String nvDetailLine = br.readLine();
                                if (nvDetailLine != null) 
                                {
                                    String[] nvParts = nvDetailLine.split("\\|");
                                    if (nvParts.length == 3) 
                                    {
                                        NhanVien nv = new NhanVien(partsNguoi[1], partsNguoi[2], partsNguoi[3], partsNguoi[4], ngaySinh, nvParts[0], Double.parseDouble(nvParts[1]), Double.parseDouble(nvParts[2]));
                                        dsNguoi.add(nv);
                                    }
                                }
                            }
                        }
                        break;
                    
                    case "---PHONG---":
                        String[] partsPhong = dong.split("\\|");
                        if (partsPhong.length == 4) 
                        {
                            Phong p = new Phong(partsPhong[0], partsPhong[1], Double.parseDouble(partsPhong[2]), partsPhong[3]);
                            dsPhong.add(p);
                        }
                        break;
                    case "---PHIEUTHUE---":
                    case "---HOADON---":
                        break;
                }
            }
        } catch (IOException | NumberFormatException | ParseException e) {
            System.out.println("File reading error: " + e.getMessage());
            return; 
        }
        try (BufferedReader br = new BufferedReader(new FileReader(f))) 
        {
            String dong;
            phanHienTai = "";
            while ((dong = br.readLine()) != null) 
                {
                    if (dong.startsWith("---") && dong.endsWith("---")) 
                    {
                        phanHienTai = dong;
                        continue;
                    }
                    switch (phanHienTai) 
                    {
                        case "---PHIEUTHUE---":
                            String[] partsPT = dong.split("\\|");
                            if (partsPT.length == 5) 
                            {
                                LocalDateTime ngayThue = LocalDateTime.parse(partsPT[1], dateTimeFormatter);
                                LocalDateTime ngayTraDuKien = LocalDateTime.parse(partsPT[2], dateTimeFormatter);
                                KhachHang kh = timKhachHang(partsPT[3]);
                                Phong p = timPhong(partsPT[4]);
                                if (kh != null && p != null) 
                                {
                                    PhieuThue pt = new PhieuThue(partsPT[0], ngayThue, ngayTraDuKien, kh, p);
                                    dsPhieuThue.add(pt);
                                }
                            }
                            break;
                        case "---HOADON---":
                            String[] partsHD = dong.split("\\|");
                            if (partsHD.length == 6) {
                                PhieuThue pt = timPhieuThue(partsHD[1]);
                                NhanVien nvLap = null;
                                for(Nguoi n : dsNguoi) {
                                    if (n instanceof NhanVien && n.getma().equalsIgnoreCase(partsHD[2])) 
                                    {
                                        nvLap = (NhanVien) n;
                                        break;
                                    }
                                }
                                LocalDateTime ngayLap = LocalDateTime.parse(partsHD[3], dateTimeFormatter);
                                double tongTien = Double.parseDouble(partsHD[4]);
                                if (pt != null && nvLap != null) 
                                {
                                    HoaDon hd = new HoaDon(partsHD[0], pt, nvLap, ngayLap, "Da thanh toan", tongTien);
                                    dsHoaDon.add(hd);
                                }
                            }
                            break;
                    }
            }
            System.out.println("Doc du lieu thanh cong!");
            hienThidsPhong();
            hienThidsNguoi();
            hienThidsPhieuThue();
            hienThidsHoaDon();
        } catch (IOException e) {
            System.out.println("Doc file loi o Phieu Thue va Hoa Don: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so o Phieu Thue va Hoa Don: " + e.getMessage());
        }
    }

    public void hienThidsPhong() 
    {
        System.out.println("\n---Danh sach phong (" + dsPhong.size() + " phong) ---");
        for (Phong p : dsPhong) {
            p.xuat();
            System.out.println("--------------------");
        }
    }

    public void hienThidsNguoi() 
    {
        System.out.println("\n---Danh sach nguoi (" + dsNguoi.size() + " nguoi) ---");
        for (Nguoi n : dsNguoi) 
        {
            if (n instanceof NhanVien) 
            {
                n.xuat();
            } 
            else 
                if (n instanceof KhachHang) 
                {
                    n.xuat();
                }
            System.out.println("--------------------");
        }
    }

    public void hienThidsPhieuThue() 
    {
        System.out.println("\n--- Danh sach phieu thue (" + dsPhieuThue.size() + " phieu) ---");
        for (PhieuThue pt : dsPhieuThue) 
        {
            pt.xuat();
        }
    }
    
    public void hienThidsHoaDon() 
    {
        System.out.println("\n--- Danh sach hoa don (" + dsHoaDon.size() + " hoa don) ---");
        for (HoaDon hd : dsHoaDon) 
        {
            hd.xuat();
        }
    }
}
