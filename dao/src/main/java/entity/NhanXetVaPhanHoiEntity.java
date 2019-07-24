package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "nhan_xet_va_phan_hoi")
public class NhanXetVaPhanHoiEntity {
    private long id;
    private NguoiDungEntity nguoiDung;
    private NgoiNhaEntity ngoiNha;
    private String noiDung;
    private NhanXetVaPhanHoiEntity nhanXet;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "nguoi_dung_id")
    @NotNull
    public NguoiDungEntity getNguoiDung() {
        return nguoiDung;
    }

    public void setNguoiDung(NguoiDungEntity nguoiDung) {
        this.nguoiDung = nguoiDung;
    }

    @Column(name = "ngoi_nha_id")
    @NotNull
    public NgoiNhaEntity getNgoiNha() {
        return ngoiNha;
    }

    public void setNgoiNha(NgoiNhaEntity ngoiNha) {
        this.ngoiNha = ngoiNha;
    }

    @Column(name = "noi_dung")
    @NotNull
    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    @Column(name = "nhan_xet")
    @Null
    public NhanXetVaPhanHoiEntity getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(NhanXetVaPhanHoiEntity nhanXet) {
        this.nhanXet = nhanXet;
    }
}
