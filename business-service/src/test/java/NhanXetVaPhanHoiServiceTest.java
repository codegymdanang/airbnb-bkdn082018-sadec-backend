import Impl.NhanXetVaPhanHoiServiceImpl;
import entity.LichSuThueNhaEntity;
import entity.NgoiNhaEntity;
import entity.NguoiDungEntity;
import entity.NhanXetVaPhanHoiEntity;
import jpaRepository.NhanXetVaPhanHoiRepository;
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
public class NhanXetVaPhanHoiServiceTest {
    @Mock
    private NhanXetVaPhanHoiRepository nhanXetVaPhanHoiRepository;

    @InjectMocks
    private NhanXetVaPhanHoiServiceImpl nhanXetVaPhanHoiService;

    NguoiDungEntity chuNha = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");
    NguoiDungEntity nguoiDung = new NguoiDungEntity(1002L, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
    NgoiNhaEntity ngoiNha = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);
    NhanXetVaPhanHoiEntity nhanXetVaPhanHoi = new NhanXetVaPhanHoiEntity(1001L, nguoiDung, ngoiNha, "comment", null);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        when(nhanXetVaPhanHoiRepository.save(nhanXetVaPhanHoi)).thenReturn(nhanXetVaPhanHoi);
        NhanXetVaPhanHoiEntity testnhanXetVaPhanHoi = nhanXetVaPhanHoiService.save(nhanXetVaPhanHoi);

        Assert.assertNotNull(testnhanXetVaPhanHoi.getId());
        Assert.assertThat(testnhanXetVaPhanHoi.getNgoiNha(), is(nhanXetVaPhanHoi.getNgoiNha()));
        Assert.assertThat(testnhanXetVaPhanHoi.getNguoiDung(), is(nhanXetVaPhanHoi.getNguoiDung()));
        Assert.assertThat(testnhanXetVaPhanHoi.getNhanXet(), is(nhanXetVaPhanHoi.getNhanXet()));
        Assert.assertThat(testnhanXetVaPhanHoi.getNoiDung(), is(nhanXetVaPhanHoi.getNoiDung()));

        Assert.assertNull(nhanXetVaPhanHoiService.save(null));
    }

    @Test
    public void testFindAll(){
        List<NhanXetVaPhanHoiEntity> list = new ArrayList<>();
        list.add(new NhanXetVaPhanHoiEntity(1002L, nguoiDung, ngoiNha, "comment_1", null));
        list.add(new NhanXetVaPhanHoiEntity(1003L, nguoiDung, ngoiNha, "comment_2", null));

        when(nhanXetVaPhanHoiRepository.findAll()).thenReturn(list);
        List<NhanXetVaPhanHoiEntity> testNhanXetVaPhanHoi = nhanXetVaPhanHoiService.findAll();

        Assert.assertEquals(testNhanXetVaPhanHoi.size(), 2);

    }

    @Test
    public void findAll_IfHaveNthing(){
        List<NhanXetVaPhanHoiEntity> list = new ArrayList<>();
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void testFindById() {
        when(nhanXetVaPhanHoiRepository.save(nhanXetVaPhanHoi)).thenReturn(nhanXetVaPhanHoi);
        nhanXetVaPhanHoiService.save(nhanXetVaPhanHoi);
        when(nhanXetVaPhanHoiRepository.findById(1001L)).thenReturn(Optional.of(nhanXetVaPhanHoi));
        NhanXetVaPhanHoiEntity testnhanXetVaPhanHoi = nhanXetVaPhanHoiService.findById(1001L);

        Assert.assertNotNull(testnhanXetVaPhanHoi.getId());
        Assert.assertThat(testnhanXetVaPhanHoi.getNoiDung(), is(nhanXetVaPhanHoi.getNoiDung()));
        Assert.assertThat(testnhanXetVaPhanHoi.getNhanXet(), is(nhanXetVaPhanHoi.getNhanXet()));
        Assert.assertThat(testnhanXetVaPhanHoi.getNguoiDung(), is(nhanXetVaPhanHoi.getNguoiDung()));
        Assert.assertThat(testnhanXetVaPhanHoi.getNgoiNha(), is(nhanXetVaPhanHoi.getNgoiNha()));
    }

    @Test
    public void testFindById_IfIdNull(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            nhanXetVaPhanHoiService.findById(null);
        });
    }

    @Test
    public void testRemove(){
        when(nhanXetVaPhanHoiRepository.save(nhanXetVaPhanHoi)).thenReturn(nhanXetVaPhanHoi);
        nhanXetVaPhanHoiService.save(nhanXetVaPhanHoi);
        nhanXetVaPhanHoiService.remove(1001L);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            nhanXetVaPhanHoiService.findById(1001L);
        });
    }
}
