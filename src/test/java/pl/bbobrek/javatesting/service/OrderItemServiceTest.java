package pl.bbobrek.javatesting.service;

import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.StubValue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.bbobrek.javatesting.model.OrderItem;
import pl.bbobrek.javatesting.model.Product;
import pl.bbobrek.javatesting.model.dto.CreateOrderDto;
import pl.bbobrek.javatesting.repo.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
class OrderItemServiceTest {

    /**
     * Spy - to bedzie tylko zabezpieczenie przed null podczas wstrzykiwania zaleznosci
     * Stub - to jest to samo co Spy + możlwiość weryfikacji wywołania metody
     * Mock - to bedzie to samo co Spy i Stub + możwliość decdydowania co ma być zwrócone jako rezultat mockowanej metody
     * */

/*    @Spy
    private ProductRepository productRepository;*/

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private OrderItemService orderItemService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCovertProductDtoToOrderItem() {
        //given
        CreateOrderDto.ProductDto productDto = new CreateOrderDto.ProductDto();
        productDto.setQuantity(10);
        productDto.setId(9);

        Product product = new Product();
        product.setName("Woda gazowana");

        Mockito.when(productRepository.getById(Mockito.anyLong())).thenReturn(product);

        //when
        OrderItem result = orderItemService.convert(productDto);

        //then
        Mockito.verify(productRepository, Mockito.times(1)).getById(90L);
        assertNotNull(result);
        assertEquals(10, result.getQuantity());
        assertNotNull(result.getProduct());
        assertEquals("Woda gazowana", result.getProduct().getName());
    }


}