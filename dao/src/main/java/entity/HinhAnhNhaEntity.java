package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;

@Entity
@Table(name = "hinh_anh_nha")
public class HinhAnhNhaEntity {
    private long id;
    private Image hinhAnh;
    private NgoiNhaEntity ngoiNha;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "hinh_anh")
    @NotNull
    public Image getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(Image hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ngoi_nha_id", nullable = false)
    public NgoiNhaEntity getngoiNha() {
        return ngoiNha;
    }

    public void setngoiNha(NgoiNhaEntity ngoiNha) {
        this.ngoiNha = ngoiNha;
    }
}
