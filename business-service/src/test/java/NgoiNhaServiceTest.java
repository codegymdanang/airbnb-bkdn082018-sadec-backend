import Impl.NgoiNhaServiceImpl;
import elasticsearchRepository.NgoiNhaESRepository;
import entity.NgoiNhaEntity;
import entity.NguoiDungEntity;
import jpaRepository.NgoiNhaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NgoiNhaServiceTest {
    @Mock
    private NgoiNhaESRepository ngoiNhaESRepository;

    @Mock
    private NgoiNhaRepository ngoiNhaRepository;

    @InjectMocks
    private NgoiNhaServiceImpl ngoiNhaService;

    NguoiDungEntity chuNha = new NguoiDungEntity(1002L, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
    NgoiNhaEntity ngoiNha = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        when(ngoiNhaRepository.save(ngoiNha)).thenReturn(ngoiNha);
        when(ngoiNhaESRepository.save(ngoiNha)).thenReturn(ngoiNha);

        NgoiNhaEntity testNha = ngoiNhaService.save(ngoiNha);

        Assert.assertNotNull(testNha.getId());
        Assert.assertThat(testNha.getChuNha(), is(ngoiNha.getChuNha()));
        Assert.assertThat(testNha.getDanhGia(), is(ngoiNha.getDanhGia()));
        Assert.assertThat(testNha.getDiaChi(), is(ngoiNha.getDiaChi()));
        Assert.assertThat(testNha.getGiaTienTheoDem(), is(ngoiNha.getGiaTienTheoDem()));
        Assert.assertThat(testNha.getHinhAnhNha(), is(ngoiNha.getHinhAnhNha()));
        Assert.assertThat(testNha.getLoaiNha(), is(ngoiNha.getLoaiNha()));
        Assert.assertThat(testNha.getMoTaChung(), is(ngoiNha.getMoTaChung()));
        Assert.assertThat(testNha.getNhanXetVaPhanHoi(), is(ngoiNha.getNhanXetVaPhanHoi()));
        Assert.assertThat(testNha.getSoPhongNgu(), is(ngoiNha.getSoPhongNgu()));
        Assert.assertThat(testNha.getSoPhongTam(), is(ngoiNha.getSoPhongTam()));
        Assert.assertThat(testNha.getTenNha(), is(ngoiNha.getTenNha()));

        Assert.assertNull(ngoiNhaService.save(null));
    }

    @Test
    public void testfindAll(){
        List<NgoiNhaEntity> list = new ArrayList<>();
        list.add(new NgoiNhaEntity(1002L, chuNha, "Chaaya", 2, 1, "Hue", "Nha cap 4", 120000, "Day du tien nghi", true));
        list.add(new NgoiNhaEntity(1003L, chuNha, "Chahna", 3, 2, "Ha Noi", "Nha cap 3", 300000, "Day du tien nghi", true));

        when(ngoiNhaESRepository.findAll()).thenReturn(list);
        List<NgoiNhaEntity> testNgoiNha = ngoiNhaService.findAll();

        Assert.assertThat(testNgoiNha.size(), is(2));
    }

    @Test
    public void testFindAll_IfHaveNothing(){
        List<NgoiNhaEntity> list = new ArrayList<>();
        Assert.assertThat(ngoiNhaService.findAll().size(), is(0));
    }

    @Test
    public void testFindById(){
        when(ngoiNhaRepository.save(ngoiNha)).thenReturn(ngoiNha);
        when(ngoiNhaESRepository.save(ngoiNha)).thenReturn(ngoiNha);
        ngoiNhaService.save(ngoiNha);
        when(ngoiNhaESRepository.findById(1001L)).thenReturn(Optional.of(ngoiNha));

        NgoiNhaEntity testNha = ngoiNhaService.findById(1001L);

        Assert.assertNotNull(testNha.getId());
        Assert.assertThat(testNha.getChuNha(), is(ngoiNha.getChuNha()));
        Assert.assertThat(testNha.getDanhGia(), is(ngoiNha.getDanhGia()));
        Assert.assertThat(testNha.getDiaChi(), is(ngoiNha.getDiaChi()));
        Assert.assertThat(testNha.getGiaTienTheoDem(), is(ngoiNha.getGiaTienTheoDem()));
        Assert.assertThat(testNha.getHinhAnhNha(), is(ngoiNha.getHinhAnhNha()));
        Assert.assertThat(testNha.getLoaiNha(), is(ngoiNha.getLoaiNha()));
        Assert.assertThat(testNha.getMoTaChung(), is(ngoiNha.getMoTaChung()));
        Assert.assertThat(testNha.getNhanXetVaPhanHoi(), is(ngoiNha.getNhanXetVaPhanHoi()));
        Assert.assertThat(testNha.getSoPhongNgu(), is(ngoiNha.getSoPhongNgu()));
        Assert.assertThat(testNha.getSoPhongTam(), is(ngoiNha.getSoPhongTam()));
        Assert.assertThat(testNha.getTenNha(), is(ngoiNha.getTenNha()));
    }

    @Test
    public void testFindById_IfIdNull(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            ngoiNhaService.findById(null);
        });
    }

    @Test
    public void testRemove(){
        when(ngoiNhaESRepository.save(ngoiNha)).thenReturn(ngoiNha);
        when(ngoiNhaRepository.save(ngoiNha)).thenReturn(ngoiNha);
        ngoiNhaService.save(ngoiNha);
        ngoiNhaService.remove(1001L);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            ngoiNhaService.findById(1001L);
        });
    }

    @Test
    public void testFindBySoPhongNgu(){
        List<NgoiNhaEntity> list = new ArrayList<>();
        list.add(new NgoiNhaEntity(1002L, chuNha, "Chaaya", 2, 1, "Hue", "Nha cap 4", 120000, "Day du tien nghi", true));
        list.add(new NgoiNhaEntity(1003L, chuNha, "Chahna", 2, 2, "Ha Noi", "Nha cap 3", 300000, "Day du tien nghi", true));

        when(ngoiNhaESRepository.findBySoPhongNgu(2)).thenReturn(list);
        List<NgoiNhaEntity> testNha = ngoiNhaService.findBySoPhongNgu(2);

        Assert.assertThat(testNha.size(), is(2));
    }

    @Test
    public void testFindBySoPhongTam(){
        List<NgoiNhaEntity> list = new ArrayList<>();
        list.add(new NgoiNhaEntity(1002L, chuNha, "Chaaya", 5, 2, "Hue", "Nha cap 4", 120000, "Day du tien nghi", true));
        list.add(new NgoiNhaEntity(1003L, chuNha, "Chahna", 3, 2, "Ha Noi", "Nha cap 3", 300000, "Day du tien nghi", true));

        when(ngoiNhaESRepository.findBySoPhongTam(2)).thenReturn(list);
        List<NgoiNhaEntity> testNha = ngoiNhaService.findBySoPhongTam(2);

        Assert.assertThat(testNha.size(), is(2));
    }

    @Test
    public void testFindByDiaChi(){
        List<NgoiNhaEntity> list = new ArrayList<>();
        list.add(new NgoiNhaEntity(1002L, chuNha, "Chaaya", 5, 3, "Hue", "Nha cap 4", 120000, "Day du tien nghi", true));
        list.add(new NgoiNhaEntity(1003L, chuNha, "Chahna", 3, 2, "Hue", "Nha cap 3", 300000, "Day du tien nghi", true));

        when(ngoiNhaESRepository.findByDiaChi("Hue")).thenReturn(list);
        List<NgoiNhaEntity> testNha = ngoiNhaService.findByDiaChi("Hue");

        Assert.assertThat(testNha.size(), is(2));
    }

    @Test
    public void testFindByGiaTienTheoDem(){
        List<NgoiNhaEntity> list = new ArrayList<>();
        list.add(new NgoiNhaEntity(1002L, chuNha, "Chaaya", 5, 3, "Hue", "Nha cap 4", 120000, "Day du tien nghi", true));
        list.add(new NgoiNhaEntity(1003L, chuNha, "Chahna", 3, 2, "Da Nang", "Nha cap 3", 300000, "Day du tien nghi", true));

        when(ngoiNhaESRepository.findByGiaTienTheoDemBetween(100000, 310000)).thenReturn(list);
        List<NgoiNhaEntity> testNha = ngoiNhaService.findByGiaTienTheoDemBetween(100000, 310000);

        Assert.assertThat(testNha.size(), is(2));
    }

}
