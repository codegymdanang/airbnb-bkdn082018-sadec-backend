import Impl.NguoiDungServiceImpl;
import entity.NguoiDungEntity;
import jpaRepository.NguoiDungRepository;
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
public class NguoiDungServiceTest {

    @Mock
    private NguoiDungRepository nguoiDungRepository;

    @InjectMocks
    private NguoiDungServiceImpl nguoiDungService;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        NguoiDungEntity nguoiDung = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");
        when(nguoiDungRepository.save(nguoiDung)).thenReturn(nguoiDung);
        NguoiDungEntity testNguoiDung = nguoiDungService.save(nguoiDung);

        Assert.assertNotNull(testNguoiDung.getId());
        Assert.assertEquals(testNguoiDung.getTenNguoiDung(), nguoiDung.getTenNguoiDung());
        Assert.assertEquals(testNguoiDung.getMatKhau(), nguoiDung.getMatKhau());
        Assert.assertEquals(testNguoiDung.getHoTen(), nguoiDung.getHoTen());
        Assert.assertEquals(testNguoiDung.getSoDienThoai(), nguoiDung.getSoDienThoai());
        Assert.assertEquals(testNguoiDung.getDiaChi(), nguoiDung.getDiaChi());
        Assert.assertEquals(testNguoiDung.getEmail(), nguoiDung.getEmail());

        Assert.assertNull(nguoiDungService.save(null));
    }

    @Test
    public void testFindAll(){
        List<NguoiDungEntity> listNguoiDung = new ArrayList<>();

        listNguoiDung.add(new NguoiDungEntity(1001, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang"));
        listNguoiDung.add(new NguoiDungEntity(1002, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue"));
        listNguoiDung.add(new NguoiDungEntity(1003, "username_3", "password_3", "Lyly", "0125463987", "lyly@gmail.com", "Quang Binh"));
        listNguoiDung.add(new NguoiDungEntity(1004, "username_4", "password_4", "Anna", "0125874963", "anna@gmail.com", "Quang Tri"));
        listNguoiDung.add(new NguoiDungEntity(1005, "username_5", "password_5", "Lucy", "0521478963", "lucy@gmail.com", "Nam Dinh"));

        when(nguoiDungRepository.findAll()).thenReturn(listNguoiDung);
        Assert.assertThat(nguoiDungService.findAll().size(), is(5));
    }

    @Test
    public void testFindAll_IfHaveNothing(){
        List<NguoiDungEntity> listNguoiDung = new ArrayList<>();

        when(nguoiDungRepository.findAll()).thenReturn(listNguoiDung);
        Assert.assertThat(nguoiDungService.findAll().size(), is(0));
    }

    @Test
    public void testFindById(){
        NguoiDungEntity nguoiDung = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");

        when(nguoiDungRepository.save(nguoiDung)).thenReturn(nguoiDung);
        nguoiDungService.save(nguoiDung);

        when(nguoiDungRepository.findById(1001L)).thenReturn(Optional.of(nguoiDung));
        NguoiDungEntity testNguoiDung = nguoiDungService.findById(1001L);

        Assert.assertNotNull(testNguoiDung.getId());
        Assert.assertEquals(testNguoiDung.getTenNguoiDung(), nguoiDung.getTenNguoiDung());
        Assert.assertEquals(testNguoiDung.getMatKhau(), nguoiDung.getMatKhau());
        Assert.assertEquals(testNguoiDung.getHoTen(), nguoiDung.getHoTen());
        Assert.assertEquals(testNguoiDung.getSoDienThoai(), nguoiDung.getSoDienThoai());
        Assert.assertEquals(testNguoiDung.getDiaChi(), nguoiDung.getDiaChi());
        Assert.assertEquals(testNguoiDung.getEmail(), nguoiDung.getEmail());
    }

    @Test
    public void testFindById_IfIdNull() throws Exception{

        Assertions.assertThrows(NullPointerException.class, () -> {
            nguoiDungService.findById(null);
        });
    }

    @Test
    public void testRemove(){
        NguoiDungEntity nguoiDung = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");
        when(nguoiDungRepository.save(nguoiDung)).thenReturn(nguoiDung);
        nguoiDungService.save(nguoiDung);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
           nguoiDungService.findById(1001L);
        });
    }

}
