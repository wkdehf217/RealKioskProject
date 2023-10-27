import java.time.LocalDateTime;
import java.util.*;

public class Init {
    private Map<String, List<Item>> menuItems;
    private List<Item> cart;
    private List<Item> waitingOrderList;
    private long totalPrice;
    private int orderNumber;
    private HashMap<Integer, List<Item>> dailyOrderList;
    public ArrayList<List<Item>> waitItemList = new ArrayList<>();  //waitingNumber랑 세트
    private long dailySales;
    private long waitingNumber;
    private int dailyOrderCount;
    Scanner scanner = new Scanner(System.in);
    private String inputString;
    private int input;
    // 스캐너 함수입니다
    public static int kioskScanner(String scantest) {
        int num = 0;
        if (scantest != null && scantest.matches("[-+]?\\d*\\.?\\d+")) {
            num = Integer.parseInt(scantest);
        } else {
            return -1;
        }
        return num;
    }
    //객체 생성
    public Init() {
//        menus = new HashMap<>();
        dailyOrderList = new HashMap<>();
        menuItems = new HashMap<>();
        cart = new ArrayList<>();
        totalPrice = 0;
        orderNumber = 0;
        dailySales = 0;
        dailyOrderCount = 0;
//
        initMenuItems();
    }

    //메뉴 초기화, menuItems(List<Item>)에 burgerMenu(HashMap<"메뉴분류", List<Item>) 입력, 그리고 firstPage로 이동
    void initMenuItems() {
        List<Item> burgerMenu = new ArrayList<>();
        burgerMenu.add(new Item("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6900, "burger_1"));
        burgerMenu.add(new Item("SmokeShack", "애플 우드 칩으로 훈연한 베이컨, 매콤한 체리 페퍼에 쉐소스가 토핑된 치즈 버거", 8900, "burger_2"));
        burgerMenu.add(new Item("ShroomBurger", "몬스터 치즈와 체다 치즈로 속을 채우고 바삭하게 뒤겨낸 포토벨로 버섯 패티에 양상추, 토마토, 쇅소스를 올린 베지테리안 버거", 9400, "burger_3"));
        burgerMenu.add(new Item("Shack Stack", "슈룸 버거와 쉑버거의 맛을 한번에 즐길 수 있는 메뉴", 12400, "burger_4"));
        burgerMenu.add(new Item("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6900, "burger_5"));
        burgerMenu.add(new Item("Hamburger", "포테이토 번과 비프패티를 기본으로 신선한 양상추, 토마토 피클, 양파 토핑을 취향에 따라 선택할 수 있는 버거", 5400, "burger_6"));
        List<Item> frozenCustardMenu = new ArrayList<>();
        frozenCustardMenu.add(new Item("Shake", "바닐라, 초콜렛, 솔티드 카라멜, 블랙& 화이트, 스트로베리, 피넛버터, 커피", 5900, "dessert_1"));
        frozenCustardMenu.add(new Item("Shake of the Week", "특별한 커스터드 플레이버", 6500, "dessert_2"));
        frozenCustardMenu.add(new Item("Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6500, "dessert_3"));
        frozenCustardMenu.add(new Item("Floats", "루트 비어, 퍼플 카우, 크림시클", 5900, "dessert_4"));
        frozenCustardMenu.add(new Item("Cups&Cones", "바닐라, 초콜렛, Flavor of the Week", 4900, "dessert_5"));
        frozenCustardMenu.add(new Item("Concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합", 5900, "dessert_6"));
        List<Item> drinkMenu = new ArrayList<>();
        drinkMenu.add(new Item("Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", 3900, "drink_1"));
        drinkMenu.add(new Item("Fresh Brewed Ice Tea", "직접 유기농 홍차를 우려낸 아이스티", 3400, "drink_2"));
        drinkMenu.add(new Item("Fifty/Fifty", "레몬에이트와 아이스티의 만남", 3500, "drink_3"));
        drinkMenu.add(new Item("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 2700, "drink_4"));
        drinkMenu.add(new Item("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 단산음료", 4400, "drink_5"));
        drinkMenu.add(new Item("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1000, "drink_6"));
        drinkMenu.add(new Item("ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9800, "drink_7"));
        List<Item> menu4 = new ArrayList<>();
        List<Item> menu5 = new ArrayList<>();
        List<Item> menu6 = new ArrayList<>();
        List<Item> menu7 = new ArrayList<>();
        List<Item> menu8 = new ArrayList<>();
        List<Item> menu9 = new ArrayList<>();
        List<Item> menu10 = new ArrayList<>();
        List<Item> menu11 = new ArrayList<>();

        menuItems.put("burger", burgerMenu);
        menuItems.put("frozenCustard", frozenCustardMenu);
        menuItems.put("drink", drinkMenu);

        firstPage();
    }




    public void firstPage() {
        System.out.println("""
             ================================================
              
 
              [ 1. 관리자 모드 | 2. 판매 시작 | 3. 프로그램 종료 ]
         
 
             ================================================""");
        inputString = scanner.nextLine();
        int input = kioskScanner(inputString);
        System.out.print(">");
        switch (input) {
            case 1 -> adminPage(); // 관리자 모드 들어가는 메소드 넣기
            case 2 -> mainMenuPage();
            case 3 -> System.out.println("프로그램을 종료합니다");
            case -1 -> { System.out.println("잘못 입력하셨습니다"); firstPage(); }
            default -> { System.out.println("잘못 입력하셨습니다"); firstPage(); }
        }
    }




    //관리자 페이지
    public void adminPage() {
        System.out.println("""
               =========================================================
               
               
                [ 1. 판매 현황  | 2. 주문 목록 | 3. 메뉴 관리 | 4. 뒤로 가기 | 5. 대기주문 완료시키기]
              
              
               =========================================================
                """);
        inputString = scanner.nextLine();
        int select = kioskScanner(inputString);
        System.out.print(">");
        switch (select) {
            case 5:
                deleteWait();
            case 1:
                System.out.println("============================");
                System.out.println(" [ Daily Report ] ");
                System.out.println(" 오늘 매출     |   " + dailySales);
                System.out.println(" 오늘 주문     |   " + dailyOrderCount);
                System.out.println();
                System.out.println("[ 1. 뒤로 가기 ]");
                System.out.println("============================");

                inputString = scanner.nextLine();
                int adminSelect = kioskScanner(inputString);
                switch (adminSelect) {
                    case 1 -> adminPage();
                    case -1 -> { System.out.println("숫자를 잘못 입력하셨습니다");
                        System.out.println("관리자 페이지 메인으로 나갑니다");
                        System.out.println();
                        adminPage(); }
                    default -> { System.out.println("숫자를 잘못 입력하셨습니다");
                        System.out.println("관리자 페이지 메인으로 나갑니다");
                        System.out.println();
                        adminPage(); }
                }
                break;
            case 2:
                System.out.println("===================================================");
                System.out.println();
                System.out.println(" [ 1. 개별 주문 검색 | 2. 모든 주문 보기 | 3. 뒤로 가기 ] ");
                System.out.println();
                System.out.println("===================================================");
                System.out.print(">");
                inputString = scanner.nextLine();
                int adminSelect2 = kioskScanner(inputString);
                switch (adminSelect2) {
                    case 1:
                        System.out.print("주문 번호>");
                        inputString = scanner.nextLine();
                        int adminSelect3 = kioskScanner(inputString);
                        try {
                            List<Item> orderList = dailyOrderList.get(adminSelect3);
                            System.out.println("======================================");
                            System.out.println();
                            for (Item item: orderList) {
                                totalPrice += item.price;
                                System.out.printf(" %-25s|    %-15d\n", item.name, item.price);
                            }
                            System.out.println();
                            System.out.printf("[ Total price | %d]", totalPrice);
                            System.out.println();
                        } catch (Exception e) {
                            System.out.println("없는 주문 번호를 입력하셨거나 숫자가 아닙니다");
                        } finally {
                            System.out.println();
                            System.out.println("[ 1. 뒤로 가기 ]");
                            System.out.println();
                            System.out.println("======================================");
                        }
                        System.out.print(">");
                        inputString = scanner.nextLine();
                        int adminSelect4 = kioskScanner(inputString);
                        switch (adminSelect4){
                            case 1:
                                adminPage();
                            case -1:
                                System.out.println("숫자를 잘못 입력하셨습니다");
                                System.out.println("관리자 페이지 메인으로 나갑니다");
                                adminPage();
                            default:
                                System.out.println("숫자를 잘못 입력하셨습니다");
                                System.out.println("관리자 페이지 메인으로 나갑니다");
                                adminPage();
                        }
                    case 2:
                        System.out.println("=================================");
                        System.out.println();
                        for (int i = 1; i < dailyOrderList.size()+1; i++) {
                            System.out.println("주문번호: " + i);
                            for (int j = 0; j < dailyOrderList.get(i).size(); j++) {
                                System.out.printf(" %-25s| %-15d\n", dailyOrderList.get(i).get(j).name, dailyOrderList.get(i).get(j).price);
                            }
                        }
                        System.out.println();
                        System.out.println("[ 1. 뒤로 가기 ]");
                        System.out.println();
                        System.out.println("=================================");
                        inputString = scanner.nextLine();
                        int select5 = kioskScanner(inputString);
                        switch (select5){
                            case 1:
                                adminPage();
                            case -1:
                                System.out.println("숫자를 잘못 입력하셨습니다");
                                System.out.println("관리자 페이지 메인으로 나갑니다");
                                adminPage();
                            default:
                                System.out.println("숫자를 잘못 입력하셨습니다");
                                System.out.println("관리자 페이지 메인으로 나갑니다");
                                adminPage();
                        }
                    case -1:
                        System.out.println("숫자를 잘못 입력하셨습니다");
                        System.out.println("관리자 페이지 메인으로 나갑니다");
                        adminPage();
                    default:
                        System.out.println("숫자를 잘못 입력하셨습니다");
                        System.out.println("관리자 페이지 메인으로 나갑니다");
                        adminPage();
                }
            case 3:
                addDeletePage();
                break;
            case 4:
                firstPage();
                break;
            case -1:
                System.out.println("숫자를 잘못 입력하셨습니다");
                System.out.println("관리자 페이지 메인으로 나갑니다");
                adminPage();
            default:
                System.out.println("숫자를 잘못 입력하셨습니다");
                System.out.println("관리자 페이지 메인으로 나갑니다");
                adminPage();
        }
    }


    void addDeletePage() {

        System.out.println("""
        =========================================


        [ 1. 메뉴 추가 | 2.메뉴 삭제 | 3. 뒤로 가기 ]
       
       
        ==========================================""");
        System.out.print(">");
        inputString = scanner.nextLine();
        int addDelete = kioskScanner(inputString);
        switch (addDelete) {
            case 1 -> addMenu();
            case 2 -> deleteMenu();
            case 3 -> adminPage();
            case -1 -> { System.out.println("잘못 입력하셨습니다"); addDeletePage(); }
            default -> { System.out.println("잘못 입력하셨습니다"); addDeletePage(); }
        }
    }


    //메인 페이지
    public void mainMenuPage() {
        System.out.println("""
            =====================================================
             "SHAKESHACK BURGER 에 오신걸 환영합니다."
             아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.
                            
             [ SHAKESHACK MENU ]
             1. Burgers         | 앵거스 비프 통살을 다져만든 버거
             2. Frozen Custard  | 매장에서 신선하게 만드는 아이스크림
             3. Drinks          | 매장에서 직접 만드는 음료
                            
             [ ORDER MENU ]
             4. Order       | 장바구니를 확인 후 주문합니다.
             5. Cancel      | 진행중인 주문을 취소합니다.
            
            
             6. Home        | 처음 화면으로 돌아갑니다.
            
            =====================================================""");
        System.out.print(">");
        inputString = scanner.nextLine();
        int select = kioskScanner(inputString);
        switch (select) {
            case 1:
                burgerPage();
                break;
            case 2:
                frozenCustardPage();
                break;
            case 3:
                drinkPage();
                break;
            case 4:
                orderPage();
                break;
            case 5:
                clearCart();
                break;
            case 6:
                firstPage();
                cart.clear();
                break;
            case -1:
                System.out.println("잘못 입력하셨습니다");
                mainMenuPage();
            default:
                System.out.println("잘못 입력하셨습니다");
                mainMenuPage();
        }
    }




    //burger 메뉴 페이지
    public void burgerPage() {
        System.out.println("""
            =========================================================================================================================================
             "SHAKESHACK BURGER 에 오신걸 환영합니다."
             아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.
                                
             [ Burgers MENU ]""");
        List<Item> burgerMenu = menuItems.get("burger");
        for(int i = 0; i < burgerMenu.size(); i++) {
            System.out.printf(" %d. %-25s|    W %-9d| %s\n", i+1, burgerMenu.get(i).name, burgerMenu.get(i).price, burgerMenu.get(i).description);
        }
        System.out.println();
        System.out.println(" [Order Menu]");
        System.out.printf(" %d. Order       | 장바구니를 확인 후 주문합니다.\n", burgerMenu.size()+1);
        System.out.printf(" %d. Cancel      | 진행중인 주문을 취소합니다.\n", burgerMenu.size()+2);
        System.out.println();
        System.out.printf(" %d. 뒤로 가기\n", burgerMenu.size()+3);
        System.out.println("=========================================================================================================================================");

        HashMap<Integer, Item> burgerdMap = new HashMap<>();
        for (int i = 1; i <= burgerMenu.size(); i++) {
            burgerdMap.put(i, burgerMenu.get(i-1));
        }

        System.out.print(">");
        inputString = scanner.nextLine();
        int selectItem = kioskScanner(inputString);
        if(selectItem == -1 || selectItem > burgerMenu.size()+3){
            System.out.println("잘못 입력하셨습니다.");
            burgerPage();
        } else if (selectItem == burgerMenu.size()+1) {
            orderPage();
        } else if (selectItem == burgerMenu.size()+2) {
            clearCart();
        } else if (selectItem == burgerMenu.size()+3) {
            mainMenuPage();
        } else {
            cart.add(burgerdMap.get(selectItem));
            System.out.println(" 장바구니에 담겼습니다\n");
            burgerPage();
        }
    }




    //frozenCustard 메뉴 페이지
    public void frozenCustardPage() {
        System.out.println("""
            ===========================================================================================================
             "SHAKESHACK BURGER 에 오신걸 환영합니다."
             아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.
                                
            [ frozenCustard MENU ]""");
        List<Item> frozenCustardMenu = menuItems.get("frozenCustard");
        for(int i = 0; i < frozenCustardMenu.size(); i++) {
            System.out.printf(" %d. %-25s|    W  %-6d   | %s\n", i+1, frozenCustardMenu.get(i).name, frozenCustardMenu.get(i).price, frozenCustardMenu.get(i).description);
        }
        System.out.println();
        System.out.println(" [Order Menu]");
        System.out.printf(" %d. Order           | 장바구니를 확인 후 주문합니다.\n", frozenCustardMenu.size()+1);
        System.out.printf(" %d. Cancel          | 진행중인 주문을 취소합니다.\n", frozenCustardMenu.size()+2);
        System.out.println();
        System.out.printf(" %d. 뒤로 가기\n", frozenCustardMenu.size()+3);
        System.out.println("===========================================================================================================");

        HashMap<Integer, Item> frozenCustardMap = new HashMap<>();
        for (int i = 1; i <= frozenCustardMenu.size(); i++) {              // HashMap애 키값 1부터 담는중, 1부터 프로즌 메뉴리스트.사이즈 값(7)까지 1부터 7까지 돈다
            frozenCustardMap.put(i, frozenCustardMenu.get(i-1));
        }
        System.out.print(">");
        inputString = scanner.nextLine();
        int selectItem = kioskScanner(inputString);
        if(selectItem == -1 || selectItem > frozenCustardMenu.size()+3){
            System.out.println("잘못 입력하셨습니다.");
            frozenCustardPage();
        } else if (selectItem == frozenCustardMenu.size()+1) {
            orderPage();
        } else if (selectItem == frozenCustardMenu.size()+2) {
            clearCart();
        } else if (selectItem == frozenCustardMenu.size()+3) {
            mainMenuPage();
        } else {
            cart.add(frozenCustardMap.get(selectItem));
            System.out.println(" 장바구니에 담겼습니다\n");
            frozenCustardPage();
        }
    }




    //Drink 메뉴 페이지
    public void drinkPage() {
        System.out.println("""
            ===========================================================================================================
             "SHAKESHACK BURGER 에 오신걸 환영합니다."
             아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.
                                
             [ Drink MENU ]""");
        List<Item> drinkMenu = menuItems.get("drink");
        for(int i = 0; i < drinkMenu.size(); i++) {
            System.out.printf(" %d. %-25s|    W  %-6d   | %s\n", i+1, drinkMenu.get(i).name, drinkMenu.get(i).price, drinkMenu.get(i).description);
        }
        System.out.println();
        System.out.println(" [Order Menu]");
        System.out.printf(" %d. Order       | 장바구니를 확인 후 주문합니다.\n", drinkMenu.size()+1);
        System.out.printf(" %d. Cancel      | 진행중인 주문을 취소합니다.\n", drinkMenu.size()+2);
        System.out.println();
        System.out.printf(" %d. 뒤로 가기\n", drinkMenu.size()+3);
        System.out.println("===========================================================================================================");

        HashMap<Integer, Item> drinkMap = new HashMap<>();
        for (int i = 1; i <= drinkMenu.size(); i++) {
            drinkMap.put(i, drinkMenu.get(i-1));
        }
        System.out.print(">");
        inputString = scanner.nextLine();
        int selectItem = kioskScanner(inputString);
        if(selectItem == -1 || selectItem > drinkMenu.size()+3){
            System.out.println("잘못 입력하셨습니다.");
            drinkPage();
        } else if (selectItem == drinkMenu.size()+1) {
            orderPage();
        } else if (selectItem == drinkMenu.size()+2) {
            clearCart();
        } else if (selectItem == drinkMenu.size()+3) {
            mainMenuPage();
        } else {
            cart.add(drinkMap.get(selectItem));
            System.out.println(" 장바구니에 담겼습니다\n");
            drinkPage();
        }
    }




    //장바구니 페이지
    public void orderPage() {
        if (!cart.isEmpty()) {
            System.out.println("""
                ===============================================================================================
                 "SHAKESHACK BURGER 에 오신걸 환영합니다."
                 아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.

                 [ ORDER ]""");

            //cart 리스트 출력, totalPrice 계산
            for (int i = 0; i < cart.size(); i++) {
                System.out.printf(" %d. %-25s|    W  %-6d   | %s\n", i+1, cart.get(i).name, cart.get(i).price, cart.get(i).description);
                totalPrice = totalPrice + cart.get(i).price;
            }
            //totalPrice 출력
            System.out.println();
            System.out.printf(" [ 1. 결제하기 : %d | 2. 메뉴 추가 ]\n", totalPrice);
            System.out.println("===============================================================================================");
            inputString = scanner.nextLine();
            int select = kioskScanner(inputString);
            switch (select) {
                case 1:
                    //결제 하고, 대기번호 출력, 오더리스트로 옮기기 그 후 cart.clear()
                    System.out.println("=============================================");
                    System.out.println();
                    System.out.println(" 주문해주셔서 감사합니다\n");
                    System.out.printf(" [ 주문 번호: %d ]\n",  ++orderNumber, ++waitingNumber);                     // 하루 주문 건수
                    dailyOrderList.put(orderNumber, new ArrayList<>(cart));

                        this.waitItemList.add(cart);
                        System.out.println(cart+"cart가 wait에 담김");

                    System.out.println("대기번호: " + waitingNumber);
                    System.out.println();
                    System.out.println();
                    System.out.println("=============================================");
                    //orderList는 관리자 페이지에서 쓸때 가져가서 쓰면 될 듯 합니다
                    dailySales += totalPrice;                                                    //dailySales 하루 매출
                    dailyOrderCount =orderNumber;                                                // 하루 주문 횟수

                    totalPrice = 0;          // 합계 금액 0으로 초기화
                    cart.clear();            // 장바구니 초기화
                    mainMenuPage();
                    break;
                case 2:
                    mainMenuPage();
                    break;
                case -1:
                    System.out.println("잘못 입력하셨습니다.");
                    mainMenuPage();
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    mainMenuPage();
            }
        } else {
            System.out.println("""
             ==========================================
              "SHAKESHACK BURGER 에 오신걸 환영합니다."
              아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.
                    
                    
                    
              [ 장바구니가 비어있습니다 ]

             ==========================================""");
            mainMenuPage();
        }
    }




    //장바구니 비우기, 비운 후 메인화면 이동
    public void clearCart() {
        System.out.println(" 장바구니를 비웠습니다");
        cart.clear();
        mainMenuPage();
    }



    public void addMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("추가할 메뉴의 종류를 입력해 주세요");
        System.out.print(">");
        String menu = scanner.nextLine();
        menuItems.get(menu);
        System.out.print("추가할 메뉴의 이름을 입력해 주세요");
        System.out.print(">");
        String name = scanner.nextLine();
        System.out.print("추가할 메뉴의 설명을 입력해 주세요");
        System.out.print(">");
        String description = scanner.nextLine();
        System.out.print("추가할 메뉴의 가격을 입력해 주세요");
        System.out.print(">");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.print("추가할 메뉴의 ID를 입력해 주세요");
        System.out.print(">");
        String id = scanner.nextLine();
        menuItems.get(menu).add(0, new Item(name, description, price, id));
        System.out.println("메뉴가 추가되었습니다");
        addDeletePage();
    }
    public void deleteMenu() {
        Scanner scanner =new Scanner(System.in);

        System.out.print("삭제할 메뉴의 종류를 입력해 주세요");
        System.out.print(">");
        String menu = scanner.nextLine();
        System.out.print("삭제할 메뉴의 이름을 입력해 주세요");
        System.out.print(">");
        String name = scanner.nextLine();

        List<Item> itemList = menuItems.get(menu);
        Item itemToRemove = null;

        for (Item item : itemList) {
            if (item.name.equals(name)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            itemList.remove(itemToRemove);
            System.out.println("메뉴가 삭제되었습니다");
        } else {
            System.out.println("해당 이름을 가진 메뉴가 없습니다");
        }

        addDeletePage();
    }

    //재현 (주문대기를 완료시키는 메서드)
    public void deleteWait() {
        System.out.println("대기주문 완료시키는 페이지\n");
        System.out.println("[대기주문목록]");

        //아이탬이름, 대기번호 출력
        for(int i=0;i<waitItemList.size();i++) {
            System.out.println("i: "+i);
            for (int j = 0; j < waitItemList.get(i).size(); j++) {
                System.out.println("j:"+j);
                System.out.println("메뉴: " + waitItemList.get(i).get(j).name + " | 대기번호: " + i + 1);
            }
        }

        System.out.println("대기번호를 입력해서 완료시키기: ");
        Scanner scanner = new Scanner(System.in);
        int inputOrderNumber = scanner.nextInt()+1;

//        System.out.println(waitItemList.get(inputOrderNumber).name+"대기번호"+inputOrderNumber+"가 제거되었습니다.");
        for (int i=0;i<waitItemList.get(inputOrderNumber).size();i++) {
            System.out.println(waitItemList.get(inputOrderNumber).get(i).name);
        }

        waitItemList.remove(inputOrderNumber);
        --waitingNumber;

        firstPage();


    }
}