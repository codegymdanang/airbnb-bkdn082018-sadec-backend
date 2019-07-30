package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;

@Entity
@Table(name = "hinh_anh_nha")
public class HinhAnhNhaEntity {
    private long id;
    private byte[] hinhAnh;
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

    @Column(name = "hinh_anh", nullable = false)
    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ngoi_nha_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference(value = "hinhAnh")
    public NgoiNhaEntity getngoiNha() {
        return ngoiNha;
    }

    public void setngoiNha(NgoiNhaEntity ngoiNha) {
        this.ngoiNha = ngoiNha;
    }
}
