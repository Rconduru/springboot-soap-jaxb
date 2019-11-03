package soapproducer.repository;

import https.github_com.rconduru.Buyer;
import https.github_com.rconduru.Item;
import https.github_com.rconduru.Sale;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SalesRepository {
    private static final Map<String, Sale> sales = new HashMap<>();

    @PostConstruct
    public void initData(){
        Item item = new Item();
        item.setNote("NOT023");
        item.setPrice(new BigDecimal(20));
        item.setQuantity(new BigInteger("1"));
        item.setTitle("Book - Soap is dying");

        Buyer buyer = new Buyer();
        buyer.setAddress("North Road");
        buyer.setCity("Lost City");
        buyer.setCountry("Lost Country");
        buyer.setName("Santa Claus developer");

        Sale sale = new Sale();
        sale.getItem().add(item);
        sale.setBuyer(buyer);
        sale.setNumOrder("OR234");
        sale.setSalesman("Crazy Leg");

        Item item2 = new Item();
        item.setNote("NOT023");
        item.setPrice(new BigDecimal(20));
        item.setQuantity(new BigInteger("1"));
        item.setTitle("Book - Bino, GraphQL is a trap");

        Sale sale2 = new Sale();
        sale.getItem().add(item2);
        sale.setBuyer(buyer);
        sale.setNumOrder("OR235");
        sale.setSalesman("Trouble maker");

        sales.put(sale.getNumOrder(), sale);
        sales.put(sale2.getNumOrder(), sale2);
    }

    public List<Sale> getAllSales(){
        return new ArrayList<>(sales.values());
    }
}
