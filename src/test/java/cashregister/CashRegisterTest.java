package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
        FakePrinter fakePrinter = new FakePrinter();
        CashRegister cashRegister = new CashRegister(fakePrinter);
        Item[] items = {new Item("itemA",1)};
        Purchase purchase = new Purchase(items);
        //when
        cashRegister.process(purchase);
        //then
        Assertions.assertTrue(fakePrinter.printMethodWasCalled());
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        FakePrinter fakePrinter = new FakePrinter();
        FakePurchase fakePurchase = new FakePurchase();
        fakePurchase.setStringIWant("TEST");
        CashRegister cashRegister = new CashRegister(fakePrinter);

        //when
        cashRegister.process(fakePurchase);
        //then
        Assertions.assertEquals(fakePurchase.asString(), fakePrinter.printedString());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("TEST");

        CashRegister cashRegister = new CashRegister(printer);

        //when
        cashRegister.process(purchase);

        //then
        verify(printer).print("TEST");
    }

}
