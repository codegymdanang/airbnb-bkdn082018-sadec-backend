package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @OneToOne(fetch = FetchType.LAZY)
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

    @Column(name = "noi_dung", nullable = false)
    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nhan_xet_id", referencedColumnName = "id", nullable = true)
    @JsonBackReference
    public NhanXetVaPhanHoiEntity getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(NhanXetVaPhanHoiEntity nhanXet) {
        this.nhanXet = nhanXet;
    }
}
