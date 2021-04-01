import com.bfs.demo.domain.User;

public class MyUserDemo {
    public static void main(String[] args) {
        MyUser user = new MyUser.MyUserBuilder()
                                .setId(1)
                                .setAge(10)
                                .setName("UserA")
                                .build();

        System.out.println(user.toString());
    }
}
