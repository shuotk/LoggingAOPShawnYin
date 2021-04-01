public aspect MyAspect {
    pointcut log():call(void AspectJDemo.test());

    before():log(){
        System.out.println("Before the execution");
    }

    after():log(){
        System.out.println("After the execution");
    }
}
