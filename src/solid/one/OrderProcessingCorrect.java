package solid.one;

public class OrderProcessingCorrect {

    private final ITotalCalculator totalCalculator;
    private final DiscountFactory discountFactory;
    private final IPaymentService paymentService;
    private final INotificationService notificationService;
    private final IOrderRepository orderRepository;
    private final TestService testService = new TestService(" ", " ");

    public OrderProcessingCorrect(ITotalCalculator totalCalculator,
                                  DiscountFactory discountFactory,
                                  IPaymentService paymentService,
                                  INotificationService notificationService,
                                  IOrderRepository orderRepository, TestService testService) {
        this.totalCalculator = totalCalculator;
        this.discountFactory = discountFactory;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
        this.orderRepository = orderRepository;
    }

    //dependency

    public void process(Order order) {
        double total = totalCalculator.totalCalculator(order);

        IDiscountService discountService = discountFactory.getDiscount(order.getCustomerType());
        total = discountService.discountCalculator(total);

        PaymentRequest paymentRequest = new PaymentRequest(order.getId(), total);
        paymentService.processPayment(paymentRequest);

        MessageDTO messageDTO = new MessageDTO("Order confirmed", order.getPhone(), order.getEmail());
        notificationService.sendNotification(messageDTO);

        orderRepository.save(order);
    }
}


///issues fixed
//S single responsibility, the class was doing too much, so i split to separate services, and utility classes
//Open closed , a class must be closed for modification and open for exetension, implemented introduced interfaces so thst each payment method or messaging methos can provide its own implemnetation
//The Order Correct (service) is supposed to depend on abstractions not concrete implementations eg INotificationService such that the calling service or resource is the one to determine the type of Notification service it wants to send, dont bind it to one
//DIP is useful for decoupling low level implementation from the high level business logic to make room for expansion eg adding new changes
//Interface Segregation principle, Order was being passed around with all its fields to numerous services eg payment that doesn require all the fields, itys a fat model, (just like we can have a fat interface)
//