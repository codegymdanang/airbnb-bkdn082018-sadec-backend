package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Column(name = "noi_dung")
    @NotNull
    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    @Column(name = "tinh_trang")
    @NotNull
    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoi_dung_id", nullable = false)
    public NguoiDungEntity getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDungEntity nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ngoi_nha_id", nullable = false)
    public NgoiNhaEntity getNgoiNha() {
        return ngoiNha;
    }

    public void setNgoiNha(NgoiNhaEntity ngoiNha) {
        this.ngoiNha = ngoiNha;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nhan_xet_va_phan_hoi_id", nullable = false)
    public NhanXetVaPhanHoiEntity getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(NhanXetVaPhanHoiEntity nhanXet) {
        this.nhanXet = nhanXet;
    }

    @Column(name = "url")
    @NotNull
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
