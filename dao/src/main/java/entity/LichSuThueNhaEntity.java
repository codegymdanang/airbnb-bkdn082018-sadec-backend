package entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "lich_su_thue_nha")
public class LichSuThueNhaEntity {
    private long id;
    private NguoiDungEntity nguoiThue;
    private NgoiNhaEntity nhaDaThue;
    private Date ngayBatDauThue;
    private Date ngayKetThuc;
    private int tongNgayThue;
    private float tongChiPhi;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoi_thue_id", referencedColumnName = "id", nullable = false)
    public NguoiDungEntity getNguoiThue() {
        return nguoiThue;
    }

    public void setNguoiThue(NguoiDungEntity nguoiThue) {
        this.nguoiThue = nguoiThue;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nha_da_thue_id", referencedColumnName = "id", nullable = false)
    public NgoiNhaEntity getNhaDaThue() {
        return nhaDaThue;
    }

    public void setNhaDaThue(NgoiNhaEntity nhaDaThue) {
        this.nhaDaThue = nhaDaThue;
    }

    @Column(name = "ngay_bat_dau_thue", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy/MM/dd")
    @Past
    public Date getNgayBatDauThue() {
        return ngayBatDauThue;
    }

    public void setNgayBatDauThue(Date ngayBatDauThue) {
        this.ngayBatDauThue = ngayBatDauThue;
    }

    @Column(name = "ngay_ket_thuc", nullable = true)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy/MM/dd")
    @Past
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Column(name = "tong_ngay_thue", nullable = false)
    public int getTongNgayThue() {
        return tongNgayThue;
    }

    public void setTongNgayThue(int tongNgayThue) {
        this.tongNgayThue = tongNgayThue;
    }

    @Column(name = "tong_chi_phi", nullable = false)
    public float getTongChiPhi() {
        return tongChiPhi;
    }

    public void setTongChiPhi(float tongChiPhi) {
        this.tongChiPhi = tongChiPhi;
    }
}
