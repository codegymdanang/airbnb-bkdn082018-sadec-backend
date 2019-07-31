import Impl.LichSuThueNhaServiceImpl;
import entity.LichSuThueNhaEntity;
import entity.NgoiNhaEntity;
import entity.NguoiDungEntity;
import jpaRepository.LichSuThueNhaRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LichSuThueNhaServiceTest {
    @Mock
    private LichSuThueNhaRepository lichSuThueNhaRepository;

    @InjectMocks
    private LichSuThueNhaServiceImpl lichSuThueNhaService;

    NguoiDungEntity chuNha = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");
    NguoiDungEntity nguoiThue = new NguoiDungEntity(1002L, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
    NgoiNhaEntity nhaDaThue = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);
    LichSuThueNhaEntity lichSuThueNha = new LichSuThueNhaEntity(1001L, nguoiThue, nhaDaThue, new Date(2019/05/13), new Date(2019/05/15), 2, 1250000);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        when(lichSuThueNhaRepository.save(lichSuThueNha)).thenReturn(lichSuThueNha);
        LichSuThueNhaEntity testLichSuThueNha = lichSuThueNhaService.save(lichSuThueNha);

        Assert.assertNotNull(testLichSuThueNha.getId());
        Assert.assertThat(testLichSuThueNha.getNguoiThue(), is(lichSuThueNha.getNguoiThue()));
        Assert.assertThat(testLichSuThueNha.getNhaDaThue(), is(lichSuThueNha.getNhaDaThue()));
        Assert.assertThat(testLichSuThueNha.getNgayBatDauThue(), is(lichSuThueNha.getNgayBatDauThue()));
        Assert.assertThat(testLichSuThueNha.getNgayKetThuc(), is(lichSuThueNha.getNgayKetThuc()));
        Assert.assertThat(testLichSuThueNha.getTongChiPhi(), is(lichSuThueNha.getTongChiPhi()));
        Assert.assertThat(testLichSuThueNha.getTongNgayThue(), is(lichSuThueNha.getTongNgayThue()));

        Assert.assertNull(lichSuThueNhaService.save(null));
    }

    @Test
    public void testFindAll(){
        List<LichSuThueNhaEntity> list = new ArrayList<>();
        list.add(new LichSuThueNhaEntity(1002L, nguoiThue, nhaDaThue, new Date(2019/06/16), new Date(2019/06/18), 2, 1250000));
        list.add(new LichSuThueNhaEntity(1003L, nguoiThue, nhaDaThue, new Date(2019/07/18), new Date(2019/07/20), 2, 1250000));
        list.add(new LichSuThueNhaEntity(1004L, nguoiThue, nhaDaThue, new Date(2019/01/10), new Date(2019/01/12), 2, 1250000));

        when(lichSuThueNhaRepository.findAll()).thenReturn(list);
        List<LichSuThueNhaEntity> testLichSuThueNha = lichSuThueNhaService.findAll();

        Assert.assertEquals(testLichSuThueNha.size(), 3);

    }

    @Test
    public void findAll_IfHaveNthing(){
        List<LichSuThueNhaEntity> list = new ArrayList<>();
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void testFindById(){
        when(lichSuThueNhaRepository.save(lichSuThueNha)).thenReturn(lichSuThueNha);
        lichSuThueNhaService.save(lichSuThueNha);
        when(lichSuThueNhaRepository.findById(1001L)).thenReturn(Optional.of(lichSuThueNha));
        LichSuThueNhaEntity testLichSuThueNha = lichSuThueNhaService.findById(1001L);

        Assert.assertNotNull(testLichSuThueNha.getId());
        Assert.assertThat(testLichSuThueNha.getNguoiThue(), is(lichSuThueNha.getNguoiThue()));
        Assert.assertThat(testLichSuThueNha.getNhaDaThue(), is(lichSuThueNha.getNhaDaThue()));
        Assert.assertThat(testLichSuThueNha.getNgayBatDauThue(), is(lichSuThueNha.getNgayBatDauThue()));
        Assert.assertThat(testLichSuThueNha.getNgayKetThuc(), is(lichSuThueNha.getNgayKetThuc()));
        Assert.assertThat(testLichSuThueNha.getTongChiPhi(), is(lichSuThueNha.getTongChiPhi()));
        Assert.assertThat(testLichSuThueNha.getTongNgayThue(), is(lichSuThueNha.getTongNgayThue()));
    }

    @Test
    public void testFindById_IfIdNull(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            lichSuThueNhaService.findById(null);
        });
    }

    @Test
    public void testRemove(){
        when(lichSuThueNhaRepository.save(lichSuThueNha)).thenReturn(lichSuThueNha);
        lichSuThueNhaService.save(lichSuThueNha);
        lichSuThueNhaService.remove(1001L);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            lichSuThueNhaService.findById(1001L);
        });
    }
}
