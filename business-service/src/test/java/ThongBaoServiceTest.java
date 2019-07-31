import Impl.ThongBaoServiceImpl;
import entity.*;
import jpaRepository.ThongBaoRepository;
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
public class ThongBaoServiceTest {
    @Mock
    private ThongBaoRepository thongBaoRepository;

    @InjectMocks
    private ThongBaoServiceImpl thongBaoService;

    NguoiDungEntity chuNha = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");
    NguoiDungEntity nguoiDung = new NguoiDungEntity(1002L, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
    NgoiNhaEntity ngoiNha = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);
    NhanXetVaPhanHoiEntity nhanXetVaPhanHoi = new NhanXetVaPhanHoiEntity(1001L, nguoiDung, ngoiNha, "comment", null);
    ThongBaoEntity thongBao = new ThongBaoEntity(1001L, "Notifications", true, nguoiDung, ngoiNha, nhanXetVaPhanHoi, "no_url");

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        when(thongBaoRepository.save(thongBao)).thenReturn(thongBao);
        ThongBaoEntity testThongBao = thongBaoService.save(thongBao);

        Assert.assertNotNull(testThongBao.getId());
        Assert.assertThat(testThongBao.getNgoiNha(), is(thongBao.getNgoiNha()));
        Assert.assertThat(testThongBao.getNguoiDung(), is(thongBao.getNguoiDung()));
        Assert.assertThat(testThongBao.getNhanXet(), is(thongBao.getNhanXet()));
        Assert.assertThat(testThongBao.getNoiDung(), is(thongBao.getNoiDung()));
        Assert.assertThat(testThongBao.getUrl(), is(thongBao.getUrl()));

        Assert.assertNull(thongBaoService.save(null));
    }

    @Test
    public void testFindAll(){
        List<ThongBaoEntity> list = new ArrayList<>();
        list.add(new ThongBaoEntity(1001L, "Notifications_1", true, nguoiDung, ngoiNha, nhanXetVaPhanHoi, "no_url"));
        list.add(new ThongBaoEntity(1002L, "Notifications_2", true, nguoiDung, ngoiNha, nhanXetVaPhanHoi, "no_url"));

        when(thongBaoRepository.findAll()).thenReturn(list);
        List<ThongBaoEntity> testLichSuThueNha = thongBaoService.findAll();

        Assert.assertEquals(thongBaoService.findAll().size(), 2);

    }

    @Test
    public void findAll_IfHaveNthing(){
        List<ThongBaoEntity> list = new ArrayList<>();
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void testFindById(){
        when(thongBaoRepository.save(thongBao)).thenReturn(thongBao);
        thongBaoService.save(thongBao);
        when(thongBaoRepository.findById(1001L)).thenReturn(Optional.of(thongBao));
        ThongBaoEntity testThongBao = thongBaoService.findById(1001L);

        Assert.assertNotNull(testThongBao.getId());
        Assert.assertThat(testThongBao.getUrl(), is(thongBao.getUrl()));
        Assert.assertThat(testThongBao.getNoiDung(), is(thongBao.getNoiDung()));
        Assert.assertThat(testThongBao.getNhanXet(), is(thongBao.getNhanXet()));
        Assert.assertThat(testThongBao.getNguoiDung(), is(thongBao.getNguoiDung()));
        Assert.assertThat(testThongBao.getNgoiNha(), is(thongBao.getNgoiNha()));
    }

    @Test
    public void testFindById_IfIdNull(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            thongBaoService.findById(null);
        });
    }

    @Test
    public void testRemove(){
        when(thongBaoRepository.save(thongBao)).thenReturn(thongBao);
        thongBaoService.save(thongBao);
        thongBaoService.remove(1001L);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            thongBaoService.findById(1001L);
        });
    }
}
