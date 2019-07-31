import Impl.DanhGiaServiceImpl;
import entity.DanhGiaEntity;
import entity.NgoiNhaEntity;
import entity.NguoiDungEntity;
import jpaRepository.DanhGiaRepository;
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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DanhGiaServiceTest {
    @Mock
    private DanhGiaRepository danhGiaRepository;

    @InjectMocks
    private DanhGiaServiceImpl danhGiaService;

    @Before
    public void SetUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave(){
        NguoiDungEntity nguoiDanhGia = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");
        NguoiDungEntity chuNha = new NguoiDungEntity(1002L, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
        NgoiNhaEntity ngoiNhaEntity = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);
        DanhGiaEntity danhGiaEntity = new DanhGiaEntity(1001L, nguoiDanhGia, ngoiNhaEntity,3);

        when(danhGiaRepository.save(danhGiaEntity)).thenReturn(danhGiaEntity);
        DanhGiaEntity testDanhGia = danhGiaService.save(danhGiaEntity);

        Assert.assertNotNull(testDanhGia.getId());
        Assert.assertEquals(testDanhGia.getNgoiNha(), danhGiaEntity.getNgoiNha());
        Assert.assertEquals(testDanhGia.getNguoiDanhGia(), danhGiaEntity.getNguoiDanhGia());
        Assert.assertEquals(testDanhGia.getSuDanhGia(), danhGiaEntity.getSuDanhGia());
    }

    @Test
    public void testSave_IfNull(){
        DanhGiaEntity testDanhGia = danhGiaService.save(null);
        Assert.assertNull(testDanhGia);
    }

    @Test
    public void testFindAll(){
        NguoiDungEntity nguoiDanhGia = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");
        NguoiDungEntity chuNha = new NguoiDungEntity(1002, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
        NgoiNhaEntity ngoiNhaEntity = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);

        List<DanhGiaEntity> listDanhGia = new ArrayList<>();
        listDanhGia.add(new DanhGiaEntity(1001L, nguoiDanhGia, ngoiNhaEntity,3));
        listDanhGia.add(new DanhGiaEntity(1002L, nguoiDanhGia, ngoiNhaEntity,4));
        listDanhGia.add(new DanhGiaEntity(1003L, nguoiDanhGia, ngoiNhaEntity,2));
        listDanhGia.add(new DanhGiaEntity(1004L, nguoiDanhGia, ngoiNhaEntity,1));
        listDanhGia.add(new DanhGiaEntity(1005L, nguoiDanhGia, ngoiNhaEntity,5));

        when(danhGiaRepository.findAll()).thenReturn(listDanhGia);
        List<DanhGiaEntity> testDanhGia = danhGiaService.findAll();

        Assert.assertEquals(5, testDanhGia.size());
    }

    @Test
    public void testFindAll_IfHaveNothing(){
        List<DanhGiaEntity> listDanhGia = new ArrayList<>();

        when(danhGiaRepository.findAll()).thenReturn(listDanhGia);
        List<DanhGiaEntity> testDanhGia = danhGiaService.findAll();

        Assert.assertEquals(0, listDanhGia.size());
    }

    @Test
    public void testFindById(){
        NguoiDungEntity nguoiDanhGia = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");
        NguoiDungEntity chuNha = new NguoiDungEntity(1002, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
        NgoiNhaEntity ngoiNhaEntity = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);
        DanhGiaEntity danhGiaEntity = new DanhGiaEntity(1001L, nguoiDanhGia, ngoiNhaEntity,3);

        when(danhGiaRepository.save(danhGiaEntity)).thenReturn(danhGiaEntity);
        danhGiaService.save(danhGiaEntity);
        when(danhGiaRepository.findById(1001L)).thenReturn(Optional.of(danhGiaEntity));
        DanhGiaEntity testDanhGia = danhGiaService.findById(1001L);

        Assert.assertNotNull(testDanhGia.getId());
        Assert.assertEquals(testDanhGia.getNgoiNha(), danhGiaEntity.getNgoiNha());
        Assert.assertEquals(testDanhGia.getNguoiDanhGia(), danhGiaEntity.getNguoiDanhGia());
        Assert.assertEquals(testDanhGia.getSuDanhGia(), danhGiaEntity.getSuDanhGia());
    }

    @Test
    public void testFindById_IfIdNull(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            danhGiaService.findById(null);
        });
    }

    @Test
    public void testRemove(){
        NguoiDungEntity nguoiDanhGia = new NguoiDungEntity(1001L, "username_1", "password_1", "John", "0123456789", "john@gmail.com", "Da Nang");
        NguoiDungEntity chuNha = new NguoiDungEntity(1002, "username_2", "password_2", "Josh", "0125634789", "josh@gmail.com", "Hue");
        NgoiNhaEntity ngoiNhaEntity = new NgoiNhaEntity(1001L, chuNha, "Roma", 5, 5, "Da Nang", "Nha cap 4", 120000, "Day du tien nghi", true);
        DanhGiaEntity danhGiaEntity = new DanhGiaEntity(1001L, nguoiDanhGia, ngoiNhaEntity,3);

        when(danhGiaRepository.save(danhGiaEntity)).thenReturn(danhGiaEntity);
        danhGiaService.save(danhGiaEntity);
        danhGiaService.remove(1001L);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            danhGiaService.findById(1001L);
        });
    }
}
