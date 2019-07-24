package entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "thu_nhap_thang")
public class ThuNhapThangEntity {
    private long id;
    private Date thoiGian;
    private NguoiDungEntity chuNha;
    private float thuNhap;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "thoi_gian")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy/MM/dd")
    @NotNull
    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chu_nha_id", nullable = false)
    public NguoiDungEntity getchuNha() {
        return chuNha;
    }

    public void setchuNha(NguoiDungEntity chuNha) {
        this.chuNha = chuNha;
    }

    @Column(name = "thu_nhap")
    @NotNull
    public float getThuNhap() {
        return thuNhap;
    }

    public void setThuNhap(float thuNhap) {
        this.thuNhap = thuNhap;
    }
}
