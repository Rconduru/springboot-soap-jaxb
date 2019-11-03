# SOAP Example Project (springboot-soap-jaxb)

Example SOAP application using Spring Boot + Gradle + jaxB  gradle plugin

## Requisites (Whats i used)

- Java  (1.8.0_221);
- InteliJ IDE;
- Postman (only for tests)

### Steps to run

1. Clone this project;
2. run ```./gradlew bootRun```
3. In browser access ```http://localhost:8080/ws/countries.wsdl``` and ```http://localhost:8080/ws/sales.wsdl``` to see WSDL info;

### Now What? Let's do some tests

> I've used Postman (https://www.getpostman.com/), but you can use whatever you want, like the SoapUi. So i'll show how i made the tests in Postman.

#### Test 1

In Postman i set:

- Method POST;
- URL ```http://localhost:8080/ws```;
- Headers: ~Content-Type~ = text/xml
- Body: raw XML;
- On Body:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="https://github.com/Rconduru">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getSalesRequest/>
   </soapenv:Body>
</soapenv:Envelope>
```

Expected Response:
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getSalesResponse xmlns:ns2="https://github.com/Rconduru">
            <ns2:sale/>
            <ns2:sale numOrder="OR235">
                <ns2:salesman>Trouble maker</ns2:salesman>
                <ns2:buyer>
                    <ns2:name>Santa Claus developer</ns2:name>
                    <ns2:address>North Road</ns2:address>
                    <ns2:city>Lost City</ns2:city>
                    <ns2:country>Lost Country</ns2:country>
                </ns2:buyer>
                <ns2:item>
                    <ns2:title>Book - Bino, GraphQL is a trap</ns2:title>
                    <ns2:note>NOT023</ns2:note>
                    <ns2:quantity>1</ns2:quantity>
                    <ns2:price>20</ns2:price>
                </ns2:item>
                <ns2:item/>
            </ns2:sale>
        </ns2:getSalesResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

#### Test 2

In Postman i set:

- Method POST;
- URL ```http://localhost:8080/ws```;
- Headers: ~Content-Type~ = text/xml
- Body: raw XML;
- On Body:
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="https://github.com/Rconduru">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:getCountryRequest>
         <gs:name>Spain</gs:name>
      </gs:getCountryRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

Expected Response:
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getCountryResponse xmlns:ns2="https://github.com/Rconduru">
            <ns2:country>
                <ns2:name>Spain</ns2:name>
                <ns2:population>46704314</ns2:population>
                <ns2:capital>Madrid</ns2:capital>
                <ns2:currency>EUR</ns2:currency>
            </ns2:country>
        </ns2:getCountryResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

