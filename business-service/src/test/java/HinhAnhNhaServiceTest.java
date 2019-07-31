import Impl.HinhAnhNhaServiceImpl;
import entity.HinhAnhNhaEntity;
import entity.NgoiNhaEntity;
import entity.NguoiDungEntity;
import jpaRepository.HinhAnhNhaRepository;
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
public class HinhAnhNhaServiceTest {
    @Mock
    private HinhAnhNhaRepository hinhAnhNhaRepository;

    @InjectMocks
    private HinhAnhNhaServiceImpl hinhAnhNhaService;

    @Before
    public void SetUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        NguoiDungEntity chuNha = new NguoiDungEntity(1002L, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
        NgoiNhaEntity ngoiNha = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);
        HinhAnhNhaEntity hinhAnhNhaEntity = new HinhAnhNhaEntity(1001L, new byte[]{80, 65, 78, 75, 65, 74}, ngoiNha);

        when(hinhAnhNhaRepository.save(hinhAnhNhaEntity)).thenReturn(hinhAnhNhaEntity);
        HinhAnhNhaEntity testHinhAnh = hinhAnhNhaService.save(hinhAnhNhaEntity);

        Assert.assertNotNull(testHinhAnh.getId());
        Assert.assertThat(testHinhAnh.getHinhAnh(), is(hinhAnhNhaEntity.getHinhAnh()));
        Assert.assertThat(testHinhAnh.getngoiNha(), is(hinhAnhNhaEntity.getngoiNha()));

        Assert.assertNull(hinhAnhNhaService.save(null));
    }

    @Test
    public void testFindAll(){
        NguoiDungEntity chuNha = new NguoiDungEntity(1002L, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
        NgoiNhaEntity ngoiNha = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);

        List<HinhAnhNhaEntity> listHinhAnh = new ArrayList<>();
        listHinhAnh.add(new HinhAnhNhaEntity(1001L, new byte[]{80}, ngoiNha));
        listHinhAnh.add(new HinhAnhNhaEntity(1001L, new byte[]{65}, ngoiNha));
        listHinhAnh.add(new HinhAnhNhaEntity(1001L, new byte[]{70}, ngoiNha));
        listHinhAnh.add(new HinhAnhNhaEntity(1001L, new byte[]{85}, ngoiNha));
        listHinhAnh.add(new HinhAnhNhaEntity(1001L, new byte[]{60}, ngoiNha));

        when(hinhAnhNhaRepository.findAll()).thenReturn(listHinhAnh);
        List<HinhAnhNhaEntity> testHinhAnh = hinhAnhNhaService.findAll();

        Assert.assertEquals(testHinhAnh.size(), 5);
    }

    @Test
    public void testFindAll_IfHaveNothing(){
        List<HinhAnhNhaEntity> list = new ArrayList<>();

        when(hinhAnhNhaRepository.findAll()).thenReturn(list);

        Assert.assertThat(hinhAnhNhaService.findAll().size(), is(0));
    }

    @Test
    public void testFindById(){
        NguoiDungEntity chuNha = new NguoiDungEntity(1002L, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
        NgoiNhaEntity ngoiNha = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);
        HinhAnhNhaEntity hinhAnhNha = new HinhAnhNhaEntity(1001L, new byte[]{80, 65, 78, 75, 65, 74}, ngoiNha);

        when(hinhAnhNhaRepository.save(hinhAnhNha)).thenReturn(hinhAnhNha);
        hinhAnhNhaService.save(hinhAnhNha);

        when(hinhAnhNhaRepository.findById(1001L)).thenReturn(Optional.of(hinhAnhNha));
        HinhAnhNhaEntity testHinhAnh = hinhAnhNhaService.findById(hinhAnhNha.getId());

        Assert.assertNotNull(testHinhAnh.getId());
        Assert.assertThat(testHinhAnh.getHinhAnh(), is(hinhAnhNha.getHinhAnh()));
        Assert.assertThat(testHinhAnh.getngoiNha(), is(hinhAnhNha.getngoiNha()));
    }

    @Test
    public void testFindById_IfIdNull(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            hinhAnhNhaService.findById(null);
        });
    }

    @Test
    public void testRemove(){
        NguoiDungEntity chuNha = new NguoiDungEntity(1002L, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
        NgoiNhaEntity ngoiNha = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);
        HinhAnhNhaEntity hinhAnhNha = new HinhAnhNhaEntity(1001L, new byte[]{80, 65, 78, 75, 65, 74}, ngoiNha);

        when(hinhAnhNhaRepository.save(hinhAnhNha)).thenReturn(hinhAnhNha);
        hinhAnhNhaService.save(hinhAnhNha);
        hinhAnhNhaService.remove(1001L);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            hinhAnhNhaService.findById(1001L);
        });
    }

}
