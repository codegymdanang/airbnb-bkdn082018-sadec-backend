package entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "nguoi_dung")
public class NguoiDungEntity {
    private long id;
    private String tenNguoiDung;
    private String matKhau;
    private String hoTen;
    private String soDienThoai;
    private String email;
    private String diaChi;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "ten_nguoi_dung")
    @NotBlank
    @Size(min = 3)
    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    @Column(name = "mat_khau")
    @NotBlank
    @Size(min = 8)
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Column(name = "ho_ten", nullable = false)
    @Size(min = 3, max = 15)
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Column(name = "so_dien_thoai")
    @NotBlank
    @Pattern(regexp = "^0[0-9]{9}")
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Column(name = "email")
    @NotBlank
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "dia_chi")
    @NotBlank
    @Pattern(regexp = "[\\\\w,]{2,}\\\\w")
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

}