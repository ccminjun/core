package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // 자바 기본의 static 영역 확인하기.. static 영역에 하나만 만들어짐

    // 조회할떄는 이놈을 씀
    public static  SingletonService getInstance(){
        return instance;
    }


    private SingletonService(){

    }
    
    public void Logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
