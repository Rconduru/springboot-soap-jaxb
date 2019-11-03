package soapproducer;

import https.github_com.rconduru.GetSalesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import soapproducer.repository.SalesRepository;

@Endpoint
public class SaleEndpoint {
    private static final String NAMESPACE_URI = "https://github.com/Rconduru";

    private SalesRepository salesRepository;

    @Autowired
    public SaleEndpoint(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSalesRequest")
    @ResponsePayload
    public GetSalesResponse getSales() {
        GetSalesResponse response = new GetSalesResponse();
        response.getSale().addAll(salesRepository.getAllSales());

        return response;
    }
}