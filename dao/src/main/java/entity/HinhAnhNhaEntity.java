package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.sql.Blob;

@Entity
@Table(name = "hinh_anh_nha")
public class HinhAnhNhaEntity {
    private long id;
    private byte[] hinhAnh;
    private NgoiNhaEntity ngoiNha;

    public HinhAnhNhaEntity() {}

    public HinhAnhNhaEntity(byte[] hinhAnh, NgoiNhaEntity ngoiNha) {
        this.hinhAnh = hinhAnh;
        this.ngoiNha = ngoiNha;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("hinhAnh")
    @Column(name = "hinh_anh", nullable = false)
    @Lob
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
