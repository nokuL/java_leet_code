package design_patterns.Creation.SimpleFactory;



public class SimpleFactoryMethod {
    private  final  EcocashGateway ecocashGateway;
    private final IveriGateway iveriGateway;

    public SimpleFactoryMethod(EcocashGateway ecocashGateway, IveriGateway iveriGateway) {
        this.ecocashGateway = ecocashGateway;
        this.iveriGateway = iveriGateway;
    }


    public PaymentProcessor getProcessor(String paymentMethod){
        switch(paymentMethod){
            case "ECOCASH" :
                return  ecocashGateway;

            case "IVERI":
                return iveriGateway;

            default: throw new IllegalArgumentException("Couldnt find payment ,method");
        }

    }
}
