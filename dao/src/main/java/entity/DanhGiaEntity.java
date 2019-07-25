package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "danh_gia")
public class DanhGiaEntity {
    private long id;
    private NguoiDungEntity nguoiDanhGia;
    private NgoiNhaEntity ngoiNha;
    private int suDanhGia;

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
    @JoinColumn(name = "nguoi_danh_gia_id", referencedColumnName = "id", nullable = false)
    public NguoiDungEntity getNguoiDanhGia() {
        return nguoiDanhGia;
    }

    public void setNguoiDanhGia(NguoiDungEntity nguoiDanhGia) {
        this.nguoiDanhGia = nguoiDanhGia;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ngoi_nha_id", referencedColumnName = "id", nullable = false)
    public NgoiNhaEntity getNgoiNha() {
        return ngoiNha;
    }

    public void setNgoiNha(NgoiNhaEntity ngoiNha) {
        this.ngoiNha = ngoiNha;
    }

    @Column(name = "su_danh_gia", nullable = false)
    public int getSuDanhGia() {
        return suDanhGia;
    }

    public void setSuDanhGia(int suDanhGia) {
        this.suDanhGia = suDanhGia;
    }
}
