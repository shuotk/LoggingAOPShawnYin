import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MyUser {
    private Integer id;
    private Integer age;
    private String name;

    public MyUser(MyUserBuilder builder) {
        this.id = builder.id;
        this.age = builder.age;
        this.name = builder.name;
    }

    public static class MyUserBuilder{
        private Integer id;
        private Integer age;
        private String name;

        public MyUserBuilder() {
        }

        public MyUserBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public MyUserBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public MyUserBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public MyUser build(){
            return new MyUser(this);
        }
    }

}
