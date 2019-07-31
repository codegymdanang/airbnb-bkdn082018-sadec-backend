import Impl.ThuNhapThangSerViceImpl;
import entity.LichSuThueNhaEntity;
import entity.NguoiDungEntity;
import entity.ThongBaoEntity;
import entity.ThuNhapThangEntity;
import jpaRepository.ThuNhapThangRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import service.ThuNhapThangSerVice;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ThuNhapHangThangServiceTest {
    @Mock
    private ThuNhapThangRepository thuNhapThangRepository;

    @InjectMocks
    private ThuNhapThangSerViceImpl thuNhapThangSerVice;

    NguoiDungEntity nguoiDung = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");
    ThuNhapThangEntity thuNhap = new ThuNhapThangEntity(1001L, new Date(2019/02/16), nguoiDung, 12500000.0f);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        when(thuNhapThangRepository.save(thuNhap)).thenReturn(thuNhap);
        ThuNhapThangEntity testThuNhapThang = thuNhapThangSerVice.save(thuNhap);

        Assert.assertNotNull(testThuNhapThang.getId());
        Assert.assertThat(testThuNhapThang.getchuNha(), is(thuNhap.getchuNha()));
        Assert.assertThat(testThuNhapThang.getThoiGian(), is(thuNhap.getThoiGian()));
        Assert.assertThat(testThuNhapThang.getThuNhap(), is(thuNhap.getThuNhap()));

        Assert.assertNull(thuNhapThangSerVice.save(null));
    }

    @Test
    public void testFindAll(){
        List<ThuNhapThangEntity> list = new ArrayList<>();
        list.add(new ThuNhapThangEntity(1001L, new Date(2019/02/16), nguoiDung, 12500000.0f));
        list.add(new ThuNhapThangEntity(1002L, new Date(2019/07/11), nguoiDung, 30500000.0f));

        when(thuNhapThangRepository.findAll()).thenReturn(list);
        List<ThuNhapThangEntity> testThuNhapThang = thuNhapThangSerVice.findAll();

        Assert.assertEquals(testThuNhapThang.size(), 2);

    }

    @Test
    public void findAll_IfHaveNthing(){
        List<ThuNhapThangEntity> list = new ArrayList<>();
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void testFindById(){
        when(thuNhapThangRepository.save(thuNhap)).thenReturn(thuNhap);
        thuNhapThangSerVice.save(thuNhap);
        when(thuNhapThangRepository.findById(1001L)).thenReturn(Optional.of(thuNhap));
        ThuNhapThangEntity testThuNhap = thuNhapThangSerVice.findById(1001L);

        Assert.assertNotNull(testThuNhap.getId());
        Assert.assertThat(testThuNhap.getThuNhap(), is(thuNhap.getThuNhap()));
        Assert.assertThat(testThuNhap.getThoiGian(), is(thuNhap.getThoiGian()));
        Assert.assertThat(testThuNhap.getchuNha(), is(thuNhap.getchuNha()));
    }

    @Test
    public void testFindById_IfIdNull(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            thuNhapThangSerVice.findById(null);
        });
    }

    @Test
    public void testRemove(){
        when(thuNhapThangRepository.save(thuNhap)).thenReturn(thuNhap);
        thuNhapThangSerVice.save(thuNhap);
        thuNhapThangSerVice.remove(1001L);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            thuNhapThangSerVice.findById(1001L);
        });
    }
}
