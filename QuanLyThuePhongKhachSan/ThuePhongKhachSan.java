import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import  java.util.Date;
import java.util.Scanner;
public class ThuePhongKhachSan 
{
    public static void main(String[] args) throws Exception
    {
        KhachSan_QuanLyThuePhong qlThuePhong=new KhachSan_QuanLyThuePhong();
        SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc=new Scanner(System.in);
        Date ngaySinhKH=d.parse("25/09/2000");
        KhachHang kh1 = new KhachHang("KH01","Nguyen Van A","0901234567", "Ha Noi" ,ngaySinhKH,"347347");
        KhachHang kh2 = new KhachHang("KH02","Nguyen Van B","0901234568", "Ha Noi" ,ngaySinhKH,"347347");
        qlThuePhong.themNguoi(kh1);
        qlThuePhong.themNguoi(kh2);
        Date ngaySinhNV=d.parse("18/08/1999");
        NhanVien nv1 = new NhanVien("NV01","Tran Thi B","0988888888","Ho Chi Minh",ngaySinhNV,"Thu Ngan",8000000,500000);
        qlThuePhong.themNguoi(nv1);
        NhanVien nv2 = new NhanVien("NV02","Nguyen Van D","0988888999","Da Nang",ngaySinhNV,"Thu Ngan",9000000,500000);
        qlThuePhong.themNguoi(nv2);
        Phong p1 = new Phong("P101","Phong don",500000,"Trong");
        qlThuePhong.themPhong(p1);
        Phong p2 = new Phong("P102","Phong doi",700000,"Trong");
        qlThuePhong.themPhong(p2);
        LocalDateTime ngayThue = LocalDateTime.of(2025, 1, 1, 12, 0);
        LocalDateTime ngayTraDuKien = LocalDateTime.of(2025, 1, 4, 12, 0);
        PhieuThue pt = qlThuePhong.thuePhong(kh1, p1, ngayThue, ngayTraDuKien);
        pt.xuat();
        HoaDon hd = qlThuePhong.traPhong(pt.getMaPhieuThue(), nv1);
        int chon;
        do
        {
            System.out.println("\n------Menu chuc nang-----");
            System.out.println("1.Them nguoi.");
            System.out.println("2.Them phong.");
            System.out.println("3.Thue phong.");
            System.out.println("4.Tra phong");
            System.out.println("5.Tim.");
            System.out.println("6.Xoa.");
            System.out.println("7.Sua");
            System.out.println("8.Tinh tong doanh thu.");
            System.out.println("9.Hien thi danh sach thong tin");
            System.out.println("10.Doc ghi file.");
            System.out.println("11.Thoat chuong trinh.");
            System.out.println("Moi nhap lua chon:");
            chon=Integer.parseInt(sc.nextLine());
            switch(chon){
                case 1: 
                {
                    char c='y';
                    Nguoi nguoi=null;
                    while (c=='y')
                    {
                        System.out.println("Nhap lua chon: 1.Nhap khach hang | 2.Nhap nhan vien");
                        char type=sc.nextLine().toUpperCase().charAt(0);
                        switch(type)
                        {
                            case '1':nguoi=new KhachHang();break;
                            case '2':nguoi=new NhanVien();break;
                            default:System.out.println("Nhap sai!");
                        }
                        if (nguoi!=null)
                        {
                            nguoi.nhap();
                            qlThuePhong.themNguoi(nguoi);
                        }
                        System.out.println("Nhap 'y' de tiep tuc hoac phim bat ky de thoat!");
                        c=sc.nextLine().toLowerCase().charAt(0);
                    }
                    break;
                }
                case 2: 
                {
                    String c;
                    do 
                    {
                        System.out.println("\n--- Nhap thong tin phong moi---");
                        Phong pMoi = new Phong();
                        pMoi.nhap();
                        qlThuePhong.themPhong(pMoi);
                        System.out.println("Ban co muon them phong khac khong? (Y/N)");
                        c = sc.nextLine();
                    } 
                    while (c.equalsIgnoreCase("Y"));
                    break;
                }
                case 3:
                {
                    String c;  
                    Phong phongCanThue = null; 
                    KhachHang khachHangThue = null;
                    do
                    {
                        System.out.println("\n--- THUC HIEN THUE PHONG ---");
                        do 
                        {
                            System.out.println("Nhap Ma phong muon thue:");
                            String maP = sc.nextLine();
                            phongCanThue = qlThuePhong.timPhong(maP);
                            if (phongCanThue == null) 
                            {
                                System.out.println("Loi: Khong tim thay ma phong '" + maP + "'. Vui long nhap lai.");
                            } 
                            else 
                                if (!phongCanThue.getTrangThai().equalsIgnoreCase("Trong")) 
                                {
                                    System.out.println("Loi: Phong '" + maP + "' hien tai da co khach thue.");
                                    phongCanThue = null; 
                                } 
                                else 
                                {
                                    System.out.println("Phong '" + maP + "' trong, co the thue duoc.");
                                }
                        } 
                        while (phongCanThue == null);
                        do {
                            System.out.println("Nhap Ma Khach hang thue:");
                            String maKH = sc.nextLine();
                            Nguoi n = qlThuePhong.timKhachHang(maKH);
                            khachHangThue = (KhachHang) (n instanceof KhachHang ? n : null); 
                            if (khachHangThue == null) 
                            {
                                System.out.println("Loi: Khong tim thay Khach hang voi ma '" + maKH + "'. Vui long nhap lai.");
                            } 
                            else 
                            {
                                System.out.println("Tim thay Khach hang: " + khachHangThue.getHoTen());
                            }
                        } while (khachHangThue == null);
                        PhieuThue pthue = new PhieuThue();
                        pthue.nhap(khachHangThue, phongCanThue); 
                        PhieuThue ptMoi = qlThuePhong.thuePhong(khachHangThue, phongCanThue, pthue.getNgayThue(), pthue.getNgayTraDuKien());
                        if (ptMoi != null) 
                        {
                            System.out.println("--- Chi tiet Phieu Thue Vua Tao ---");
                            ptMoi.xuat();
                        }
                        System.out.println("Ban co muon thue phong khac khong? (Y/N)");
                        c = sc.nextLine();
                    } while (c.equalsIgnoreCase("Y"));
                    break;
                }
                case 4:
                {
                    String c;
                    do
                    {
                        System.out.println("\n--- THUC HIEN TRA PHONG ---");
                        NhanVien nv=null;
                        do 
                        {
                                System.out.println("Nhap nhan vien xu ly:");
                                String maNV = sc.nextLine();
                                for (Nguoi n : qlThuePhong.dsNguoi) 
                                {
                                    if (n instanceof NhanVien) 
                                    {
                                        if (n.getma().equalsIgnoreCase(maNV)) 
                                        {
                                            nv=(NhanVien) n;
                                            break;
                                        }
                                    }
                                }
                                if (nv != null) {
                                    System.out.println("Nhan vien " +nv.getHoTen() + " dang xu ly hoa don!");
                                } else {
                                    System.out.println("Khong ton tai nhan vien voi ma " + maNV + ". Vui long kiem tra lai!");
                                }
                        } 
                        while (nv == null);
                        System.out.println("Nhap ma phieu thue can tra:");
                        String maPT = sc.nextLine();
                        qlThuePhong.traPhong(maPT, nv);
                        System.out.println("Ban co muon tra phong khac khong? (Y/N)");
                        c = sc.nextLine();
                    } 
                    while (c.equalsIgnoreCase("Y"));
                    break;
                }
                case 5:
                {
                    int chon1;
                    do 
                    {
                        System.out.println("\n========== MENU TIM KIEM ==========");
                        System.out.println("1. Tim Khach Hang");
                        System.out.println("2. Tim Phong");
                        System.out.println("3. Tim Phieu Thue");
                        System.out.println("4. Tim Hoa Don");
                        System.out.println("5. Tim nhan vien");
                        System.out.println("0. Thoat");
                        System.out.print("Nhap lua chon: ");
                        chon1 = Integer.parseInt(sc.nextLine());
                        switch (chon1) 
                        {
                            case 1:
                                String c1;
                                do 
                                {
                                    System.out.println("Nhap ma khach hang:");
                                    String maKH = sc.nextLine();
                                    KhachHang kh = qlThuePhong.timKhachHang(maKH);
                                    if (kh == null) 
                                    {
                                        System.out.println("Khong tim thay khach hang voi ma '" + maKH + "'");
                                    } 
                                    else 
                                    {
                                        System.out.println("Tim thay khach hang:");
                                        kh.xuat();
                                    }
                                    System.out.println("Ban co muon tim khach hang khac khong? (Y/N)");
                                    c1 = sc.nextLine();
                                } 
                                while (c1.equalsIgnoreCase("Y"));
                                break;
                            case 2:
                                String c2;
                                do 
                                {
                                    System.out.println("Nhap ma phong:");
                                    String maPhong = sc.nextLine();
                                    Phong p = qlThuePhong.timPhong(maPhong);
                                    if (p == null) 
                                    {
                                        System.out.println("Khong tim thay phong voi ma '" + maPhong + "'");
                                    } 
                                    else 
                                    {
                                        System.out.println("Tim thay phong:");
                                        p.xuat();
                                    }
                                    System.out.println("Ban co muon tim phong khac khong? (Y/N)");
                                    c2 = sc.nextLine();
                                } 
                                while (c2.equalsIgnoreCase("Y"));
                                break;
                            case 3:
                                String c3;
                                do 
                                {
                                    System.out.println("Nhap ma phieu thue:");
                                    String maPT = sc.nextLine();
                                    PhieuThue pt1 = qlThuePhong.timPhieuThue(maPT);
                                    if (pt1 == null) 
                                    {
                                        System.out.println("Khong tim thay phieu thue voi ma '" + maPT + "'");
                                    } 
                                    else 
                                    {
                                        System.out.println("Tim thay phieu thue:");
                                        pt1.xuat();
                                    }
                                    System.out.println("Ban co muon tim phieu thue khac khong? (Y/N)");
                                    c3 = sc.nextLine();
                                } 
                                while (c3.equalsIgnoreCase("Y"));
                                break;
                            case 4:
                                String c4;
                                do 
                                {
                                    System.out.println("Nhap ma hoa don:");
                                    String maHD = sc.nextLine();
                                    HoaDon hd1 = qlThuePhong.timHoaDon(maHD);
                                    if (hd1 == null) 
                                    {
                                        System.out.println("Khong tim thay hoa don voi ma '" + maHD + "'");
                                    } 
                                    else 
                                    {
                                        System.out.println("Tim thay hoa don:");
                                        hd1.xuat();
                                    }

                                    System.out.println("Ban co muon tim hoa don khac khong? (Y/N)");
                                    c4 = sc.nextLine();
                                } 
                                while (c4.equalsIgnoreCase("Y"));
                                break;
                            case 5:
                                String c5;
                                do 
                                {
                                    System.out.println("Nhap ma nhan vien:");
                                    String maNV = sc.nextLine();
                                    NhanVien nv = qlThuePhong.timNhanVien(maNV);
                                    if (nv == null) 
                                    {
                                        System.out.println("Khong tim thay nhan vien voi ma '" + maNV + "'");
                                    } 
                                    else 
                                    {
                                        System.out.println("Tim thay nhan vien:");
                                        nv.xuat();
                                    }
                                    System.out.println("Ban co muon tim nhan vien khac khong? (Y/N)");
                                    c5 = sc.nextLine();
                                } 
                                while (c5.equalsIgnoreCase("Y"));
                                break;
                            case 0:
                                System.out.println("Thoat Menu Tim Kiem!");
                                break;

                            default:
                                System.out.println("Lua chon khong hop le!");
                        }
                    } 
                    while (chon1 != 0);
                    break;
                }
                case 6:
                {
                    int chon2;
                    do 
                    {
                        System.out.println("\n========== MENU XOA ==========");
                        System.out.println("1. Xoa Khach Hang");
                        System.out.println("2. Xoa Phong");
                        System.out.println("3. Xoa Phieu Thue");
                        System.out.println("4. Xoa Nhan Vien");
                        System.out.println("0. Thoat");
                        System.out.print("Nhap lua chon: ");
                        chon2 = Integer.parseInt(sc.nextLine());
                        switch (chon2) 
                        {
                            case 1:
                                String c1;
                                do 
                                {
                                    System.out.println("Nhap ma khach hang can xoa:");
                                    String maKH = sc.nextLine();
                                    qlThuePhong.xoaKhachHang(maKH);
                                    System.out.println("Ban co muon xoa khach hang khac khong? (Y/N)");
                                    c1 = sc.nextLine();
                                } 
                                while (c1.equalsIgnoreCase("Y"));
                                break;
                            case 2:
                                String c2;
                                do 
                                {
                                    System.out.println("Nhap ma phong can xoa:");
                                    String maPhong = sc.nextLine();
                                    qlThuePhong.xoaPhong(maPhong);
                                    System.out.println("Ban co muon xoa phong khac khong? (Y/N)");
                                    c2 = sc.nextLine();
                                } 
                                while (c2.equalsIgnoreCase("Y"));
                                break;
                            case 3:  
                                String c3;
                                do 
                                {
                                    System.out.println("Nhap ma phieu thue can xoa:");
                                    String maPT = sc.nextLine();
                                    qlThuePhong.xoaPhieuThue(maPT);
                                    System.out.println("Ban co muon xoa phieu thue khac khong? (Y/N)");
                                    c3 = sc.nextLine();
                                } 
                                while (c3.equalsIgnoreCase("Y"));
                                break;
                            case 4:
                                String c4;
                                do 
                                {
                                    System.out.println("Nhap ma nhan vien can xoa:");
                                    String maNV = sc.nextLine();
                                    qlThuePhong.xoaNhanVien(maNV);
                                    System.out.println("Ban co muon xoa nhan vien khac khong? (Y/N)");
                                    c4 = sc.nextLine();
                                } 
                                while (c4.equalsIgnoreCase("Y"));
                                break;
                            case 0:
                                System.out.println("Thoat Menu Xoa!");
                                break;

                            default:
                                System.out.println("Lua chon khong hop le!");
                        }
                    } 
                    while (chon2 != 0);
                    break;
                }
                case 7:
                {
                    int chon3;
                    do 
                    {
                        System.out.println("\n========== MENU SUA ==========");
                        System.out.println("1. Sua Khach Hang");
                        System.out.println("2. Sua Nhan Vien");
                        System.out.println("3. Sua Phong");
                        System.out.println("0. Thoat");
                        System.out.print("Nhap lua chon: ");
                        chon3 = Integer.parseInt(sc.nextLine());
                        switch (chon3) 
                        {
                            case 1:
                                String c1;
                                do 
                                {
                                    System.out.println("Nhap ma khach hang can sua:");
                                    String maKH = sc.nextLine();
                                    boolean suaKhachHang=qlThuePhong.suaKhachHang(maKH);
                                    if (suaKhachHang==true)
                                    {
                                        System.out.println("Cap nhat thong tin khach hang thanh cong!");
                                    }
                                    else
                                    {
                                        System.out.println("Khong tim thay khach hang de cap nhat!");
                                    }
                                    System.out.println("Ban co muon sua khach hang khac khong? (Y/N)");
                                    c1 = sc.nextLine();
                                } 
                                while (c1.equalsIgnoreCase("Y"));
                                break;
                            case 2:
                                String c2;
                                do 
                                {
                                    System.out.println("Nhap ma nhan vien can sua:");
                                    String maNhanVien = sc.nextLine();
                                    boolean suaNhanVien=qlThuePhong.suaNhanVien(maNhanVien);
                                    if (suaNhanVien==true)
                                    {
                                        System.out.println("Cap nhat thong tin nhan vien thanh cong!");
                                    }
                                    else
                                    {
                                        System.out.println("Khong tim thay nhan vien de cap nhat!");
                                    }
                                    System.out.println("Ban co muon sua nhan vien khac khong? (Y/N)");
                                    c2 = sc.nextLine();
                                } 
                                while (c2.equalsIgnoreCase("Y"));
                                break;
                            case 3:  
                                String c3;
                                do 
                                {
                                    System.out.println("Nhap ma phong can sua:");
                                    String maPhong = sc.nextLine();
                                    boolean suaPhong=qlThuePhong.suaPhong(maPhong);
                                    if (suaPhong==true)
                                    {
                                        System.out.println("Cap nhat thong tin phong thanh cong!");
                                    }
                                    else
                                    {
                                        System.out.println("Khong tim thay phong de cap nhat!");
                                    }
                                    System.out.println("Ban co muon sua phong khac khong? (Y/N)");
                                    c3 = sc.nextLine();
                                } 
                                while (c3.equalsIgnoreCase("Y"));
                                break;
                            case 0:
                                System.out.println("Thoat Menu Xoa!");
                                break;

                            default:
                                System.out.println("Lua chon khong hop le!");
                        }
                    } 
                    while (chon3 != 0);
                    break;
                }
                case 8:
                {
                    double tongdoanhthu=qlThuePhong.tinhTongDoanhThu();
                    System.out.println("\nTong doanh thu la: "+tongdoanhthu);
                    break;
                }
                case 9:
                {
                    int c;
                    do
                    {
                        System.out.println("1: Hien thi danh sach nguoi.\n2. Hien thi danh sach phong.\n3. Hien thi danh sach phieu thue.\n4. Hien thi danh sach hoa don\n0.Thoat.");
                        System.out.println("Nhap lua chon:");
                        c=Integer.parseInt(sc.nextLine());
                        switch(c)
                        {
                            case 1:qlThuePhong.hienThidsNguoi();break;
                            case 2:qlThuePhong.hienThidsPhong();break;
                            case 3:qlThuePhong.hienThidsPhieuThue();break;
                            case 4:qlThuePhong.hienThidsHoaDon();break;
                        }
                    }
                    while(c!=0);
                    break;
                }
                case 10:
                {
                    int c;
                    do
                    {
                        System.out.println("\n--- DOC GHI FILE ---");
                        System.out.println("1. Ghi du lieu xuong file.");
                        System.out.println("2. Doc du lieu tu file.");
                        System.out.println("0. Quay lai Menu chinh.");
                        System.out.println("Nhap lua chon:");     
                        try 
                        {
                            c = Integer.parseInt(sc.nextLine().trim());
                        } 
                        catch (NumberFormatException e) 
                        {
                            System.out.println("Loi: Vui long nhap so nguyen.");
                            c = -1;
                            continue;
                        }
                        switch(c)
                        {
                            case 1:
                                qlThuePhong.WriteData();
                                break;
                            case 2:
                                qlThuePhong.ReadData();
                                break;
                            case 0:
                                System.out.println("Quay lai Menu chinh.");
                                break;
                            default:
                                System.out.println("Nhap sai, vui long nhap lai!");
                        }
                    }
                    while(c!=0);
                    break;
                }
                default:System.out.println("Nhap sai nhap lai!");
                break;
        }
    } while(chon!=11);
}
}
