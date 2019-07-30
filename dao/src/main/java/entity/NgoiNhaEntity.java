package entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ngoi_nha")
@Document(indexName = "airbnb", type = "nha")
public class NgoiNhaEntity {
    private long id;
    private NguoiDungEntity chuNha;
    private String tenNha;
    private int soPhongNgu;
    private int soPhongTam;
    private String diaChi;
    private String loaiNha;
    private float giaTienTheoDem;
    private String moTaChung;
    private Set<DanhGiaEntity> danhGia = new HashSet<>();
    private boolean tinhTrang;
    private Set<HinhAnhNhaEntity> hinhAnhNha = new HashSet<>();
    private Set<NhanXetVaPhanHoiEntity> nhanXetVaPhanHoi = new HashSet<>();

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "chu_nha_id", referencedColumnName = "id", nullable = false)
    public NguoiDungEntity getChuNha() {
        return chuNha;
    }

    public void setChuNha(NguoiDungEntity chuNha) {
        this.chuNha = chuNha;
    }


    @Column(name = "ten_nha", nullable = false)
    public String getTenNha() {
        return tenNha;
    }

    public void setTenNha(String tenNha) {
        this.tenNha = tenNha;
    }

    @Column(name = "so_luong_phong_ngu", nullable = false)
    public int getSoPhongNgu() {
        return soPhongNgu;
    }

    public void setSoPhongNgu(int soPhongNgu) {
        this.soPhongNgu = soPhongNgu;
    }

    @Column(name = "so_luong_phong_tam", nullable = false)
    public int getSoPhongTam() {
        return soPhongTam;
    }

    public void setSoPhongTam(int soPhongTam) {
        this.soPhongTam = soPhongTam;
    }

    @Column(name = "dia_chi", nullable = false)
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Column(name = "loai_nha", nullable = false)
    public String getLoaiNha() {
        return loaiNha;
    }

    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }

    @Column(name = "gia_tien_theo_dem", nullable = false)
    public float getGiaTienTheoDem() {
        return giaTienTheoDem;
    }

    public void setGiaTienTheoDem(float giaTienTheoDem) {
        this.giaTienTheoDem = giaTienTheoDem;
    }

    @Column(name = "mo_ta_chung", nullable = false)
    public String getMoTaChung() {
        return moTaChung;
    }

    public void setMoTaChung(String moTaChung) {
        this.moTaChung = moTaChung;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ngoiNha")
    @JsonManagedReference(value = "danhGia")
    public Set<DanhGiaEntity> getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(Set<DanhGiaEntity> danhGia) {
        this.danhGia = danhGia;
    }

    @Column(name = "tinh_trang", nullable = false)
    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ngoiNha")
    @JsonManagedReference(value = "hinhAnh")
    public Set<HinhAnhNhaEntity> getHinhAnhNha() {
        return hinhAnhNha;
    }

    public void setHinhAnhNha(Set<HinhAnhNhaEntity> hinhAnhNha) {
        this.hinhAnhNha = hinhAnhNha;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ngoiNha")
    @JsonManagedReference(value = "nhanXetVaPhanHoi")
    public Set<NhanXetVaPhanHoiEntity> getNhanXetVaPhanHoi() {
        return nhanXetVaPhanHoi;
    }

    public void setNhanXetVaPhanHoi(Set<NhanXetVaPhanHoiEntity> nhanXetVaPhanHoi) {
        this.nhanXetVaPhanHoi = nhanXetVaPhanHoi;
    }
}
