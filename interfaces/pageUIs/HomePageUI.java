package pageUIs;

public class HomePageUI {
    // Class này chỉ có nhiệm vụ chứa các locator, field (biến) không có hàm nào hết
    // nên không áp nguyên tắc kế thừa
    public static final String REGISTER_LINK = "//a[@class='ico-register']";

    //1 - public :
    // Không set protected vì các class bên ngoài package không dùng được -> không áp dụng kết thừa
    // Không set private thì chắc chắn ngoài class không dùng được
    // không set default vì ngoài package cũng không dùng được
    // một tính năng là một module riêng, nên sẽ nằm các package khác nhau cho nên -> public
    // public đồng nghĩa với việc bất kỳ class nào cũng gọi tới để sử dụng được
    // Sẽ có người đứng từ registerPageObject gọi qua HomePageUI -> Sai về mặt Business
    // Có một cách hạn chế là sẽ Communication / Convention : thống nhất chung cả team
    // HomePageObject sẽ gọi qua HomePageUI

    // 2 - Static : Đứng từ phạm vi class mình không cần khởi tạo một cái biến vẫn có thể gọi static được
    // 3 - final : Không thay đổi giá trị trong vòng đời sử dụng, không kế thừa không override được

    //Trong lập trình Java không có từ khóa nào đại diện cho hằng số
    // Kết hợp 2 từ khóa lại với nhau = hằng số -> là một giá trị fixed cố định không thay đổi
    // static + final ->
    // tên biến viết hoa và có dấu gạch nối : TEN_BIEN

    //4 - String : vì các locator dùng tham số parameter bên trong là String nên define là String

}
