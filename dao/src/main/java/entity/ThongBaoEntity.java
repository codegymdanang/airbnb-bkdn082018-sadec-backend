package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "thong_bao")
public class ThongBaoEntity {
    private long id;
    private String noiDung;
    private boolean tinhTrang;
    private NguoiDungEntity nguoiDung;
    private NgoiNhaEntity ngoiNha;
    private NhanXetVaPhanHoiEntity nhanXet;
    private String url;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "noi_dung", nullable = false)
    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    @Column(name = "tinh_trang", nullable = false)
    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoi_dung_id", referencedColumnName = "id", nullable = false)
    public NguoiDungEntity getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDungEntity nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ngoi_nha_id", referencedColumnName = "id", nullable = false)
    public NgoiNhaEntity getNgoiNha() {
        return ngoiNha;
    }

    public void setNgoiNha(NgoiNhaEntity ngoiNha) {
        this.ngoiNha = ngoiNha;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nhan_xet_va_phan_hoi_id", referencedColumnName = "id", nullable = false)
    public NhanXetVaPhanHoiEntity getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(NhanXetVaPhanHoiEntity nhanXet) {
        this.nhanXet = nhanXet;
    }

    @Column(name = "url", nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ThongBaoEntity(long l, Date date, NguoiDungEntity nguoiDung, float v) {
    }

    public ThongBaoEntity(long id, String noiDung, boolean tinhTrang, NguoiDungEntity nguoiDung, NgoiNhaEntity ngoiNha, NhanXetVaPhanHoiEntity nhanXet, String url) {
        this.id = id;
        this.noiDung = noiDung;
        this.tinhTrang = tinhTrang;
        this.nguoiDung = nguoiDung;
        this.ngoiNha = ngoiNha;
        this.nhanXet = nhanXet;
        this.url = url;
    }
}
